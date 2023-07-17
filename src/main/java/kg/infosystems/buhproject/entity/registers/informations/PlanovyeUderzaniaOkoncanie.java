package kg.infosystems.buhproject.entity.registers.informations;

import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.compensations.VidyUderzanij;
import lombok.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity(name = "informations_PlanovyeUderzaniaOkoncanie")
@Table(name = "PlanovyeUderzaniaOkoncanieIr", schema = "informations")
@Getter
@Setter
public class PlanovyeUderzaniaOkoncanie extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGISTRATOR_ID")
    private kg.infosystems.buhproject.entity.one.Multiple registrator;

	@Column(name = "PERIOD")
    private LocalDateTime period;

	@Column(name = "NOMER_STROKI", precision = 9, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "AKTIVNOST1")
    private Boolean aktivnost1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOTRUDNIK_ID")
    private kg.infosystems.buhproject.entity.catalogs.Sotrudniki sotrudnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_RASCETA_ID")
    private VidyUderzanij vidRasceta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_SSYLKA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple dokumentSsylka;

	@Column(name = "RAZMER", precision = 15, scale = 2)
    private BigDecimal razmer;

}
