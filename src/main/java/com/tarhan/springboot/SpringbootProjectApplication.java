package com.tarhan.springboot;

import com.tarhan.springboot.dao.JsonConverter;
import com.tarhan.springboot.entity.Category;
import com.tarhan.springboot.entityService.CategoryEntityService;
import com.tarhan.springboot.entityService.ConverterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootProjectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootProjectApplication.class, args);
		CategoryEntityService service = applicationContext.getBean(CategoryEntityService.class);

		List<Category> categoryList =service.findAll();

		for(Category category : categoryList)
			System.out.println(category.toString());

		//ConverterService converterService = new ConverterService(new JsonConverter());
		//converterService.convertResponse();

		ConverterService converterService = applicationContext.getBean(ConverterService.class);
		converterService.convertResponse();

	}

}
