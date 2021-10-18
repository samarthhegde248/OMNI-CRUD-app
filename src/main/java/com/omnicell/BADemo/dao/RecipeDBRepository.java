package com.omnicell.BADemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnicell.BADemo.entity.RecipeDB;

public interface RecipeDBRepository extends JpaRepository<RecipeDB, Long>{

}
