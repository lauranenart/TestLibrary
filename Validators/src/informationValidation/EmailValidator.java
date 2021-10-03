package informationValidation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailValidator{

	LocalPartValidator localPartValidator = new LocalPartValidator();
	DomainPartValidator domainPartValidator = new DomainPartValidator();

	public Boolean ContainsAtSymbol(String email)
	{
		return calculateAtRecurrence(email);
	}
	
	public Boolean ContainsIllegalSymbols(String email)
	{
		if(validateLocalPart(email) && validateDomainPart(email))
		{
			return false;
		}
		return true;
	}
	
	public Boolean IsDomainTLDCorrect(String email) throws FileNotFoundException {
		boolean found = false;
		String[] arr = readTldTxt();

		int index = email.indexOf('@');
		String domainPart = email.substring(index + 1);
		String tld = findTLD(domainPart);

		for(int i = 0; i < arr.length; i++)
		{
			String s = arr[i].toLowerCase();
			if(tld.equals(s))
			{
				found = true;
			}
		}
		if(found && validateDomainPart(email))
		{
			return true;
		}
		return false;
	}

	private String[] readTldTxt() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/informationValidation/TLD.txt"));
		List<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}

		String[] arr = lines.toArray(new String[0]);
		return arr;
	}

	private String findTLD(String s)
	{
		String tld = "";
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == '.')
			{
				tld = s.substring(i + 1);
			}
		}
		return tld;
	}

	private boolean calculateAtRecurrence(String email)
	{
		int number = 0;
		for(char c : email.toCharArray())
		{
			if(c == '@')
				number++;
		}
		return  number == 1 ? true : false;
	}

	private boolean validateLocalPart(String email)
	{
		int index = email.indexOf('@');
		String localPart = email.substring(0, index);
		if(localPart.length() == localPartValidator.validate(localPart))
		{
			return true;
		}
		return false;
	}

	private boolean validateDomainPart(String email)
	{
		int index = email.indexOf('@');
		String domainPart = email.substring(index + 1);
		if(domainPart.length() == domainPartValidator.validate(domainPart) && domainPart.length() < 64
		&& domainPart.length() > 0 )
		{
			return true;
		}
		return false;
	}
}
