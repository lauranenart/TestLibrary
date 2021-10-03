package informationValidation;

public class PasswordChecker {

	String specialCharacters = "!#$%&'*+-/=?^_`{|}~.";

	public Boolean IsLongEnough(String password, Integer length)
	{
		return password.length() >= length;
	}
	
	public Boolean ContainsUppercase(String password)
	{
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);

			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean ContainsSpecialChar(String password)
	{
		char[] items = specialCharacters.toCharArray();
		for(char c : password.toCharArray())
		{
			for(int i = 0; i < items.length; i++)
			{
				if(c == items[i])
				{
					return true;
				}
			}
		}
		return false;
	}
}
