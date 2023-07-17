package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Zametki", schema = "catalogs")
@Getter
@Setter
public class Zametki {
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

	@Column(name = "NAIMENOVANIE", length = 100)
	private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
	private kg.infosystems.buhproject.entity.catalogs.Zametki roditel1;

	@Column(name = "ETO_GRUPPA")
	private Boolean etoGruppa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
	private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREDMET_ID")
	private kg.infosystems.buhproject.entity.one.Multiple predmet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SODERZANIE_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage soderzanie;

	@Lob
	@Column(name = "TEKST_SODERZANIA")
	private String tekstSoderzania;

	@Column(name = "DLA_RABOCEGO_STOLA")
	private Boolean dlaRabocegoStola;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POMETKA_ID")
	private kg.infosystems.buhproject.entity.enumerations.CvetaZametok pometka;

	@Column(name = "DATA_IZMENENIA")
	private LocalDateTime dataIzmenenia;

	@Column(name = "PREDSTAVLENIE_PREDMETA", length = 100)
	private String predstavleniePredmeta;

}
