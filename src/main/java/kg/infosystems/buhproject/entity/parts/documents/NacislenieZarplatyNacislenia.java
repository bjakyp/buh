package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "NacislenieZarplatyNacislenia", schema = "parts_documents")
@Getter
@Setter
public class NacislenieZarplatyNacislenia {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.NacislenieZarplaty part;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOLZNOST1_ID")
	private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VID_RASCETA_ID", nullable = false)
	private VidyNacislenij vidRasceta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SPOSOB_OTRAZENIA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.SposobyOtrazeniaZarabotnojPlaty sposobOtrazenia;

	@NotNull
	@Column(name = "DATA_NACALA", nullable = false)
	private LocalDateTime dataNacala;

	@NotNull
	@Column(name = "DATA_OKONCANIA", nullable = false)
	private LocalDateTime dataOkoncania;

	@Column(name = "NORMA_DNEJ", precision = 4, scale = 2)
	private BigDecimal normaDnej;

	@Column(name = "NORMA_CASOV", precision = 7, scale = 2)
	private BigDecimal normaCasov;

	@Column(name = "REZUL1TAT", precision = 15, scale = 2)
	private BigDecimal rezul1tat;

	@Column(name = "OTRABOTANO_DNEJ", precision = 4, scale = 2)
	private BigDecimal otrabotanoDnej;

	@Column(name = "RAZMER", precision = 15, scale = 2)
	private BigDecimal razmer;

	@Column(name = "OTRABOTANO_CASOV", precision = 7, scale = 2)
	private BigDecimal otrabotanoCasov;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRAFIK_RABOTY_ID", nullable = false)
	private kg.infosystems.buhproject.entity.catalogs.GrafikiRaboty grafikRaboty;

	@Column(name = "RUCNAA_KORREKTIROVKA")
	private Boolean rucnaaKorrektirovka;

    @InstanceName
    @DependsOnProperties({"vidRasceta", "razmer"})
    public String getInstanceName() {
        return String.format("%s: %s", vidRasceta, razmer);
    }

}
