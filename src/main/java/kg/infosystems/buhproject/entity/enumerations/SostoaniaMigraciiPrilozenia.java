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
@Table(name = "SostoaniaMigraciiPrilozenia", schema = "enumerations")
@Getter
@Setter
public class SostoaniaMigraciiPrilozenia {
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
	1 Выполняется Выполняется
	2 ЗавершенаСОшибкой Завершена с ошибкой
	3 ЗавершенаУспешно Завершена успешно
	4 ОжиданиеЗагрузки Ожидание загрузки
	5 ОжиданиеОбновления Ожидание обновления
	
	*/
}
