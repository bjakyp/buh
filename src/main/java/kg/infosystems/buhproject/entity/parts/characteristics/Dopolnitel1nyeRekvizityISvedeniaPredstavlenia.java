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
@Table(name = "Dopolnitel1nyeRekvizityISvedeniaPredstavlenia", schema = "parts_characteristics")
@Getter
@Setter
public class Dopolnitel1nyeRekvizityISvedeniaPredstavlenia {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.characteristics.Dopolnitel1nyeRekvizityISvedenia part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "KOD_AZYKA", length = 10)
    private String kodAzyka;

	@Column(name = "ZAGOLOVOK", length = 75)
    private String zagolovok;

	@Lob
	@Column(name = "PODSKAZKA")
    private String podskazka;

	@Column(name = "ZAGOLOVOK_FORMY_ZNACENIA", length = 150)
    private String zagolovokFormyZnacenia;

	@Column(name = "ZAGOLOVOK_FORMY_VYBORA_ZNACENIA", length = 150)
    private String zagolovokFormyVyboraZnacenia;

}
