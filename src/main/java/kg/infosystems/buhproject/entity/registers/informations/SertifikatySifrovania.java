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
@Entity(name = "informations_SertifikatySifrovania")
@Table(name = "SertifikatySifrovaniaIr", schema = "informations")
@Getter
@Setter
public class SertifikatySifrovania extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZASIFROVANNYJ_OB2EKT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple zasifrovannyjOb2ekt;

	@Column(name = "PORADKOVYJ_NOMER", precision = 10, scale = 0)
    private BigDecimal poradkovyjNomer;

	@Lob
	@Column(name = "PREDSTAVLENIE")
    private String predstavlenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERTIFIKAT_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage sertifikat;

	@Column(name = "OTPECATOK", length = 28)
    private String otpecatok;

}
