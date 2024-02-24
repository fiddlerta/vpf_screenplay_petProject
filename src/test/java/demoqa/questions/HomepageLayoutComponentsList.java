package demoqa.questions;

import demoqa.user_interface.BasePage;
import demoqa.user_interface.HomePage;
import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class HomepageLayoutComponentsList implements Question<List<Target>> {

    public static Question<List<Target>> displayed() {
        return new HomepageLayoutComponentsList();
    }

    @Override public List<Target> answeredBy(Actor actor) {
        return new ArrayList<>(Arrays.asList(BasePage.HEADER, BasePage.FOOTER, HomePage.ADD_BANNER, HomePage.TOOL_CARDS));
    }
}
