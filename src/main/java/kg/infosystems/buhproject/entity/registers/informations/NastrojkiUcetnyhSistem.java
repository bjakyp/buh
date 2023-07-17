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
@Entity(name = "informations_NastrojkiUcetnyhSistem")
@Table(name = "NastrojkiUcetnyhSistemIr", schema = "informations")
@Getter
@Setter
public class NastrojkiUcetnyhSistem extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCETNAA_SISTEMA_ID")
    private kg.infosystems.buhproject.entity.catalogs.IdentifikatoryOb2ektovMetadannyh ucetnaaSistema;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POL1ZOVATEL1_ID")
    private kg.infosystems.buhproject.entity.catalogs.Pol1zovateli pol1zovatel1;

	@Lob
	@Column(name = "ADRES_SERVISA")
    private String adresServisa;

	@Column(name = "OPOVESAT1_OB_IZMENENIAH")
    private Boolean opovesat1ObIzmeneniah;

	@Column(name = "ISPOL1ZOVAT1_SERTIFIKAT")
    private Boolean ispol1zovat1Sertifikat;

	@Lob
	@Column(name = "IMA_SERTIFIKATA")
    private String imaSertifikata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPOSOB_AUTENTIFIKACII_ID")
    private kg.infosystems.buhproject.entity.enumerations.SposobyAutentifikacii sposobAutentifikacii;

	@Lob
	@Column(name = "LOGIN")
    private String login;

	@Column(name = "PODPISYVAT1_DANNYE")
    private Boolean podpisyvat1Dannye;

}
