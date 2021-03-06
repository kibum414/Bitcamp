package Lecture._20210303.Rectangle;

public class Rectangle implements Comparable {
	public int getArea() {
		return width * height;
	}
	
	@Override
	public int compareTo(Object other) {
		Rectangle otherRect = (Rectangle) other;
		
		if (this.getArea() < otherRect.getArea())
			return -1;
		else if (this.getArea() > otherRect.getArea())
			return 1;
		else
			return 0;
	}
}
