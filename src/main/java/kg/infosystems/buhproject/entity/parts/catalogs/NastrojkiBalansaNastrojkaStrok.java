package kg.infosystems.buhproject.entity.parts.catalogs;

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
@Table(name = "NastrojkiBalansaNastrojkaStrok", schema = "parts_catalogs")
@Getter
@Setter
public class NastrojkiBalansaNastrojkaStrok {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
    private kg.infosystems.buhproject.entity.catalogs.NastrojkiBalansa part;

	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;


	@Column(name = "NOMER_STROKI", precision = 5, scale = 0)
    private BigDecimal nomerStroki;

	@Column(name = "STROKA", length = 100)
    private String stroka;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCET_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj scet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEBET_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj debet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KREDIT_ID")
    private kg.infosystems.buhproject.entity.accounts.Hozrascetnyj kredit;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORMULA_ID")
    private kg.infosystems.buhproject.entity.one.Multiple formula;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ZNAK_ID")
    private kg.infosystems.buhproject.entity.enumerations.PlusMinus znak;

}
