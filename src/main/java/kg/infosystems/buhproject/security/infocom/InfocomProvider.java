package kg.infosystems.buhproject.security.infocom;

import io.jmix.security.authentication.RoleGrantedAuthority;
import io.jmix.security.model.ResourceRole;
import io.jmix.security.model.RowLevelRole;
import io.jmix.security.role.ResourceRoleRepository;
import io.jmix.security.role.RowLevelRoleRepository;
import io.jmix.security.role.assignment.RoleAssignment;
import io.jmix.security.role.assignment.RoleAssignmentRepository;
import io.jmix.security.role.assignment.RoleAssignmentRoleType;
import kg.infosystems.buhproject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class InfocomProvider implements AuthenticationProvider {
    private static final Logger log = LoggerFactory.getLogger(InfocomProvider.class);
    @Autowired
    private InfocomService infocomService;
    @Autowired
    private InfocomUserPersistence infocomUserPersistence;
    @Autowired
    private ResourceRoleRepository resourceRoleRepository;
    @Autowired
    private RoleAssignmentRepository roleAssignmentRepository;
    @Autowired
    private RowLevelRoleRepository rowLevelRoleRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication instanceof InfocomAuthToken token) {
            String name = token.getUser();
            String comp = token.getComp();
            String pass = token.getCode();

            try {
                AuthResponse response = infocomService.getToken(name, comp, pass);

                User jmixUser = infocomUserPersistence.loadUserByPin(response.getPersonIdnp(), response.getPersonFio());
                jmixUser.setAuthorities(fetchAuthorities(jmixUser.getUsername()));

                UsernamePasswordAuthenticationToken result = UsernamePasswordAuthenticationToken.authenticated(authentication.getPrincipal(), authentication, jmixUser.getAuthorities());
                result.setDetails(authentication.getDetails());
                return result;
            } catch (Exception e) {
                throw new AuthenticationServiceException("Info exc", e);
            }
        }

        return null;
    }

    private Collection<? extends GrantedAuthority> fetchAuthorities(String username) {
        return roleAssignmentRepository.getAssignmentsByUsername(username).stream()
            .map(this::fetchAuthority)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    private GrantedAuthority fetchAuthority(RoleAssignment roleAssignment) {
        GrantedAuthority authority = null;
        if (RoleAssignmentRoleType.RESOURCE.equals(roleAssignment.getRoleType())) {
            ResourceRole role = resourceRoleRepository.findRoleByCode(roleAssignment.getRoleCode());
            if (role != null) {
                authority = RoleGrantedAuthority.ofResourceRole(role);
            }
        } else if (RoleAssignmentRoleType.ROW_LEVEL.equals(roleAssignment.getRoleType())) {
            RowLevelRole role = rowLevelRoleRepository.findRoleByCode(roleAssignment.getRoleCode());
            if (role != null) {
                authority = RoleGrantedAuthority.ofRowLevelRole(role);
            }
        }
        return authority;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.getName().equals(InfocomAuthToken.class.getName());
    }
}
