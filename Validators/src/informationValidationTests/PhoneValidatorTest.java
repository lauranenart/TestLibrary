package informationValidationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import informationValidation.PhoneValidator;

class PhoneValidatorTest {
	PhoneValidator phoneValidator;
	
	@BeforeEach
	void setUp() throws Exception {
		phoneValidator = new PhoneValidator();
	}

	@Test
	void testContainsOnlyNumbers() {
		assertEquals(true, phoneValidator.ContainsOnlyNumbers("4864158427287"));
	}

	@Test
	void testReplaceBegining() {
		assertEquals("+370648427", phoneValidator.ReplaceBegining("8648427", '8', "+370"));
	}

	@Test
	void testIsLengthCorrect() {
		assertEquals(true, phoneValidator.IsLengthCorrect("862425048", 9));
	}
}
