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
@Table(name = "FiziceskieLicaPrisoedinennyeFajlyElektronnyePodpisi", schema = "parts_catalogs")
@Getter
@Setter
public class FiziceskieLicaPrisoedinennyeFajlyElektronnyePodpisi {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLicaPrisoedinennyeFajly part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "DATA_PODPISI")
    private LocalDateTime dataPodpisi;

	@Column(name = "IMA_FAJLA_PODPISI", length = 260)
    private String imaFajlaPodpisi;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@Lob
	@Column(name = "KOMU_VYDAN_SERTIFIKAT")
    private String komuVydanSertifikat;

	@Column(name = "OTPECATOK", length = 28)
    private String otpecatok;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODPIS1_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage podpis1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USTANOVIVSIJ_PODPIS1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli ustanovivsijPodpis1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERTIFIKAT_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage sertifikat;

	@Column(name = "DATA_PROVERKI_PODPISI")
    private LocalDateTime dataProverkiPodpisi;

	@Column(name = "PODPIS1_VERNA")
    private Boolean podpis1Verna;

}
