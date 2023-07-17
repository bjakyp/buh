package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Vedomost1ZarabotnojPlatyZarplata", schema = "parts_documents")
@Getter
@Setter
public class Vedomost1ZarabotnojPlatyZarplata {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.Vedomost1ZarabotnojPlaty part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SOTRUDNIK_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PODRAZDELENIE_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@Column(name = "RUCNAA_KORREKTIROVKA")
	private Boolean rucnaaKorrektirovka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANKOVSKIJ_SCET_ID")
	private kg.infosystems.buhproject.entity.catalogs.BankovskieSceta bankovskijScet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANK_BANKOVSKOGO_SCETA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Banki bankBankovskogoSceta;

	@Column(name = "SUMMA_PO_BANKOVSKOMU_SCETU", precision = 15, scale = 2)
	private BigDecimal summaPoBankovskomuScetu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KART_SCET_ID")
	private kg.infosystems.buhproject.entity.catalogs.KartScetaSotrudnikov kartScet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BANK_KART_SCETA_ID")
	private kg.infosystems.buhproject.entity.catalogs.Banki bankKartSceta;

	@Column(name = "SUMMA_PO_KART_SCETU", precision = 15, scale = 2)
	private BigDecimal summaPoKartScetu;

	@Column(name = "SUMMA_PO_KASSE", precision = 15, scale = 2)
	private BigDecimal summaPoKasse;

	@Column(name = "KLUC_SVAZI", precision = 5, scale = 0)
	private BigDecimal klucSvazi;

}
