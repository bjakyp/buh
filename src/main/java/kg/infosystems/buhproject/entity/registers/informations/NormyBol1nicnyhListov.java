package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_NormyBol1nicnyhListov")
@Table(name = "NormyBol1nicnyhListovIr", schema = "informations")
@Getter
@Setter
public class NormyBol1nicnyhListov extends BaseEntity {
	@Column(name = "NIZNAA_GRANICA", precision = 2, scale = 0)
    private BigDecimal niznaaGranica;

	@Column(name = "DNEJ_ORGANIZACII", precision = 3, scale = 0)
    private BigDecimal dnejOrganizacii;

	@Column(name = "PROCENT", precision = 5, scale = 2)
    private BigDecimal procent;

	@Column(name = "PROCENT_BEREMENNOST1", precision = 5, scale = 2)
    private BigDecimal procentBeremennost1;

	@Column(name = "RAZMER_ZA_SCET_SF", precision = 15, scale = 2)
    private BigDecimal razmerZaScetSF;

	@Column(name = "RAZMER_BEREMENNOST1_ZA_SCET_SF", precision = 15, scale = 2)
    private BigDecimal razmerBeremennost1ZaScetSF;

}
