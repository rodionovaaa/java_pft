package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePassword extends TestBase{
    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void passwordChange() throws IOException {
        User user = app.change().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1,10000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        String password = "12345";
        app.change().changePassword(confirmationLink, password);
        assertTrue(app.newSession().login(user.getUsername(), password));
    }
    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
