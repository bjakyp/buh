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
@Entity(name = "informations_PravaRolej")
@Table(name = "PravaRolejIr", schema = "informations")
@Getter
@Setter
public class PravaRolej extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_METADANNYH_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ob2ektMetadannyh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh rol1;

	@Column(name = "IZMENENIE")
    private Boolean izmenenie;

	@Column(name = "DOBAVLENIE")
    private Boolean dobavlenie;

	@Column(name = "CTENIE_BEZ_OGRANICENIA")
    private Boolean ctenieBezOgranicenia;

	@Column(name = "IZMENENIE_BEZ_OGRANICENIA")
    private Boolean izmenenieBezOgranicenia;

	@Column(name = "DOBAVLENIE_BEZ_OGRANICENIA")
    private Boolean dobavlenieBezOgranicenia;

	@Column(name = "PROSMOTR")
    private Boolean prosmotr;

	@Column(name = "REDAKTIROVANIE")
    private Boolean redaktirovanie;

	@Column(name = "INTERAKTIVNOE_DOBAVLENIE")
    private Boolean interaktivnoeDobavlenie;

}
