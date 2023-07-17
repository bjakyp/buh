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
@Entity(name = "informations_KluciDostupaKRegistram")
@Table(name = "KluciDostupaKRegistramIr", schema = "informations")
@Getter
@Setter
public class KluciDostupaKRegistram extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registr;

	@Column(name = "VARIANT_DOSTUPA", precision = 4, scale = 0)
    private BigDecimal variantDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLE1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pole1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLE2_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pole2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLE3_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pole3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLE4_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pole4;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLE5_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pole5;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUC_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KluciDostupa klucDostupa;

}
