package com.spring.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass
{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency)
	{
		super();
		this.someDependency=someDependency;
		System.out.println("All Dependencies are Ready");
	}
	
	@PostConstruct
	public void initialize()
	{
		someDependency.getReady();
	}
	
	@PreDestroy
	public void cleanup()
	{
		System.out.println("CleanUp");
	}
}

@Component 
class SomeDependency
{
	public void getReady()
	{
		System.out.println("Some logic Using SomeDependency");
	}
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(var context = new AnnotationConfigApplicationContext
				(PrePostAnnotationsContextLauncherApplication.class))
		{
//			context.getBean(GamingConsole.class).up();
//			context.getBean(GameRunner.class).run();
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		

	}

}
