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
@Entity(name = "informations_NastrojkiOcistkiFajlov")
@Table(name = "NastrojkiOcistkiFajlovIr", schema = "informations")
@Getter
@Setter
public class NastrojkiOcistkiFajlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_FAJLA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple vladelecFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_VLADEL1CA_FAJLA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh tipVladel1caFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILO_OTBORA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage praviloOtbora;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEJSTVIE_ID")
    private kg.infosystems.buhproject.entity.enumerations.VariantyOcistkiFajlov dejstvie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERIOD_OCISTKI_ID")
    private kg.infosystems.buhproject.entity.enumerations.PeriodOcistkiFajlov periodOcistki;

	@Column(name = "ETO_FAJL")
    private Boolean etoFajl;

}
