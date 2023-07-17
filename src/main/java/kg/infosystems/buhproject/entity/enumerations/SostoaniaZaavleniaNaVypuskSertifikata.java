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
@Table(name = "SostoaniaZaavleniaNaVypuskSertifikata", schema = "enumerations")
@Getter
@Setter
public class SostoaniaZaavleniaNaVypuskSertifikata {
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
	1 НеПодготовлено Не подготовлено
	2 Подготовлено Подготовлено
	3 Отправлено Отправлено
	4 Отклонено Отклонено
	5 ИсполненоСертификатНеУстановлен Исполнено, сертификат не установлен
	6 Исполнено Исполнено
	
	*/
}
