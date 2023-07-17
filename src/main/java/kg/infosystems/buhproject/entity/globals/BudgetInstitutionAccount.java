package kg.infosystems.buhproject.entity.globals;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.base.BaseLong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Table(name = "BUDGET_INSTITUTION_ACCOUNT", schema = "GLOBALS", indexes = {
    @Index(name = "IDX_BUDGET_INSTITUTION_ACCOUNT_BUDGET_INSTITUTION", columnList = "BUDGET_INSTITUTION_ID"),
    @Index(name = "IDX_BUDGET_INSTITUTION_ACCOUNT_ACCOUNT_TYPE", columnList = "ACCOUNT_TYPE_ID"),
    @Index(name = "IDX_BUDGET_INSTITUTION_ACCOUNT_VEDOM_CLASSIFIER", columnList = "VEDOM_CLASSIFIER_ID"),
    @Index(name = "IDX_BUDGET_INSTITUTION_ACCOUNT_FUNCTION_CLASSIFIER", columnList = "FUNCTION_CLASSIFIER_ID"),
    @Index(name = "IDX_BUDGET_INSTITUTION_ACCOUNT_BUDGET", columnList = "BUDGET_ID")
})
@Entity
@Getter
@Setter
public class BudgetInstitutionAccount extends BaseLong {
    @Column(name = "CODE", length = 25)
    private String code;

    @InstanceName
    @Column(name = "NAME", length = 500)
    private String name;

    @JoinColumn(name = "BUDGET_INSTITUTION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private BudgetInstitution budgetInstitution;

    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private AccountType accountType;

    @JoinColumn(name = "VEDOM_CLASSIFIER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VedomClassifier vedomClassifier;

    @JoinColumn(name = "FUNCTION_CLASSIFIER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FunctionClassifer functionClassifier;

    @JoinColumn(name = "BUDGET_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Budget budget;

    @Column(name = "CHK_BD", nullable = false)
    @NotNull
    private Boolean chkBd = true;
}
