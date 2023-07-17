package kg.infosystems.buhproject.screen.catalogs.stepenirodstvafiziceskihlic;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.StepeniRodstvaFiziceskihLic;

@UiController("StepeniRodstvaFiziceskihLic.browse")
@UiDescriptor("stepeni-rodstva-fiziceskih-lic-browse.xml")
@LookupComponent("stepeniRodstvaFiziceskihLicsTable")
public class StepeniRodstvaFiziceskihLicBrowse extends StandardLookup<StepeniRodstvaFiziceskihLic> {
}