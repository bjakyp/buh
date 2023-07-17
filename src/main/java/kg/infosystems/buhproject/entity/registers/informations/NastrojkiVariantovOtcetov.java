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
@Entity(name = "informations_NastrojkiVariantovOtcetov")
@Table(name = "NastrojkiVariantovOtcetovIr", schema = "informations")
@Getter
@Setter
public class NastrojkiVariantovOtcetov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VARIANT_ID")
    private kg.infosystems.buhproject.entity.catalogs.VariantyOtcetov variant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODSISTEMA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple podsistema;

	@Column(name = "VIDIMOST1")
    private Boolean vidimost1;

	@Column(name = "BYSTRYJ_DOSTUP")
    private Boolean bystryjDostup;

}
