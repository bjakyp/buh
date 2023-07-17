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
@Entity(name = "informations_ElektronnyePodpisi")
@Table(name = "ElektronnyePodpisiIr", schema = "informations")
@Getter
@Setter
public class ElektronnyePodpisi extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODPISANNYJ_OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple podpisannyjOb2ekt;

	@Column(name = "PORADKOVYJ_NOMER", precision = 10, scale = 0)
    private BigDecimal poradkovyjNomer;

	@Column(name = "DATA_PROVERKI_PODPISI")
    private LocalDateTime dataProverkiPodpisi;

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

	@Column(name = "PODPIS1_VERNA")
    private Boolean podpis1Verna;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERTIFIKAT_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage sertifikat;

	@Column(name = "DATA_PODPISI")
    private LocalDateTime dataPodpisi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USTANOVIVSIJ_PODPIS1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli ustanovivsijPodpis1;

}
