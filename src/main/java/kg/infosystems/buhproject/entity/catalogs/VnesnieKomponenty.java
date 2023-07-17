package kg.infosystems.buhproject.entity.catalogs;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "VnesnieKomponenty", schema = "catalogs")
@Getter
@Setter
public class VnesnieKomponenty {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISPOL1ZOVANIE_ID")
	private kg.infosystems.buhproject.entity.enumerations.VariantyIspol1zovaniaVnesnihKomponent ispol1zovanie;

	@Column(name = "IDENTIFIKATOR", length = 150)
	private String identifikator;

	@Column(name = "VERSIA", length = 20)
	private String versia;

	@Column(name = "DATA_VERSII")
	private LocalDateTime dataVersii;

	@Column(name = "IMA_FAJLA", length = 260)
	private String imaFajla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HRANILISE_KOMPONENTY_ID")
	private kg.infosystems.buhproject.entity.one.ValueStorage hraniliseKomponenty;

	@Column(name = "OBNOVLAT1_S_PORTALA1_SITS")
	private Boolean obnovlat1SPortala1SITS;

	@Column(name = "OPISANIE_OSIBKI", length = 1024)
	private String opisanieOsibki;

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
