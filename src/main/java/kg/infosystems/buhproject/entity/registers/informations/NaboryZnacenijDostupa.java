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
@Entity(name = "informations_NaboryZnacenijDostupa")
@Table(name = "NaboryZnacenijDostupaIr", schema = "informations")
@Getter
@Setter
public class NaboryZnacenijDostupa extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ob2ekt;

	@Column(name = "NOMER_NABORA", precision = 10, scale = 0)
    private BigDecimal nomerNabora;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenieDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UTOCNENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh utocnenie;

	@Column(name = "CTENIE")
    private Boolean ctenie;

	@Column(name = "IZMENENIE")
    private Boolean izmenenie;

	@Column(name = "STANDARTNOE_ZNACENIE")
    private Boolean standartnoeZnacenie;

	@Column(name = "ZNACENIE_BEZ_GRUPP")
    private Boolean znacenieBezGrupp;

}
