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
@Entity(name = "accumulations_PodohodnyjNalog")
@Table(name = "PodohodnyjNalogAr", schema = "accumulations")
@Getter
@Setter
public class PodohodnyjNalog extends BaseEntity {
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
	@JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_FINANSIROVANIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyFinansirovania vidFinansirovania;

	@Column(name = "ODPN", precision = 15, scale = 2)
    private BigDecimal oDPN;

	@Column(name = "ODSF", precision = 15, scale = 2)
    private BigDecimal oDSF;

	@Column(name = "VYCETY", precision = 15, scale = 2)
    private BigDecimal vycety;

	@Column(name = "PN", precision = 15, scale = 2)
    private BigDecimal pN;

	@Column(name = "PFR", precision = 15, scale = 2)
    private BigDecimal pFR;

	@Column(name = "GNPFR", precision = 15, scale = 2)
    private BigDecimal gNPFR;

	@Column(name = "PFR_DLA_RASCETA_PN", precision = 15, scale = 2)
    private BigDecimal pFRDlaRascetaPN;

	@Column(name = "GNPFR_DLA_RASCETA_PN", precision = 15, scale = 2)
    private BigDecimal gNPFRDlaRascetaPN;

	@Column(name = "VSEGO_NACISLENO", precision = 15, scale = 2)
    private BigDecimal vsegoNacisleno;

}
