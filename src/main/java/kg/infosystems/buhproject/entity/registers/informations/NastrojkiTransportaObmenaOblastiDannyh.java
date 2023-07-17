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
@Entity(name = "informations_NastrojkiTransportaObmenaOblastiDannyh")
@Table(name = "NastrojkiTransportaObmenaOblastiDannyhIr", schema = "informations")
@Getter
@Setter
public class NastrojkiTransportaObmenaOblastiDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KORRESPONDENT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple korrespondent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONECNAA_TOCKA_KORRESPONDENTA_ID")
    private kg.infosystems.buhproject.entity.publications.ObmenSoobseniami konecnaaTockaKorrespondenta;

	@Lob
	@Column(name = "KATALOG_OBMENA_INFORMACIEJ")
    private String katalogObmenaInformaciej;

}
