package kg.infosystems.buhproject.entity.enumerations;

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
@Table(name = "RezimySovmestimostiRazresenijDopolnitel1nyhOtcetovIObrabotok", schema = "enumerations")
@Getter
@Setter
public class RezimySovmestimostiRazresenijDopolnitel1nyhOtcetovIObrabotok {
	@JmixGeneratedValue
	@Id
    private Long id;

	@InstanceName
	@Column(name = "NAME")
    private String name;

	@Column(name = "SYNONYM_")
    private String synonym;

	@Column(name = "ORDER_")
    private Integer order;

	/*
	id name synonym
	1 Версия_2_1_3 Версия 2.1.3
	2 Версия_2_2_2 Версия 2.2.2
	
	*/
}
