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
@Table(name = "VvodNacal1nyhOstatkovBibliotecnyeFondy", schema = "parts_documents")
@Getter
@Setter
public class VvodNacal1nyhOstatkovBibliotecnyeFondy {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.documents.VvodNacal1nyhOstatkov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IZDANIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.BibliotecnyeFondy izdanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOBYTIE_ID")
	private kg.infosystems.buhproject.entity.catalogs.SobytiaOS sobytie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_UCETA_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetUceta;

	@Column(name = "KOLICESTVO", precision = 15, scale = 3)
	private BigDecimal kolicestvo;

	@Column(name = "CENA", precision = 15, scale = 2)
	private BigDecimal cena;

	@Column(name = "SUMMA", precision = 15, scale = 2)
	private BigDecimal summa;

}
