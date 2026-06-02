package orangehrm.pages;
import com.microsoft.playwright.Page;

public class SideBarPage {
    private final Page page;

    public SideBarPage(Page page) { 
        this.page = page;
    }

    public void clickOnSideBarOption(String option) { 
        String navBarOption = String.format("//nav[@aria-label='Sidepanel']//a//span[text()='%s']",option);
        page.locator(navBarOption).click();
    }
    
}
