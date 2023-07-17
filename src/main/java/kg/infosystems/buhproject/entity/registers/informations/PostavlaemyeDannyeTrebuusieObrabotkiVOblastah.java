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
@Entity(name = "informations_PostavlaemyeDannyeTrebuusieObrabotkiVOblastah")
@Table(name = "PostavlaemyeDannyeTrebuusieObrabotkiVOblastahIr", schema = "informations")
@Getter
@Setter
public class PostavlaemyeDannyeTrebuusieObrabotkiVOblastah extends BaseEntity {
	@Column(name = "IDENTIFIKATOR_FAJLA")
    private UUID identifikatorFajla;

	@Column(name = "KOD_OBRABOTCIKA", length = 150)
    private String kodObrabotcika;

	@Column(name = "OBLAST1_DANNYH_VSPOMOGATEL1NYE_DANNYE", precision = 7, scale = 0)
    private BigDecimal oblast1DannyhVspomogatel1nyeDannye;

}
