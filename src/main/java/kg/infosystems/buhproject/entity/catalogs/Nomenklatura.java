package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.NomenklaturaDopolnitel1nyeRekvizity;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "Nomenklatura", schema = "catalogs")
@Getter
@Setter
public class Nomenklatura {
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

	@Column(name = "KOD", length = 11)
    private String kod;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Nomenklatura roditel1;

	@Column(name = "ETO_GRUPPA")
    private Boolean etoGruppa;

	@Column(name = "NAIMENOVANIE_POLNOE", length = 1000)
    private String naimenovaniePolnoe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EDINICA_IZMERENIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KlassifikatorEdinicIzmerenia edinicaIzmerenia;

	@Column(name = "USLUGA")
    private Boolean usluga;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_KARTINKI_ID")
    private kg.infosystems.buhproject.entity.catalogs.NomenklaturaPrisoedinennyeFajly fajlKartinki;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<NomenklaturaDopolnitel1nyeRekvizity> dopolnitel1nyeRekvizity;
}
