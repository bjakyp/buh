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
@Entity(name = "informations_StatusySinhronizaciiFajlovSOblacnymServisom")
@Table(name = "StatusySinhronizaciiFajlovSOblacnymServisomIr", schema = "informations")
@Getter
@Setter
public class StatusySinhronizaciiFajlovSOblacnymServisom extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_ID")
    private kg.infosystems.buhproject.entity.one.Multiple fajl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCETNAA_ZAPIS1_ID")
    private kg.infosystems.buhproject.entity.catalogs.UcetnyeZapisiSinhronizaciiFajlov ucetnaaZapis1;

	@Lob
	@Column(name = "HREF")
    private String href;

	@Lob
	@Column(name = "ETAG")
    private String etag;

	@Column(name = "UNIKAL1NYJ_IDENTIFIKATOR1_S")
    private UUID unikal1nyjIdentifikator1S;

	@Column(name = "ETO_FAJL")
    private Boolean etoFajl;

	@Column(name = "ETO_VLADELEC_FAJLA")
    private Boolean etoVladelecFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_FAJLA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple vladelecFajla;

	@Column(name = "SINHRONIZIROVAN")
    private Boolean sinhronizirovan;

	@Column(name = "DATA_SINHRONIZACII_NACALO")
    private LocalDateTime dataSinhronizaciiNacalo;

	@Column(name = "DATA_SINHRONIZACII_ZAVERSENIE")
    private LocalDateTime dataSinhronizaciiZaversenie;

	@Column(name = "NOMER_SEANSA", precision = 25, scale = 0)
    private BigDecimal nomerSeansa;

}
