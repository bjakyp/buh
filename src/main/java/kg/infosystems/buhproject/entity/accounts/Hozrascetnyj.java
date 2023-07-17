package kg.infosystems.buhproject.entity.accounts;

import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import kg.infosystems.buhproject.entity.templates.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@JmixEntity
@Entity
@Table(name = "Hozrascetnyj", schema = "accounts")
@Getter
@Setter
// Хозрасчетный
public class Hozrascetnyj extends BaseEntity {
    // Родитель
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Hozrascetnyj parent;

    @InstanceName
    // Код
    @Column(name = "CODE", length = 9)
    private String code;

    // Наименование
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    // Порядок
    @Column(name = "ORDER_FIELD")
    private Integer orderField;

    // Вид
    @Column(name = "KIND")
    private Integer kind;

    // Забалансовый
    @Column(name = "OFF_BALANCE")
    private Boolean offBalance;

    // ЗапретитьИспользоватьВПроводках
    @Column(name = "DONT_USE_IN_PROV")
    private Boolean dontUseInProv;

    // ПарныйСчет
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAIR_ID")
    private Hozrascetnyj pair;

    // Временный
    @Column(name = "TEMPORARY")
    private Boolean temporary;

    // ОбластьДанныхОсновныеДанные

    // Валютный
    @Column(name = "MONETARY")
    private Boolean monetary;

    // Количественный
    @Column(name = "CARDINAL")
    private Boolean cardinal;
}
