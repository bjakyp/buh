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
@Table(name = "KategoriiRascetov", schema = "enumerations")
@Getter
@Setter
public class KategoriiRascetov {
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
	1 Первичное Первичное
	2 ЗависимоеПервогоУровня Зависимое первого уровня
	3 ЗависимоеВторогоУровня Зависимое второго уровня
	4 ЗависимоеТретьегоУровня Зависимое третьего уровня
	5 ЗависимоеЧетвертогоУровня Зависимое четвертого уровня
	6 ЗависимоеПятогоУровня Зависимое пятого уровня
	7 ЗависимоеШестогоУровня Зависимое шестого уровня
	8 ЗависимоеСедьмогоУровня Зависимое седьмого уровня
	9 ЗависимоеВосьмогоУровня Зависимое восьмого уровня
	10 ЗависимоеДевятогоУровня Зависимое девятого уровня
	11 ЗависимоеДесятогоУровня Зависимое десятого уровня
	
	*/
}
