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
@Table(name = "PrilozeniaDlaUvazki", schema = "enumerations")
@Getter
@Setter
public class PrilozeniaDlaUvazki {
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
	1 БюджетныеРасходы Ежекварт. отчет в казнач. по бюджетным средствам
	2 Расходы Расходы
	3 Доходы Доходы
	4 Баланс Баланс
	5 Приложение1 Приложение1
	6 Приложение2 Приложение2
	7 Приложение3 Приложение3
	8 Приложение4 Приложение4
	9 Приложение5 Приложение5
	10 Приложение6 Приложение6
	11 Приложение7 Приложение7
	12 Приложение8 Приложение8
	13 Приложение9 Приложение9
	14 Приложение10 Приложение10
	15 Приложение11 Приложение11
	16 Приложение12 Приложение12
	17 Приложение13 Приложение13
	18 Приложение4_1 Приложение4_1
	19 Приложение4_2 Приложение4_2
	20 Приложение6_1 Приложение6_1
	21 Приложение8_1 Приложение8_1
	22 Приложение8_2 Приложение8_2
	
	*/
}
