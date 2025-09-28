-- Create the database
CREATE DATABASE IF NOT EXISTS serenify;
USE serenify;

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Playlists table
CREATE TABLE IF NOT EXISTS playlists (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    mood VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    created_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES users(id) ON DELETE SET NULL
);

-- Sample data for moods
INSERT INTO playlists (name, mood, description, created_by) VALUES
('Happy Vibes', 'Happy', 'Songs to lift your mood', 1),
('Chill Beats', 'Relaxed', 'Relaxing tunes', 1),
('Focus Music', 'Focused', 'Background music for work', 2),
('Workout Pump', 'Energetic', 'High-energy workout songs', 2),
('Sad Songs', 'Sad', 'Melancholic tracks', 3);
