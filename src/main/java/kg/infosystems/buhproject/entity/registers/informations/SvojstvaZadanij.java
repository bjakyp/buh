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
@Entity(name = "informations_SvojstvaZadanij")
@Table(name = "SvojstvaZadanijIr", schema = "informations")
@Getter
@Setter
public class SvojstvaZadanij extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_ZADANIA")
    private UUID identifikatorZadania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZADANIE_ID")
    private kg.infosystems.buhproject.entity.one.Multiple zadanie;

	@Column(name = "KOD_SOSTOANIA", precision = 10, scale = 0)
    private BigDecimal kodSostoania;

	@Column(name = "OSIBKA")
    private Boolean osibka;

	@Column(name = "IDENTIFIKATOR_SOOBSENIA_OB_OSIBKE")
    private UUID identifikatorSoobseniaObOsibke;

	@Column(name = "IDENTIFIKATOR_REZUL1TATA")
    private UUID identifikatorRezul1tata;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
