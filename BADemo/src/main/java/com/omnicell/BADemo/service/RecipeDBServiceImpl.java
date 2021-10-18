package com.omnicell.BADemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnicell.BADemo.bean.RecipeBean;
import com.omnicell.BADemo.dao.RecipeDBRepository;
import com.omnicell.BADemo.entity.RecipeDB;

@Service
public class RecipeDBServiceImpl {
	@Autowired
	private RecipeDBRepository recipeRepo;
	
	public List<RecipeDB> getAllRecipes() {
		return this.recipeRepo.findAll();
	}
	public List<RecipeDB> saveAllRecipe(List<RecipeDB> recipe) {
		return this.recipeRepo.saveAll(recipe);
	}
	
	public RecipeDB saveRecipe(RecipeDB recipe) {
		return this.recipeRepo.save(recipe);
	}
	
	public Optional<RecipeDB> getRecipeById(long id) {
		return this.recipeRepo.findById(id);
	}
	
	public long getSavedRecipeCount() {
		return this.recipeRepo.count();
	}
}
