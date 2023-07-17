package kg.infosystems.buhproject.entity.characteristics;

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
@Table(name = "Dopolnitel1nyeRekvizityISvedenia", schema = "characteristics")
@Getter
@Setter
public class Dopolnitel1nyeRekvizityISvedenia {
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

	@Column(name = "TIP_ZNACENIA")
    private byte[] tipZnacenia;

	@Column(name = "NAIMENOVANIE", length = 150)
    private String naimenovanie;

	@Column(name = "VIDEN")
    private Boolean viden;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VLADELEC_DOPOLNITEL1NYH_ZNACENIJ_ID")
    private kg.infosystems.buhproject.entity.characteristics.Dopolnitel1nyeRekvizityISvedenia vladelecDopolnitel1nyhZnacenij;

	@Column(name = "VYVODIT1_V_VIDE_GIPERSSYLKI")
    private Boolean vyvodit1VVideGiperssylki;

	@Column(name = "DOPOLNITEL1NYE_ZNACENIA_ISPOL1ZUUTSA")
    private Boolean dopolnitel1nyeZnaceniaIspol1zuutsa;

	@Column(name = "DOPOLNITEL1NYE_ZNACENIA_S_VESOM")
    private Boolean dopolnitel1nyeZnaceniaSVesom;

	@Column(name = "DOSTUPEN")
    private Boolean dostupen;

	@Column(name = "ZAGOLOVOK", length = 75)
    private String zagolovok;

	@Column(name = "ZAGOLOVOK_FORMY_VYBORA_ZNACENIA", length = 150)
    private String zagolovokFormyVyboraZnacenia;

	@Column(name = "ZAGOLOVOK_FORMY_ZNACENIA", length = 150)
    private String zagolovokFormyZnacenia;

	@Column(name = "ZAPOLNAT1_OBAZATEL1NO")
    private Boolean zapolnat1Obazatel1no;

	@Column(name = "IMA", length = 100)
    private String ima;

	@Lob
	@Column(name = "KOMMENTARIJ")
    private String kommentarij;

	@Column(name = "MNOGOSTROCNOE_POLE_VVODA", precision = 2, scale = 0)
    private BigDecimal mnogostrocnoePoleVvoda;

	@Lob
	@Column(name = "PODSKAZKA")
    private String podskazka;

	@Lob
	@Column(name = "FORMAT_SVOJSTVA")
    private String formatSvojstva;

	@Column(name = "ETO_DOPOLNITEL1NOE_SVEDENIE")
    private Boolean etoDopolnitel1noeSvedenie;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NABOR_SVOJSTV_ID")
    private kg.infosystems.buhproject.entity.catalogs.NaboryDopolnitel1nyhRekvizitovISvedenij naborSvojstv;

	@Column(name = "IDENTIFIKATOR_DLA_FORMUL", length = 150)
    private String identifikatorDlaFormul;

}
