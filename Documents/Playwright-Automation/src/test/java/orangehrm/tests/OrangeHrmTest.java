package orangehrm.tests;
import orangehrm.base.BaseTestClass;
import orangehrm.pages.BuzzPage;
import orangehrm.pages.DashboardPage;
import orangehrm.pages.LoginPage;
import orangehrm.pages.SideBarPage;
import orangehrm.pages.LeavePage;
import org.junit.jupiter.api.*;

public class OrangeHrmTest extends BaseTestClass {

    // @Test
    // void ApplyForLeave() {
    //     DashboardPage dashboardPage = new DashboardPage(page);
    //     dashboardPage.clickOnButton("Assign Leave");
    //     LeavePage leavePage = new LeavePage(page);
    //     leavePage.selectEmployeeName("Peter Mac Anderson");
    //     leavePage.selectLeaveType("CAN - Personal");
    //     leavePage.selectLeaveDates("2022-15-06", "2022-18-06");
    //     leavePage.submitLeave();
    // }

    // @Test
    // void createBuzzPost() { 
    //     SideBarPage sideBarPage = new SideBarPage(page);
    //     sideBarPage.clickOnSideBarOption("Buzz");
    //     BuzzPage buzzPage  = new BuzzPage(page);
    //     buzzPage.createBasicPostThroughHeader("this is a basic test page");
    // }

    // @Test
    // void createPostWithPhotos() { 
    //   SideBarPage sideBarPage = new SideBarPage(page);
    //     sideBarPage.clickOnSideBarOption("Buzz");
    //     BuzzPage buzzPage  = new BuzzPage(page);
    //     buzzPage.createPostWithPhotos("this is test buzz with picture");
    //     takeScreenshot("photouploadedproof.png");
    // }

    // @Test
    // void likeFirstPost() { 
    //     SideBarPage sideBarPage = new SideBarPage(page);
    //     sideBarPage.clickOnSideBarOption("Buzz");
    //     BuzzPage buzzPage  = new BuzzPage(page);
    //     buzzPage.likeNthPost(1);
    // }

    // @Test 
    // void commentNthPost() { 
    //     SideBarPage sideBarPage = new SideBarPage(page);
    //     sideBarPage.clickOnSideBarOption("Buzz");
    //     BuzzPage buzzPage  = new BuzzPage(page);
    //     buzzPage.commentNthPost(1,"this is a test comment for post");
    // }

    // @Test
    // void deletePost() { 
    //     SideBarPage sideBarPage = new SideBarPage(page);
    //     sideBarPage.clickOnSideBarOption("Buzz");
    //     BuzzPage buzzPage  = new BuzzPage(page);
    //     buzzPage.deleteNthPost(1);
    // }

    @Test
    void deletePostCancelButton() {
        SideBarPage sideBarPage = new SideBarPage(page);
        sideBarPage.clickOnSideBarOption("Buzz");
        BuzzPage buzzPage  = new BuzzPage(page);
        buzzPage.deleteNthPostCancel(1);
    }

}
