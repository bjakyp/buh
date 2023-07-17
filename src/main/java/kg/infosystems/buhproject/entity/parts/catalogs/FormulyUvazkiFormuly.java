package kg.infosystems.buhproject.entity.parts.catalogs;

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
@Table(name = "FormulyUvazkiFormuly", schema = "parts_catalogs")
@Getter
@Setter
public class FormulyUvazkiFormuly {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.FormulyUvazki part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNAK_ID")
    private kg.infosystems.buhproject.entity.enumerations.PlusMinus znak;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_UVAZKI_ID")
    private kg.infosystems.buhproject.entity.enumerations.Ob2ektyDlaUvazki ob2ektUvazki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRILOZENIE_ID")
    private kg.infosystems.buhproject.entity.enumerations.PrilozeniaDlaUvazki prilozenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORMULA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple formula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOLONKA_ID")
    private kg.infosystems.buhproject.entity.enumerations.KolonkiDlaUvazki kolonka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOLONKA_BUDZET_ID")
    private kg.infosystems.buhproject.entity.enumerations.KolonkiDlaUvazki kolonkaBudzet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOLONKA_SPEC_SCET_ID")
    private kg.infosystems.buhproject.entity.enumerations.KolonkiDlaUvazki kolonkaSpecScet;

	@Column(name = "VID_SCETA", length = 10)
    private String vidSceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RASSIRENNYJ_KOD_ID")
    private kg.infosystems.buhproject.entity.enumerations.RassirennyeKodyDlaUvazki rassirennyjKod;

}
