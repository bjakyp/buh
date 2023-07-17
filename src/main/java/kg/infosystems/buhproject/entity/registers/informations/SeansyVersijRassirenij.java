package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SeansyVersijRassirenij")
@Table(name = "SeansyVersijRassirenijIr", schema = "informations")
@Getter
@Setter
public class SeansyVersijRassirenij extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VERSIA_RASSIRENIJ_ID")
	private kg.infosystems.buhproject.entity.catalogs.VersiiRassirenij versiaRassirenij;

	@Column(name = "NOMER_SEANSA", precision = 10, scale = 0)
	private BigDecimal nomerSeansa;

	@Column(name = "NACALO_SEANSA")
	private LocalDateTime nacaloSeansa;

}
