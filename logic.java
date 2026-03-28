package Logic;

import java.util.*;

public class logic {
	
	static boolean upp = false;
	static boolean low = false;
	static boolean sp = false;
	static boolean num = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	public static boolean[] getError(String name, String pass) {
		char_check(pass);
		boolean[] ans= {upp,low,sp,num,length_check(pass),username(pass,name)};
		return ans;
	}

	public static boolean getStrength(String username, String pass) {
		if ((length_check(pass) && username(pass, username)) && char_check(pass)) {
			return true;
		}
		return false;
	}

	private static boolean char_check(String pass) {
		

		for (int i = 0; i < pass.length(); i++) {
			char ch = pass.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				upp = true;
			}
			if (ch >= 'a' && ch <= 'z') {
				low = true;
			}
			if (ch >= 48 && ch <= 57) {
				num = true;
			}
			if ((ch >= 33 && ch <= 47) || (ch >= 58 && ch <= 64) || (ch >= 91 && ch <= 96)
					|| (ch >= 123 && ch <= 126)) {
				sp = true;
			}
		}
		boolean f = false;
		if ((upp && low) && (sp && num)) {
			f = true;
		}
		return f;

	}

	private static boolean length_check(String pass) {
		int l = pass.length();
		if (l >= 8) {
			return true;
		}
		return false;
	}

	private static boolean username(String pass, String name) {
		return !pass.toLowerCase().contains(name.toLowerCase());

	}

}
