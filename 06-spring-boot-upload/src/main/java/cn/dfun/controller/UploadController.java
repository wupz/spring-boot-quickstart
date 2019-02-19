package cn.dfun.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	@RequestMapping("/fileUpload")
	public Map<String, Object> fileUpload(MultipartFile filename) throws IllegalStateException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		filename.transferTo(new File("d:/" + filename.getOriginalFilename()));
		map.put("msg", "ok");
		return map;
	}
}
