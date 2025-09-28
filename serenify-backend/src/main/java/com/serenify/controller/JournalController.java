package com.serenify.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serenify.model.Journal;
import com.serenify.repository.JournalRepository;
import com.serenify.service.MoodService;

@RestController
@RequestMapping("/api/journals")
@CrossOrigin(origins = "http://localhost:3000")
public class JournalController {

    private final JournalRepository journalRepository;
    private final MoodService moodService;

    public JournalController(JournalRepository journalRepository, MoodService moodService) {
        this.journalRepository = journalRepository;
        this.moodService = moodService;
    }

    @PostMapping("/")
    public Journal addJournal(@RequestBody Map<String, String> body) {
        String text = body.get("text");
        String mood = moodService.detectMood(text);
        String playlist = moodService.getPlaylist(mood);

        Journal journal = new Journal();
        journal.setText(text);
        journal.setMood(mood);
        journal.setPlaylistUrl(playlist);
        return journalRepository.save(journal);
    }

    @GetMapping("/")
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    @GetMapping("/trends")
public List<Map<String, Object>> getTrends() {
    return journalRepository.findAll().stream()
            .collect(Collectors.groupingBy(
                    j -> j.getCreatedAt().toLocalDate().toString(),
                    Collectors.counting()))
            .entrySet().stream()
            .map(e -> {
                Map<String, Object> map = new HashMap<>();
                map.put("date", e.getKey());
                map.put("count", e.getValue());
                return map;
            })
            .collect(Collectors.toList());
}
}