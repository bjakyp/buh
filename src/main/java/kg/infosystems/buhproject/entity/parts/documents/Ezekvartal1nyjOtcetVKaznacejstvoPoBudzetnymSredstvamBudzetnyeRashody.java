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
@Table(name = "Ezekvartal1nyjOtcetVKaznacejstvoPoBudzetnymSredstvamBudzetnyeRashody", schema = "parts_documents")
@Getter
@Setter
public class Ezekvartal1nyjOtcetVKaznacejstvoPoBudzetnymSredstvamBudzetnyeRashody {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.Ezekvartal1nyjOtcetVKaznacejstvoPoBudzetnymSredstvam part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAT1A_ID")
    private kg.infosystems.buhproject.entity.catalogs.Stat1iDohodovIRashodov stat1a;

	@Column(name = "UTVERZDENO_PO_SMETE_NA_GOD", precision = 15, scale = 2)
    private BigDecimal utverzdenoPoSmeteNaGod;

	@Column(name = "UTOCNENNAA_SMETA_NA_OTCETNYJ_PERIOD", precision = 15, scale = 2)
    private BigDecimal utocnennaaSmetaNaOtcetnyjPeriod;

	@Column(name = "OTKRYTO_KREDITOV_NA_OTCETNYJ_PERIOD", precision = 15, scale = 2)
    private BigDecimal otkrytoKreditovNaOtcetnyjPeriod;

	@Column(name = "KASSOVYE_RASHODY", precision = 15, scale = 2)
    private BigDecimal kassovyeRashody;

	@Column(name = "FAKTICESKIE_RASHODY", precision = 15, scale = 2)
    private BigDecimal fakticeskieRashody;

	@Column(name = "OBAZATEL1STVA_I_KONTRAKTY", precision = 15, scale = 2)
    private BigDecimal obazatel1stvaIKontrakty;

	@Column(name = "KOD", length = 10)
    private String kod;

}
