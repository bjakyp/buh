package kg.infosystems.buhproject.entity.parts.catalogs;

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
@Table(name = "Pol1zovateliKontaktnaaInformacia", schema = "parts_catalogs")
@Getter
@Setter
public class Pol1zovateliKontaktnaaInformacia {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipyKontaktnojInformacii tip;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii vid;

	@Column(name = "PREDSTAVLENIE", length = 500)
    private String predstavlenie;

	@Lob
	@Column(name = "ZNACENIA_POLEJ")
    private String znaceniaPolej;

	@Column(name = "STRANA", length = 100)
    private String strana;

	@Column(name = "REGION", length = 50)
    private String region;

	@Column(name = "GOROD", length = 50)
    private String gorod;

	@Column(name = "ADRES_EP", length = 100)
    private String adresEP;

	@Column(name = "DOMENNOE_IMA_SERVERA", length = 100)
    private String domennoeImaServera;

	@Column(name = "NOMER_TELEFONA", length = 20)
    private String nomerTelefona;

	@Column(name = "NOMER_TELEFONA_BEZ_KODOV", length = 20)
    private String nomerTelefonaBezKodov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_DLA_SPISKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii vidDlaSpiska;

	@Lob
	@Column(name = "ZNACENIE")
    private String znacenie;

}
