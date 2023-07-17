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
@Table(name = "Rezul1tatyVypolneniaObmena", schema = "enumerations")
@Getter
@Setter
public class Rezul1tatyVypolneniaObmena {
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
	1 Выполнено Выполнено
	2 Отменено Отменено
	3 Ошибка Ошибка
	4 Ошибка_ТранспортСообщения Ошибка транспорта сообщения
	5 Предупреждение_СообщениеОбменаБылоРанееПринято Сообщение обмена было ранее принято
	6 ВыполненоСПредупреждениями Выполнено с предупреждениями
	
	*/
}
