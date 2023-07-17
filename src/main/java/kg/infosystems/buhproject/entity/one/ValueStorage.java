package kg.infosystems.buhproject.entity.one;

import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@JmixEntity
@Entity
@Table(name = "ValueStorage")
@Getter
@Setter
public class ValueStorage {
    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FILE_REF")
    private FileRef fileRef;
}
