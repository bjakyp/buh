package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_UcenyeStepeniFiziceskihLic")
@Table(name = "UcenyeStepeniFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class UcenyeStepeniFiziceskihLic extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCENAA_STEPEN1_ID")
	private kg.infosystems.buhproject.entity.catalogs.UcenyeStepeni ucenaaStepen1;

	@Column(name = "DATA_PRISUZDENIA_UCENOJ_STEPENI")
	private LocalDateTime dataPrisuzdeniaUcenojStepeni;

	@Lob
	@Column(name = "OTRASL1_NAUKI")
	private String otrasl1Nauki;

	@Lob
	@Column(name = "DISSERTACIONNYJ_SOVET")
	private String dissertacionnyjSovet;

	@Column(name = "DIPLOM_SERIA_NOMER", length = 50)
	private String diplomSeriaNomer;

	@Lob
	@Column(name = "DIPLOM_VYDAN_ORGANIZACIA")
	private String diplomVydanOrganizacia;

}
