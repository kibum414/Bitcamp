package Lecture._20210303.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto4 {

	public static void main(String[] args) {
		Integer[] intArray = new Integer[45];
		
		for (int i = 0; i < 45; i++) {
			intArray[i] = i + 1;
		}
		
		// Repoclass?
		
		// 배열을 List로 바꾸는데 이름은 intList
		List<Integer> intList = Arrays.asList(intArray);
		
		Collections.shuffle(intList);
		
		intList.toArray(intArray);
		
		for (int i = 0; i < 6; i++) {
			System.out.println(intArray[i] + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(intArray));
	}

}
