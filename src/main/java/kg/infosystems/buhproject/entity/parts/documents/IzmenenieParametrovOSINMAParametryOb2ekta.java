package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "IzmenenieParametrovOSINMAParametryOb2ekta", schema = "parts_documents")
@Getter
@Setter
public class IzmenenieParametrovOSINMAParametryOb2ekta {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.IzmenenieParametrovOSINMA part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PARAMETR_ID", nullable = false)
	private kg.infosystems.buhproject.entity.enumerations.ParametryIzmeneniaOSINMA parametr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAROE_ZNACENIE_ID")
	private kg.infosystems.buhproject.entity.one.Multiple staroeZnacenie;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "NOVOE_ZNACENIE_ID", nullable = false)
	private kg.infosystems.buhproject.entity.one.Multiple novoeZnacenie;

}
