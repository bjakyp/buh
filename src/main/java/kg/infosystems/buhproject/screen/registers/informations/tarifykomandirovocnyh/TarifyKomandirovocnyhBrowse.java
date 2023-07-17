package kg.infosystems.buhproject.screen.registers.informations.tarifykomandirovocnyh;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.registers.informations.TarifyKomandirovocnyh;

@UiController("informations_TarifyKomandirovocnyh.browse")
@UiDescriptor("tarify-komandirovocnyh-browse.xml")
@LookupComponent("tarifyKomandirovocnyhsTable")
public class TarifyKomandirovocnyhBrowse extends StandardLookup<TarifyKomandirovocnyh> {
}