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
@Entity(name = "accumulations_OstatkiBibliotecnyhFondov")
@Table(name = "OstatkiBibliotecnyhFondovAr", schema = "accumulations")
@Getter
@Setter
public class OstatkiBibliotecnyhFondov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

	@Column(name = "PERIOD")
    private LocalDateTime period;

	@Column(name = "NOMER_STROKI", precision = 9, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "AKTIVNOST1")
    private Boolean aktivnost1;

	@Column(name = "VID_DVIZENIA", precision = 1, scale = 0)
    private BigDecimal vidDvizenia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOL_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica mOL;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IZDANIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.BibliotecnyeFondy izdanie;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
    private BigDecimal kolicestvo;

	@Column(name = "SUMMA", precision = 15, scale = 2)
    private BigDecimal summa;

}
