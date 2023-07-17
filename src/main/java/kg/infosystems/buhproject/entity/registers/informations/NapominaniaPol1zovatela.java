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
@Entity(name = "informations_NapominaniaPol1zovatela")
@Table(name = "NapominaniaPol1zovatelaIr", schema = "informations")
@Getter
@Setter
public class NapominaniaPol1zovatela extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

	@Column(name = "VREMA_SOBYTIA")
    private LocalDateTime vremaSobytia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISTOCNIK_ID")
    private kg.infosystems.buhproject.entity.one.Multiple istocnik;

	@Column(name = "SROK_NAPOMINANIA")
    private LocalDateTime srokNapominania;

	@Column(name = "OPISANIE", length = 255)
    private String opisanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_USTANOVKI_VREMENI_NAPOMINANIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.SposobyUstanovkiVremeniNapominania sposobUstanovkiVremeniNapominania;

	@Column(name = "INTERVAL_VREMENI_NAPOMINANIA", precision = 10, scale = 0)
    private BigDecimal intervalVremeniNapominania;

	@Column(name = "IMA_REKVIZITA_ISTOCNIKA", length = 255)
    private String imaRekvizitaIstocnika;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RASPISANIE_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage raspisanie;

	@Column(name = "PREDSTAVLENIE_ISTOCNIKA", length = 100)
    private String predstavlenieIstocnika;

	@Column(name = "IDENTIFIKATOR", length = 100)
    private String identifikator;

}
