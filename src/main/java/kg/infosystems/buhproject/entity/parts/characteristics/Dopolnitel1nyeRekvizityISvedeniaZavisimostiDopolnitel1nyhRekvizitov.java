package kg.infosystems.buhproject.entity.parts.characteristics;

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
@Table(name = "Dopolnitel1nyeRekvizityISvedeniaZavisimostiDopolnitel1nyhRekvizitov", schema = "parts_characteristics")
@Getter
@Setter
public class Dopolnitel1nyeRekvizityISvedeniaZavisimostiDopolnitel1nyhRekvizitov {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.characteristics.Dopolnitel1nyeRekvizityISvedenia part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "ZAVISIMOE_SVOJSTVO", length = 25)
    private String zavisimoeSvojstvo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NABOR_SVOJSTV_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryDopolnitel1nyhRekvizitovISvedenij naborSvojstv;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REKVIZIT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple rekvizit;

	@Column(name = "USLOVIE", length = 20)
    private String uslovie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNACENIE_ID")
    private kg.infosystems.buhproject.entity.one.Multiple znacenie;

}
