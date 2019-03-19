package com.softserve.dto;

import com.softserve.models.Game;
import com.softserve.utilities.DataBaseUtilities;

public class GameConverter implements Converter<Game, GameDto> {
    @Override
    public GameDto apply(Game game) {
        GameDto gameDto = new GameDto();
        gameDto.setId(game.getId());
        gameDto.setTitle(game.getTitle());
        gameDto.setReleaseYear(game.getReleaseYear());
        gameDto.setImg(game.getImg());
        gameDto.setDescription(game.getDescription());
        gameDto.setAvgMark(DataBaseUtilities.getGamesDao()
                .calculateAverageMark(game.getId()));
        return gameDto;
    }
}
