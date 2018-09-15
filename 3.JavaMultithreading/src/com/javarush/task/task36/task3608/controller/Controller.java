package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;
    private MainModel mainModel;
    private EditUserView editUserView;

    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }
    public void onShowAllDeletedUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
        model.loadDeletedUsers();
    }
    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }
}

