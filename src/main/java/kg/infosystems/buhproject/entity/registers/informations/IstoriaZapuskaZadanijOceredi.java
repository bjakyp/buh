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
@Entity(name = "informations_IstoriaZapuskaZadanijOceredi")
@Table(name = "IstoriaZapuskaZadanijOcerediIr", schema = "informations")
@Getter
@Setter
public class IstoriaZapuskaZadanijOceredi extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_ZAPUSKA")
    private UUID identifikatorZapuska;

	@Column(name = "CAS")
    private LocalDateTime cas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZADANIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.Ocered1Zadanij zadanie;

	@Column(name = "DATA")
    private LocalDateTime data;

	@Column(name = "DATA_MS", precision = 3, scale = 0)
    private BigDecimal dataMS;

	@Column(name = "DLITEL1NOST1_ZAPUSKA", precision = 6, scale = 0)
    private BigDecimal dlitel1nost1Zapuska;

	@Column(name = "DLITEL1NOST1_VYPOLNENIA", precision = 9, scale = 0)
    private BigDecimal dlitel1nost1Vypolnenia;

	@Column(name = "SEANS", precision = 10, scale = 0)
    private BigDecimal seans;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
