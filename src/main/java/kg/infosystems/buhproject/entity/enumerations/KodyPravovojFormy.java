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
@Table(name = "KodyPravovojFormy", schema = "enumerations")
@Getter
@Setter
public class KodyPravovojFormy {
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
	1 ОсОО ОсОО
	2 ОО ОО
	3 ОАО ОАО
	4 ЗАО ЗАО
	5 ГП ГП
	6 МКП МКП
	7 ОсДО ОсДО
	8 ОФ ОФ
	9 ТСЖ ТСЖ
	10 ИП ИП
	
	*/
}
