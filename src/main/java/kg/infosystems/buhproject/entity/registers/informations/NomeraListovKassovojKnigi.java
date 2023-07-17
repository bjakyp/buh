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
@Entity(name = "informations_NomeraListovKassovojKnigi")
@Table(name = "NomeraListovKassovojKnigiIr", schema = "informations")
@Getter
@Setter
public class NomeraListovKassovojKnigi extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KASSA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Kassy kassa;

	@Column(name = "NOMER_LISTA", precision = 5, scale = 0)
    private BigDecimal nomerLista;

}
