package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeaService {
	@Autowired
	private IdeaRepository ideaRepository;

	public Idea saveIdea(String text, int themeId) { // Longからintに変更
		Idea idea = new Idea();
		idea.setText(text);
		idea.setThemeId(themeId); // Longからintに変更
		return ideaRepository.save(idea);
	}

	public List<Idea> getIdeasByThemeId(int themeId) { // Longからintに変更
		return ideaRepository.findByThemeId(themeId);
	}
}
