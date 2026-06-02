package orangehrm.pages;

import com.microsoft.playwright.Page;

public class BuzzPage {
    
    private Page page; 
    private String headerPostInputField = "div.orangehrm-buzz-create-post-header textarea";
    private String submitPost = "div.orangehrm-buzz-create-post-header button";
    private String sharePhotosButtonHeader = "button:has-text('Share Photos')";

    public BuzzPage(Page page) { 
        this.page = page; 
    }

    public void createBasicPostThroughHeader(String postText) { 
        page.locator(headerPostInputField).fill(postText);
        page.locator(submitPost).click(); 
    }

    public void createPostWithPhotos() { 
        page.locator(sharePhotosButtonHeader).click();
    }

    
}
