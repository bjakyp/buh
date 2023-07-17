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
@Table(name = "NomenklaturaPrisoedinennyeFajlySertifikatySifrovania", schema = "parts_catalogs")
@Getter
@Setter
public class NomenklaturaPrisoedinennyeFajlySertifikatySifrovania {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.NomenklaturaPrisoedinennyeFajly part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "OTPECATOK", length = 28)
    private String otpecatok;

	@Lob
	@Column(name = "PREDSTAVLENIE")
    private String predstavlenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERTIFIKAT_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage sertifikat;

}
