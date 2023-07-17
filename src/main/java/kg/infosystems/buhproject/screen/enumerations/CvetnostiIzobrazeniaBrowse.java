package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.CvetnostiIzobrazenia;

@UiController("CvetnostiIzobrazenia.browse")
@UiDescriptor("CvetnostiIzobrazenia-browse.xml")
@LookupComponent("enumsTable")
public class CvetnostiIzobrazeniaBrowse extends StandardLookup<CvetnostiIzobrazenia> {
}