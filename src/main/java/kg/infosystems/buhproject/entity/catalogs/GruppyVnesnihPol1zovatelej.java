package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.GruppyVnesnihPol1zovatelejNaznacenie;
import kg.infosystems.buhproject.entity.parts.catalogs.GruppyVnesnihPol1zovatelejRoli;
import kg.infosystems.buhproject.entity.parts.catalogs.GruppyVnesnihPol1zovatelejSostav;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "GruppyVnesnihPol1zovatelej", schema = "catalogs")
@Getter
@Setter
public class GruppyVnesnihPol1zovatelej {
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
	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RODITEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.GruppyVnesnihPol1zovatelej roditel1;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@Column(name = "VSE_OB2EKTY_AVTORIZACII")
    private Boolean vseOb2ektyAvtorizacii;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<GruppyVnesnihPol1zovatelejSostav> sostav;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<GruppyVnesnihPol1zovatelejRoli> roli;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<GruppyVnesnihPol1zovatelejNaznacenie> naznacenie;
}
