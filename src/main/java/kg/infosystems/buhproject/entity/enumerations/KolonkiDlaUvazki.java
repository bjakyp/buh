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
@Table(name = "KolonkiDlaUvazki", schema = "enumerations")
@Getter
@Setter
public class KolonkiDlaUvazki {
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
	1 УтвержденоПоСметеНаГод УтвержденоПоСметеНаГод
	2 УточненнаяСметаНаОтчетныйПериод УточненнаяСметаНаОтчетныйПериод
	3 ОткрытоКредитовНаОтчетныйПериод ОткрытоКредитовНаОтчетныйПериод
	4 КассовыеРасходы КассовыеРасходы
	5 ФактическиеРасходы ФактическиеРасходы
	6 ВсегоКассовыхРасходов ВсегоКассовыхРасходов
	7 ПоКазначейству ПоКазначейству
	8 ПоКассеБюджетногоУчреждения ПоКассеБюджетногоУчреждения
	9 ФактическийДоходИРасход ФактическийДоходИРасход
	10 БюджетныеСредства БюджетныеСредства
	11 СпециальныеСредства СпециальныеСредства
	12 Итого Итого
	13 Сумма Сумма
	14 ОтнесеноНа32171120 ОтнесеноНа32171120
	15 ОтнесеноНаДругойЭлемент ОтнесеноНаДругойЭлемент
	16 ИтогоОстатокНаНачало ИтогоОстатокНаНачало
	17 ИтогоПоступление ИтогоПоступление
	18 ИтогоРасход ИтогоРасход
	19 ИтогоОстатокНаКонец ИтогоОстатокНаКонец
	20 БюджетныеСредстваНаНачало БюджетныеСредстваНаНачало
	21 БюджетныеСредстваПоступление БюджетныеСредстваПоступление
	22 БюджетныеСредстваРасходование БюджетныеСредстваРасходование
	23 БюджетныеСредстваНаКонец БюджетныеСредстваНаКонец
	24 СпециальныеСредстваНаНачало СпециальныеСредстваНаНачало
	25 СпециальныеСредстваПоступление СпециальныеСредстваПоступление
	26 СпециальныеСредстваРасходование СпециальныеСредстваРасходование
	27 СпециальныеСредстваНаКонец СпециальныеСредстваНаКонец
	28 БюджетныеСредстваДт БюджетныеСредстваДт
	29 БюджетныеСредстваКт БюджетныеСредстваКт
	30 СпециальныеСредстваДт СпециальныеСредстваДт
	31 СпециальныеСредстваКт СпециальныеСредстваКт
	
	*/
}
