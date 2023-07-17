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
@Entity(name = "informations_NastrojkiObmenaDannymiXDTO")
@Table(name = "NastrojkiObmenaDannymiXDTOIr", schema = "informations")
@Getter
@Setter
public class NastrojkiObmenaDannymiXDTO extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UZEL_INFORMACIONNOJ_BAZY_ID")
    private kg.infosystems.buhproject.entity.one.Multiple uzelInformacionnojBazy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKI_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage nastrojki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NASTROJKI_KORRESPONDENTA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage nastrojkiKorrespondenta;

	@Column(name = "PROPUSKAT1_OB2EKTY_S_OSIBKAMI_PROVERKI_PO_SHEME")
    private Boolean propuskat1Ob2ektySOsibkamiProverkiPoSheme;

	@Column(name = "RASSIRENIE_FORMATA", length = 250)
    private String rassirenieFormata;

	@Column(name = "IMA_PLANA_OBMENA_KORRESPONDENTA", length = 80)
    private String imaPlanaObmenaKorrespondenta;

}
