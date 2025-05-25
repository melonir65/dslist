package com.rafaelmeloni.dslist.dto;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.rafaelmeloni.dslist.entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListDto {

    private Long id;
    private String name;

    public GameListDto() {
    }

    public GameListDto(GameList entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
