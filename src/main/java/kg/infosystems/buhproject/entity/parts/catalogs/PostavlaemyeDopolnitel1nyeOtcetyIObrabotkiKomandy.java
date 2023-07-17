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
@Table(name = "PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiKomandy", schema = "parts_catalogs")
@Getter
@Setter
public class PostavlaemyeDopolnitel1nyeOtcetyIObrabotkiKomandy {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.PostavlaemyeDopolnitel1nyeOtcetyIObrabotki part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "IDENTIFIKATOR", length = 100)
    private String identifikator;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VARIANT_ZAPUSKA_ID")
    private kg.infosystems.buhproject.entity.enumerations.SposobyVyzovaDopolnitel1nyhObrabotok variantZapuska;

	@Column(name = "PREDSTAVLENIE", length = 200)
    private String predstavlenie;

	@Column(name = "POKAZYVAT1_OPOVESENIE")
    private Boolean pokazyvat1Opovesenie;

	@Column(name = "MODIFIKATOR", length = 9)
    private String modifikator;

	@Column(name = "SKRYT1")
    private Boolean skryt1;

}
