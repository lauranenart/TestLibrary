package informationValidation;

public class LocalPartValidator {
    String latinSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String digits = "0123456789";
    String specialCharacters = "!#$%&'*+-/=?^_`{|}~.";
    String spacePunctuations = "\"(),:;<>@[\\]";

    public int validate(String localPart)
    {
        int found = 0;
        if(!localPart.startsWith(".") && !localPart.endsWith("."))
        {
            for(char c : localPart.toCharArray())
            {
                if(charIsItemFromList(c, latinSymbols.toCharArray()) || charIsItemFromList(c, digits.toCharArray())
                || charIsItemFromList(c, specialCharacters.toCharArray()))
                {
                    found++;
                }
            }
        }
        else if(localPart.startsWith("\""))
        {
            for(char c : localPart.toCharArray())
            {
                if(charIsItemFromList(c, spacePunctuations.toCharArray()))
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
