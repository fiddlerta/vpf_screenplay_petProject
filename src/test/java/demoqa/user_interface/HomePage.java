package demoqa.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static Target ADD_BANNER = Target.the("add banner").locatedBy("div.home-banner img");
    public static Target TOOL_CARDS = Target.the("tool cards").locatedBy("div.category-cards div.card");
    public static Target TOOL_CARD_WITH_NAME = Target.the("{0} card").locatedBy("//div[contains(@class, 'card')]//h5[text()='{0}']");
}
