package informationValidationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import informationValidation.EmailValidator;

import java.io.FileNotFoundException;

class EmailValidatorTest {
	EmailValidator emailValidator;
	
	@BeforeEach
	void setUp() throws Exception {
		emailValidator = new EmailValidator();
	}

	@Test
	void testContainsAtSymbol() {
		assertEquals(true, emailValidator.ContainsAtSymbol("test@test.com"));
	}

	@Test
	void testContainsIllegalSymbols() {
		assertEquals(true, emailValidator.ContainsIllegalSymbols("te  s t@te%$^st.c^$om"));
	}

	@Test
	void testIsDomainTLDCorrect() throws FileNotFoundException {
		assertEquals(true, emailValidator.IsDomainTLDCorrect("test@gmail.com"));
	}
}
