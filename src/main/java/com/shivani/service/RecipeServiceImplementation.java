package com.shivani.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.model.Recipe;
import com.shivani.model.User;
import com.shivani.repository.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe createRecipe(Recipe recipe, User user) {
        Recipe createdRecipe = new Recipe();
        createdRecipe.setTitle(recipe.getTitle());
        createdRecipe.setImage(recipe.getImage());
        createdRecipe.setDescription(recipe.getDescription());
        createdRecipe.setVegetarian(recipe.isVegetarian());
        createdRecipe.setUser(user);
        createdRecipe.setCreatedAt(LocalDateTime.now());
        return recipeRepository.save(createdRecipe);
	}

	@Override
	public Recipe findRecipeById(Long id) throws Exception {
		//optional type means maybe recipe is existing or may be not
		Optional<Recipe> opt = recipeRepository.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		throw new Exception("recipe not found with id "+id);
		
	}

	@Override
	public void deleteRecipe(Long id) throws Exception {
		//first we need to check whether the recipe exist in db
		findRecipeById(id);
		//delete
		recipeRepository.deleteById(id);
		
		
	}

	@Override
	public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {
		Recipe oldRecipe = findRecipeById(id);
		
		if(recipe.getTitle()!=null)
		{
			oldRecipe.setTitle(recipe.getTitle());
		}
		if(recipe.getImage()!=null)
		{
			oldRecipe.setImage(recipe.getImage());
		}
		if(recipe.getDescription()!=null)
		{
			oldRecipe.setDescription(recipe.getDescription());
		}
		
		
		 /*
		 * save method works for both creating and updating a record--
		 * how it updates?? it will check for id, if a record is present then it will update otherwise save
		 */
		return recipeRepository.save(oldRecipe);
	}

	@Override
	public List<Recipe> findAllRecipe() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe likeRecipe(Long recipeId, User user) throws Exception {
	    Recipe recipe = findRecipeById(recipeId);
	    
	    if(recipe.getLikes().contains(user.getId()))
	    {
	    	recipe.getLikes().remove(user.getId());
	    }
	    else
	    {
	    	recipe.getLikes().add(user.getId());
	    }
	    return recipeRepository.save(recipe);
	}
	
	
}
