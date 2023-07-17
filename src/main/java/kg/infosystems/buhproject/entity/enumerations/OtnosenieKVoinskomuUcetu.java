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
@Table(name = "OtnosenieKVoinskomuUcetu", schema = "enumerations")
@Getter
@Setter
public class OtnosenieKVoinskomuUcetu {
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
	1 СостоитНаВоинскомУчете Состоит на воинском учете
	2 ВстаетНаВоинскийУчет Встает на воинский учет
	3 НеСостоитНаВоинскомУчете Не состоит на воинском учете
	4 СнятСВоинскогоУчетаПоСостояниюЗдоровья Снят с воинского учета по состоянию здоровья
	5 СнятСВоинскогоУчетаПоВозрасту Снят с воинского учета по возрасту
	
	*/
}
