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
@Entity(name = "informations_Pol1zovatel1skieMaketyPecati")
@Table(name = "Pol1zovatel1skieMaketyPecatiIr", schema = "informations")
@Getter
@Setter
public class Pol1zovatel1skieMaketyPecati extends BaseEntity {
	@Column(name = "IMA_MAKETA", length = 100)
    private String imaMaketa;

	@Column(name = "OB2EKT", length = 255)
    private String ob2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAKET_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage maket;

	@Column(name = "ISPOL1ZOVANIE")
    private Boolean ispol1zovanie;

}
