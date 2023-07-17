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
@Table(name = "VariantyVersionirovaniaOb2ektov", schema = "enumerations")
@Getter
@Setter
public class VariantyVersionirovaniaOb2ektov {
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
	1 ВерсионироватьПриЗаписи При записи
	2 ВерсионироватьПриПроведении При проведении
	3 ВерсионироватьПриСтарте При старте
	4 НеВерсионировать Никогда
	
	*/
}
