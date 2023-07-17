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
@Table(name = "EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvamDohody", schema = "parts_documents")
@Getter
@Setter
public class EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvamDohody {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.EzemesacnyjOtcetVKaznacejstvoPoSpecSredstvam part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "STAT1A", length = 200)
    private String stat1a;

	@Column(name = "UTOCNENNAA_SMETA_NA_GOD", precision = 15, scale = 2)
    private BigDecimal utocnennaaSmetaNaGod;

	@Column(name = "UTOCNENNAA_SMETA_NA_OTCETNYJ_PERIOD", precision = 15, scale = 2)
    private BigDecimal utocnennaaSmetaNaOtcetnyjPeriod;

	@Column(name = "KASSOVYE_RASHODY_ZA_PREDYDUSIJ_PERIOD", precision = 15, scale = 2)
    private BigDecimal kassovyeRashodyZaPredydusijPeriod;

	@Column(name = "KASSOVYE_RASHODY_ZA_OTCETNYJ_PERIOD", precision = 15, scale = 2)
    private BigDecimal kassovyeRashodyZaOtcetnyjPeriod;

	@Column(name = "KASSOVYE_RASHODY_S_NACALA_GODA", precision = 15, scale = 2)
    private BigDecimal kassovyeRashodySNacalaGoda;

	@Column(name = "OSTATOK", precision = 15, scale = 2)
    private BigDecimal ostatok;

}
