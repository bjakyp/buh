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
@Table(name = "SostoaniaPrilozenij", schema = "enumerations")
@Getter
@Setter
public class SostoaniaPrilozenij {
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
	1 Новая Новая
	2 Готово Готово
	3 ГотовитсяКИспользованию Готовится к использованию
	4 Используется Используется
	5 Конвертируется Конвертируется
	6 Копируется Копируется
	7 КУдалению К удалению
	8 Удалена Удалена
	9 Отсутствует Отсутствует
	10 ОшибкаПодготовки Ошибка подготовки
	11 ИмпортИзФайла Импорт из файла
	12 МиграцияПриложения Миграция приложения
	
	*/
}
