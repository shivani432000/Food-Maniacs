package com.shivani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

	
}
