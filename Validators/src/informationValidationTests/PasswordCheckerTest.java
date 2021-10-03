package informationValidationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import informationValidation.PasswordChecker;

class PasswordCheckerTest {
	PasswordChecker passwordCheck;

	@BeforeEach
	void setUp() throws Exception {
		passwordCheck = new PasswordChecker();
	}

	@Test
	void testIsLongEnough() {
		assertEquals(true, passwordCheck.IsLongEnough("testPasswordLength", 10));
	}

	@Test
	void testContainsUppercase() {
		assertEquals(true, passwordCheck.ContainsUppercase("testPassword"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"te$stPassword", "testPassword^", "test!Password"})
	void testContainsSpecialChar(String password) {
		assertEquals(true, passwordCheck.ContainsSpecialChar(password));
	}
}
