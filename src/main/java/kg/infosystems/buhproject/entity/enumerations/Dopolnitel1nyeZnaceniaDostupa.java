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
@Table(name = "Dopolnitel1nyeZnaceniaDostupa", schema = "enumerations")
@Getter
@Setter
public class Dopolnitel1nyeZnaceniaDostupa {
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
	1 ДоступРазрешен Доступ разрешен
	2 ДоступЗапрещен Доступ запрещен
	3 Истина Истина
	4 Ложь Ложь
	5 ПустаяСсылкаЛюбогоТипа Пустая ссылка любого типа
	6 Неопределено Неопределено
	7 Null Null
	8 ТипРазрешенный Тип разрешенный
	9 ТипЗапрещенный Тип запрещенный
	
	*/
}
