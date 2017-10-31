package com.galvanize.curriculum.xp.di;

import com.galvanize.curriculum.xp.di.orm.InMemoryDriver;
import com.galvanize.curriculum.xp.di.orm.Orm;
import com.galvanize.curriculum.xp.di.room.Room;
import com.galvanize.curriculum.xp.di.room.RoomController;
import com.galvanize.curriculum.xp.di.room.RoomRepository;
import com.galvanize.curriculum.xp.di.room.RoomValidator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleDiContainerTest {

    @Test
    public void injectsOneDependency() {
        // Setup
        InMemoryDriver driverImpl = new InMemoryDriver();
        SimpleDiContainer container = new SimpleDiContainer(driverImpl);

        // Exercise
        Orm ormBean = container.getBean(Orm.class); // getBean() should create an instance of Orm *and* set the driver
        ormBean.save("String"); // save() should complete successfully if the driver field has been set
        ormBean.save(new int[] { 1, 2, 3 });

        // Assert
        assertThat(driverImpl.saved, hasItem("String"));
        assertThat(driverImpl.saved, hasItem(new int[] { 1, 2, 3 }));
    }

    @Test
    public void injectsMultipleDependencies() {

        // Setup
        RoomValidator validator = new RoomValidator();
        RoomRepository repository = new RoomRepository();
        SimpleDiContainer container = new SimpleDiContainer(validator, repository);

        // Exercise
        RoomController controllerBean = container.getBean(RoomController.class);
        controllerBean.createRoom(new Room("Classroom", 30));

        // Assert
        assertThat(validator.called, is(true));
        assertThat(repository.called, is(true));
    }
}
