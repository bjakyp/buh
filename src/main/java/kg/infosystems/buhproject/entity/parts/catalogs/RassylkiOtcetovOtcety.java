package kg.infosystems.buhproject.entity.parts.catalogs;

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
@Table(name = "RassylkiOtcetovOtcety", schema = "parts_catalogs")
@Getter
@Setter
public class RassylkiOtcetovOtcety {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.RassylkiOtcetov part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTCET_ID")
    private kg.infosystems.buhproject.entity.one.Multiple otcet;

	@Column(name = "OTPRAVLAT1_ESLI_PUSTOJ")
    private Boolean otpravlat1EsliPustoj;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage nastrojki;

}
