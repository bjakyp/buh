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
@Table(name = "PeremesenieTovarovTovary", schema = "parts_documents")
@Getter
@Setter
public class PeremesenieTovarovTovary {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.PeremesenieTovarov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMENKLATURA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Nomenklatura nomenklatura;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
    private BigDecimal kolicestvo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_OTPRAVITELA_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUcetaOtpravitela;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_POLUCATELA_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUcetaPolucatela;

}
