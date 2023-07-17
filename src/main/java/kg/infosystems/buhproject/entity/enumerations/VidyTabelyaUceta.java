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
@Table(name = "VidyTabelyaUceta", schema = "enumerations")
@Getter
@Setter
public class VidyTabelyaUceta {
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
	1 Пособия Пособия
	2 Командировка Командировка
	3 Неявка Неявка
	4 Отпуск Отпуск

	*/
}
