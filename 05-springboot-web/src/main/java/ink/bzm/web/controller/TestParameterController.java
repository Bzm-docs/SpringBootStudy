package ink.bzm.web.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: buzhengmiao    https://blogs.bzm.ink/
 * @time: 2021/9/17 下午5:01
 */
@RestController
public class TestParameterController {

	/**
	 * http://localhost:8989/car/3/owner/lisi?age=18&inters=basketball&inters=game
	 *
	 * @return
	 */
	@GetMapping("car/{id}/owner/{username}")
	public Map car(@PathVariable Integer id,    //请求路径获取值
				   @PathVariable String username,
				   @RequestHeader("User-Agent") String userAgent,    //获取请求头
				   @RequestHeader Map<String, String> header,
				   @RequestParam Map<String, String> params,    //从请求参数获取值
				   @CookieValue("username") Cookie cookie
	) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", username);
		map.put("userAgent", userAgent);
		map.put("header", header);
		map.put("params", params);
		System.out.println(cookie.getName() + "-------" + cookie.getValue());
		return map;
	}

	/**
	 * @param content
	 * @return
	 */
	@PostMapping("/save")
	public Map postMethod(@RequestBody String content) {    //接收从前端传给后端的json字符串
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		return map;
	}

	/**
	 * 请求路径：/cars/sell;low=34;brand=byd,audi,yd
	 * <p>
	 * 默认SpringBoot禁用了矩阵变量功能，需要手动开启
	 *
	 * @return
	 */
	@GetMapping("/cars/{path}")
	public Map carsSell(@MatrixVariable("low") Integer low,
						@MatrixVariable("brand") List<String> brand,
						@PathVariable("path") String path) {
		Map<String, Object> map = new HashMap<>();
		map.put("low", low);
		map.put("brand", brand);
		map.put("path", path);
		return map;
	}

	/**
	 * @param bossAge
	 * @param empAge
	 * @return
	 */
	@GetMapping("/boss/{bossId}/{empId}")
	public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
					@MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
		Map<String, Object> map = new HashMap<>();

		map.put("bossAge", bossAge);
		map.put("empAge", empAge);
		return map;
	}

}

