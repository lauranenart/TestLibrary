package informationValidation;

public class DomainPartValidator {
    String latinSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String digits = "0123456789";

    public int validate(String domainPart)
    {
        int found = 0;
        if((!domainPart.startsWith("-") && !domainPart.endsWith("-")) ||
                (!domainPart.startsWith(".") && !domainPart.endsWith(".")))
        {
            for(char c : domainPart.toCharArray())
            {
                if(charIsItemFromList(c, latinSymbols.toCharArray()) || charIsItemFromList(c, digits.toCharArray())
                || c == '-' || c == '.')
                {
                    found++;
                }
            }
        }
        return found;
    }

    public static boolean charIsItemFromList(char c, char[] items)
    {
        for(int i =0; i < items.length; i++)
        {
            if(c == items[i])
            {
                return true;
            }
        }
        return false;
    }
}
