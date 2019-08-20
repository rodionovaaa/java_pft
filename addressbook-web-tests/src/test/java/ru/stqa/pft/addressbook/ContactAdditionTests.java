package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactAdditionTests extends TestBase {

  @Test
  public void testContactAdditionTests() throws Exception {
    gotoContactPage();
    fillContactForm(new ContactData("Ivan", "Ivanov", "89993345223", "ii@relex.ru"));
    submitContactAdd();
    returnToHomePage();
  }

}
