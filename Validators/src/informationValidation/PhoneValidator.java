package informationValidation;

public class PhoneValidator {

	String digits = "0123456789";

	public Boolean ContainsOnlyNumbers(String number)
	{
		int notANumber = 0;
		for(char c : number.toCharArray())
		{
				if(!charIsItemFromList(c, digits.toCharArray()))
				{
					notANumber++;
				}
		}
		if(notANumber != 0 )
		{
			return false;
		}
		return true;
	}
	
	public String ReplaceBegining(String number, char before, String after)
	{
		if(number.charAt(0) == before){
			number = number.substring(1);
			return after + number;
		}
		else {
			return number;
		}
	}
	
	public Boolean IsLengthCorrect(String number, Integer Length)
	{
		return number.length() == Length;
	}

	private static boolean charIsItemFromList(char c, char[] items)
	{
		for(int i = 0; i < items.length; i++)
		{
			if(c == items[i])
			{
				return true;
			}
		}
		return false;
	}
}
