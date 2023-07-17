package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyUderzanij;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Ispolnitel1nyjList", schema = "documents")
@Getter
@Setter
public class Ispolnitel1nyjList {
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

	@NotNull
	@Column(name = "DATA", nullable = false)
	private LocalDateTime data;

	@Column(name = "NOMER", length = 9)
	private String nomer;

	@Column(name = "PROVEDEN")
	private Boolean proveden;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORGANIZACIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "KONTRAGENT_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Kontragenty kontragent;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_RASCETA_ID", nullable = false)
	private VidyUderzanij vidRasceta;

	@NotNull
	@Column(name = "DATA_NACALA", nullable = false)
	private LocalDateTime dataNacala;

	@NotNull
	@Column(name = "DATA_OKONCANIA", nullable = false)
	private LocalDateTime dataOkoncania;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

	@Column(name = "LICEVOJ_SCET", length = 30)
	private String licevojScet;

	@Column(name = "NAZNACENIE_PLATEZA", length = 150)
	private String naznaceniePlateza;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

	@InstanceName
	@DependsOnProperties({"data", "nomer"})
	public String getInstanceName() {
		return String.format("%s %s", data, nomer);
	}

}
