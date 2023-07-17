package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "OtcetPoVyplatamIUderzaniamPNOtcetGodovoj", schema = "parts_documents")
@Getter
@Setter
public class OtcetPoVyplatamIUderzaniamPNOtcetGodovoj {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.OtcetPoVyplatamIUderzaniamPN part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@Column(name = "INN", length = 14)
    private String iNN;

	@Column(name = "KOD_DOHODA", length = 10)
    private String kodDohoda;

	@Column(name = "ODPN", precision = 15, scale = 2)
    private BigDecimal oDPN;

	@Column(name = "SUMMA_MATERIAL1NOJ_VYGODY", precision = 15, scale = 2)
    private BigDecimal summaMaterial1nojVygody;

	@Column(name = "SUMMA_PN", precision = 15, scale = 2)
    private BigDecimal summaPN;

	@Column(name = "SUMMA_PNS_MATERIAL1NOJ_VYGODY", precision = 15, scale = 2)
    private BigDecimal summaPNSMaterial1nojVygody;

}
