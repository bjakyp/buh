package kg.infosystems.buhproject.screen.catalogs.ucebnyezavedenia;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.UcebnyeZavedenia;

@UiController("UcebnyeZavedenia.edit")
@UiDescriptor("ucebnye-zavedenia-edit.xml")
@EditedEntityContainer("ucebnyeZavedeniaDc")
public class UcebnyeZavedeniaEdit extends StandardEditor<UcebnyeZavedenia> {
}