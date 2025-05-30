package com.rafaelmeloni.dslist.services;

import com.rafaelmeloni.dslist.dto.GameListDto;


import com.rafaelmeloni.dslist.entities.GameList;
import com.rafaelmeloni.dslist.projections.GameMinProjection;
import com.rafaelmeloni.dslist.repositories.GameListRepository;
import com.rafaelmeloni.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();
        return gameLists.stream().map(x -> new GameListDto(x)).toList();
    }

    @Transactional
    public void move (Long listId, int sourceIndex, int targetIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(targetIndex, obj);

        int min = sourceIndex < targetIndex ? sourceIndex : targetIndex;
        int max = sourceIndex < targetIndex ? targetIndex : sourceIndex;

        for (int i = min; i <= max ; i++) {

            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);

        }


    }
}
