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
@Table(name = "VidyDopolnitel1nyhOtcetovIObrabotok", schema = "enumerations")
@Getter
@Setter
public class VidyDopolnitel1nyhOtcetovIObrabotok {
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
	1 ДополнительнаяОбработка Дополнительная обработка
	2 ДополнительныйОтчет Дополнительный отчет
	3 ЗаполнениеОбъекта Заполнение объекта
	4 Отчет Отчет
	5 ПечатнаяФорма Печатная форма
	6 СозданиеСвязанныхОбъектов Создание связанных объектов
	7 ШаблонСообщения Шаблон сообщения
	
	*/
}
