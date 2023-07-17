package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JmixEntity
@Entity(name = "informations_VersiiOb2ektov")
@Table(name = "VersiiOb2ektovIr", schema = "informations")
@Getter
@Setter
public class VersiiOb2ektov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
	private kg.infosystems.buhproject.entity.one.Multiple ob2ekt;

	@Column(name = "NOMER_VERSII", precision = 10, scale = 0)
	private BigDecimal nomerVersii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VERSIA_OB2EKTA_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage versiaOb2ekta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AVTOR_VERSII_ID")
	private kg.infosystems.buhproject.entity.one.Multiple avtorVersii;

	@Column(name = "DATA_VERSII")
	private LocalDateTime dataVersii;

	@Lob
	@Column(name = "KOMMENTARIJ")
	private String kommentarij;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_VERSII_OB2EKTA_ID")
	private kg.infosystems.buhproject.entity.enumerations.TipyVersijOb2ekta tipVersiiOb2ekta;

	@Column(name = "VERSIA_PROIGNORIROVANA")
	private Boolean versiaProignorirovana;

	@Column(name = "RAZMER_DANNYH", precision = 15, scale = 0)
	private BigDecimal razmerDannyh;

	@Column(name = "KONTROL1NAA_SUMMA", length = 32)
	private String kontrol1naaSumma;

	@Column(name = "EST1_DANNYE_VERSII")
	private Boolean est1DannyeVersii;

	@Column(name = "VERSIA_VLADELEC", precision = 10, scale = 0)
	private BigDecimal versiaVladelec;

	@Lob
	@Column(name = "UZEL")
	private String uzel;

	@Column(name = "SINHRONIZIRUETSA")
	private Boolean sinhroniziruetsa;

	@Column(name = "SMESENIE", precision = 10, scale = 0)
	private BigDecimal smesenie;

}
