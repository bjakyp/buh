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
@Entity(name = "informations_NaznacenieDopolnitel1nyhObrabotok")
@Table(name = "NaznacenieDopolnitel1nyhObrabotokIr", schema = "informations")
@Getter
@Setter
public class NaznacenieDopolnitel1nyhObrabotok extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_NAZNACENIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ob2ektNaznacenia;

	@Column(name = "TIP_FORMY", length = 20)
    private String tipFormy;

	@Column(name = "ISPOL1ZOVAT1_ZAPOLNENIE_OB2EKTA")
    private Boolean ispol1zovat1ZapolnenieOb2ekta;

	@Column(name = "ISPOL1ZOVAT1_OTCETY")
    private Boolean ispol1zovat1Otcety;

	@Column(name = "ISPOL1ZOVAT1_SOZDANIE_SVAZANNYH_OB2EKTOV")
    private Boolean ispol1zovat1SozdanieSvazannyhOb2ektov;

}
