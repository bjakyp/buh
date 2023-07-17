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
@Table(name = "VidyTransportaSoobsenijObmena", schema = "enumerations")
@Getter
@Setter
public class VidyTransportaSoobsenijObmena {
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
	1 EMAIL Почтовые сообщения
	2 FILE Локальный или сетевой каталог
	3 FTP FTP-ресурс
	4 WS Интернет
	5 COM Прямое подключение
	6 WSПассивныйРежим Интернет (пассивный режим)
	7 ВнешняяСистема Внешняя система
	
	*/
}
