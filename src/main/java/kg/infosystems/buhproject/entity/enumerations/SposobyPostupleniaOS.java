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
@Table(name = "SposobyPostupleniaOS", schema = "enumerations")
@Getter
@Setter
public class SposobyPostupleniaOS {
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
	1 Приобретение Приобретение
	2 Строительство Строительство
	3 ВкладВУК Вклад в УК
	4 Аренда Аренда
	5 Инвентаризация Инвентаризация
	6 ДругоеПоступление Другое поступление
	7 Иное Иное
	8 ВнутриведомственноеПоступление Внутриведомственное поступление
	9 ВнутриведомственноеПередача Внутриведомственное передача
	10 ДругаяЕдиницаГосСектора Другая единица гос сектора
	
	*/
}
