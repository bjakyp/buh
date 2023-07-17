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
@Entity(name = "informations_Ob2ektyKOtpravke")
@Table(name = "Ob2ektyKOtpravkeIr", schema = "informations")
@Getter
@Setter
public class Ob2ektyKOtpravke extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCETNAA_SISTEMA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ucetnaaSistema;

	@Column(name = "IDENTIFIKATOR_OB2EKTA", length = 50)
    private String identifikatorOb2ekta;

	@Column(name = "OBRABOTCIK", length = 50)
    private String obrabotcik;

	@Column(name = "IDENTIFIKATOR_FAJLA")
    private UUID identifikatorFajla;

}
