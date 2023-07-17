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
@Entity(name = "informations_RabotnikiKaznacejstva")
@Table(name = "RabotnikiKaznacejstvaIr", schema = "informations")
@Getter
@Setter
public class RabotnikiKaznacejstva extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOLZNOST1_SOTRUDNIKA_KAZNACEJSTVA_ID")
    private kg.infosystems.buhproject.entity.enumerations.DolznostiSotrudnikovKaznacejstva dolznost1SotrudnikaKaznacejstva;

	@Column(name = "FIO", length = 200)
    private String fIO;

}
