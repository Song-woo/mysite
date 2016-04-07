package com.songwoo.mysite.util;

public class Common {

	public static String replaceHtml(String str) {
		if (str == null) {
			return null;
		}
		str = str.replace("&", "&amp;");
		str = str.replace("\"", "&quot;");
		str = str.replace("'", "&apos;");
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		return str;
	}
}

