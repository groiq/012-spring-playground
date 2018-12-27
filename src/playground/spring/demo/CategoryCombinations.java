package playground.spring.demo;

public class CategoryCombinations {
	
	static String[][] cats = {{"human","dwarf","elf"},{"warrior","rogue","mage"}};
//			[["human","dwarf","elf"],["warrior","rogue","mage"]];
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String[] cat: cats) {
//			System.out.println(cat);
			for (String item: cat) {
				System.out.println(item);
			}
		}

	}

}
