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
@Entity(name = "informations_PravilaDlaObmenaDannymi")
@Table(name = "PravilaDlaObmenaDannymiIr", schema = "informations")
@Getter
@Setter
public class PravilaDlaObmenaDannymi extends BaseEntity {
	@Column(name = "IMA_PLANA_OBMENA", length = 150)
    private String imaPlanaObmena;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_PRAVIL_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyPravilDlaObmenaDannymi vidPravil;

	@Column(name = "IMA_MAKETA_PRAVIL", length = 150)
    private String imaMaketaPravil;

	@Column(name = "IMA_MAKETA_PRAVIL_KORRESPONDENTA", length = 150)
    private String imaMaketaPravilKorrespondenta;

	@Column(name = "IMA_PLANA_OBMENA_IZ_PRAVIL", length = 150)
    private String imaPlanaObmenaIzPravil;

	@Column(name = "IMA_FAJLA_OBRABOTKI_DLA_OTLADKI_VYGRUZKI", length = 255)
    private String imaFajlaObrabotkiDlaOtladkiVygruzki;

	@Column(name = "IMA_FAJLA_OBRABOTKI_DLA_OTLADKI_ZAGRUZKI", length = 255)
    private String imaFajlaObrabotkiDlaOtladkiZagruzki;

	@Column(name = "IMA_FAJLA_PRAVIL", length = 255)
    private String imaFajlaPravil;

	@Column(name = "IMA_FAJLA_PROTOKOLA_OBMENA", length = 255)
    private String imaFajlaProtokolaObmena;

	@Lob
	@Column(name = "INFORMACIA_O_PRAVILAH")
    private String informaciaOPravilah;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISTOCNIK_PRAVIL_ID")
    private kg.infosystems.buhproject.entity.enumerations.IstocnikiPravilDlaObmenaDannymi istocnikPravil;

	@Column(name = "NE_OSTANAVLIVAT1_PO_OSIBKE")
    private Boolean neOstanavlivat1PoOsibke;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILA_XML_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage pravilaXML;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILA_XML_KORRESPONDENTA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage pravilaXMLKorrespondenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILA_ZACITANNYE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage pravilaZacitannye;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILA_ZACITANNYE_KORRESPONDENTA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage pravilaZacitannyeKorrespondenta;

	@Column(name = "REZIM_OTLADKI")
    private Boolean rezimOtladki;

	@Column(name = "REZIM_OTLADKI_VYGRUZKI")
    private Boolean rezimOtladkiVygruzki;

	@Column(name = "REZIM_OTLADKI_ZAGRUZKI")
    private Boolean rezimOtladkiZagruzki;

	@Column(name = "REZIM_PROTOKOLIROVANIA_OBMENA_DANNYMI")
    private Boolean rezimProtokolirovaniaObmenaDannymi;

	@Column(name = "ISPOL1ZOVAT1_FIL1TR_VYBOROCNOJ_REGISTRACII_OB2EKTOV")
    private Boolean ispol1zovat1Fil1trVyborocnojRegistraciiOb2ektov;

	@Column(name = "PRAVILA_ZAGRUZENY")
    private Boolean pravilaZagruzeny;

}
