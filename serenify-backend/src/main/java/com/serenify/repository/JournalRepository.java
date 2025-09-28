package com.serenify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serenify.model.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}