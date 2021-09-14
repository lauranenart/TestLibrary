public class EmailValidator {

    public boolean findAddressSign(String emailAddress) {
        return true;
    }

    public boolean hasInvalidSymbol(String emailAddress) {
        return false;
    }

    public boolean hasValidDomainName(String emailAddress) {
        return true;
    }

    public String findTLD(String emailAddress) {
        return "gmail.com";
    }

}
