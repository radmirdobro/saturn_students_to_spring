package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.GroupsDAO;
import ru.innopolis.stc9.servlets.db.dao.GroupsDAOImpl;

public class GroupsService {
    GroupsDAO groupsDAO = new GroupsDAOImpl();

    public String getGroupById(int id) {
        return groupsDAO.getStGroupById(id);
    }
}
