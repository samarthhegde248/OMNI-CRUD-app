package com.omnicell.BADemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicell.BADemo.service.RecipeDBServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import com.omnicell.BADemo.entity.*;
import com.omnicell.BADemo.bean.*;

@SpringBootApplication
public class BaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaDemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(RecipeDBServiceImpl recipeService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<RecipeDB>> typeReference = new TypeReference<List<RecipeDB>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/recipes_data.json");
			try {
				List<RecipeDB> recipe = mapper.readValue(inputStream,typeReference);
				recipeService.saveAllRecipe(recipe);
				System.out.println("Recipes Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Recipes: " + e.getMessage());
			}
		};
	}
}
