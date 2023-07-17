package kg.infosystems.buhproject.screen.enumerations;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.enumerations.TipyRegistrov;

@UiController("TipyRegistrov.browse")
@UiDescriptor("TipyRegistrov-browse.xml")
@LookupComponent("enumsTable")
public class TipyRegistrovBrowse extends StandardLookup<TipyRegistrov> {
}