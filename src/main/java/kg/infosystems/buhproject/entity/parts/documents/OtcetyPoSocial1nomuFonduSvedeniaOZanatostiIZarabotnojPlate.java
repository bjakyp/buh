package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate", schema = "parts_documents")
@Getter
@Setter
public class OtcetyPoSocial1nomuFonduSvedeniaOZanatostiIZarabotnojPlate {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.OtcetyPoSocial1nomuFondu part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@Column(name = "DATA_NACALA_RABOTY")
    private LocalDateTime dataNacalaRaboty;

	@Column(name = "DATA_OKONCANIA_RABOTY")
    private LocalDateTime dataOkoncaniaRaboty;

	@Column(name = "DNEJ", precision = 10, scale = 0)
    private BigDecimal dnej;

	@Column(name = "FAKTICESKI_DNEJ", precision = 10, scale = 0)
    private BigDecimal fakticeskiDnej;

	@Column(name = "FOND_OPLATY_TRUDA", precision = 15, scale = 2)
    private BigDecimal fondOplatyTruda;

	@Column(name = "DOPOLNITEL1NYJ_FOND_OPLATY_TRUDA", precision = 15, scale = 2)
    private BigDecimal dopolnitel1nyjFondOplatyTruda;

	@Column(name = "NACISLENNYE_STRAHOVYE_VZNOSY", precision = 15, scale = 2)
    private BigDecimal nacislennyeStrahovyeVznosy;

	@Column(name = "NACSILENYE_VZNOSY_PO_NPF", precision = 15, scale = 2)
    private BigDecimal nacsilenyeVznosyPoNPF;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KATEGORIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KategoriiSotrudnikov kategoria;

}
