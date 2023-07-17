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
@Table(name = "TipyFajlovDlaVstroennogoRedaktora", schema = "enumerations")
@Getter
@Setter
public class TipyFajlovDlaVstroennogoRedaktora {
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
	1 ГеографическиеСхемы Географические схемы
	2 ГрафическиеСхемы Графические схемы
	3 ТабличныеФайлы Табличные файлы
	4 ТекстовыеФайлы Текстовые файлы
	
	*/
}
