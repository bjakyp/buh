package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_VoinskijUcetFiziceskihLic")
@Table(name = "VoinskijUcetFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class VoinskijUcetFiziceskihLic extends BaseEntity {
	@Column(name = "PERIOD")
	private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
	private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTNOSENIE_K_VOINSKOJ_OBAZANNOSTI_ID")
	private kg.infosystems.buhproject.entity.enumerations.OtnosenieKVoinskojObazannosti otnosenieKVoinskojObazannosti;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTNOSENIE_K_VOINSKOMU_UCETU_ID")
	private kg.infosystems.buhproject.entity.enumerations.OtnosenieKVoinskomuUcetu otnosenieKVoinskomuUcetu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZVANIE_ID")
	private kg.infosystems.buhproject.entity.enumerations.KlassifikatorVoinskihZvanij zvanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOSTAV_ID")
	private kg.infosystems.buhproject.entity.catalogs.SostavyVoennosluzasih sostav;

	@Column(name = "VUS", length = 15)
	private String vUS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GODNOST1_ID")
	private kg.infosystems.buhproject.entity.enumerations.Godnost1KVoinskojSluzbe godnost1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VOENKOMAT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Voenkomaty voenkomat;

	@Column(name = "ZABRONIROVAN_ORGANIZACIEJ", length = 150)
	private String zabronirovanOrganizaciej;

	@Column(name = "SPEC_UCET")
	private Boolean specUcet;

	@Column(name = "VOENNYJ_BILET", length = 30)
	private String voennyjBilet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRUPPA_UCETA_ID")
	private kg.infosystems.buhproject.entity.catalogs.GruppyVoinskogoUceta gruppaUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KATEGORIA_UCETA_ID")
	private kg.infosystems.buhproject.entity.catalogs.KategoriiVoinskogoUceta kategoriaUceta;

	@Column(name = "NOMER_SPEC_UCETA", length = 20)
	private String nomerSpecUceta;

}
