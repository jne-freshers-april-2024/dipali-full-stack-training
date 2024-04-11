package com.spring.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA
{
	
}

@Component
@Lazy
class ClassB
{
	private ClassA classA;
	
	public ClassB(ClassA classA)
	{
		System.out.println("Some Initialization Logic");
		this.classA=classA;
	}
	
	public void doSomething()
	{
		System.out.println("Do Something");
	}
	
	
}


@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(var context = new AnnotationConfigApplicationContext
				(LazyInitializationLauncherApplication.class))
		{
//			context.getBean(GamingConsole.class).up();
//			context.getBean(GameRunner.class).run();
//			Arrays.stream(context.getBeanDefinitionNames())
//			.forEach(System.out::println);
			
			System.out.println("Initialization of context is Completed");
			context.getBean(ClassB.class).doSomething();;
		}
		

	}

}
