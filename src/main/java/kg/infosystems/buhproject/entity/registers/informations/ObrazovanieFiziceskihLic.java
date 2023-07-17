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
@Entity(name = "informations_ObrazovanieFiziceskihLic")
@Table(name = "ObrazovanieFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class ObrazovanieFiziceskihLic extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@Column(name = "DIPLOM", length = 25)
    private String diplom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_OBRAZOVANIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.VidyObrazovaniaFiziceskihLic vidObrazovania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCEBNOE_ZAVEDENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.UcebnyeZavedenia ucebnoeZavedenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORMA_OBUCENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.FormaObucenia formaObucenia;

	@Column(name = "GOD_OKONCANIA")
    private LocalDateTime godOkoncania;

	@Column(name = "KVALIFIKACIA", length = 99)
    private String kvalifikacia;

	@Column(name = "GOD_POSTUPLENIA")
    private LocalDateTime godPostuplenia;

	@Column(name = "DATA_VYDACI_DIPLOMA")
    private LocalDateTime dataVydaciDiploma;

	@Column(name = "SPECIAL1NOST1", length = 500)
    private String special1nost1;

}
