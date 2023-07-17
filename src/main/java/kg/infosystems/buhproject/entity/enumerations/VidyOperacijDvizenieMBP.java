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
@Table(name = "VidyOperacijDvizenieMBP", schema = "enumerations")
@Getter
@Setter
public class VidyOperacijDvizenieMBP {
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
	1 ВводМБПВЭксплуатацию Ввод МБП в эксплуатацию
	2 ПеремещениеМБППоСкладам Перемещение МБП по складам
	3 ПеремещениеМБПВЭксплуатации Перемещение МБП в эксплуатации
	4 СписаниеМБПВЭксплуатации Списание МБП в эксплуатации
	5 ОприходованиеМБП Оприходование МБП (по инвентаризации)
	
	*/
}
