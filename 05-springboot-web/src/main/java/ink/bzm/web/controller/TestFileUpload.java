package ink.bzm.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试文件上传
 * @author: buzhengmiao    https://blogs.bzm.ink/
 * @time: 2021/9/28 下午4:39
 */
@Controller
@Slf4j
public class TestFileUpload {

	@PostMapping("/upload")
	@ResponseBody
	public List<String> upload(@RequestPart("file") MultipartFile[] file) {
		List list = new ArrayList();
		if (file.length > 0) {
			for (MultipartFile multipartFile : file) {
				if (!multipartFile.isEmpty()) {
					list.add("上传成功：" + multipartFile.getOriginalFilename());
				}
			}
		}
		return list;
	}


}
