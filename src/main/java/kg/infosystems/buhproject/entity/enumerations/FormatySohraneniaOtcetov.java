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
@Table(name = "FormatySohraneniaOtcetov", schema = "enumerations")
@Getter
@Setter
public class FormatySohraneniaOtcetov {
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
	1 HTML Веб-страница (.html)
	2 HTML4 Веб-страница версии 4 (.html)
	3 XLS Лист Microsoft Excel 97-2003 (.xls)
	4 XLSX Лист Microsoft Excel 2007 (.xlsx)
	5 PDF Документ PDF (.pdf)
	6 MXL Табличный документ (.mxl)
	7 ODS Электронная таблица Open Document (.ods)
	8 DOCX Документ Word 2007 (.docx)
	9 TXT Текстовый документ UTF-8 (.txt)
	10 ANSITXT Текстовый документ ANSI (.txt)
	
	*/
}
