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
@Entity(name = "informations_NastrojkiTransportaObmenaSoobseniami")
@Table(name = "NastrojkiTransportaObmenaSoobseniamiIr", schema = "informations")
@Getter
@Setter
public class NastrojkiTransportaObmenaSoobseniami extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KONECNAA_TOCKA_ID")
    private kg.infosystems.buhproject.entity.publications.ObmenSoobseniami konecnaaTocka;

	@Lob
	@Column(name = "ADRES_VEB_SERVISA")
    private String adresVebServisa;

	@Column(name = "IMA_POL1ZOVATELA", length = 165)
    private String imaPol1zovatela;

	@Column(name = "ZAPOMNIT1_PAROL1")
    private Boolean zapomnit1Parol1;

}
