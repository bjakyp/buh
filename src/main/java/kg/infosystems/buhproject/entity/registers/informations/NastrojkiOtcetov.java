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
@Entity(name = "informations_NastrojkiOtcetov")
@Table(name = "NastrojkiOtcetovIr", schema = "informations")
@Getter
@Setter
public class NastrojkiOtcetov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_OTCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ob2ektOtcet;

	@Column(name = "VYVODIT1_MESTO_DLA_STAMPA")
    private Boolean vyvodit1MestoDlaStampa;

}
