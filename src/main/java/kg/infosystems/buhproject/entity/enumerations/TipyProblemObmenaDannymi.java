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
@Table(name = "TipyProblemObmenaDannymi", schema = "enumerations")
@Getter
@Setter
public class TipyProblemObmenaDannymi {
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
	1 НепроведенныйДокумент Непроведенный документ
	2 НезаполненныеРеквизиты Незаполненные реквизиты
	3 ОшибкаВыполненияКодаОбработчиковПриОтправкеДанных Ошибка выполнения кода обработчиков при отправке данных
	4 ОшибкаВыполненияКодаОбработчиковПриПолученииДанных Ошибка выполнения кода обработчиков при получении данных
	5 ОшибкаПроверкиСконвертированногоОбъекта Ошибка проверки сконвертированного объекта
	
	*/
}
