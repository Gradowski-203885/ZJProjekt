package com.cinema.service;

import com.cinema.model.ScreeningRoom;

public interface ScreeningRoomService {
    ScreeningRoom getScreeningRoom(Long id);
    Long updateScreeningRoom(ScreeningRoom screeningRoom);
    Long addScreeningRoom(ScreeningRoom screeningRoom);
    void deleteScreeningRoom(Long id);
}
