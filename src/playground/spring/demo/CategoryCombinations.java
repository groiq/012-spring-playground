package playground.spring.demo;

public class CategoryCombinations {
	
	static String[][] cats = {{"human","dwarf","elf"},{"warrior","rogue","mage"}};
//			[["human","dwarf","elf"],["warrior","rogue","mage"]];
	

	private static String getCombinations() {
		String result = "";
		for (String[] cat: cats) {
//			System.out.println(cat);
			for (String item: cat) {
				result = result + item;
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		System.out.println(getCombinations());

	}

}
