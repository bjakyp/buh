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
@Entity(name = "informations_ObsiePostavlaemyeMaketyPecati")
@Table(name = "ObsiePostavlaemyeMaketyPecatiIr", schema = "informations")
@Getter
@Setter
public class ObsiePostavlaemyeMaketyPecati extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OB2EKT_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ob2ekt;

	@Column(name = "IMA_MAKETA", length = 100)
    private String imaMaketa;

	@Column(name = "KONTROL1NAA_SUMMA", length = 32)
    private String kontrol1naaSumma;

	@Column(name = "PREDYDUSAA_KONTROL1NAA_SUMMA", length = 32)
    private String predydusaaKontrol1naaSumma;

	@Column(name = "VERSIA_MAKETA", length = 20)
    private String versiaMaketa;

}
