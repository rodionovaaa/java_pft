package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {
      click(By.linkText("home page"));
    }

    public void submitContactAdd() {
      click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("mobile"),contactData.getMobile());
      type(By.name("email"),contactData.getEmail());
    }
}
