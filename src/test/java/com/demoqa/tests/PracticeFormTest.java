package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase{


    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }


    @Test
    public void createStudentAccountTest(){
        new PracticeFormPage(driver).hidelframes();
        new PracticeFormPage(driver)
                .enterPersonalData("Vasiliy","Usenko","usenko18@gmail.com","0987654321")
        .selectGender("Male")
                .enterBirthDay("25 April 1984")
                .enterSubjects(new String[]{"Maths","Chemistry"})
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:/QA/22-518x560.jpg")
                .selestState("NCR")
                .selectCity("Delhi")
                .clickOnSubmit()
                .verifySuccessTitle("Thanks for submitting the form");
;
    }
}
