package kg.infosystems.buhproject.entity.one;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Entity
@Table(name = "Multiple")
@Getter
@Setter
public class Multiple {
    // TODO: choose id
    // TODO: Multiple impl
    // TODO: ValueStorage impl
    @InstanceName
    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    // _TYPE
    @Column(name = "M_TYPE", nullable = false)
    private Integer type;

    // _L
    @Column(name = "M_BOOL")
    private Boolean bool;

    // _N
    @Column(name = "M_NUMBER", precision = 18, scale = 2)
    private BigDecimal number;

    // _T
    @Column(name = "M_DATE")
    private LocalDateTime date;

    // _S
    @Column(name = "M_STRING", columnDefinition = "TEXT")
    private String string;

//    not used
//    // _B
//    @Column(name = "BYTE")
//    private byte[] bytes;

    // _RTRef
    @Column(name = "M_TABLE")
    private String table;

    // _RRRef
    @Column(name = "M_ROW_ID")
    private UUID row;

    @Column(name = "M_ROW_ID_INT")
    private Long rowLong;
}
