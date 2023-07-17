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
@Table(name = "PoradkiOkruglenia", schema = "enumerations")
@Getter
@Setter
public class PoradkiOkruglenia {
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
	1 Окр0_01 0.01
	2 Окр0_05 0.05
	3 Окр0_1 0.1
	4 Окр0_5 0.5
	5 Окр1 1
	6 Окр5 5
	7 Окр10 10
	8 Окр50 50
	9 Окр100 100
	10 ОтсечениеДробнойЧасти Отсечение дробной части
	
	*/
}
