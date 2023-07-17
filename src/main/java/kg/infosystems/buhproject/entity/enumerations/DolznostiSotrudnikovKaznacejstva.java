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
@Table(name = "DolznostiSotrudnikovKaznacejstva", schema = "enumerations")
@Getter
@Setter
public class DolznostiSotrudnikovKaznacejstva {
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
	1 ЗаведующийРОК Заведующий РОК
	2 Исполнитель Исполнитель
	3 УполномоченныйСотрудник Уполномоченный сотрудник
	
	*/
}
