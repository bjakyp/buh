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
@Table(name = "OtcetyPoPodohodnomuNaloguPodohodnyjNalogVtorojMesacKvartala", schema = "parts_documents")
@Getter
@Setter
public class OtcetyPoPodohodnomuNaloguPodohodnyjNalogVtorojMesacKvartala {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.OtcetyPoPodohodnomuNalogu part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "STROKA_OTCETA", precision = 1, scale = 0)
    private BigDecimal strokaOtceta;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
    private BigDecimal kolicestvo;

	@Column(name = "SUMMA_NACISLENO", precision = 15, scale = 2)
    private BigDecimal summaNacisleno;

	@Column(name = "SUMMA_NEOBLAGAEMAA", precision = 15, scale = 2)
    private BigDecimal summaNeoblagaemaa;

	@Column(name = "VYCETY", precision = 15, scale = 2)
    private BigDecimal vycety;

	@Column(name = "SUMMA_OBLAGAEMAA", precision = 15, scale = 2)
    private BigDecimal summaOblagaemaa;

	@Column(name = "SUMMA_PNS_SOTRUDNIKA", precision = 15, scale = 2)
    private BigDecimal summaPNSSotrudnika;

	@Column(name = "SUMMA_PN", precision = 15, scale = 2)
    private BigDecimal summaPN;

	@Column(name = "SUMMA_PNSMRD", precision = 15, scale = 2)
    private BigDecimal summaPNSMRD;

	@Column(name = "SUMMA_VYPLACENNYH_DOHODOV", precision = 15, scale = 2)
    private BigDecimal summaVyplacennyhDohodov;

	@Column(name = "SUMMA_PN_PODLEZASAA_UPLATE", precision = 15, scale = 2)
    private BigDecimal summaPNPodlezasaaUplate;

}
