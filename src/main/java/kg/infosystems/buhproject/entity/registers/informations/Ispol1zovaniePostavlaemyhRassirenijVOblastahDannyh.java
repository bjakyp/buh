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
@Entity(name = "informations_Ispol1zovaniePostavlaemyhRassirenijVOblastahDannyh")
@Table(name = "Ispol1zovaniePostavlaemyhRassirenijVOblastahDannyhIr", schema = "informations")
@Getter
@Setter
public class Ispol1zovaniePostavlaemyhRassirenijVOblastahDannyh extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POSTAVLAEMOE_RASSIRENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PostavlaemyeRassirenia postavlaemoeRassirenie;

	@Column(name = "ISPOL1ZUEMOE_RASSIRENIE")
    private UUID ispol1zuemoeRassirenie;

	@Column(name = "INSTALLACIA")
    private UUID installacia;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
