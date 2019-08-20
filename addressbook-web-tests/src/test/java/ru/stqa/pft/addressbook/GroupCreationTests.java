package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreationTests() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
