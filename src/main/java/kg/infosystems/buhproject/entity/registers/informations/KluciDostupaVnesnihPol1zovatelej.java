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
@Entity(name = "informations_KluciDostupaVnesnihPol1zovatelej")
@Table(name = "KluciDostupaVnesnihPol1zovatelejIr", schema = "informations")
@Getter
@Setter
public class KluciDostupaVnesnihPol1zovatelej extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VNESNIJ_POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryGruppDostupa vnesnijPol1zovatel1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUC_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KluciDostupa klucDostupa;

	@Column(name = "IZMENENIE")
    private Boolean izmenenie;

	@Column(name = "DOBAVLENIE")
    private Boolean dobavlenie;

	@Column(name = "ETO_PRAVA_NABORA_GRUPP")
    private Boolean etoPravaNaboraGrupp;

}
