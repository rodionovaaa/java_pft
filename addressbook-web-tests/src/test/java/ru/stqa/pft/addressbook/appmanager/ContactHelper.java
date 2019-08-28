package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {
      click(By.linkText("home page"));
    }

    public void submitContactAdd() {
      click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("mobile"),contactData.getMobile());
      type(By.name("email"),contactData.getEmail());
    }

    public void selectContact() {

        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void confirmDeletion() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("Окно для подтверждения удаления контакта не появилось");
        }
    }

    public void initContactModification() {
        click(By.xpath("//img[@src='icons/pencil.png']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(ContactData contact)
    {
        click(By.linkText("add new"));
        fillContactForm(contact);
        submitContactAdd();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
   /* public List<ContactData> getContactList(){
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("td.center"));
        for (WebElement element:elements){
            String firstname =  element.getText();
            String lastname = element.getText();
            ContactData contact = new ContactData(firstname, lastname, null, null);
            contacts.add(contact);
        }
        return contacts;
    }*/
}

