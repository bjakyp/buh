package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "IstoriaProverkiIKorrektirovkiDannyh", schema = "catalogs")
@Getter
@Setter
public class IstoriaProverkiIKorrektirovkiDannyh {
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

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Column(name = "DATA")
    private LocalDateTime data;

	@Column(name = "ISPRAVLENIE")
    private Boolean ispravlenie;

	@Column(name = "OBNARUZENY_PROBLEMY")
    private Boolean obnaruzenyProblemy;

	@Lob
	@Column(name = "PREDSTAVLENIE_REZUL1TATA")
    private String predstavlenieRezul1tata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TABLICNYJ_DOKUMENT_ID")
    private kg.infosystems.buhproject.entity.catalogs.IstoriaProverkiIKorrektirovkiDannyhPrisoedinennyeFajly tablicnyjDokument;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

}
