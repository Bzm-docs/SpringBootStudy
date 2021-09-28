package ink.bzm.hello.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author: buzhengmiao    docs.bzm.ink
 * @time: 2021/9/16 下午4:22
 */
@Component
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	String name;
	Integer age;

	public User(String name) {
		this.name = name;
	}
}
