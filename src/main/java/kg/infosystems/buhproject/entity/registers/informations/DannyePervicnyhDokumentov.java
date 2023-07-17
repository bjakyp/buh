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
@Entity(name = "informations_DannyePervicnyhDokumentov")
@Table(name = "DannyePervicnyhDokumentovIr", schema = "informations")
@Getter
@Setter
public class DannyePervicnyhDokumentov extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOKUMENT_ID")
    private kg.infosystems.buhproject.entity.one.Multiple dokument;

	@Column(name = "NOMER", length = 30)
    private String nomer;

	@Column(name = "DATA")
    private LocalDateTime data;

	@Column(name = "DATA_REGISTRATORA")
    private LocalDateTime dataRegistratora;

	@Column(name = "NOMER_REGISTRATORA", length = 30)
    private String nomerRegistratora;

	@Column(name = "SUMMA_DOKUMENTA", precision = 15, scale = 2)
    private BigDecimal summaDokumenta;

}
