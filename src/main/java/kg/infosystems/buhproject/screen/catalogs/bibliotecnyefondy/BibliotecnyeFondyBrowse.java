package kg.infosystems.buhproject.screen.catalogs.bibliotecnyefondy;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.BibliotecnyeFondy;

@UiController("BibliotecnyeFondy.browse")
@UiDescriptor("bibliotecnye-fondy-browse.xml")
@LookupComponent("bibliotecnyeFondiesTable")
public class BibliotecnyeFondyBrowse extends StandardLookup<BibliotecnyeFondy> {
}