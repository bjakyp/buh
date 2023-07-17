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
@Entity(name = "informations_Dopolnitel1nyeSvedenia")
@Table(name = "Dopolnitel1nyeSvedeniaIr", schema = "informations")
@Getter
@Setter
public class Dopolnitel1nyeSvedenia extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ob2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVO_ID")
    private kg.infosystems.buhproject.entity.characteristics.Dopolnitel1nyeRekvizityISvedenia svojstvo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenie;

}
