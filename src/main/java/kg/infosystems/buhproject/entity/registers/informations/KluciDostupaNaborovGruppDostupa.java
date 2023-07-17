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
@Entity(name = "informations_KluciDostupaNaborovGruppDostupa")
@Table(name = "KluciDostupaNaborovGruppDostupaIr", schema = "informations")
@Getter
@Setter
public class KluciDostupaNaborovGruppDostupa extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NABOR_GRUPP_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryGruppDostupa naborGruppDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUC_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KluciDostupa klucDostupa;

	@Column(name = "IZMENENIE")
    private Boolean izmenenie;

	@Column(name = "DOBAVLENIE")
    private Boolean dobavlenie;

}
