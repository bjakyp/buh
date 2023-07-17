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
@Entity(name = "informations_NastrojkiVersionirovaniaOb2ektov")
@Table(name = "NastrojkiVersionirovaniaOb2ektovIr", schema = "informations")
@Getter
@Setter
public class NastrojkiVersionirovaniaOb2ektov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_OB2EKTA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple tipOb2ekta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VARIANT_ID")
    private kg.infosystems.buhproject.entity.enumerations.VariantyVersionirovaniaOb2ektov variant;

	@Column(name = "ISPOL1ZOVAT1")
    private Boolean ispol1zovat1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SROK_HRANENIA_VERSIJ_ID")
    private kg.infosystems.buhproject.entity.enumerations.SrokiHraneniaVersij srokHraneniaVersij;

}
