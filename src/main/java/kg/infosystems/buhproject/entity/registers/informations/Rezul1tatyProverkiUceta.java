package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_Rezul1tatyProverkiUceta")
@Table(name = "Rezul1tatyProverkiUcetaIr", schema = "informations")
@Getter
@Setter
public class Rezul1tatyProverkiUceta extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEMNYJ_OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple problemnyjOb2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRAVILO_PROVERKI_ID")
    private kg.infosystems.buhproject.entity.catalogs.PravilaProverkiUceta praviloProverki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_PROVERKI_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyProverok vidProverki;

	@Column(name = "KLUC_UNIKAL1NOSTI")
    private UUID klucUnikal1nosti;

	@Column(name = "IGNORIROVAT1_PROBLEMU")
    private Boolean ignorirovat1Problemu;

	@Lob
	@Column(name = "UTOCNENIE_PROBLEMY")
    private String utocnenieProblemy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VAZNOST1_PROBLEMY_ID")
    private kg.infosystems.buhproject.entity.enumerations.Vaznost1ProblemyUceta vaznost1Problemy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTVETSTVENNYJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli otvetstvennyj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOPOLNITEL1NAA_INFORMACIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dopolnitel1naaInformacia;

	@Column(name = "VYAVLENO")
    private LocalDateTime vyavleno;

	@Column(name = "UDALIT1_IGNORIROVAT1_PROBLEMU")
    private Boolean udalit1Ignorirovat1Problemu;

	@Column(name = "KONTROL1NAA_SUMMA", length = 32)
    private String kontrol1naaSumma;

}
