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
@Entity(name = "informations_KluciDostupaKOb2ektam")
@Table(name = "KluciDostupaKOb2ektamIr", schema = "informations")
@Getter
@Setter
public class KluciDostupaKOb2ektam extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ob2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUC_DOSTUPA_POL1ZOVATELEJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.KluciDostupa klucDostupaPol1zovatelej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUC_DOSTUPA_VNESNIH_POL1ZOVATELEJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.KluciDostupa klucDostupaVnesnihPol1zovatelej;

}
