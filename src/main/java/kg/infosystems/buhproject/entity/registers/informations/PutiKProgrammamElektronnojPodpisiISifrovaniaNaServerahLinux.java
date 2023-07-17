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
@Entity(name = "informations_PutiKProgrammamElektronnojPodpisiISifrovaniaNaServerahLinux")
@Table(name = "PutiKProgrammamElektronnojPodpisiISifrovaniaNaServerahLinuxIr", schema = "informations")
@Getter
@Setter
public class PutiKProgrammamElektronnojPodpisiISifrovaniaNaServerahLinux extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROGRAMMA_ID")
    private kg.infosystems.buhproject.entity.catalogs.ProgrammyElektronnojPodpisiISifrovania programma;

	@Column(name = "IMA_KOMP1UTERA", length = 255)
    private String imaKomp1utera;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@Lob
	@Column(name = "PUT1_K_PROGRAMME")
    private String put1KProgramme;

}
