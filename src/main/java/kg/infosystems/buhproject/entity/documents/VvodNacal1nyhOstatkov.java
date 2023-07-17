package kg.infosystems.buhproject.entity.documents;

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
@Table(name = "VvodNacal1nyhOstatkov", schema = "documents")
@Getter
@Setter
public class VvodNacal1nyhOstatkov {
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

	@Column(name = "DATA")
	private LocalDateTime data;

	@Column(name = "NOMER", length = 9)
	private String nomer;

	@Column(name = "PROVEDEN")
	private Boolean proveden;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
	private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@Column(name = "RAZDEL_UCETA", length = 30)
	private String razdelUceta;

	@Column(name = "NE_PRINATYE_K_UCETU")
	private Boolean nePrinatyeKUcetu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKLAD_ID")
	private kg.infosystems.buhproject.entity.catalogs.Sklady sklad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOL_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica mOL;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
	private BigDecimal summaDokumenta;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

}
