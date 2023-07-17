package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SostoaniaObmenovDannymiOblastejDannyh")
@Table(name = "SostoaniaObmenovDannymiOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class SostoaniaObmenovDannymiOblastejDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEJSTVIE_PRI_OBMENE_ID")
	private kg.infosystems.buhproject.entity.enumerations.DejstviaPriObmene dejstviePriObmene;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZUL1TAT_VYPOLNENIA_OBMENA_ID")
	private kg.infosystems.buhproject.entity.enumerations.Rezul1tatyVypolneniaObmena rezul1tatVypolneniaObmena;

	@Column(name = "DATA_NACALA")
	private LocalDateTime dataNacala;

	@Column(name = "DATA_OKONCANIA")
	private LocalDateTime dataOkoncania;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
	private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
