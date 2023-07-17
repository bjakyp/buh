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
@Entity(name = "informations_PredopredelennyeVariantyOtcetovVersijRassirenij")
@Table(name = "PredopredelennyeVariantyOtcetovVersijRassirenijIr", schema = "informations")
@Getter
@Setter
public class PredopredelennyeVariantyOtcetovVersijRassirenij extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OTCET_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovRassirenij otcet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VARIANT_ID")
    private kg.infosystems.buhproject.entity.catalogs.PredopredelennyeVariantyOtcetovRassirenij variant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VERSIA_RASSIRENIJ_ID")
    private kg.infosystems.buhproject.entity.catalogs.VersiiRassirenij versiaRassirenij;

	@Column(name = "KLUC_VARIANTA", length = 256)
    private String klucVarianta;

}
