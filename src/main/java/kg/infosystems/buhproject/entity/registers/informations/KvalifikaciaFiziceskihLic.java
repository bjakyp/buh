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
@Entity(name = "informations_KvalifikaciaFiziceskihLic")
@Table(name = "KvalifikaciaFiziceskihLicIr", schema = "informations")
@Getter
@Setter
public class KvalifikaciaFiziceskihLic extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.Organizacii organizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIZ_LICO_ID")
    private kg.infosystems.buhproject.entity.catalogs.FiziceskieLica fizLico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PODRAZDELENIE_ID")
    private kg.infosystems.buhproject.entity.catalogs.PodrazdeleniaOrganizacij podrazdelenie;

	@Column(name = "DATA_S")
    private LocalDateTime dataS;

	@Column(name = "EKZAMEN")
    private Boolean ekzamen;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KVALIFIKACIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KvalifikaciiSotrudnikov kvalifikacia;

	@Column(name = "KOMMENTARIJ", length = 150)
    private String kommentarij;

	@Column(name = "DATA_PO")
    private LocalDateTime dataPo;

}
