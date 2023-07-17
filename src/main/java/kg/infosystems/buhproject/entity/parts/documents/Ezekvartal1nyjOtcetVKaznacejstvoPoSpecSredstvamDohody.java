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
@Table(name = "Ezekvartal1nyjOtcetVKaznacejstvoPoSpecSredstvamDohody", schema = "parts_documents")
@Getter
@Setter
public class Ezekvartal1nyjOtcetVKaznacejstvoPoSpecSredstvamDohody {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.Ezekvartal1nyjOtcetVKaznacejstvoPoSpecSredstvam part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "STAT1A", length = 200)
    private String stat1a;

	@Column(name = "UTVERZDENO_PO_SMETE_NA_GOD", precision = 15, scale = 2)
    private BigDecimal utverzdenoPoSmeteNaGod;

	@Column(name = "UTOCNENNAA_SMETA_NA_OTCETNYJ_PERIOD", precision = 15, scale = 2)
    private BigDecimal utocnennaaSmetaNaOtcetnyjPeriod;

	@Column(name = "VSEGO_KASSOVYH_RASHODOV", precision = 15, scale = 2)
    private BigDecimal vsegoKassovyhRashodov;

	@Column(name = "PO_KAZNACEJSTVU", precision = 15, scale = 2)
    private BigDecimal poKaznacejstvu;

	@Column(name = "PO_KASSE_BUDZETNOGO_UCREZDENIA", precision = 15, scale = 2)
    private BigDecimal poKasseBudzetnogoUcrezdenia;

	@Column(name = "FAKTICESKIJ_DOHOD_I_RASHOD", precision = 15, scale = 2)
    private BigDecimal fakticeskijDohodIRashod;

	@Column(name = "KOD", length = 10)
    private String kod;

}
