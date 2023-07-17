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
@Table(name = "DostupnyePeriodyOtceta", schema = "enumerations")
@Getter
@Setter
public class DostupnyePeriodyOtceta {
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
	1 День День
	2 Неделя Неделя
	3 Декада Декада
	4 Месяц Месяц
	5 Квартал Квартал
	6 Полугодие Полугодие
	7 Год Год
	8 ПроизвольныйПериод Произвольный
	
	*/
}
