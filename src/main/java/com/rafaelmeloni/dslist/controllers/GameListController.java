package com.rafaelmeloni.dslist.controllers;


import com.rafaelmeloni.dslist.dto.GameListDto;
import com.rafaelmeloni.dslist.dto.GameMinDTO;
import com.rafaelmeloni.dslist.dto.ReplacementDTO;
import com.rafaelmeloni.dslist.services.GameListService;
import com.rafaelmeloni.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll() {

        return gameListService.findAll();

    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void  move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getTargetIndex());
    }
}
