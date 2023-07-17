package kg.infosystems.buhproject.entity.registers.accumulations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "accumulations_DannyeDlaOtcetaPoSFEzemesacnomu")
@Table(name = "DannyeDlaOtcetaPoSFEzemesacnomuAr", schema = "accumulations")
@Getter
@Setter
public class DannyeDlaOtcetaPoSFEzemesacnomu extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

	@Column(name = "PERIOD")
    private LocalDateTime period;

	@Column(name = "NOMER_STROKI", precision = 9, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "AKTIVNOST1")
    private Boolean aktivnost1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KATEGORIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KategoriiSotrudnikov kategoria;

	@Column(name = "FOT", precision = 15, scale = 2)
    private BigDecimal fOT;

	@Column(name = "NACISLENNYE_VZNOSY", precision = 15, scale = 2)
    private BigDecimal nacislennyeVznosy;

	@Column(name = "GNPFR", precision = 15, scale = 2)
    private BigDecimal gNPFR;

	@Column(name = "NORMA_DNEJ", precision = 10, scale = 0)
    private BigDecimal normaDnej;

	@Column(name = "FAKT_DNEJ", precision = 10, scale = 0)
    private BigDecimal faktDnej;

}
