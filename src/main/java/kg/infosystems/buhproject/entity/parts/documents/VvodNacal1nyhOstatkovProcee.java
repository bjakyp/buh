package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VvodNacal1nyhOstatkovProcee", schema = "parts_documents")
@Getter
@Setter
public class VvodNacal1nyhOstatkovProcee {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.VvodNacal1nyhOstatkov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@Column(name = "VID_SAL1DO", length = 10)
	private String vidSal1do;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkonto1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO2_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkonto2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO3_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkonto3;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
	private BigDecimal kolicestvo;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

}
