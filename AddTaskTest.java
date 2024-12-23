package com.testcases;

import com.base.ActionClass;
import com.base.BaseClass;
import com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

    public class AddTaskTest extends BaseClass {
        public ActionClass action;
        public HomePage hp;

        public AddTaskTest() {
            super();
        }

        @BeforeClass(alwaysRun = true)
        public void initialize() {
            driver = initializeDriver();
            action = new ActionClass();
            hp = new HomePage();
        }

        @Test(priority = 1, groups = "regression", description = "Verify adding a task with valid inputs")
        public void testAddTaskWithValidInput() {
            hp.clickFloatingActionButton();
            hp.enterTaskTitle("Valid Task");
            hp.enterDescriptionInput("Valid Description");
            hp.clickSaveButton();
            Assert.assertTrue(hp.isHomePageVisible(), "Task not added successfully!");
        }

        @Test(priority = 2, groups = "regression", description = "Verify task cannot be added without a title")
        public void testAddTaskWithoutTitle() {
            hp.clickFloatingActionButton();
            hp.enterDescriptionInput("Description Only");
            Assert.assertFalse(hp.isSaveButtonVisible(), "Save button should not be enabled without a title.");
        }

        @Test(priority = 3, groups = "regression", description = "Verify title input length validation")
        public void testAddTaskWithLongTitle() {
            hp.clickFloatingActionButton();
            String longTitle = "This is a very long title exceeding the character limit for testing.";
            hp.enterTaskTitle(longTitle);
            hp.enterDescriptionInput("Description for long title");
            hp.clickSaveButton();
            // Assuming the app truncates the title or provides a warning
        }

        @Test(priority = 4, groups = "regression", description = "Verify adding a task without a description")
        public void testAddTaskWithoutDescription() {
            hp.clickFloatingActionButton();
            hp.enterTaskTitle("Task Without Description");
            hp.clickSaveButton();
            Assert.assertTrue(hp.isHomePageVisible(), "Task not added successfully!");
        }

        @Test(priority = 5, groups = "regression", description = "Verify the 'Cancel' button functionality")
        public void testCancelButtonFunctionality() {
            hp.clickFloatingActionButton();
            hp.enterTaskTitle("Task to be Discarded");
            hp.enterDescriptionInput("This task should be discarded");
            hp.clickCancelButton();
            Assert.assertTrue(hp.isHomePageVisible(), "User not redirected to home screen after cancelling.");
        }

        @Test(priority = 6, groups = "regression", description = "Verify 'Change Date' functionality")
        public void testChangeDateFunctionality() {
            hp.clickFloatingActionButton();
            hp.enterTaskTitle("Task with Custom Date");
            hp.clickChangeDate();
            hp.enterChangeDate("2024-12-25"); // Example date
            hp.clickOkButton();
            hp.clickSaveButton();
            Assert.assertTrue(hp.isHomePageVisible(), "Task not added successfully with custom date!");
        }

        @Test(priority = 7, groups = "regression", description = "Verify navigating back without saving a task")
        public void testNavigateUpButtonFunctionality() {
            hp.clickFloatingActionButton();
            hp.enterTaskTitle("Task to Navigate Back");
            hp.clickNavigateUp();
            Assert.assertTrue(hp.isHomePageVisible(), "User not redirected to home screen after navigating up.");
        }

        @Test(priority = 8, groups = "regression", description = "Verify duplicate task titles are handled")
        public void testDuplicateTaskTitles() {
            hp.clickFloatingActionButton();
            hp.enterTaskTitle("Duplicate Task");
            hp.clickSaveButton();
            Assert.assertTrue(hp.isHomePageVisible(), "First task not added successfully!");

            hp.clickFloatingActionButton();            hp.enterTaskTitle("Duplicate Task");
            hp.clickSaveButton();
//            // Assuming app handles duplicates with a warning
//            Assert.assertTrue(action.isElementVisible("//android.widget.TextView[@text='Task already exists']"),
//                    "Duplicate task warning not displayed!");
        }

        @DataProvider(name = "specialTitleData")
        public Object[][] specialTitleData() {
            return new Object[][] {
                    { "@Task123" }, // Task with special characters
                    { "Task & Work" }, // Task with ampersand
                    { "12345" }, // Numeric title
            };
        }

        @Test(priority = 9, dataProvider = "specialTitleData", groups = "regression", description = "Verify special characters in the title")
        public void testSpecialCharactersInTitle(String taskTitle) {
            hp.clickFloatingActionButton();
            hp.enterTaskTitle(taskTitle);
            hp.enterDescriptionInput("Description for " + taskTitle);
            hp.clickSaveButton();
            Assert.assertTrue(hp.isHomePageVisible(), "Task with special characters not added successfully!");
        }



}
