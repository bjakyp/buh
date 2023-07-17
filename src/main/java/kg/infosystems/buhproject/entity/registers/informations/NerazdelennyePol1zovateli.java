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
@Entity(name = "informations_NerazdelennyePol1zovateli")
@Table(name = "NerazdelennyePol1zovateliIr", schema = "informations")
@Getter
@Setter
public class NerazdelennyePol1zovateli extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_POL1ZOVATELA_IB")
    private UUID identifikatorPol1zovatelaIB;

	@Column(name = "PORADKOVYJ_NOMER", precision = 5, scale = 0)
    private BigDecimal poradkovyjNomer;

	@Column(name = "IMA_POL1ZOVATELA", length = 255)
    private String imaPol1zovatela;

}
