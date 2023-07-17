package kg.infosystems.buhproject.screen.catalogs.vidyobrazovaniafiziceskihlic;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyObrazovaniaFiziceskihLic;

@UiController("VidyObrazovaniaFiziceskihLic.edit")
@UiDescriptor("vidy-obrazovania-fiziceskih-lic-edit.xml")
@EditedEntityContainer("vidyObrazovaniaFiziceskihLicDc")
public class VidyObrazovaniaFiziceskihLicEdit extends StandardEditor<VidyObrazovaniaFiziceskihLic> {
}