package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.base.BaseLong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "BUDGET_INSTITUTION", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_BUDGET_INSTITUTION_ROK", columnList = "ROK_ID")
})
@Entity
@Getter
@Setter
public class BudgetInstitution extends BaseLong {
    @Column(name = "CODE", length = 25)
    private String code;

    @InstanceName
    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "PRINT_NAME", length = 50)
    private String printName;

    @JoinColumn(name = "ROK_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rok rok;

    @Column(name = "INN")
    private String inn;

    @Column(name = "OKPO", length = 8)
    private String okpo;

    @Column(name = "SFKR", length = 20)
    private String sfkr;

    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountType budgetType;

    @JoinColumn(name = "BUDGET_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Budget ayilOkmotu;

    @Column(name = "IPC_CLIENT_ID", length = 8)
    private String ipcClientId;
}
