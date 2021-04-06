package pkb.ct.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 매개변수가 하나도 없는 생성자
@AllArgsConstructor // 모든 매개변수를 가지는 생성자
@Data // Getter, Setter 까지 만들어주는 생성자. DTO 객체라는 것 명시
public class Human {
	private String name;
	private int age;
	
}
