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
@Entity(name = "informations_OtvetstvennyeLicaOrganizacijDlaPecati")
@Table(name = "OtvetstvennyeLicaOrganizacijDlaPecatiIr", schema = "informations")
@Getter
@Setter
public class OtvetstvennyeLicaOrganizacijDlaPecati extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_OTCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ob2ektOtcet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTVETSTVENNOE_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyOtvetstvennyhLic otvetstvennoeLico;

	@Column(name = "PORADOK", precision = 5, scale = 0)
    private BigDecimal poradok;

}
