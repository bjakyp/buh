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
@Entity(name = "informations_NasledovanieNastroekPravOb2ektov")
@Table(name = "NasledovanieNastroekPravOb2ektovIr", schema = "informations")
@Getter
@Setter
public class NasledovanieNastroekPravOb2ektov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.catalogs.PapkiFajlov ob2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.PapkiFajlov roditel1;

	@Column(name = "NASLEDOVAT1")
    private Boolean nasledovat1;

	@Column(name = "UROVEN1_ISPOL1ZOVANIA", precision = 1, scale = 0)
    private BigDecimal uroven1Ispol1zovania;

}
