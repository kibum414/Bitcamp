package Lecture._20210302.Time;

public class Time {
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59
	
	// 첫 번째 생성자
	public Time() {
		this(0, 0, 0);
	}
	
	// 두 번째 생성자
	public Time(int h, int m, int s) {
		hour = ((h >= 0 && h < 24) ? h : 0); // 시간 검증
		minute = ((m >= 0 && m < 60) ? m : 0); // 분 검증
		second = ((s >= 0 && s < 60) ? s : 0); // 초 검증
	}
	
	public String toString() {
		return String.format("%2d:%2d:%2d\n", hour, minute, second);
	}
}
