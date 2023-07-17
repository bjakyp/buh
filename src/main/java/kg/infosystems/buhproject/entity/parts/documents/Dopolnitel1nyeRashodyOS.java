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
@Table(name = "Dopolnitel1nyeRashodyOS", schema = "parts_documents")
@Getter
@Setter
public class Dopolnitel1nyeRashodyOS {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.Dopolnitel1nyeRashody part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OSNOVNOE_SREDSTVO_ID")
	private kg.infosystems.buhproject.entity.catalogs.OsnovnyeSredstva osnovnoeSredstvo;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

	@Column(name = "SUMMA_RASHODOV", precision = 15, scale = 2)
	private BigDecimal summaRashodov;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCET_UCETA_ID", nullable = false)
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_POSTUPLENIA_ID")
	private kg.infosystems.buhproject.entity.documents.PostuplenieTovarovUslug dokumentPostuplenia;

}
