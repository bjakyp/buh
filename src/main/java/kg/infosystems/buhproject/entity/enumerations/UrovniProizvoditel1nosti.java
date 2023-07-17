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
@Table(name = "UrovniProizvoditel1nosti", schema = "enumerations")
@Getter
@Setter
public class UrovniProizvoditel1nosti {
    @Column(nullable = false)
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
	1 Идеально Идеально (apdex = 1)
	2 Отлично Отлично (apdex >= 0.94)
	3 Хорошо Хорошо (apdex >= 0.85)
	4 Удовлетворительно Удовлетворительно (apdex >= 0.70)
	5 Плохо Плохо (apdex >= 0.50)

	*/
}
