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
@Table(name = "IdentifikatoryOb2ektovMetadannyh", schema = "catalogs")
@Getter
@Setter
public class IdentifikatoryOb2ektovMetadannyh {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh roditel1;

	@Column(name = "PORADOK_KOLLEKCII", precision = 2, scale = 0)
    private BigDecimal poradokKollekcii;

	@Column(name = "IMA", length = 255)
    private String ima;

	@Column(name = "SINONIM", length = 255)
    private String sinonim;

	@Column(name = "POLNOE_IMA", length = 430)
    private String polnoeIma;

	@Column(name = "POLNYJ_SINONIM", length = 430)
    private String polnyjSinonim;

	@Column(name = "BEZ_DANNYH")
    private Boolean bezDannyh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_PUSTOJ_SSYLKI_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znaceniePustojSsylki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUC_OB2EKTA_METADANNYH_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage klucOb2ektaMetadannyh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOVAA_SSYLKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh novaaSsylka;

}
