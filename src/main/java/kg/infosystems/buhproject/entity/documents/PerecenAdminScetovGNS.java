package kg.infosystems.buhproject.entity.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@JmixEntity
@Table(name = "PERECEN_ADMIN_SCETOV_GNS", schema = "documents")
@Entity
@Getter
@Setter
public class PerecenAdminScetovGNS {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "LICEVOI_SCET", length = 254)
    private String licevoiScet;

    @InstanceName
    @Column(name = "NAIMENOVANIE", length = 254)
    private String naimenovanie;

    @Column(name = "INN", length = 14)
    private String iNN;

    @Column(name = "NAIMENOVANIE_POLUCATELA", length = 50)
    private String naimenovaniePolucatela;

    @Column(name = "BIK", length = 6)
    private String bik;

    @Column(name = "BIK_DLA_BUDJETNIH", length = 6)
    private String bikDlaBudjetnih;

    @Column(name = "BANK", length = 254)
    private String bank;

    @JoinColumn(name = "REGIONALNYE_ORGANY_SF_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private RegionalnyeOrganySF regionalnyeOrganySF;

    @JoinColumn(name = "REGIONALNYE_ORGANY_UGNS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private RegionalnyeOrganyUGNS regionalnyeOrganyUGNS;

}
