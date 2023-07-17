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
@Table(name = "TipyVersijOb2ekta", schema = "enumerations")
@Getter
@Setter
public class TipyVersijOb2ekta {
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
	1 ИзмененоПользователем Изменено пользователем
	2 ПринятыеДанныеПоКоллизии Принятые данные по коллизии
	3 НепринятыеДанныеПоКоллизии Непринятые данные по коллизии
	4 НепринятыйПоДатеЗапретаОбъектСуществуетВБазе Непринятый по дате запрета объект существует в базе
	5 НепринятыйПоДатеЗапретаОбъектНеСуществуетВБазе Непринятый по дате запрета объект не существует в базе
	
	*/
}
