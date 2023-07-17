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
@Entity(name = "informations_SvedeniaOFajlah")
@Table(name = "SvedeniaOFajlahIr", schema = "informations")
@Getter
@Setter
public class SvedeniaOFajlah extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_ID")
    private kg.infosystems.buhproject.entity.one.Multiple fajl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple avtor;

	@Column(name = "DATA_SOZDANIA")
    private LocalDateTime dataSozdania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_FAJLA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple vladelecFajla;

	@Column(name = "INDEKS_KARTINKI", precision = 10, scale = 0)
    private BigDecimal indeksKartinki;

	@Column(name = "NOMER_KARTINKI_PODPISAN_ZASIFROVAN", precision = 10, scale = 0)
    private BigDecimal nomerKartinkiPodpisanZasifrovan;

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Lob
	@Column(name = "OPISANIE")
    private String opisanie;

	@Column(name = "RAZMER", precision = 10, scale = 0)
    private BigDecimal razmer;

	@Column(name = "RASSIRENIE", length = 10)
    private String rassirenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REDAKTIRUET_ID")
    private kg.infosystems.buhproject.entity.one.Multiple redaktiruet;

	@Column(name = "SLUZEBNYJ")
    private Boolean sluzebnyj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_HRANENIA_FAJLA_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipyHraneniaFajlov tipHraneniaFajla;

	@Column(name = "HRANIT1_VERSII")
    private Boolean hranit1Versii;

}
