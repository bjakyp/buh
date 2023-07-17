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
@Entity(name = "informations_RazreseniaNaIspol1zovanieVnesnihResursovVModeliServisa")
@Table(name = "RazreseniaNaIspol1zovanieVnesnihResursovVModeliServisaIr", schema = "informations")
@Getter
@Setter
public class RazreseniaNaIspol1zovanieVnesnihResursovVModeliServisa extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_PROGRAMMNOGO_MODULA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh tipProgrammnogoModula;

	@Column(name = "IDENTIFIKATOR_PROGRAMMNOGO_MODULA")
    private UUID identifikatorProgrammnogoModula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIP_VLADEL1CA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh tipVladel1ca;

	@Column(name = "IDENTIFIKATOR_VLADEL1CA")
    private UUID identifikatorVladel1ca;

	@Column(name = "KLUC_RAZRESENIA", length = 32)
    private String klucRazresenia;

	@Lob
	@Column(name = "TELO_RAZRESENIA")
    private String teloRazresenia;

	@Lob
	@Column(name = "PREDSTAVLENIE_PROGRAMMNOGO_MODULA")
    private String predstavlenieProgrammnogoModula;

	@Lob
	@Column(name = "PREDSTAVLENIE_VLADEL1CA")
    private String predstavlenieVladel1ca;

}
