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
@Table(name = "SertifikatyKlucejElektronnojPodpisiISifrovania", schema = "catalogs")
@Getter
@Setter
public class SertifikatyKlucejElektronnojPodpisiISifrovania {
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

	@Column(name = "KOMU_VYDAN", length = 430)
    private String komuVydan;

	@Column(name = "FIRMA", length = 100)
    private String firma;

	@Column(name = "FAMILIA", length = 100)
    private String familia;

	@Column(name = "IMA", length = 100)
    private String ima;

	@Column(name = "OTCESTVO", length = 100)
    private String otcestvo;

	@Column(name = "DOLZNOST1", length = 100)
    private String dolznost1;

	@Column(name = "KEM_VYDAN", length = 100)
    private String kemVydan;

	@Column(name = "DEJSTVITELEN_DO")
    private LocalDateTime dejstvitelenDo;

	@Column(name = "PODPISANIE")
    private Boolean podpisanie;

	@Column(name = "SIFROVANIE")
    private Boolean sifrovanie;

	@Column(name = "OTPECATOK", length = 28)
    private String otpecatok;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DANNYE_SERTIFIKATA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dannyeSertifikata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROGRAMMA_ID")
    private kg.infosystems.buhproject.entity.catalogs.ProgrammyElektronnojPodpisiISifrovania programma;

	@Column(name = "OTOZVAN")
    private Boolean otozvan;

	@Column(name = "USILENNAA_ZASITA_ZAKRYTOGO_KLUCA")
    private Boolean usilennaaZasitaZakrytogoKluca;

	@Column(name = "ORGANIZACIA", length = 10)
    private String organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

	@Column(name = "POL1ZOVATEL1_OPOVESEN_O_SROKE_DEJSTVIA")
    private Boolean pol1zovatel1OpovesenOSrokeDejstvia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOBAVIL_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli dobavil;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTOANIE_ZAAVLENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.SostoaniaZaavleniaNaVypuskSertifikata sostoanieZaavlenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SODERZANIE_ZAAVLENIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage soderzanieZaavlenia;

}
