package com.truYum.app.validator;

import java.util.regex.Pattern;

public class UserIdValidator {
	public static boolean isValidUserName(String userId) {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		return Pattern.compile(regex).matcher(userId).matches();
//		attern.compile("\"^(.+)@(.+)$\"").matcher(userId).matches()
	}
}
