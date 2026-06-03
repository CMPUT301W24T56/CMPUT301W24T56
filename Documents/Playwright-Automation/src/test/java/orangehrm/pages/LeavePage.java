package orangehrm.pages;

import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import com.microsoft.playwright.Locator;

public class LeavePage {

    // Peter Mac Anderson
    private final Page page;
    private String employeeNameInputField = "input[placeholder='Type for hints...']";
    private String employeeLeaveType = "div.oxd-select-text-input";
    private String inputDateField = "input[placeholder='yyyy-dd-mm']";
    private String commentTextArea = "textarea.oxd-textarea";
    private String submitButtonLeave = "button[type='submit']";

    public LeavePage (Page page) { 
        this.page = page;
    }
    public void selectEmployeeName(String employee) { 
        page.locator(employeeNameInputField).fill(employee);
        String employeeFieldSelection = String.format("xpath=//div[@role='option']//span[contains(text(),'%s')]",employee);
        
        page.screenshot(
            new Page.ScreenshotOptions()
                .setPath(Paths.get("Playwright-Screenshot.png"))
                .setFullPage(true)
        );
        page.locator(employeeFieldSelection).click();
    }

    public void selectLeaveType(String leaveType) { 
        page.locator(employeeLeaveType).click();
        // now select the options 
        page.locator("div[role='option'] span")
        .filter(new Locator.FilterOptions().setHasText(leaveType))
        .click();
        // page.getByText("CAN - Personal").click();
    }

    public void selectLeaveDates(String fromDate, String toDate) { 
        page.locator(inputDateField).first().clear();
        page.locator(inputDateField).first().fill(fromDate);
        Locator locatorToDate =  page.locator(inputDateField).nth(1);
        locatorToDate.press("Meta+A");
        locatorToDate.press("Backspace"); // we can also use press function to send commands of system like ctr; A and backspace 
        page.locator(inputDateField).nth(1).fill(toDate);  
    }
    
    public void enterCommentsInTextArea(String comments) { 
        page.locator(commentTextArea).fill(comments);
    }

    public void submitLeave() { 
        page.locator(submitButtonLeave).click();
    }
}
