
package orangehrm.pages;

import com.microsoft.playwright.Page;
public class LoginPage {
    private static String loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final Page page;


    private String usernameInputField = "input[name='username']";
    private String passwordInputField = "input[name='password']";
    private String LoginSubmitButton = "button:has-text('Login')";

    // xpath version - private String loginSubmitButton = "xpath=//button[contains(text(), 'Login')]"
    
    public LoginPage(Page page) { 
        this.page = page;
    }

    public void openLoginPage() { 
        page.navigate(loginUrl);
    }

    public void enterUserName(String userName) { 
        page.locator(usernameInputField).fill(userName);
    }

    public void enterPassword(String password) { 
        page.locator(passwordInputField).fill(password);
    }

    public void clickOnSubmit() { 
        page.locator(LoginSubmitButton).click();
    }

}

