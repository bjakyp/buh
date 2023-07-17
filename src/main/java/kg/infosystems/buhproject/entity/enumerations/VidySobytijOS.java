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
@Table(name = "VidySobytijOS", schema = "enumerations")
@Getter
@Setter
public class VidySobytijOS {
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
	1 ПринятиеКУчету Принятие к учету
	2 НачислениеАмортизации Начисление амортизации
	3 ВнутреннееПеремещение Внутреннее перемещение
	4 КапитальныйРемонт Капитальный ремонт
	5 Переоценка Переоценка
	6 Модернизация Модернизация
	7 Списание Списание
	8 Прочее Прочее
	9 ПередачаБезвозмездно Передача безвозмездно
	10 СписаниеПоРезультатамИнвентаризации Списание по результатам инвентаризации
	11 ПоступлениеОтДругойОрганизации Поступление от другой организации
	12 ПоступлениеБезвозмездно Поступление безвозмездно
	13 ПоступлениеПоИнвентаризации Поступление по инвентаризации
	14 Приобретение Приобретение
	15 ПолучениеОтДругойЕдиницыГоссектораВнутриведомственно Получение от другой единицы госсектора внутриведомственно
	16 ПередачаДругойЕдиницеГоссектораВнутриведомственно Передача другой единице госсектора внутриведомственно
	17 ПередачаДругойЕдиницеГоссектора Передача другой единице госсектора
	18 ПолучениеОтДругойЕдиницыГоссектора Получение от другой единицы госсектора
	19 ПередачаДругойОрганизации Передача другой организации
	
	*/
}
