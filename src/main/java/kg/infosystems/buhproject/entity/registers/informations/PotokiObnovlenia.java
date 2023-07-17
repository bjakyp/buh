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
@Entity(name = "informations_PotokiObnovlenia")
@Table(name = "PotokiObnovleniaIr", schema = "informations")
@Getter
@Setter
public class PotokiObnovlenia extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_POTOKA")
    private UUID identifikatorPotoka;

	@Column(name = "ADRES_REZUL1TATA", length = 255)
    private String adresRezul1tata;

	@Column(name = "GRUPPA", length = 20)
    private String gruppa;

	@Column(name = "NAIMENOVANIE", length = 1024)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETRY_PROCEDURY_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage parametryProcedury;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETRY_PROCEDURY_ZAVERSENIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage parametryProceduryZaversenia;

	@Column(name = "PRIORITET_ZAVERSENIA", precision = 10, scale = 0)
    private BigDecimal prioritetZaversenia;

	@Column(name = "IDENTIFIKATOR_ZADANIA")
    private UUID identifikatorZadania;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
