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
@Entity(name = "informations_PrimenenieRazresenijNaIspol1zovanieVnesnihResursovVModeliServisa")
@Table(name = "PrimenenieRazresenijNaIspol1zovanieVnesnihResursovVModeliServisaIr", schema = "informations")
@Getter
@Setter
public class PrimenenieRazresenijNaIspol1zovanieVnesnihResursovVModeliServisa extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_PAKETA")
    private UUID identifikatorPaketa;

	@Lob
	@Column(name = "SOSTOANIE")
    private String sostoanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REZUL1TAT_ID")
    private kg.infosystems.buhproject.entity.enumerations.Rezul1tatyObrabotkiZaprosovNaIspol1zovanieVnesnihResursovVModeliServisa rezul1tat;

}
