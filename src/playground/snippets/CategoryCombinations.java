package playground.snippets;

public class CategoryCombinations {
	
	
//	static String[][] cats = {{"human","dwarf","elf"},{"warrior","rogue","mage"}};
//	static String[][] cats = {{"A","B"},{"a","b"},{"1","2"}};
	static String[][] cats = {{"0","1"},{"0","1"},{"0","1"},{"0","1"}};
//			[["human","dwarf","elf"],["warrior","rogue","mage"]];
	
	private static String processOneEntry(String catsAbove, int level) {
		String result = "";
		for (String entry : cats[level]) {
//			System.out.println(entry);
			String curCats = catsAbove + " " + entry;
//			result = result + " " + catsAbove + " " + entry;
			if (level < cats.length - 1) {
				result = result + processOneEntry(curCats, level+1);
			} else {
				result = result + curCats + ", ";
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
