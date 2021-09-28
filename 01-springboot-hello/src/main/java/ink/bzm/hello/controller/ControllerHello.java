package ink.bzm.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: buzhengmiao    docs.bzm.ink
 * @time: 2021/9/16 下午3:16
 */
@RestController
@Slf4j	//lombok自带日志工具
public class ControllerHello {

	@RequestMapping("/hello")
	String hello(){
		log.info("info................");
		return "hello1234";
	}
}
