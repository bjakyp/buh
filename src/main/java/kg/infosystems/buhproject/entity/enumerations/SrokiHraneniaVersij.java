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
@Table(name = "SrokiHraneniaVersij", schema = "enumerations")
@Getter
@Setter
public class SrokiHraneniaVersij {
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
	1 ЗаПоследнююНеделю За последнюю неделю
	2 ЗаПоследнийМесяц За последний месяц
	3 ЗаПоследниеТриМесяца За последние три месяца
	4 ЗаПоследниеШестьМесяцев За последние шесть месяцев
	5 ЗаПоследнийГод За последний год
	6 Бессрочно Бессрочно
	
	*/
}
