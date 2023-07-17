package kg.infosystems.buhproject.entity.parts.documents;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam", schema = "parts_documents")
@Getter
@Setter
public class OtcetyPoSocial1nomuFonduFondOplatyTrudaPoKategoriam {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.documents.OtcetyPoSocial1nomuFondu part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KATEGORIA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KategoriiSotrudnikov kategoria;

	@Column(name = "CISLENNOST1", precision = 15, scale = 2)
    private BigDecimal cislennost1;

	@Column(name = "FOT_BOLEE", precision = 15, scale = 2)
    private BigDecimal fOTBolee;

	@Column(name = "FOT_MENEE", precision = 15, scale = 2)
    private BigDecimal fOTMenee;

	@Column(name = "DOP_FOT", precision = 15, scale = 2)
    private BigDecimal dopFOT;

	@Column(name = "ITOGO", precision = 15, scale = 2)
    private BigDecimal itogo;

}
