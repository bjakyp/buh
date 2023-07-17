package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_Udalit1Rezul1tatyObmenaDannymi")
@Table(name = "Udalit1Rezul1tatyObmenaDannymiIr", schema = "informations")
@Getter
@Setter
public class Udalit1Rezul1tatyObmenaDannymi extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEMNYJ_OB2EKT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple problemnyjOb2ekt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_PROBLEMY_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyProblemObmenaDannymi tipProblemy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
	private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

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

}
