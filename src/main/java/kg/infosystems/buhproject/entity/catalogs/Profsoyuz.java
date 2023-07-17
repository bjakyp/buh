package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.enumerations.VidyDvizenijPoProfsouzam;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "PROFSOYUZ", indexes = {
    @Index(name = "IDX_PROFSOYUZ_VID_DVIZENIA", columnList = "VID_DVIZENIA_ID"),
    @Index(name = "IDX_PROFSOYUZ_SOTRUDNIKI", columnList = "SOTRUDNIKI_ID")
})
@Entity
@Getter
@Setter
public class Profsoyuz {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATA_DVIZENIA", nullable = false)
    @NotNull
    private LocalDateTime dataDvizenia;

    @JoinColumn(name = "VID_DVIZENIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private VidyDvizenijPoProfsouzam vidDvizenia;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @JoinColumn(name = "SOTRUDNIKI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sotrudniki sotrudniki;
}
