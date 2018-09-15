package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
   private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        User user0 = new User("A",11,0);
        User user1 = new User("B",12,1);
        User user2 = new User("C",13,2);
        List<User> userList = new ArrayList<>();
        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        modelData.setUsers(userList);


    }

    @Override
    public void loadDeletedUsers() {
    throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }
}
