package com.amazom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazom.base.TestBase;

public class AddressPage extends TestBase {

	@FindBy(id = "ya-myab-plus-address-icon")
	WebElement addAddressIcon;

	@FindBy(xpath = "(//span[@class='a-dropdown-prompt'])[1]")
	WebElement countryDropdown;

	@FindBy(css = "[name='address-ui-widgets-enterAddressFullName']")
	WebElement fullName;

	@FindBy(css = "[name='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement phoneNumber;

	@FindBy(id = "address-ui-widgets-enterAddressLine1")
	WebElement addressLine;

	@FindBy(id = "address-ui-widgets-enterAddressCity")
	WebElement city;

	@FindBy(xpath = "//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@class='a-button-text a-declarative' and @role='button']")
	WebElement province;

	@FindBy(css = "#address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")
	WebElement ontarioSelect;

	@FindBy(id = "address-ui-widgets-enterAddressPostalCode")
	WebElement postalCode;

	@FindBy(id = "address-ui-widgets-use-as-my-default")
	WebElement checkbox;

	@FindBy(xpath = "//span[@class='a-expander-prompt']")
	WebElement addDeliveryPreference;

	@FindBy(css = "[aria-label='Other']")
	WebElement otherBuilding;

	@FindBy(css = ".a-button-input")
	WebElement addAddressButton;

	@FindBy(xpath = "//div[contains(text(),' a name.')]")
	WebElement fullNameError;

	@FindBy(xpath = "//div[text()='Please enter a phone number so we can call if there are any issues with delivery.']")
	WebElement phoneNumberError;

	@FindBy(xpath = "//div[contains(text(),' an address.')]")
	WebElement addressError;

	@FindBy(xpath = "(//div[contains(text(),' a city name')])[2]")
	WebElement cityError;

	@FindBy(xpath = "(//div[contains(text(),'enter a postal code.')])")
	WebElement postalError;

	@FindBy(xpath = "(//div[@class='a-section address-section-no-default'])[2]")
	WebElement confirmAddress;
	
	@FindBy(css=".a-section a-spacing-none default-section")
		WebElement defaultAddConfirmation;
	
	@FindBy(xpath="//h4[text()='Address saved']")
	WebElement addressSaved;

	@FindBy(css="label[for=address-ui-widgets-suggested-address-block_id-input]")
	WebElement suggesttedAddress;
	public AddressPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnAddAddress() {
		addAddressIcon.click();
	}

	public void sendkeys(String fullnme, String phnNumber, String address, String cityname, String postalcode) {
		fullName.clear();
		fullName.sendKeys(fullnme);
		phoneNumber.clear();
		phoneNumber.sendKeys(phnNumber);
		addressLine.clear();
		addressLine.sendKeys(address);
		city.clear();
		city.sendKeys(cityname);
		province.click();
		ontarioSelect.click();
		postalCode.clear();
		postalCode.sendKeys(postalcode);

	}

	public void selectDefaultAdd() {
		checkbox.click();
	}
	
	public boolean defaultAddConfirmation() {
		return defaultAddConfirmation.isDisplayed();
	}

	public void deliveryPreference() {
		addDeliveryPreference.click();
		otherBuilding.click();
	}

	public void addAddressBtn() {
		addAddressButton.click();
	}

	public String fullNameErrorText() {
		return fullNameError.getText();
	}

	public String phoneNumberErrorText() {
		return phoneNumberError.getText();
	}

	public String addressErrorText() {
		return addressError.getText();
	}

	public String cityErrorText() {
		return cityError.getText();
	}

	public String postalErrorText() {
		return postalError.getText();
	}

	public String confirmAddressText() {
		return confirmAddress.getText();
	}
	public boolean addressSaved() {
		return addressSaved.isDisplayed();
	}
	public boolean suggesttedAdd() {
		return suggesttedAddress.isDisplayed();
	}

}
