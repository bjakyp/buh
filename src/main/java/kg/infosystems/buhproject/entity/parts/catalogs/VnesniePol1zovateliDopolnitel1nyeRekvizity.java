package kg.infosystems.buhproject.entity.parts.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VnesniePol1zovateliDopolnitel1nyeRekvizity", schema = "parts_catalogs")
@Getter
@Setter
public class VnesniePol1zovateliDopolnitel1nyeRekvizity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.catalogs.VnesniePol1zovateli part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SVOJSTVO_ID")
	private kg.infosystems.buhproject.entity.characteristics.Dopolnitel1nyeRekvizityISvedenia svojstvo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_ID")
	private kg.infosystems.buhproject.entity.one.Multiple znacenie;

	@Lob
	@Column(name = "TEKSTOVAA_STROKA")
	private String tekstovaaStroka;

}
