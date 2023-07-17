package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.compensations.VidyNacislenij;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "MetodyRascetaBol1nicnogoLista", schema = "catalogs")
@Getter
@Setter
public class MetodyRascetaBol1nicnogoLista {
	@Column(name = "ID", nullable = false)
	@Id
	@JmixGeneratedValue
    private UUID id;

	@Column(name = "VERSIA_DANNYH")
	@Version
    private Integer versiaDannyh;

	@DeletedBy
	@Column(name = "DELETED_BY")
    private String deletedBy;

	@DeletedDate
	@Column(name = "DELETED_DATE")
    private LocalDateTime deletedDate;

	@InstanceName
	@Column(name = "NAIMENOVANIE", length = 50)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEPOLNYE_MESACY_ID")
    private kg.infosystems.buhproject.entity.enumerations.NepolnyeMesacy nepolnyeMesacy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_RASCETA_ORGANIZACIA_ID")
    private VidyNacislenij vidRascetaOrganizacia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VID_RASCETA_SF_ID")
    private VidyNacislenij vidRascetaSF;

}
