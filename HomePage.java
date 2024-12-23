package com.pages;

import com.base.ActionClass;
import com.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

        public ActionClass action = new ActionClass();

        public HomePage() {
            PageFactory.initElements(driver, this);
        }

        // Landing on Homepage/ Home tab
        @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.peterdpong.checked:id/title\"]")
        WebElement homePageEle;
        public boolean isHomePageVisible() {
            return action.isElementVisiblePageLoad(homePageEle);
        }

        @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
        WebElement navigateUpEle;
        public boolean isNavigateUpVisible() {
            return action.isElementVisible(navigateUpEle);
        }
        public void clickNavigateUp() {
            action.clickElement(navigateUpEle);
        }

        @FindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.peterdpong.checked:id/floating_action_button\"]")
        WebElement floatingActionButtonEle;
        public boolean isFloatingActionButtonVisible() {
            return action.isElementVisible(floatingActionButtonEle);
        }
        public void clickFloatingActionButton() {
            action.clickElement(floatingActionButtonEle);
        }

        @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.peterdpong.checked:id/addtitle\"]")
        WebElement addTitleEle;
        public boolean isAddTitleVisible() {
            return action.isElementVisible(addTitleEle);
        }

        @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.peterdpong.checked:id/titleTextField\"]/android.widget.FrameLayout")
        WebElement TaskTitleInputFieldEle;
        public boolean isTaskTitleInputFieldVisible() {
            return action.isElementVisible(TaskTitleInputFieldEle);
        }
        public void clickTaskTitleInputField() {
            action.clickElement(TaskTitleInputFieldEle);
        }
        public void enterTaskTitle(String taskTitle) {
             action.enterValue(TaskTitleInputFieldEle, taskTitle);
        }

        @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.peterdpong.checked:id/changedate\"]")
        WebElement changeDateEle;

        public boolean isChangeDateVisible() {
            return action.isElementVisible(changeDateEle);
        }

        public void clickChangeDate() {
            action.clickElement(changeDateEle);
        }

        public void enterChangeDate(String changeDate) {
            action.enterValue(changeDateEle, changeDate);
        }

        @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
        WebElement okButtonEle;
        public boolean isOkButtonVisible() {
            return action.isElementVisible(okButtonEle);
        }
        public void clickOkButton() {
            action.clickElement(okButtonEle);
        }

        @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
        WebElement cancelPopupBtnEle;
        public boolean isCancelPopupBtnVisible() {
            return action.isElementVisible(cancelPopupBtnEle);
        }
        public void clickCancelPopupBtnButton() {
            action.clickElement(cancelPopupBtnEle);
        }

        @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.peterdpong.checked:id/description\"]")
        WebElement descriptionInputEle;

        public boolean isDescriptionInputVisible() {
            return action.isElementVisible(descriptionInputEle);
        }
        public void clickDescriptionInput() {
            action.clickElement(descriptionInputEle);
        }
        public void enterDescriptionInput(String descriptionInput) {
            action.enterValue(descriptionInputEle, descriptionInput);
        }


        @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.peterdpong.checked:id/savebtn\"]")
        WebElement saveButtonEle;
        public boolean isSaveButtonVisible() {
            return action.isElementVisible(saveButtonEle);
        }
        public void clickSaveButton() {
            action.clickElement(saveButtonEle);
        }

        @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.peterdpong.checked:id/cancelbtn\"]")
        WebElement cancelBtnEle;
        public boolean isCancelButtonVisible() {
            return action.isElementVisible(cancelBtnEle);
        }
        public void clickCancelButton() {
            action.clickElement(cancelBtnEle);
        }


    }

