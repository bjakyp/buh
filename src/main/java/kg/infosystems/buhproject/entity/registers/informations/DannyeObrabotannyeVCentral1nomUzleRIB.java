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
@Entity(name = "informations_DannyeObrabotannyeVCentral1nomUzleRIB")
@Table(name = "DannyeObrabotannyeVCentral1nomUzleRIBIr", schema = "informations")
@Getter
@Setter
public class DannyeObrabotannyeVCentral1nomUzleRIB extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_PLANA_OBMENA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelPlanaObmena;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_METADANNYH_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ob2ektMetadannyh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DANNYE_ID")
    private kg.infosystems.buhproject.entity.one.Multiple dannye;

	@Column(name = "OCERED1", precision = 10, scale = 0)
    private BigDecimal ocered1;

	@Column(name = "KLUC_UNIKAL1NOSTI")
    private UUID klucUnikal1nosti;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIA_OTBOROV_NEZAVISIMOGO_REGISTRA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage znaceniaOtborovNezavisimogoRegistra;

}
