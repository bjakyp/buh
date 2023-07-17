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
@Entity(name = "informations_Ispol1zovanieDopolnitel1nyhOtcetovIObrabotokServisaVAvtonomnomRabocemMeste")
@Table(name = "Ispol1zovanieDopolnitel1nyhOtcetovIObrabotokServisaVAvtonomnomRabocemMesteIr", schema = "informations")
@Getter
@Setter
public class Ispol1zovanieDopolnitel1nyhOtcetovIObrabotokServisaVAvtonomnomRabocemMeste extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOPOLNITEL1NYJ_OTCET_ILI_OBRABOTKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dopolnitel1nyeOtcetyIObrabotki dopolnitel1nyjOtcetIliObrabotka;

	@Column(name = "POSTAVLAEMYJ")
    private Boolean postavlaemyj;

}
