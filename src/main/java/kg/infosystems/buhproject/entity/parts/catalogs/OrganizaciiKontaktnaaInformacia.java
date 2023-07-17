package kg.infosystems.buhproject.entity.parts.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "OrganizaciiKontaktnaaInformacia", schema = "parts_catalogs")
@Getter
@Setter
public class OrganizaciiKontaktnaaInformacia {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii part;

    @Column(name = "ID", nullable = false)
    @Id
    @JmixGeneratedValue
    private UUID id;


    @Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIP_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipyKontaktnojInformacii tip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii vid;

    @Column(name = "PREDSTAVLENIE", length = 500)
    private String predstavlenie;

    @Lob
    @Column(name = "ZNACENIA_POLEJ")
    private String znaceniaPolej;

    @Column(name = "STRANA", length = 100)
    private String strana;

    @Column(name = "REGION", length = 50)
    private String region;

    @Column(name = "GOROD", length = 50)
    private String gorod;

    @Column(name = "ADRES_EP", length = 100)
    private String adresEP;

    @Column(name = "DOMENNOE_IMA_SERVERA", length = 100)
    private String domennoeImaServera;

    @Column(name = "NOMER_TELEFONA", length = 20)
    private String nomerTelefona;

    @Column(name = "NOMER_TELEFONA_BEZ_KODOV", length = 20)
    private String nomerTelefonaBezKodov;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VID_DLA_SPISKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyKontaktnojInformacii vidDlaSpiska;

    @Column(name = "DEJSTVUET_S")
    private LocalDateTime dejstvuetS;

    @Lob
    @Column(name = "ZNACENIE")
    private String znacenie;

}
