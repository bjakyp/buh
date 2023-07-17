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
@Entity(name = "informations_Pol1zovatel1skieNastrojkiDostupaKObrabotkam")
@Table(name = "Pol1zovatel1skieNastrojkiDostupaKObrabotkamIr", schema = "informations")
@Getter
@Setter
public class Pol1zovatel1skieNastrojkiDostupaKObrabotkam extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOPOLNITEL1NYJ_OTCET_ILI_OBRABOTKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dopolnitel1nyeOtcetyIObrabotki dopolnitel1nyjOtcetIliObrabotka;

	@Column(name = "IDENTIFIKATOR_KOMANDY", length = 100)
    private String identifikatorKomandy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@Column(name = "DOSTUPNO")
    private Boolean dostupno;

}
