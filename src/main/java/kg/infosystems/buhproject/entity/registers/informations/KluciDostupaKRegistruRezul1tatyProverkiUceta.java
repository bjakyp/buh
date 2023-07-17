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
@Entity(name = "informations_KluciDostupaKRegistruRezul1tatyProverkiUceta")
@Table(name = "KluciDostupaKRegistruRezul1tatyProverkiUcetaIr", schema = "informations")
@Getter
@Setter
public class KluciDostupaKRegistruRezul1tatyProverkiUceta extends BaseEntity {
	@Column(name = "VARIANT_DOSTUPA", precision = 4, scale = 0)
    private BigDecimal variantDostupa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLE1_ID")
    private kg.infosystems.buhproject.entity.one.Multiple pole1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLE2_ID")
    private kg.infosystems.buhproject.entity.enumerations.Dopolnitel1nyeZnaceniaDostupa pole2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KLUC_DOSTUPA_ID")
    private kg.infosystems.buhproject.entity.catalogs.KluciDostupa klucDostupa;

}
