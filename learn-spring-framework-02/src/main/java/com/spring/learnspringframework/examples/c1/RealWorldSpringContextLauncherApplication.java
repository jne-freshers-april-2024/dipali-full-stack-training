package com.spring.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(var context = new AnnotationConfigApplicationContext
				(RealWorldSpringContextLauncherApplication.class))
		{
//			context.getBean(GamingConsole.class).up();
//			context.getBean(GameRunner.class).run();
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
		
		

	}

}
