package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage{
    public DroppablePage(WebDriver driver) {
        super(driver);
    }
@FindBy(id="draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;
    public DroppablePage actionDragMe() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();
        String text = dropHere.getText();
        if(text.equals("Dropped")){
            System.out.println("PASS!");
        }else {
            System.out.println("FAIL!");
        }
        return this;
    }

    public DroppablePage actionDragMeBy() {
        Actions actions = new Actions(driver);
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset2 = dragMe.getLocation().getY();
        System.out.println("xOffset1-->"+xOffset1+"xOffset2"+yOffset2);
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOfsset-->"+xOffset+"yOffset"+yOffset);

        xOffset=(xOffset-xOffset1)+20;
        yOffset=(yOffset-yOffset2)+30;
        actions.dragAndDropBy(dragMe,xOffset,yOffset).perform();

        String text = dropHere.getText();
        if(text.equals("Dropped!")){
            System.out.println("PASS!");
        }else{
            System.out.println("FAIL!");
        }

        return this;
    }
}
