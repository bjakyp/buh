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
@Entity(name = "informations_SvedeniaOPol1zovatelah")
@Table(name = "SvedeniaOPol1zovatelahIr", schema = "informations")
@Getter
@Setter
public class SvedeniaOPol1zovatelah extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pol1zovatel1;

	@Column(name = "POTREBOVAT1_SMENU_PAROLA_PRI_VHODE")
    private Boolean potrebovat1SmenuParolaPriVhode;

	@Column(name = "SROK_DEJSTVIA_NE_OGRANICEN")
    private Boolean srokDejstviaNeOgranicen;

	@Column(name = "SROK_DEJSTVIA")
    private LocalDateTime srokDejstvia;

	@Column(name = "PROSROCKA_RABOTY_V_PROGRAMME_DO_ZAPRESENIA_VHODA", precision = 3, scale = 0)
    private BigDecimal prosrockaRabotyVProgrammeDoZapreseniaVhoda;

	@Column(name = "DATA_RAZRESENIA_VHODA_V_PROGRAMMU")
    private LocalDateTime dataRazreseniaVhodaVProgrammu;

	@Column(name = "DATA_POSLEDNEJ_AKTIVNOSTI")
    private LocalDateTime dataPoslednejAktivnosti;

	@Column(name = "DATA_AVTOMATICESKOGO_ZAPRESENIA_VHODA")
    private LocalDateTime dataAvtomaticeskogoZapreseniaVhoda;

	@Column(name = "DATA_NACALA_ISPOL1ZOVANIA_PAROLA")
    private LocalDateTime dataNacalaIspol1zovaniaParola;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISPOL1ZOVANNYE_PAROLI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage ispol1zovannyeParoli;

	@Column(name = "POSLEDNIJ_ISPOL1ZUEMYJ_KLIENT", length = 50)
    private String poslednijIspol1zuemyjKlient;

}
