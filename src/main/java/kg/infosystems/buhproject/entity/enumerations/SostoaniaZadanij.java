package kg.infosystems.buhproject.entity.enumerations;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JmixEntity
@Entity
@Table(name = "SostoaniaZadanij", schema = "enumerations")
@Getter
@Setter
public class SostoaniaZadanij {
	@Column(nullable = false)
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
	1 Запланировано Запланировано
	2 Выполняется Выполняется
	3 Завершено Завершено
	4 НеЗапланировано Не запланировано
	5 ОшибкаВыполнения Ошибка выполнения
	6 НеАктивно Не активно
	7 ОбработкаОшибкиПриАварийномЗавершении Обработка ошибки при аварийном завершении
	
	*/
}
