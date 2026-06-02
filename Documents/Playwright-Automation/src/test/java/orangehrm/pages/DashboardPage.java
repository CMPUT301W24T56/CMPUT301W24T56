package orangehrm.pages;

import com.microsoft.playwright.Page;
public class DashboardPage {

    private final Page page;

    public DashboardPage(Page page) { 
        this.page = page;
    }

    public void clickOnButton(String option) { 
        String assignLeave = String.format("xpath=//button[contains(@title,'%s')]",option);
        page.locator(assignLeave).click();
    }
}
