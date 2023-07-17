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
@Table(name = "VidyKadrovyhSobytij", schema = "enumerations")
@Getter
@Setter
public class VidyKadrovyhSobytij {
    @Column(name = "ID", nullable = false)
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
	1 Прием Прием
	2 Перемещение Перемещение
	3 Увольнение Увольнение
	4 НачальныеДанные Начальные данные

	*/
}
