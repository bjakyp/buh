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
@Table(name = "TipyTekstovElektronnyhPisem", schema = "enumerations")
@Getter
@Setter
public class TipyTekstovElektronnyhPisem {
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
	1 HTML HTML
	2 ПростойТекст Простой текст
	3 РазмеченныйТекст Размеченный текст
	4 HTMLСКартинками HTML с картинками
	
	*/
}
