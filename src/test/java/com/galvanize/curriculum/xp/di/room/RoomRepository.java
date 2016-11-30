package com.galvanize.curriculum.xp.di.room;

public class RoomRepository {

    public boolean called;

    public void save(Room room) {
        called = true;
    }
}
