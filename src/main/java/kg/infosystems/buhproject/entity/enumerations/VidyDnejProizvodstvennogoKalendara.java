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
@Table(name = "VidyDnejProizvodstvennogoKalendara", schema = "enumerations")
@Getter
@Setter
public class VidyDnejProizvodstvennogoKalendara {
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

    @Column(name = "SHORT_NAME", length = 5)
    private String shortName;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /*
	id name synonym
	1 Рабочий Рабочий
	2 Суббота Суббота
	3 Воскресенье Воскресенье
	4 Предпраздничный Предпраздничный
	5 Праздник Праздник
	6 Выходной Выходной
	7 Нерабочий Нерабочий

	*/
}
