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
@Entity(name = "informations_HraniliseSertifikatov")
@Table(name = "HraniliseSertifikatovIr", schema = "informations")
@Getter
@Setter
public class HraniliseSertifikatov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_HRANILISA_ID")
    private kg.infosystems.buhproject.entity.enumerations.TipHranilisaSertifikatov tipHranilisa;

	@Column(name = "IDENTIFIKATOR", length = 40)
    private String identifikator;

	@Column(name = "NAIMENOVANIE", length = 256)
    private String naimenovanie;

	@Column(name = "DATA_NACALA")
    private LocalDateTime dataNacala;

	@Column(name = "DATA_OKONCANIA")
    private LocalDateTime dataOkoncania;

	@Column(name = "OTPECATOK", length = 40)
    private String otpecatok;

	@Column(name = "SERIJNYJ_NOMER", length = 100)
    private String serijnyjNomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERTIFIKAT_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage sertifikat;

}
