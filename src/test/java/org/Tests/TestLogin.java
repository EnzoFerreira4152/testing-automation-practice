package org.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aventstack.extentreports.Status;
import org.Base.BaseTest;
import org.junit.jupiter.api.Test;
import org.Pages.PageLogin;
import org.testng.annotations.BeforeClass;

class TestLogin extends BaseTest {

	@Test
	void successfulLogin() throws InterruptedException {
		PageLogin pl = new PageLogin(driver);
		test = report.createTest("Successful Login");
		test.log(Status.INFO, "Test start");

		pl.loginAs("prueba6@prueba.com", "pass123");

		assertEquals("jose gomez", pl.nameLogin());
		test.log(Status.PASS, "Validate Username");

		assertEquals("Buscá ofertas en casas, departamentos y mucho más\n¿A dónde vamos?\nBuscar", pl.mainMessage());
		test.log(Status.PASS, "Validate main text");
	}

	@Test
	void successfulLogin_2() throws InterruptedException {
		PageLogin pl = new PageLogin(driver);
		test = report.createTest("Successful Login 2");
		test.log(Status.INFO, "Test start");

		pl.loginAs("space13@prueba.com", "pass1234");

		assertEquals("Sergio1 Prueba1", pl.nameLogin());
		test.log(Status.PASS, "Validate Username");

		assertEquals("Buscá ofertas en casas, departamentos y mucho más\n¿A dónde vamos?\nBuscar", pl.mainMessage());
		test.log(Status.PASS, "Validate main text");
	}

	@Test
	void failedLoginWrongEmail() throws InterruptedException {
		PageLogin pl = new PageLogin(driver);
		test = report.createTest("Failed Login, Wrong Email");
		test.log(Status.INFO, "Test start");

		pl.loginAs("space86@prueba.com", "pass1234");

		assertEquals("Sus credenciales son inválidas. Por favor, vuelva a intentarlo", pl.result());
		test.log(Status.PASS, "Wrong email result text");
	}

	@Test
	void failedLoginWrongPassword() throws InterruptedException {
		PageLogin pl = new PageLogin(driver);
		test = report.createTest("Failed Login, Wrong password");
		test.log(Status.INFO, "Test Start");

		pl.loginAs("space14@prueba.com", "pass12343454");

		assertEquals("Sus credenciales son inválidas. Por favor, vuelva a intentarlo", pl.result());
		test.log(Status.PASS, "Wrong pass result text");
	}

}