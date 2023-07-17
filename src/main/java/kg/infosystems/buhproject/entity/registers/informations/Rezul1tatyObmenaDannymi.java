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
@Entity(name = "informations_Rezul1tatyObmenaDannymi")
@Table(name = "Rezul1tatyObmenaDannymiIr", schema = "informations")
@Getter
@Setter
public class Rezul1tatyObmenaDannymi extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_PROBLEMY_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipyProblemObmenaDannymi tipProblemy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_METADANNYH_ID")
    private kg.infosystems.buhproject.entity.one.Multiple ob2ektMetadannyh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEMNYJ_OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple problemnyjOb2ekt;

	@Column(name = "KLUC_UNIKAL1NOSTI", length = 32)
    private String klucUnikal1nosti;

	@Column(name = "DATA_VOZNIKNOVENIA")
    private LocalDateTime dataVozniknovenia;

	@Lob
	@Column(name = "PRICINA")
    private String pricina;

	@Column(name = "PROPUSENA")
    private Boolean propusena;

	@Column(name = "NOMER_DOKUMENTA", length = 50)
    private String nomerDokumenta;

	@Column(name = "DATA_DOKUMENTA")
    private LocalDateTime dataDokumenta;

	@Lob
	@Column(name = "PREDSTAVLENIE_OB2EKTA")
    private String predstavlenieOb2ekta;

	@Lob
	@Column(name = "ZNACENIA_OTBOROV_NEZAVISIMOGO_REGISTRA")
    private String znaceniaOtborovNezavisimogoRegistra;

}
