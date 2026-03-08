package Test;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.JsonDataReader;
import com.fasterxml.jackson.databind.JsonNode;


public class LoginTest  extends BaseTest {

   @DataProvider(name = "loginData")
   public Object[][] loginData() {
       return JsonDataReader.getJsonData("testdata/Login_Data.json");
   }

    @Test(dataProvider = "loginData")
    public void LoginWithValidInformation(JsonNode data) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterEmail(data.get("email").asText());
        loginPage.enterPassword(data.get("password").asText());
        loginPage.clickSubmitButton();
        loginPage.openDropdown();
        loginPage.clickLearningMaterials();
        loginPage.clickNextOnLearningMaterials();
        loginPage.selectDeviceType("Phone");
        loginPage.selectBrand("Apple");
        loginPage.chooseStorage();
        loginPage.selectColor("Blue");
        loginPage.enterQuantity("2");
        loginPage.enterAddress("Oak Avenue Ferndale");
        loginPage.clickNextInventory();
        loginPage.chooseShippingExpress();
        loginPage.chooseWarranty();
        loginPage.applyDiscount("SAVE10");
        loginPage.purchaseDevice();
        loginPage.viewHistory();
        loginPage.clickFirstInvoice();
    }
}
