package demoqa.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class BasePage {

    public static Target HEADER = Target.the("header").locatedBy("header img");
    public static Target FOOTER = Target.the("footer").locatedBy("footer span");


}
