package playground.spring.demo;

public class CategoryCombinations {
	
	static String[][] cats = {{"human","dwarf","elf"},{"warrior","rogue","mage"}};
//			[["human","dwarf","elf"],["warrior","rogue","mage"]];
	
	private static String processOneEntry(String catsAbove, int level) {
		String result = "";
		for (String entry : cats[level]) {
//			System.out.println(entry);
			result = result + " " + catsAbove + " " + entry;
			if (level < cats.length - 1) {
				result = result + processOneEntry(result, level+1);
			} else {
				result += ", ";
			}
		}
		return result;
	}
	
	private static String getCombinations() {
		String result = processOneEntry("",0);
//		for (String[] cat: cats) {
//			System.out.println(cat);
//			for (String item: cat) {
//				result = result + item;
//			}
//		}
		return result;
	}
	

	public static void main(String[] args) {
		System.out.println(getCombinations());

	}

}
