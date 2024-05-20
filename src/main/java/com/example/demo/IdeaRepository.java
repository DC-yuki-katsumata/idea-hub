package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaRepository extends JpaRepository<Idea,Integer> {
	List<Idea> findByThemeId(int themeId);
}
