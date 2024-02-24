package demoqa.stepdefinitions;

import demoqa.navigation.NavigateTo;
import demoqa.questions.HomepageLayoutComponentsList;
import demoqa.user_interface.BasePage;
import demoqa.user_interface.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;

public class HomepageStepDefinitions {

    @Given("{actor} opens a homepage")
    public void openHomepage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theDemoQaHomePage());
    }

    @Then("{actor} should see a homepage layout")
    public void should_see_homepage_layout(Actor actor) {
        /** Without leveraging custom question
         actor.should(
         eventually(seeThat(Displayed.of(HomePage.ADD_BANNER))),
         eventually(seeThat(Displayed.of(HomePage.TOOL_CARDS))),
         eventually(seeThat(Displayed.of(BasePage.HEADER))),
         eventually(seeThat(Displayed.of(BasePage.FOOTER))));
         */
        actor.should(seeThat(HomepageLayoutComponentsList.displayed(),
                layoutComponents -> layoutComponents.stream().allMatch(component -> component.isVisibleFor(actor))));
    }

    @When("{actor} clicks on add banner")
    public void clicksOnAddBanner(Actor actor) {
        actor.attemptsTo(new ClickOnTarget(HomePage.ADD_BANNER).afterWaitingUntilPresent());
    }

    @Then("{actor} lands on a page with title in a new tab")
    public void landsOnPageInNewTab(Actor actor, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        for (Map<String, String> pageInfo : data) {
            actor.attemptsTo(
                    Switch.toTheOtherWindow(),
                    Ensure.that(TheWebPage.currentUrl()).containsIgnoringCase(pageInfo.get("pageUrl")),
                    Ensure.that(TheWebPage.title()).containsIgnoringCase(pageInfo.get("pageTitle"))
            );
        }
    }

    @When("{actor} clicks on {string} widget card")
    public void clicksOnWidgetCard(Actor actor, String cardName) {
        actor.attemptsTo(
                Scroll.to(HomePage.TOOL_CARDS).andAlignToBottom(),
                Click.on(HomePage.TOOL_CARD_WITH_NAME.of(cardName)).afterWaitingUntilPresent());
    }

    @Then("{actor} lands on {string} page")
    public void landsOnPage(Actor actor, String pagePath) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.currentUrl()).endsWith(pagePath)
        );
    }

    @And("{actor} clicks on header")
    public void clicksOnHeader(Actor actor) {
        actor.attemptsTo(Click.on(BasePage.HEADER).afterWaitingUntilPresent());
    }

    @Then("{actor} is on homepage")
    public void isOnHomepage(Actor actor) {
        String pageTitle = actor.asksFor(TheWebPage.title());
        assertThat(pageTitle).isEqualToIgnoringCase("demoqa");
    }
}
