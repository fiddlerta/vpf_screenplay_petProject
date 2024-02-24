package demoqa.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theDemoQaHomePage() {
        return Task.where("{0} opens the DemoQA home page",
                Open.browserOn().the(DemoQaHomePage.class));
    }

}
