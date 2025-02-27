package com.example.springEducation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringEducationApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"
		);
		FirstBean test = context.getBean("student", FirstBean.class);

		System.out.println(test.getFirstName());

		context.close();

		//SpringApplication.run(SpringEducationApplication.class, args);
	}

}
