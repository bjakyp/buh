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
@Table(name = "TipovyeOperaciiHozrascetnyj", schema = "parts_catalogs")
@Getter
@Setter
public class TipovyeOperaciiHozrascetnyj {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private kg.infosystems.buhproject.entity.catalogs.TipovyeOperacii part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
	private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
	private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMORIAL1NYJ_ORDER_ID")
	private kg.infosystems.buhproject.entity.catalogs.SpiskiScetovMemorial1nyhOrderov memorial1nyjOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_DT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetDt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_DT1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoDt1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_DT2_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoDt2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_DT3_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoDt3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOLICESTVO_DT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple kolicestvoDt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALUTA_DT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Valuty valutaDt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALUTNAA_SUMMA_DT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple valutnaaSummaDt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_KT_ID")
	private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scetKt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_KT1_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoKt1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_KT2_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoKt2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBKONTO_KT3_ID")
	private kg.infosystems.buhproject.entity.one.Multiple subkontoKt3;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KOLICESTVO_KT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple kolicestvoKt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALUTA_KT_ID")
	private kg.infosystems.buhproject.entity.catalogs.Valuty valutaKt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VALUTNAA_SUMMA_KT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple valutnaaSummaKt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUMMA_ID")
	private kg.infosystems.buhproject.entity.one.Multiple summa;

	@Column(name = "SODERZANIE", length = 400)
	private String soderzanie;

}
