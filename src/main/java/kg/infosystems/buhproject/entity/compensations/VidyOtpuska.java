package kg.infosystems.buhproject.entity.compensations;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.MetodyRascetaOtpuska;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Table(name = "VIDY_OTPUSKA", schema = "comps", indexes = {
    @Index(name = "IDX_VIDY_OTPUSKA_METODY_RASCETA_OTPUSKA", columnList = "METODY_RASCETA_OTPUSKA_ID")
})
@Entity
@Getter
@Setter
public class VidyOtpuska extends BaseEntity {

    @Column(name = "CODE", length = 25)
    private String code;

    @InstanceName
    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "SHORT_NAME", length = 500)
    private String shortName;

//    @JoinColumn(name = "PARENT")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Rok parent;

    @Column(name = "ACTIVE")
    private Boolean active;

    @JoinColumn(name = "METODY_RASCETA_OTPUSKA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetodyRascetaOtpuska metodyRascetaOtpuska;
}
