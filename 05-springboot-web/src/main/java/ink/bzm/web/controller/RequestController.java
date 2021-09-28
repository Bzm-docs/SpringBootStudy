package ink.bzm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: buzhengmiao    https://blogs.bzm.ink/
 * @time: 2021/9/24 下午3:22
 */
@Controller
public class RequestController {

	@GetMapping("/goto")
	public String goToPage(HttpServletRequest request) {
		request.setAttribute("msg", "成功");    //设置请求域中的值
		request.setAttribute("code", "200");
		return "forward:/success";  //转发到  /success请求
	}

	@ResponseBody
	@GetMapping("/success")
	public Map success(@RequestAttribute(value = "msg", required = false) String annotation_msg,
					   @RequestAttribute(value = "code", required = false) String annotation_code,
					   HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();

		Object reqMethod_msg = request.getAttribute("msg");    //获取请求域中的值
		Object reqMethod_code = request.getAttribute("code");    //获取请求域中的值

		map.put("reqMethod_msg", reqMethod_msg);
		map.put("reqMethod_code", reqMethod_code);
		map.put("annotation_msg", annotation_msg);
		map.put("annotation_code", annotation_code);
		return map;
	}
}
