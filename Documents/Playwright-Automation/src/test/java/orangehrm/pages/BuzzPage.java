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
    private String post = ".oxd-grid-item.oxd-grid-item--gutters";
    private String footerActionsPost = ".orangehrm-buzz-post-actions";
    private String likeHeartSVGId = "svg#heart-svg";
    private String commentIcon = "i.bi-chat-text-fill";
    private String commentTextArea = "xpath=//input[@placeholder='Write your comment...']";
    private String threeDotsButton = "xpath=//div[@class='orangehrm-buzz-post-header-config']//button";
    private String threeDotButtonDropDownMenuEditPost = "//ul[contains(@class,'oxd-dropdown-menu')]//p[normalize-space()='Edit Post']";
    private String threeDotButtonDropDownMenuDeletePost = "//ul[contains(@class,'oxd-dropdown-menu')]//p[normalize-space()='Delete Post']";
    private String editPosttextArea = "div.orangehrm-buzz-post-modal-header-text textarea";
    private String editPostSubmitButton = "div.orangehrm-buzz-post-modal-actions button";
    private String deletePostYesOptionAlert = "button:has-text('Yes, Delete')";
    
    public BuzzPage(Page page) { 
        this.page = page; 
    }

    public void createBasicPostThroughHeader(String postText) { 
        page.locator(headerPostInputField).fill(postText);
        page.locator(submitPost).click(); 
    }

    public void createPostWithPhotos(String context) { 
        page.locator(sharePhotosButtonHeader).click();
        
        // page.locator(sharePhotosUploadImageField).setInputFiles(
        //     Paths.get("/Users/arsharora/Documents/Playwright-Automation/Playwright-Screenshot.png")
        // );
        // page.locator(addPhotos).click();
        // page.locator(sharePhotosUploadImageField).setInputFiles(
        //     Paths.get("/Users/arsharora/Documents/Playwright-Automation/PostCreated-ScreenShot.png")
        // );
        page.locator(sharePhotosWithPhotosCreateBuzzButton).click();        
    }

    public void likeNthPost(int postNumber) { 
        Locator nthPost = page.locator(post).nth(postNumber);
        Locator likeButton = nthPost
        .locator(footerActionsPost)
        .locator(likeHeartSVGId)
        .first();
        likeButton.click();
    }

    public void commentNthPost(int postNumber,String commentText) { 
        Locator nthPost = page.locator(post).nth(postNumber);
        
        Locator comment = nthPost
        .locator(footerActionsPost)
        .locator(commentIcon)
        .first();

        comment.click();

        // enter text in text area and hit enter 
        Locator commenttextArea = page.locator(commentTextArea);
        commenttextArea.fill(commentText);
        commenttextArea.press("Enter");
    }

    public void deleteNthPost(int postNumber) { 
        page.locator(threeDotsButton).nth(postNumber).click();
        page.locator(threeDotButtonDropDownMenuDeletePost).click();
        // delete the post 
        Locator confirmDeleteButton = page.locator(deletePostYesOptionAlert);
        confirmDeleteButton.waitFor();
        confirmDeleteButton.click();
    }
}

