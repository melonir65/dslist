package com.rafaelmeloni.dslist.repositories;

import com.rafaelmeloni.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
