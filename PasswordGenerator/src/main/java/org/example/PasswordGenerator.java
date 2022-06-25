package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordGenerator {
    private static final String ABC = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    private static final String NUMBERS = "1234567890";
    private static final String CHARS = "%*)?@#$~";

    public static String makePassword (int length) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< length; i++) {
            int random = (int) (3 * Math.random());
            switch (random) {
                case 0:
                    sb.append (randomCharacter(ABC));
                    break;
                case 1:
                    sb.append (randomCharacter(NUMBERS));
                    break;
                case 2:
                    sb.append (randomCharacter(CHARS));
                    break;
            }
        }

        while (!checkPassword(sb.toString())) {
            String anotherPassword = makePassword(length);
            if(checkPassword(anotherPassword)) {
                sb.insert(0,anotherPassword);
                break;
            }
        }
        return sb.toString();
    }

    /*
    Генерация рандомного символа
     */
    private static String randomCharacter(String characters) {
        int n = characters.length();
        int k = (int) (n * Math.random());

        return characters.substring(k, k+1);
    }

    /*
    Проверка пароля на наличие строчной и прописной буквы, цифры, спец.знака
     */
    private static boolean checkPassword (String password) {

        Pattern pattern1 = Pattern.compile("[a-z]");
        Pattern pattern2 = Pattern.compile("[A-Z]");
        Pattern pattern3 = Pattern.compile("\\d");
        Pattern pattern4 = Pattern.compile("[%*)?@#$~]");

        Matcher matcher1 = pattern1.matcher(password);
        Matcher matcher2 = pattern2.matcher(password);
        Matcher matcher3 = pattern3.matcher(password);
        Matcher matcher4 = pattern4.matcher(password);

        if(!matcher1.find()) return false;
        if(!matcher2.find()) return false;
        if(!matcher3.find()) return false;
        if(!matcher4.find()) return false;

        return true;
    }
}
