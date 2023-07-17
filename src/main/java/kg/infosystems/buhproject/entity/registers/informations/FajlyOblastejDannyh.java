package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_FajlyOblastejDannyh")
@Table(name = "FajlyOblastejDannyhIr", schema = "informations")
@Getter
@Setter
public class FajlyOblastejDannyh extends BaseEntity {
	@Column(name = "IDENTIFIKATOR")
    private UUID identifikator;

	@Column(name = "VREMENNYJ")
    private Boolean vremennyj;

	@Column(name = "DATA_FAJLA")
    private LocalDateTime dataFajla;

	@Column(name = "IMA", length = 255)
    private String ima;

	@Column(name = "RAZMER", precision = 15, scale = 0)
    private BigDecimal razmer;

	@Lob
	@Column(name = "UDALIT1_PUT1_K_FAJLU")
    private String udalit1Put1KFajlu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UDALIT1_TOM_NA_DISKE_ID")
    private kg.infosystems.buhproject.entity.catalogs.TomaHraneniaFajlov udalit1TomNaDiske;

	@Column(name = "UDALIT1_HRANIT1_NA_DISKE")
    private Boolean udalit1Hranit1NaDiske;

	@Column(name = "USTANOVIT1_VREMENNYJ_PRI_POLUCENII")
    private Boolean ustanovit1VremennyjPriPolucenii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FAJL_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage fajl;

	@Column(name = "FAJL_CRC32", precision = 10, scale = 0)
    private BigDecimal fajlCRC32;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
