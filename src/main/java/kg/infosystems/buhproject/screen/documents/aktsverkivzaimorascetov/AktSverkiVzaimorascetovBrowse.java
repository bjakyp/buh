package kg.infosystems.buhproject.screen.documents.aktsverkivzaimorascetov;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.documents.AktSverkiVzaimorascetov;

@UiController("AktSverkiVzaimorascetov.browse")
@UiDescriptor("akt-sverki-vzaimorascetov-browse.xml")
@LookupComponent("aktSverkiVzaimorascetovsTable")
public class AktSverkiVzaimorascetovBrowse extends StandardLookup<AktSverkiVzaimorascetov> {
}