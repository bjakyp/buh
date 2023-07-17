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
@Entity(name = "informations_DokumentyFiziceskihLic")
@Table(name = "DokumentyFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class DokumentyFiziceskihLic extends BaseEntity {
	@Column(name = "PERIOD")
    private LocalDateTime period;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@Column(name = "SERIA", length = 14)
    private String seria;

	@Column(name = "NOMER", length = 14)
    private String nomer;

	@Column(name = "DATA_VYDACI")
    private LocalDateTime dataVydaci;

	@Column(name = "SROK_DEJSTVIA")
    private LocalDateTime srokDejstvia;

	@Column(name = "KEM_VYDAN", length = 200)
    private String kemVydan;

	@Column(name = "PREDSTAVLENIE", length = 500)
    private String predstavlenie;

}
