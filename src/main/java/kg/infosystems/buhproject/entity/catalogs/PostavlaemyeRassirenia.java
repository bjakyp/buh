package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;

import kg.infosystems.buhproject.entity.parts.catalogs.PostavlaemyeRassireniaRazresenia;
import kg.infosystems.buhproject.entity.parts.catalogs.PostavlaemyeRassireniaSovmestimost1;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "PostavlaemyeRassirenia", schema = "catalogs")
@Getter
@Setter
public class PostavlaemyeRassirenia {
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

	@Column(name = "NAIMENOVANIE", length = 100)
    private String naimenovanie;

	@Column(name = "IMA", length = 260)
    private String ima;

	@Column(name = "VERSIA", length = 18)
    private String versia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_RASSIRENIA_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseRassirenia;

	@Column(name = "INFORMACIA", length = 1024)
    private String informacia;

	@Column(name = "IDENTIFIKATOR_VERSII")
    private UUID identifikatorVersii;

	@Column(name = "OTKLUCENO")
    private Boolean otkluceno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICINA_OTKLUCENIA_ID")
    private kg.infosystems.buhproject.entity.enumerations.PricinyOtkluceniaRassirenijVModeliServisa pricinaOtklucenia;

	@Column(name = "IZMENAET_STRUKTURU_DANNYH")
    private Boolean izmenaetStrukturuDannyh;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostavlaemyeRassireniaSovmestimost1> sovmestimost1;

	@OnDelete(DeletePolicy.CASCADE)
	@Composition
	@OrderBy("nomerStroki")
	@OneToMany(mappedBy = "part")
	private List<PostavlaemyeRassireniaRazresenia> razresenia;
}
