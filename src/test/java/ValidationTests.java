import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTests {
    PasswordChecker passwordChecker;
    PhoneValidator phoneValidator;
    EmailValidator emailValidator;

    @Before
    public void setUp() {
        passwordChecker = new PasswordChecker();
        phoneValidator = new PhoneValidator();
        emailValidator = new EmailValidator();
    }

    //PasswordChecker

    @Test
    public void TestPasswordLength() {
        assertTrue(passwordChecker.minimumLength(8, "slaptazodis"));
    }

    @Test
    public void TestPasswordHasUppercase() {
        assertTrue(passwordChecker.hasUppercase("Slaptazodis"));
    }

    @Test
    public void TestPasswordHasSymbol() {
        assertTrue(passwordChecker.hasSpecialSymbol("slaptazodis*"));
    }

    //PhoneValidator

    @Test
    public void TestPhoneContainsOnlyNumbers() {
        assertTrue(phoneValidator.hasOnlyDigits("869055890"));
    }

    @Test
    public void TestPhoneCorrectPrefix() {
        assertEquals(Long.parseLong("+37069055890"), phoneValidator.changeByPrefix("869055890"));
    }

    @Test
    public void TestPhoneHasCountry() {
        assertEquals("Lithuania", phoneValidator.findCountry("869055890"));
    }

    @Test
    public void TestPhoneCorrectLength() {
        assertTrue(phoneValidator.correctLength("+37069055890"));
    }

    //EmailValidator

    @Test
    public void TestEmailHasAddressSign() {
        assertTrue(emailValidator.findAddressSign("testavimas@gmail.com"));
    }

    @Test
    public void TestEmailOnlyValidSymbols() {
        assertFalse(emailValidator.hasInvalidSymbol("testavimas@gmail.com"));
    }

    @Test
    public void TestEmailDomainName() {
        assertTrue(emailValidator.hasValidDomainName("testavimas@gmail.com"));
    }

    @Test
    public void TestEmailTLD() {
        assertEquals("gmail.com", emailValidator.findTLD("testavimas@gmail.com"));
    }

    @AfterEach
    void tearDown() {
    }
}
