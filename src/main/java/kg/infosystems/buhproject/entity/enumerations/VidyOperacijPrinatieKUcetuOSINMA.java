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
@Table(name = "VidyOperacijPrinatieKUcetuOSINMA", schema = "enumerations")
@Getter
@Setter
public class VidyOperacijPrinatieKUcetuOSINMA {
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
	1 Оборудование Оборудование (товары)
	2 ОбъектыСтроительства Объекты строительства
	3 ПриобретенныеОСИНМА Приобретенные ОС и НМА
	4 ПоРезультатамИнвентаризации По результатам инвентаризации
	5 ДругоеПоступление Другое поступление
	
	*/
}
