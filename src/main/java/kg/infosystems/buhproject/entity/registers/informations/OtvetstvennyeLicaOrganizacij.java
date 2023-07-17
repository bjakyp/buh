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
@Entity(name = "informations_OtvetstvennyeLicaOrganizacij")
@Table(name = "OtvetstvennyeLicaOrganizacijIr", schema = "informations")
@Getter
@Setter
public class OtvetstvennyeLicaOrganizacij extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTVETSTVENNOE_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyOtvetstvennyhLic otvetstvennoeLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KASSA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Kassy kassa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOLZNOST1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Dolznosti dolznost1;

	@Column(name = "FAJL_FAKSIMIL1NAA_PECAT1", length = 10)
    private String fajlFaksimil1naaPecat1;

}
