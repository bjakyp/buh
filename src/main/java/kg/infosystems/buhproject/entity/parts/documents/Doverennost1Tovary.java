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
@Table(name = "Doverennost1Tovary", schema = "parts_documents")
@Getter
@Setter
public class Doverennost1Tovary {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.Doverennost1 part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOMENKLATURA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple nomenklatura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EDINICA_IZMERENIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KlassifikatorEdinicIzmerenia edinicaIzmerenia;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
    private BigDecimal kolicestvo;

}
