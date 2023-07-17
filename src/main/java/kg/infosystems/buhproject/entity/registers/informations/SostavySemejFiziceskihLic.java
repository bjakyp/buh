package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_SostavySemejFiziceskihLic")
@Table(name = "SostavySemejFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class SostavySemejFiziceskihLic extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@Column(name = "FIO", length = 50)
	private String fIO;

	@Column(name = "DATA")
	private LocalDateTime data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STEPEN1_RODSTVA_ID")
	private kg.infosystems.buhproject.entity.catalogs.StepeniRodstvaFiziceskihLic stepen1Rodstva;

	@Column(name = "DATA_ROZDENIA")
	private LocalDateTime dataRozdenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRAZDANSTVO_ID")
	private kg.infosystems.buhproject.entity.catalogs.StranyMira grazdanstvo;

	@Column(name = "TELEFON", length = 30)
	private String telefon;

	@Column(name = "MESTO_ROZDENIA", length = 120)
	private String mestoRozdenia;

}
