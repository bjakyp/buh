package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_ParametryOgraniceniaDostupa")
@Table(name = "ParametryOgraniceniaDostupaIr", schema = "informations")
@Getter
@Setter
public class ParametryOgraniceniaDostupa extends BaseEntity {
	@Column(name = "VERSIA", precision = 15, scale = 0)
    private BigDecimal versia;

	@Column(name = "HES_SUMMA", length = 48)
    private String hesSumma;

	@Column(name = "HES_SUMMA_POSTOANNYH_PARAMETROV", length = 48)
    private String hesSummaPostoannyhParametrov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DLA_ZAPISI_OB2EKTOV_I_PROVERKI_PRAV_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dlaZapisiOb2ektovIProverkiPrav;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DLA_OTCETA_PO_PRAVAM_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dlaOtcetaPoPravamDostupa;

	@Column(name = "HES_SUMMA_PARAMETROV_SABLONOV", length = 48)
    private String hesSummaParametrovSablonov;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DLA_SABLONOV_V_SEANSAH_POL1ZOVATELEJ_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dlaSablonovVSeansahPol1zovatelej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DLA_SABLONOV_V_SEANSAH_VNESNIH_POL1ZOVATELEJ_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage dlaSablonovVSeansahVnesnihPol1zovatelej;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VERSII_PARAMETROV_SABLONOV_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage versiiParametrovSablonov;

	@Column(name = "DATA_SOZDANIA")
    private LocalDateTime dataSozdania;

}
