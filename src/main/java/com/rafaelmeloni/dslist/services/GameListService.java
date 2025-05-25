package com.rafaelmeloni.dslist.services;

import com.rafaelmeloni.dslist.dto.GameListDto;

import com.rafaelmeloni.dslist.entities.GameList;
import com.rafaelmeloni.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDto> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(x -> new GameListDto(x)).toList();
    }
}
