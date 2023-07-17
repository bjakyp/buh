package kg.infosystems.buhproject.screen.catalogs.bibliotecnyefondy;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.BibliotecnyeFondy;

@UiController("BibliotecnyeFondy.edit")
@UiDescriptor("bibliotecnye-fondy-edit.xml")
@EditedEntityContainer("bibliotecnyeFondyDc")
public class BibliotecnyeFondyEdit extends StandardEditor<BibliotecnyeFondy> {
}