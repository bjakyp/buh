package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "ACCOUNT_TYPE", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_ACCOUNT_TYPE_PARENT", columnList = "PARENT")
})
@Entity
@Getter
@Setter
public class AccountType extends BaseDict<AccountType> {
    @JoinColumn(name = "PARENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountType parent;
}
