package org.Tests;

import org.Base.BaseTest;
import org.Pages.RegisterPage;
import org.junit.jupiter.api.Test;

class TestRegister extends BaseTest {

	@Test
	void Register() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.registerUser();
	}
}