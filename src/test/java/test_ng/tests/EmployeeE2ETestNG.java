package test_ng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test_ng.core.BaseTest;
import test_ng.pages.DashboardPage;
import test_ng.pages.LoginPage;
import test_ng.pages.pim.AddEmployeePage;
import test_ng.pages.pim.PimPage;

public class EmployeeE2ETestNG extends BaseTest {

    @Test(description = "Work flow: login -> add new employee -> check new employee")
    public void testAddAndSearchEmployee() throws InterruptedException {
        String firstName = "Le";
        String lastName = "Ted";

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        PimPage pimPage = new PimPage(driver);
        AddEmployeePage addEmployeePage = new AddEmployeePage(driver);

//        Login
        loginPage.login("Admin", "admin123");
//      Check login successfully
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Lỗi: không vào được dashboard");
//      Click open Pim page
        dashboardPage.clickPIMElement();
//      Click open Add employee
        pimPage.clickAddEmployee();
        addEmployeePage.enterEmployeeName(firstName, lastName);

        String employeeId = addEmployeePage.getGeneratedEmployeeId();
        System.out.println("Employee Id: " + employeeId);
//        Save new Employee
        addEmployeePage.clickButtonSave();
//      Check add successfully
        Assert.assertTrue(addEmployeePage.waitForSaveSuccess(), "Lỗi: Thêm không thành công");

//       Click open Pim page - employee list
        pimPage.clickTobackEmployeeList();

//        Search employee by EmployeeId
        pimPage.searchByEmployeeId(employeeId);

        String actualNameInGrid = pimPage.getFirstResultName();
        System.out.println("Tên hiển thị trên bảng: " + actualNameInGrid);

        // Verify: Tên tìm thấy phải khớp với tên ban đầu nhập vào
        Assert.assertTrue(actualNameInGrid.contains(firstName),
                "FAIL: Tên trên bảng không khớp với nhân viên vừa tạo!");
    }

}
