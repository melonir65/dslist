package com.rafaelmeloni.dslist.dto;


import com.rafaelmeloni.dslist.entities.Game;
import com.rafaelmeloni.dslist.projections.GameMinProjection;

public class GameMinDTO {


    private Long id;
    private String title, imgUrl;
    private String shortDescription;
    private Integer year;



    public GameMinDTO() {
    }


    public GameMinDTO(Game entity) {
       id = entity.getId();
       title = entity.getTitle();
       imgUrl = entity.getImgUrl();
       shortDescription = entity.getShortDescription();
       year = entity.getYear();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
        year = projection.getYear();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Integer getYear() {
        return year;
    }
}
