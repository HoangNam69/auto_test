package test_ng.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_ng.core.BaseTest;
import test_ng.helpers.ExcelHelper;
import test_ng.pages.DashboardPage;
import test_ng.pages.LoginPage;

public class OrangeHRMTestNG extends BaseTest {

    @DataProvider(name = "OrangeLoginData")
    public Object[][] getLoginDataOrHRM() {
        String excelFilePath = "src/test/resources/LoginDataOrHRM.xlsx";
        String sheetName = "Sheet1";
        return ExcelHelper.readExcel(excelFilePath, sheetName);
    }

    @Test(dataProvider = "OrangeLoginData", description = "Kiểm tra Đăng nhập OrangeHRM với Data-Drive")
    public void testOrangeLogin(String username, String password, boolean isSuccessExpected, String expectedMessage) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.login(username, password);

        if (isSuccessExpected) {
            Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Lỗi: Không thể đăng nhập thành công với tài khoản " + username);
            System.out.println("PASS: Đăng nhập thành công với " + username);
        } else {
            String actualError = loginPage.getErrorMessage();
            Assert.assertEquals(actualError, expectedMessage, "Lỗi: Báo lỗi không chính xác cho tài khoản " + username);
            System.out.println("PASS: Báo lỗi chuẩn xác cho " + username + " - Lỗi: " + actualError);
        }
    }
}
