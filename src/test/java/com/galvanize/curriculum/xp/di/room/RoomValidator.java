package com.galvanize.curriculum.xp.di.room;

public class RoomValidator {

    public boolean called;

    public boolean isValid(Room room) {
        called = true;
        return true;
    }
}
