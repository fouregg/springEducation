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

		// until DI
		/*
		Figure figure = context.getBean("triangleBean", Figure.class);
		FigureShow figureShow = new FigureShow(figure);
		figureShow.show();
		*/

		FigureShow figureShow1 = context.getBean("figureShow", FigureShow.class);
		figureShow1.setName("Test");
		System.out.println(figureShow1);
		FigureShow figureShow2 = context.getBean("figureShow", FigureShow.class);
		System.out.println(figureShow2);
		figureShow1.show();
		context.close();

		//SpringApplication.run(SpringEducationApplication.class, args);
	}

}
