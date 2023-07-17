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
@Table(name = "NastrojkiBalansaStrokiOtceta", schema = "parts_catalogs")
@Getter
@Setter
public class NastrojkiBalansaStrokiOtceta {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "STROKA", length = 100)
    private String stroka;

	@Column(name = "GRUPPA", length = 100)
    private String gruppa;

	@Column(name = "NAIMENOVANIE", length = 200)
    private String naimenovanie;

	@Column(name = "ZAGOLOVOK")
    private Boolean zagolovok;

}
