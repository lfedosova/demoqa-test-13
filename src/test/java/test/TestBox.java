package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;

public class TestBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        //url
        open("/automation-practice-form");
        //Name
        $("#firstName").setValue("Luba");
        $("#lastName").setValue("Fed");
        //email
        $("#userEmail").setValue("LF.l@mail.ru");
        //Gender
        $(byText("Female")).click();
        //Mobile
        $("#userNumber").setValue("1234567890");
        //Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--024").click();

        // Subject
        $("#subjectsInput").sendKeys("M");
        $(byText("Maths")).click();
        // Hobbies
        $(byText("Music")).click();
        // Picture
        $("#uploadPicture").uploadFromClasspath("medium.png");
        //Address
        $("#currentAddress").setValue("Rostov-on-Don");
        // State and City
        $("#react-select-3-input").sendKeys("N");
        $(byText("NCR")).click();

        $("#react-select-4-input").sendKeys("D");
        $(byText("Delhi")).click();
        // Button
        $("#submit").click();
        // Check
        $(".table-responsive").shouldHave
                (text("Luba Fed"),
                        text("LF.l@mail.ru"),
                        text("Female"),
                        text("1234567890"),
                        text("24 March,1989"),
                        text("Maths"),
                        text("Music"),
                        text("medium.png"),
                        text("Rostov-on-Don"),
                        text("NCR Delhi")
                );


    }
}

