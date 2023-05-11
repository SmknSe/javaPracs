package com.example.pw10;

import com.example.pw10.components.ConsolePrinter;
import com.example.pw10.components.FilePrinter;
import com.example.pw10.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Pw10Application {

	public static void main(String[] args) {
		ApplicationContext a = new AnnotationConfigApplicationContext(BeanConfig.class);
		FilePrinter fp = (FilePrinter) a.getBean("FilePrinter");
		fp.doPrint();
		ConsolePrinter cp = (ConsolePrinter) a.getBean("ConsolePrinter");
		cp.doPrint();
	}

}
