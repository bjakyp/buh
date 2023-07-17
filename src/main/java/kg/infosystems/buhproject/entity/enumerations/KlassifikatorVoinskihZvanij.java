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
@Table(name = "KlassifikatorVoinskihZvanij", schema = "enumerations")
@Getter
@Setter
public class KlassifikatorVoinskihZvanij {
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
	1 Рядовой Рядовой
	2 Матрос Матрос
	3 Ефрейтор Ефрейтор
	4 СтаршийМатрос Старший матрос
	5 МладшийСержант Младший сержант
	6 Старшина2Статьи Старшина2 статьи
	7 Сержант Сержант
	8 Старшина1Статьи Старшина1 статьи
	9 СтаршийСержант Старший сержант
	10 ГлавныйСтаршина Главный старшина
	11 Старшина Старшина
	12 ГлавныйКорабельныйСтаршина Главный корабельный старшина
	13 Прапорщик Прапорщик
	14 Мичман Мичман
	15 СтаршийПрапорщик Старший прапорщик
	16 СтаршийМичман Старший мичман
	17 МладшийЛейтенант Младший лейтенант
	18 Лейтенант Лейтенант
	19 СтаршийЛейтенант Старший лейтенант
	20 Капитан Капитан
	21 КапитанЛейтенант Капитан-лейтенант
	22 Майор Майор
	23 Капитан3Ранга Капитан 3 ранга
	24 Подполковник Подполковник
	25 Капитан2Ранга Капитан 2 ранга
	26 Полковник Полковник
	27 Капитан1Ранга Капитан 1 ранга
	28 ГенералМайор Генерал-майор
	29 КонтрАдмирал Контр-адмирал
	30 ГенералЛейтенант Генерал-лейтенант
	31 ВицеАдмирал Вице-адмирал
	32 ГенералПолковник Генерал-полковник
	33 Адмирал Адмирал
	34 ГенералАрмии Генерал армии
	35 АдмиралФлота Адмирал флота
	36 МаршалРоссийскойФедерации Маршал Российской Федерации
	
	*/
}
