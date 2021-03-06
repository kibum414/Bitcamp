package Lecture._20210305.Enum;

// 열거형(Enumeration)
enum Direction { EAST, SOUTH, WEST, NORTH }

public class EnumEx1 {

	public static void main(String[] args) {
		// 값 대입
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");

		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);

		// 값이 같은지 비교
		System.out.println("d1 == d2 ? " + (d1 == d2));
		System.out.println("d1 == d3 ? " + (d1 == d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
		
		// 부등호를 이용한 대소 비교 불가
		// System.out.println("d2 > d3 ? " + (d1 > d3)); // 에러
		
		// 같으면 0
		// 다르면 앞이 크면 임의의 양수, 뒤가 크면 임의의 음수
		System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));
		
		switch (d1) {
			case EAST: // Direction.EAST 라고 쓸 수 없다.
				System.out.println("The direction is EAST.");
				
				break;
			case SOUTH:
				System.out.println("The direction is SOUTH.");
				
				break;
			case WEST:
				System.out.println("The direction is WEST");
				
				break;
			case NORTH:
				System.out.println("The direction is NORTH.");
				
				break;
			default:
				System.out.println("Invalid direction.");
				
				// break;
		}
		
		Direction[] dArr = Direction.values();
		
		for (Direction d : dArr) // for (Direction d : Direction.values())
			// .ordinal : index
			System.out.printf("%s = %d\n", d.name(), d.ordinal());
	}

}
