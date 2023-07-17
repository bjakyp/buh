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
@Table(name = "RazmeryBumagi", schema = "enumerations")
@Getter
@Setter
public class RazmeryBumagi {
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
	1 НеЗадано Не задано
	2 A3 A3
	3 A4 A4
	4 A5 A5
	5 B4 B4
	6 B5 B5
	7 B6 B6
	8 C4 C4
	9 C5 C5
	10 C6 C6
	11 USExecutive US Executive
	12 USLegal US Legal
	13 USLetter US Letter
	
	*/
}
