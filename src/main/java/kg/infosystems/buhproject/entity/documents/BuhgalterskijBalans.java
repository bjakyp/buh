package kg.infosystems.buhproject.entity.documents;

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
@Table(name = "BuhgalterskijBalans", schema = "documents")
@Getter
@Setter
public class BuhgalterskijBalans {
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
	@JoinColumn(name = "VID_BUDZETA_ID")
    private kg.infosystems.buhproject.entity.enumerations.VidyBudzeta vidBudzeta;

	@Column(name = "NACALO_PERIODA")
    private LocalDateTime nacaloPerioda;

	@Column(name = "KONEC_PERIODA")
    private LocalDateTime konecPerioda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EDINICA_OTCETA_ID")
    private kg.infosystems.buhproject.entity.enumerations.EdinicyOtcetov edinicaOtceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_BALANS_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaBalans;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE1_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE2_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE3_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE4_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie4;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE5_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie5;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE6_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie6;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE7_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie7;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE8_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie8;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE9_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie9;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE10_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie10;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE11_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie11;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE12_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie12;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKA_PRILOZENIE13_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa nastrojkaPrilozenie13;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli avtor;

}
