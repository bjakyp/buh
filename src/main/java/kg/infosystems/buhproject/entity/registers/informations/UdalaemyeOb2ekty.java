package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity(name = "informations_UdalaemyeOb2ekty")
@Table(name = "UdalaemyeOb2ektyIr", schema = "informations")
@Getter
@Setter
public class UdalaemyeOb2ekty extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple ob2ekt;

	@Column(name = "IDENTIFIKATOR_SEANSA")
	private UUID identifikatorSeansa;

	@Column(name = "VREMA_BLOKIROVKI")
	private LocalDateTime vremaBlokirovki;

}
