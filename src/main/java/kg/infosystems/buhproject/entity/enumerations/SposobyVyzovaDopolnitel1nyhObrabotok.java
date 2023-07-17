package kg.infosystems.buhproject.entity.enumerations;

import io.jmix.core.annotation.*;
import io.jmix.core.entity.annotation.*;
import io.jmix.core.metamodel.annotation.*;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import kg.infosystems.buhproject.entity.templates.BaseEntity;

@JmixEntity
@Entity
@Table(name = "SposobyVyzovaDopolnitel1nyhObrabotok", schema = "enumerations")
@Getter
@Setter
public class SposobyVyzovaDopolnitel1nyhObrabotok {
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
	1 ВызовКлиентскогоМетода Вызов клиентского метода
	2 ВызовСерверногоМетода Вызов серверного метода
	3 ЗаполнениеФормы Заполнение формы
	4 ОткрытиеФормы Открытие формы
	5 СценарийВБезопасномРежиме Сценарий в безопасном режиме
	6 ЗагрузкаДанныхИзФайла Загрузка данных из файла
	
	*/
}
