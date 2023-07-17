package kg.infosystems.buhproject.screen.catalogs.ucebnyezavedenia;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UcebnyeZavedenia;

@UiController("UcebnyeZavedenia.browse")
@UiDescriptor("ucebnye-zavedenia-browse.xml")
@LookupComponent("ucebnyeZavedeniasTable")
public class UcebnyeZavedeniaBrowse extends StandardLookup<UcebnyeZavedenia> {
}