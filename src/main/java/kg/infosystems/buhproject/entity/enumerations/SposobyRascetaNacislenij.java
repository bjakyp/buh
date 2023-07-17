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
@Table(name = "SposobyRascetaNacislenij", schema = "enumerations")
@Getter
@Setter
public class SposobyRascetaNacislenij {
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
	1 ПоМесячнойСтавкеПоДням По месячной ставке по дням
	2 ПоДневнойСтавке По дневной ставке
	3 ФиксированнойСуммой Фиксированной суммой
	4 ПоМесячнойСтавкеПоЧасам По месячной ставке по часам
	5 ПоЧасовойСтавке По часовой ставке
	6 Процентом Процентом
	7 РаботаСверхурочно Работа сверхурочно
	8 ВыходныеИПраздничные Выходные и праздничные
	9 ОплатаБольничного По среднему заработку для больничного
	10 ОплатаОтпуска По среднему заработку для отпуска
	11 ПоСреднемуЗаработку По среднему заработку
	12 Неявка Неявка
	
	*/
}
