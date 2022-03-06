package regex;


public class RegexEx01 {
	public static void main(String[] args) {
		String s = "55--2350Esdfsf33";
		
		String only_nr = s.replaceAll("[0-9]", "");
		String only_str = s.replaceAll("[^0-9]", "");
		
		System.out.println(only_nr);
		System.out.println(only_str);
	}
}
