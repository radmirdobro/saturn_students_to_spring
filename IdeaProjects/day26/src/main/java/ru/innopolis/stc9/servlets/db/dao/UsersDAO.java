package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Users;

public interface UsersDAO {
    public Users getUserByLogin(String login);

    public void updateUserPwd(String pwd, int uid);

    public String getUserPwd(int uid);
}




