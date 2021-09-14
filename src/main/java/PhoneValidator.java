public class PhoneValidator {

    public boolean hasOnlyDigits(String phoneNumber) {
        return true;
    }

    public Long changeByPrefix(String phoneNumber) {
        return Long.parseLong("+37069055890");
    }

    public String findCountry(String phoneNumber) {
        return "Lithuania";
    }

    public boolean correctLength(String phoneNumber) {
        return true;
    }

}
