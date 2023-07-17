package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SostoaniaUspesnyhObmenovDannymi")
@Table(name = "SostoaniaUspesnyhObmenovDannymiIr", schema = "informations")
@Getter
@Setter
public class SostoaniaUspesnyhObmenovDannymi extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEJSTVIE_PRI_OBMENE_ID")
	private kg.infosystems.buhproject.entity.enumerations.DejstviaPriObmene dejstviePriObmene;

	@Column(name = "DATA_OKONCANIA")
	private LocalDateTime dataOkoncania;

}
