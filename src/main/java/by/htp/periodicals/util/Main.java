package by.htp.periodicals.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	private static StringBuilder text = new StringBuilder("success");
	
	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile("(ci)|(ce)|(ck)|(c)");
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String foundSequence = matcher.group();
			replaceSeq(start, end, foundSequence);
			System.out.println(text);
		}
	}
	
	private static void replaceSeq(int start, int end, String foundSequence) {
		String replaceSequence;
		switch (foundSequence) {
		case "ci":
			replaceSequence = "si";
			break;
		case "ce":
			replaceSequence = "se";
			break;
		default:
			replaceSequence = "k";
		}
		text.replace(start, end, replaceSequence);
	}

}
