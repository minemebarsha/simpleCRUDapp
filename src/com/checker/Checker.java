package com.checker;

import javax.servlet.http.HttpSession;

public class Checker {
	public static boolean isLoggedIn(HttpSession httpSession) {
		String username = (String) httpSession.getAttribute("userName");
		if (username != null) {
			return true;
		}
		return false;
	}
}
