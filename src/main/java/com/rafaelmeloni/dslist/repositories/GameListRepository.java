package com.rafaelmeloni.dslist.repositories;


import com.rafaelmeloni.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
