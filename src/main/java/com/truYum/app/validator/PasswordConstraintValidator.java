package com.truYum.app.validator;

import java.util.regex.Pattern;

public class PasswordConstraintValidator {
	public static boolean isValidPassword(String password)
    {
 
	    String regex = """
                       ^(?=.*[0-9])\
                       (?=.*[a-z])(?=.*[A-Z])\
                       (?=.*[@#$%^&+=])\
                       (?=\\S+$).{8,20}$\
                       """;
	    Pattern p = Pattern.compile(regex);
	    if (password == null) {
	        return false;
	    }
	    java.util.regex.Matcher m = p.matcher(password);
	    return m.matches();
    }
}
