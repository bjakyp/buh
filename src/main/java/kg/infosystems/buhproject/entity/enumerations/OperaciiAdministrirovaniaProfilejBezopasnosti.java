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
@Table(name = "OperaciiAdministrirovaniaProfilejBezopasnosti", schema = "enumerations")
@Getter
@Setter
public class OperaciiAdministrirovaniaProfilejBezopasnosti {
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
	1 Создание Создание
	2 Назначение Назначение
	3 Обновление Обновление
	4 Удаление Удаление
	5 УдалениеНазначения Удаление назначения
	
	*/
}
