package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_ZameryVremeniTehnologiceskie")
@Table(name = "ZameryVremeniTehnologiceskieIr", schema = "informations")
@Getter
@Setter
public class ZameryVremeniTehnologiceskie extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUCEVAA_OPERACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.KlucevyeOperacii klucevaaOperacia;

	@Column(name = "DATA_NACALA_ZAMERA", precision = 14, scale = 0)
	private BigDecimal dataNacalaZamera;

	@Column(name = "NOMER_SEANSA", precision = 15, scale = 0)
	private BigDecimal nomerSeansa;

	@Column(name = "DATA_ZAPISI_NACALO_CASA")
	private LocalDateTime dataZapisiNacaloCasa;

	@Column(name = "VREMA_VYPOLNENIA", precision = 15, scale = 3)
	private BigDecimal vremaVypolnenia;

	@Column(name = "VES_ZAMERA", precision = 10, scale = 0)
	private BigDecimal vesZamera;

	@Column(name = "KOMMENTARIJ", length = 1000)
	private String kommentarij;

	@Column(name = "DATA_ZAPISI")
	private LocalDateTime dataZapisi;

	@Column(name = "DATA_OKONCANIA", precision = 14, scale = 0)
	private BigDecimal dataOkoncania;

	@Column(name = "POL1ZOVATEL1", length = 128)
	private String pol1zovatel1;

	@Column(name = "DATA_ZAPISI_LOKAL1NAA")
	private LocalDateTime dataZapisiLokal1naa;

}
