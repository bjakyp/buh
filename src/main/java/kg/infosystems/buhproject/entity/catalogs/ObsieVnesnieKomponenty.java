package kg.infosystems.buhproject.entity.catalogs;

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
@Table(name = "ObsieVnesnieKomponenty", schema = "catalogs")
@Getter
@Setter
public class ObsieVnesnieKomponenty {
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

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Column(name = "IDENTIFIKATOR", length = 150)
    private String identifikator;

	@Column(name = "VERSIA", length = 20)
    private String versia;

	@Column(name = "DATA_VERSII")
    private LocalDateTime dataVersii;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_KOMPONENTY_ID")
    private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseKomponenty;

	@Column(name = "WINDOWS_X86")
    private Boolean windows_x86;

	@Column(name = "WINDOWS_X86_64")
    private Boolean windows_x86_64;

	@Column(name = "LINUX_X86")
    private Boolean linux_x86;

	@Column(name = "LINUX_X86_64")
    private Boolean linux_x86_64;

	@Column(name = "WINDOWS_X86_FIREFOX")
    private Boolean windows_x86_Firefox;

	@Column(name = "LINUX_X86_FIREFOX")
    private Boolean linux_x86_Firefox;

	@Column(name = "LINUX_X86_64_FIREFOX")
    private Boolean linux_x86_64_Firefox;

	@Column(name = "WINDOWS_X86_MSIE")
    private Boolean windows_x86_MSIE;

	@Column(name = "WINDOWS_X86_64_MSIE")
    private Boolean windows_x86_64_MSIE;

	@Column(name = "WINDOWS_X86_CHROME")
    private Boolean windows_x86_Chrome;

	@Column(name = "LINUX_X86_CHROME")
    private Boolean linux_x86_Chrome;

	@Column(name = "LINUX_X86_64_CHROME")
    private Boolean linux_x86_64_Chrome;

	@Column(name = "MAC_OS_X86_64")
    private Boolean macOS_x86_64;

	@Column(name = "MAC_OS_X86_64_SAFARI")
    private Boolean macOS_x86_64_Safari;

}
