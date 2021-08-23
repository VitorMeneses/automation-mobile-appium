package br.com.mybank.appium.util;

import br.com.mybank.appium.runner.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

//Class used as an aid to implement new features

public class NicoUno {


    //implementation of the class responsible for scroll the app, to help screens that have an intuitive sideways navigation, it is always necessary to put the start and end coordinates inside the String (0.1, 03).
    public void scroll (double init, double end) {
        Dimension size = DriverFactory.getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * init);
        int end_y = (int) (size.height * end);


        new TouchAction(DriverFactory.getDriver())
               .press(new PointOption().withCoordinates(x, start_y))
               .waitAction()
               .moveTo(new PointOption().withCoordinates(x, end_y))
               .release()
               .perform();

    }

    //implementation of the class responsible for swiping the app, to help screens that have an intuitive sideways navigation, it is always necessary to put the start and end coordinates inside the String (0.1, 03).
    public void swipe (double init, double end) {
        Dimension size = DriverFactory.getDriver().manage().window().getSize();

        int y = size.height / 2;


        int start_x = (int) (size.width * init);
        int end_x = (int) (size.width * end);


        new TouchAction(DriverFactory.getDriver())
                .press(new PointOption().withCoordinates(start_x, y))
                .waitAction()
                .moveTo(new PointOption().withCoordinates(end_x, y))
                .release()
                .perform();
    }

}


