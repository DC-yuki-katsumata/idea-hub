package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdeaThemeService {

    @Autowired
    private IdeaThemeRepository ideaThemeRepository;

    public List<IdeaTheme> getAllThemes() {
        return ideaThemeRepository.findAll();
    }

    public Optional<IdeaTheme> getThemeById(int id) {
        return ideaThemeRepository.findById(id);
    }

    public IdeaTheme addTheme(IdeaTheme theme) {
        return ideaThemeRepository.save(theme);
    }

    public IdeaTheme updateTheme(int id, IdeaTheme themeDetails) {
        Optional<IdeaTheme> optionalTheme = ideaThemeRepository.findById(id);
        if (optionalTheme.isPresent()) {
            IdeaTheme theme = optionalTheme.get();
            theme.setTitle(themeDetails.getTitle());
            theme.setDescription(themeDetails.getDescription());
            return ideaThemeRepository.save(theme);
        } else {
            return null; // または適切なエラーハンドリングを行う
        }
    }

    @Transactional
    public IdeaTheme renameTheme(int id, String newName) {
        IdeaTheme theme = ideaThemeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid theme ID"));
        theme.setTitle(newName);
        return ideaThemeRepository.save(theme);
    }

    public void deleteTheme(int id) {
        ideaThemeRepository.deleteById(id);
    }
    
    public List<IdeaTheme> searchThemes(String query) {
        return ideaThemeRepository.findByTitleContaining(query);
    }
}
