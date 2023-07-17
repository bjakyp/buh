package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@JmixEntity
@Entity(name = "informations_VersiiPodsistemOblastejDannyh")
@Table(name = "VersiiPodsistemOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class VersiiPodsistemOblastejDannyh extends BaseEntity {
    @Column(name = "IMA_PODSISTEMY", length = 100)
    private String imaPodsistemy;

    @Column(name = "VERSIA", length = 15)
    private String versia;

    @Column(name = "VYPOLNENA_REGISTRACIA_OTLOZENNYH_OBRABOTCIKOV")
    private Boolean vypolnenaRegistraciaOtlozennyhObrabotcikov;

    @Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
