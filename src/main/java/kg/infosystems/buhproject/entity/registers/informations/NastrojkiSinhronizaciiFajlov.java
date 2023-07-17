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
@Entity(name = "informations_NastrojkiSinhronizaciiFajlov")
@Table(name = "NastrojkiSinhronizaciiFajlovIr", schema = "informations")
@Getter
@Setter
public class NastrojkiSinhronizaciiFajlov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_FAJLA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple vladelecFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_VLADEL1CA_FAJLA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh tipVladel1caFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCETNAA_ZAPIS1_ID")
    private kg.infosystems.buhproject.entity.catalogs.UcetnyeZapisiSinhronizaciiFajlov ucetnaaZapis1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILO_OTBORA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage praviloOtbora;

	@Column(name = "SINHRONIZIROVAT1")
    private Boolean sinhronizirovat1;

	@Column(name = "ETO_FAJL")
    private Boolean etoFajl;

	@Column(name = "NAIMENOVANIE", length = 250)
    private String naimenovanie;

}
