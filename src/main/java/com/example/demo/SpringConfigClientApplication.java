package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class SpringConfigClientApplication {
    // client의 local properties(application.properties)에 foo가 정의되어 있어 local variable 값이 사용
	@Value("${foo}")
	private String foo;

	@Value("${remote.foo}")
	private String remoteFoo;

	@RequestMapping(value="/")
	public Map<String, Object> test() {
	    Map map = new java.util.HashMap();
	    map.put("foo", foo);
		map.put("remote.foo", remoteFoo);

		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}
}
