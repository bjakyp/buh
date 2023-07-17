package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.documents.NacisleniyaIUderjaniya;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "UDERJANIA_NACISLENIA_I_UDERJANIA", schema = "documents")
@Entity
@Getter
@Setter
public class UderjaniaNacisleniaIUderjania {

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VERSIA_DANNYH")
    @Version
    private Integer versiaDannyh;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

    ///////////////////////////////////////////////////////////////////////////////////

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "NACISLENIYA_I_UDERJANIYA_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private NacisleniyaIUderjaniya nacisleniyaIUderjaniya;

    @JoinColumn(name = "KATEGORIA_RABOTNIKA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private kg.infosystems.buhproject.entity.compensations.KategoriaRabotnikov kategoriaRabotnika;

    @Column(name = "NACISLENO", precision = 19, scale = 2)
    private BigDecimal nacisleno;

    @Column(name = "TIP_DOHODA")
    private String tipDohoda;

    @Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

    @Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

    @Column(name = "NORMA_DNEJ")
    private Integer normaDnej;

    @Column(name = "OTRABOTANO_DNEJ")
    private Integer otrabotanoDnej;

    ///////////////////////////////////////////////////////////////////////////////////
    @InstanceName
    @Column(name = "RAZMER", precision = 19, scale = 2)
    private BigDecimal razmer;

    @Column(name = "NACISLENIE_NE_OBL_SV", precision = 19, scale = 2)
    private BigDecimal nacislenieNeOblSV;

    @Column(name = "NACISLENIE_OBL_SV", precision = 19, scale = 2)
    private BigDecimal nacislenieOblSV;

    @Column(name = "DOP_FOT", precision = 19, scale = 2)
    private BigDecimal dopFot;

    ///////////////////////////////////////////////////////////////////////////////////
    @Column(name = "REZUL1TAT", precision = 19, scale = 2)
    private BigDecimal rezul1tat;

    @Column(name = "PF_S_RABOTODATELA", precision = 19, scale = 2)
    private BigDecimal pfSRabotodatela;

    @Column(name = "PF_S_RABOTNIKA", precision = 19, scale = 2)
    private BigDecimal pfSRabotnika;

    @Column(name = "FOMS_S_RABOTODATELA", precision = 19, scale = 2)
    private BigDecimal fomsSRabotodatela;

    @Column(name = "FOMS_S_RABOTNIKA", precision = 19, scale = 2)
    private BigDecimal fomsSRabotnika;

    @Column(name = "FOT_S_RABOTODATELA", precision = 19, scale = 2)
    private BigDecimal fotSRabotodatela;

    @Column(name = "FOT_S_RABOTNIKA", precision = 19, scale = 2)
    private BigDecimal fotSRabotnika;

    @Column(name = "GNPF_S_RABOTNIKA", precision = 19, scale = 2)
    private BigDecimal gnpfSRabotnika;

    @Column(name = "ITOGO_S_RABOTNIKA", precision = 19, scale = 2)
    private BigDecimal itogoSRabotnika;

    @Column(name = "ITOGO_S_RABOTODATELA", precision = 19, scale = 2)
    private BigDecimal itogoSRabotodatela;

    ///////////////////////////////////////////////////////////////////////////
    @Column(name = "KOEF_PERS_VYCETA", precision = 19, scale = 2)
    private BigDecimal koefPersVuceta;

    @Column(name = "PERSONALNYJ_VYCET", precision = 19, scale = 2)
    private BigDecimal personalnyjVycet;

    @Column(name = "KOLICESTVO_IJDEVENSEV", precision = 19, scale = 2)
    private BigDecimal kolicestvoIjdevensev;

    @Column(name = "VYCETY_NA_IJDIVENSEV", precision = 19, scale = 2)
    private BigDecimal vycetyNaIjdivensev;

    @Column(name = "IZ_VYCETA_NEGOS_PF", precision = 19, scale = 2)
    private BigDecimal izVycetaNegosPF;

    @Column(name = "IZ_VYCETA_PO_GOS_SV", precision = 19, scale = 2)
    private BigDecimal izVycetaPoGosSV;

    ///////////////////////////////////////////////////////////////////////////////////
    @Column(name = "NACISLENIE_NE_OBL_PN", precision = 15, scale = 2)
    private BigDecimal nacislenieNeOblPN;

    @Column(name = "SUMMA_STANDARTNIH_VYCETOV", precision = 15, scale = 2)
    private BigDecimal summaStandartnihVycetov;

    @Column(name = "NACISLENIE_OBL_PN", precision = 15, scale = 2)
    private BigDecimal nacislenieOblPN;

    @Column(name = "DOP_MRD", precision = 15, scale = 2)
    private BigDecimal dopMRD;

    ///////////////////////////////////////////////////////////////////////////////////
    @Column(name = "PN", precision = 15, scale = 2)
    private BigDecimal pn;

    @Column(name = "ITOGO_PN", precision = 15, scale = 2)
    private BigDecimal itogoPN;

    @Column(name = "PN_OT_MRD", precision = 15, scale = 2)
    private BigDecimal pnOtMrd;
}
