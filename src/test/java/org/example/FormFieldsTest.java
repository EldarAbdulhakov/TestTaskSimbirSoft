package org.example;

import org.example.page.MainPage;
import org.example.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormFieldsTest extends BaseTest {

    private static final String NAME = "Eldar";
    private static final String PASSWORD = "Ddfgdg53!";
    private static final String EMAIL = "braid2010@gmail.com";
    private static final String EXPECTED_ALERT_TEXT = "Message received!";

    @Test
    public void testFormFields() {
        String alertText = new MainPage(getDriver())
                .inputName(NAME)
                .inputPassword(PASSWORD)
                .chooseMilk()
                .chooseCoffee()
                .chooseYellow()
                .selectOne()
                .inputEmail(EMAIL)
                .inputInstrumentCount()
                .clickSubmit()
                .getAlertText();

        Assert.assertEquals(alertText, EXPECTED_ALERT_TEXT);

    }
}
