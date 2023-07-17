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
@Entity(name = "informations_Ocered1InstallaciiPostavlaemyhDopolnitel1nyhOtcetovIObrabotokVOblastiDannyh")
@Table(name = "Ocered1InstallaciiPostavlaemyhDopolnitel1nyhOtcetovIObrabotokVOblastiDannyhIr", schema = "informations")
@Getter
@Setter
public class Ocered1InstallaciiPostavlaemyhDopolnitel1nyhOtcetovIObrabotokVOblastiDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POSTAVLAEMAA_OBRABOTKA_ID")
    private kg.infosystems.buhproject.entity.catalogs.PostavlaemyeDopolnitel1nyeOtcetyIObrabotki postavlaemaaObrabotka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARAMETRY_INSTALLACII_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage parametryInstallacii;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
