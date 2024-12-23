package com.testcases;

import com.base.ActionClass;
import com.base.BaseClass;
import com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    public ActionClass action;
    public HomePage hp;
//    boolean found = false;
    public HomePageTest() {
        super();
    }

    @BeforeClass(alwaysRun = true)
    public void initialize() {
        driver = initializeDriver();
        action = new ActionClass();
        hp = new HomePage();
    }

    @Test(priority = 1, groups = "regression", dataProvider = "data", description = "Testcase for verifying the home page")
    public void verifyHomePage( String taskTitle, String description) throws InterruptedException {
        hp.isHomePageVisible();
        hp.isFloatingActionButtonVisible();
        hp.clickFloatingActionButton();
        hp.isAddTitleVisible();
        hp.isTaskTitleInputFieldVisible();
        hp.clickTaskTitleInputField();
        hp.enterTaskTitle(taskTitle);
        hp.isChangeDateVisible();
//        hp.clickChangeDate();
//        hp.enterChangeDate();
        hp.isDescriptionInputVisible();
        hp.enterDescriptionInput(description);
        hp.isSaveButtonVisible();
        hp.clickSaveButton();

    }
    @DataProvider(name = "data")
    public Object[][] taskTitle() {
        return new Object[][] {
                {  "Hackathon", "This is the description" }
        };
    }
}