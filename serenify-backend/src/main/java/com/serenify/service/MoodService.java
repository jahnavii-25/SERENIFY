package com.serenify.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MoodService {

    private static final Map<String, String> playlists = Map.of(
        "happy", "https://open.spotify.com/playlist/37i9dQZF1DXdPec7aLTmlC",
        "sad", "https://open.spotify.com/playlist/37i9dQZF1DX7qK8ma5wgG1",
        "angry", "https://open.spotify.com/playlist/37i9dQZF1DWYxwmBaMqxsl",
        "calm", "https://open.spotify.com/playlist/37i9dQZF1DX3PIPIT6lEg5"
    );

    public String detectMood(String text) {
        String lower = text.toLowerCase();
        if (lower.contains("happy") || lower.contains("joy") || lower.contains("excited"))
            return "happy";
        else if (lower.contains("sad") || lower.contains("lonely") || lower.contains("cry"))
            return "sad";
        else if (lower.contains("angry") || lower.contains("mad") || lower.contains("frustrated"))
            return "angry";
        else
            return "calm";
    }

    public String getPlaylist(String mood) {
        return playlists.getOrDefault(mood, playlists.get("calm"));
    }
}