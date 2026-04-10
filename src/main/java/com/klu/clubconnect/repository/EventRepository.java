package com.klu.clubconnect.repository;

import com.klu.clubconnect.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStatus(String status);
    List<Event> findByCategory(String category);
    long countByStatus(String status);
}