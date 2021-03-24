package Lecture._20210303.WildCard;

import java.util.List;

public class MyList {
	public static void printList(List<?> list) {
		for (Object elem : list)
			System.out.print(elem + " ");
		
		System.out.println();
	}
}
