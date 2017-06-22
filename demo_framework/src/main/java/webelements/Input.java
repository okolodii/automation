package webelements;

import org.openqa.selenium.WebElement;

public class Input {
    private WebElement element;
    public Input(WebElement element) {
        this.element = element;
    }

    /* Wrapper allows us to gather all the common functions performed with the specific type of WebElement */
    public void typeText(String text){
        this.element.click();
        this.element.clear();
        this.element.sendKeys(text);
    }
}
