package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VersiiRassirenij", schema = "catalogs")
@Getter
@Setter
public class VersiiRassirenij {
	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;

	@Column(name = "VERSIA_DANNYH")
	@Version
	private Integer versiaDannyh;

	@DeletedBy
	@Column(name = "DELETED_BY")
	private String deletedBy;

	@DeletedDate
	@Column(name = "DELETED_DATE")
	private LocalDateTime deletedDate;

	@Column(name = "KOD", precision = 9, scale = 0)
	private BigDecimal kod;

	@Lob
	@Column(name = "OPISANIE_METADANNYH")
	private String opisanieMetadannyh;

	@Column(name = "DATA_POSLEDNEGO_ISPOL1ZOVANIA")
	private LocalDateTime dataPoslednegoIspol1zovania;

}
