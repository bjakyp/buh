package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.catalogs.BazoviyOklad;
import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_StatnoeRaspisanie")
@Table(name = "StatnoeRaspisanieIr", schema = "informations")
@Getter
@Setter
public class StatnoeRaspisanie extends BaseEntity {
    @Column(name = "PERIOD")
    private LocalDateTime period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOLZNOST1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

    @Column(name = "KOLICESTVO_STAVOK", precision = 7, scale = 2)
    private BigDecimal kolicestvoStavok;

    @Column(name = "MINIMAL1NAA_TARIFNAA_STAVKA", precision = 15, scale = 2)
    private BigDecimal minimal1naaTarifnaaStavka;

    @Column(name = "MAKSIMAL1NAA_TARIFNAA_STAVKA", precision = 15, scale = 2)
    private BigDecimal maksimal1naaTarifnaaStavka;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_NACISLENIA_ID")
    private VidyNacislenij vidNacislenia;

    @JoinColumn(name = "BAZOVIY_OKLAD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private BazoviyOklad bazoviyOklad;

    @Column(name = "COEFFICENT_KRATNOSTI", precision = 19, scale = 2)
    private BigDecimal coefficentKratnosti;

    @Column(name = "SUMMA", precision = 19, scale = 2)
    private BigDecimal summa;
}
