package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_TrudovaaDeatel1nost1FiziceskihLic")
@Table(name = "TrudovaaDeatel1nost1FiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class TrudovaaDeatel1nost1FiziceskihLic extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@Column(name = "ORGANIZACIA", length = 100)
	private String organizacia;

	@Column(name = "DATA_NACALA")
	private LocalDateTime dataNacala;

	@Column(name = "DATA_OKONCANIA")
	private LocalDateTime dataOkoncania;

	@Column(name = "DOLZNOST1", length = 100)
	private String dolznost1;

	@Column(name = "PRICINA_UVOL1NENIA", length = 100)
	private String pricinaUvol1nenia;

}
