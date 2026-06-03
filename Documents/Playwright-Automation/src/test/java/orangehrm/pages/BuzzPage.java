package orangehrm.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Paths;
public class BuzzPage {
    
    private Page page; 
    private String headerPostInputField = "div.orangehrm-buzz-create-post-header textarea";
    private String submitPost = "div.orangehrm-buzz-create-post-header button";
    private String sharePhotosButtonHeader = "button:has-text('Share Photos')";
    private String textbuzzpostViaShareaPhotos = "//div[@role='document']//form[@class='oxd-form']//textarea";
    private String shareVideo = "div.orangehrm-buzz-create-post-actions button:has-text(' Share Video ')";
    private String sharePhotosUploadImageField = "input.oxd-file-input";
    private String sharePhotosWithPhotosCreateBuzzButton = "//div[@role='document']//form[@class='oxd-form']//button[contains(text(),' Share ')]";
    private String addPhotos = "button:has-text(' Add Photos ')";

    public BuzzPage(Page page) { 
        this.page = page; 
    }

    public void createBasicPostThroughHeader(String postText) { 
        page.locator(headerPostInputField).fill(postText);
        page.locator(submitPost).click(); 
    }

    public void createPostWithPhotos(String context) { 
        page.locator(sharePhotosButtonHeader).click();
        
        page.locator(sharePhotosUploadImageField).setInputFiles(
            Paths.get("/Users/arsharora/Documents/Playwright-Automation/Playwright-Screenshot.png")
        );
        page.locator(textbuzzpostViaShareaPhotos).fill(context);
        // page.locator(addPhotos).click();
        // page.locator(sharePhotosUploadImageField).setInputFiles(
        //     Paths.get("/Users/arsharora/Documents/Playwright-Automation/PostCreated-ScreenShot.png")
        // );
        // page.locator(sharePhotosWithPhotosCreateBuzzButton).click();        
    }

}
