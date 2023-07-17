package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@JmixEntity
@Entity(name = "informations_ZapusennyeObrabotcikiOcerediZadanij")
@Table(name = "ZapusennyeObrabotcikiOcerediZadanijIr", schema = "informations")
@Getter
@Setter
public class ZapusennyeObrabotcikiOcerediZadanij extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBRABOTCIK_ID")
	private kg.infosystems.buhproject.entity.catalogs.ObrabotcikiOcerediZadanij obrabotcik;

	@Column(name = "NOMER", precision = 2, scale = 0)
	private BigDecimal nomer;

}
