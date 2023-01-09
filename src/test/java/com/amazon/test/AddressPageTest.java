package com.amazon.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazom.base.TestBase;
import com.amazom.pages.AccountPage;
import com.amazom.pages.AddressPage;
import com.amazom.pages.Homepage;
import com.amazom.pages.LoginPage;
import com.amazon.util.ExcelSheet;
import com.amazon.util.Utilities;

public class AddressPageTest extends TestBase {

	Utilities utilities;
	LoginPage loginpage;
	Homepage homePage;
	AddressPage addressPage;
	AccountPage accountPage;
	ArrayList<String> data;

	public AddressPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		utilities = new Utilities();
		loginpage = new LoginPage();
		loginpage.enterEmail(prop.getProperty("username"));
		homePage = loginpage.enterPassword(prop.getProperty("password"));
		homePage.moveToAccountsLink();
		accountPage = homePage.yourAccount();
		addressPage = accountPage.clickOnYourAddress1();
		addressPage.clickOnAddAddress();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	// validating error messages by passing valid and invalid data through input fields.

	@DataProvider
	public Object[][] getExcelData() {
		return ExcelSheet.getData();
	}

	@Test(dataProvider = "getExcelData")
	public void addressPage(String fullName, String phoneNum, String address, String city, String postalCode) {
		addressPage.sendkeys(fullName, phoneNum, address, city, postalCode);
		addressPage.addAddressBtn();

		if (fullName.equals("")) {
			Assert.assertTrue(addressPage.fullNameErrorText().contains("Please enter a name."));
		}
		if (phoneNum.equals("")) {
			Assert.assertTrue(addressPage.phoneNumberErrorText().contains("Please enter a phone number"));
		}
		if (address.equals("")) {
			Assert.assertTrue(addressPage.addressErrorText().contains("Please enter an address"));
		}
		if (city.equals("")) {
			Assert.assertTrue(addressPage.cityErrorText().contains("Please enter a city"));

		}
		if (postalCode.contentEquals("")) {
			Assert.assertTrue(addressPage.postalErrorText().contains("Please enter a postal code"));
		}
		//checking if the address suggestion is given to user or not
		if(address.equals("1 Whitford")) {
			Assert.assertTrue(addressPage.suggesttedAdd());
		}

	}

	// adding delivery instructions to checking if the user is able to add adding
	// delivery instructions to delivery instructions successfully
	@Test
	public void additionalDeliveryInst() {
		addressPage.sendkeys(prop.getProperty("fullname"), prop.getProperty("phone"), prop.getProperty("address"),
				prop.getProperty("city"), prop.getProperty("postal"));
		addressPage.deliveryPreference();
		addressPage.addAddressBtn();
		Assert.assertTrue(addressPage.addressSaved());
	}

//checking if user is successfully able to set address as default
	@Test(priority = 0)
	public void setDefaultAddress() {
		addressPage.sendkeys(prop.getProperty("fullname"), prop.getProperty("phone"), prop.getProperty("address"),
				prop.getProperty("city"), prop.getProperty("postal"));
		addressPage.addAddressBtn();
		Assert.assertTrue(addressPage.defaultAddConfirmation());

	}

}
