package kg.infosystems.buhproject.screen.catalogs.vidyotvetstvennyhlic;

import io.jmix.ui.screen.*;
import kg.infosystems.buhproject.entity.catalogs.VidyOtvetstvennyhLic;

@UiController("VidyOtvetstvennyhLic.edit")
@UiDescriptor("vidy-otvetstvennyh-lic-edit.xml")
@EditedEntityContainer("vidyOtvetstvennyhLicDc")
public class VidyOtvetstvennyhLicEdit extends StandardEditor<VidyOtvetstvennyhLic> {
}