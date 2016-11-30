package com.galvanize.curriculum.xp.di.room;

import javax.inject.Inject;

public class RoomController {

    @Inject
    private RoomRepository repository;

    @Inject
    private RoomValidator validator;

    public void createRoom(Room room) {
        if (validator.isValid(room)) {
            repository.save(room);
        }
    }
}
