package com.omnicell.BADemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.omnicell.BADemo.bean.RecipeBean;
import com.omnicell.BADemo.entity.RecipeDB;
import com.omnicell.BADemo.service.RecipeDBServiceImpl;

@RestController
public class RecipeEndpointController {
	@Autowired
	private RecipeDBServiceImpl recipeService;
	
	@GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<RecipeDB> showAllRecipes(){
		return this.recipeService.getAllRecipes();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Optional<RecipeDB> getRecipeById(@PathVariable long id){
		return this.recipeService.getRecipeById(id);
	}
	
	@PostMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RecipeDB saveNewRecipe(@RequestBody RecipeBean recipe){
		return this.recipeService.saveRecipe(new RecipeDB(this.recipeService.getSavedRecipeCount(), recipe.getName(), recipe.getImage(), recipe.getCategory(), recipe.getLabel(), recipe.getPrice(), recipe.getDescription()));
	}
	
	@GetMapping(value="/{id}/show", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getRecipeImageById(@PathVariable long id){
		return this.recipeService.getRecipeById(id).get().getImage();
	}
}
