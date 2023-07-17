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
@Table(name = "OtcetPoVyplatamIUderzaniamPNOtcet", schema = "parts_documents")
@Getter
@Setter
public class OtcetPoVyplatamIUderzaniamPNOtcet {
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

	@Column(name = "KOD_STRANY", length = 3)
    private String kodStrany;

	@Column(name = "NOMER_NALOGOVOJ_REGISTRACII", length = 20)
    private String nomerNalogovojRegistracii;

	@Column(name = "KOD_DOHODA", length = 10)
    private String kodDohoda;

	@Column(name = "ODPN", precision = 15, scale = 2)
    private BigDecimal oDPN;

	@Column(name = "SUMMA_PN", precision = 15, scale = 2)
    private BigDecimal summaPN;

}
