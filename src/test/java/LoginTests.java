import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class LoginTests extends TestBase {

    @Test
    public void successfulAuthorization() {
        open("/login.html");

        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("password1");
        $("[data-testid=submit-button]").click();
        $("[data-testid=welcome-message]").shouldHave(text("Welcome, user1!"));
    }

    @Test
//    @Disabled("Login by Press Enter is not implemented yet")
    public void successfulAuthorizationWithPressEnter() {
        open("/login.html");

        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("password1").pressEnter();
        $("[data-testid=welcome-message]").shouldHave(text("Welcome, user1!"));
    }

    @Test
    public void wrongPasswordAuthorizationTest() {
        open("/login.html");

        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("wrong password");
        $("[data-testid=submit-button]").click();
        $("[data-testid=error-message]").shouldHave(text("Wrong login or password"));
    }

    @Test
    public void shortPasswordAuthorizationTest() {
    open("/login.html");

    $("[data-testid=login-input]").setValue("user1");
    $("[data-testid=password-input]").setValue("12");
    $("[data-testid=submit-button]").click();
    $("[data-testid=error-message]").shouldHave(text("Password must be at least 6 characters"));
}

    @Test
    public void emptyPasswordAuthorizationTest() {
        open("/login.html");

        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("");
        $("[data-testid=submit-button]").click();
        $("[data-testid=error-message]").shouldHave(text("Password is required (minimum 6 characters)"));
    }

    @Test
    public void emptyLoginAuthorizationTest() {
        open("/login.html");

        $("[data-testid=login-input]").setValue("");
        $("[data-testid=password-input]").setValue("password1");
        $("[data-testid=submit-button]").click();
        $("[data-testid=error-message]").shouldHave(text("Login is required (minimum 3 characters)"));
    }

    @Test
    public void emptyLoginAndPasswordAuthorizationTest() {
        open("/login.html");

        $("[data-testid=login-input]").setValue("");
        $("[data-testid=password-input]").setValue("");
        $("[data-testid=submit-button]").click();
        $("[data-testid=error-message]").shouldHave(text("Login and password are required (minimum 3 and 6 characters)"));
    }

    @Test
    public void wrongLoginAndPasswordAuthorizationTest() {
        open("/login.html");

        $("[data-testid=login-input]").setValue("User67");
        $("[data-testid=password-input]").setValue("234567");
        $("[data-testid=submit-button]").click();
        $("[data-testid=error-message]").shouldHave(text("Wrong login or password"));
    }

}


