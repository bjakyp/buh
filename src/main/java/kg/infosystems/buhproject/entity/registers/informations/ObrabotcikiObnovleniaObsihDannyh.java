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
@Entity(name = "informations_ObrabotcikiObnovleniaObsihDannyh")
@Table(name = "ObrabotcikiObnovleniaObsihDannyhIr", schema = "informations")
@Getter
@Setter
public class ObrabotcikiObnovleniaObsihDannyh extends BaseEntity {
	@Column(name = "IMA_OBRABOTCIKA", length = 255)
    private String imaObrabotcika;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID")
    private kg.infosystems.buhproject.entity.enumerations.StatusyObrabotcikovObnovlenia status;

	@Column(name = "VERSIA", length = 20)
    private String versia;

	@Column(name = "IMA_BIBLIOTEKI", length = 100)
    private String imaBiblioteki;

	@Column(name = "DLITEL1NOST1_OBRABOTKI", precision = 10, scale = 0)
    private BigDecimal dlitel1nost1Obrabotki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZIM_VYPOLNENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.RezimyVypolneniaObrabotcikov rezimVypolnenia;

	@Column(name = "VERSIA_REGISTRACII", length = 20)
    private String versiaRegistracii;

	@Column(name = "KOMMENTARIJ", length = 1024)
    private String kommentarij;

	@Column(name = "INFORMACIA_OB_OSIBKE", length = 1024)
    private String informaciaObOsibke;

}
