package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.UsersDAOImpl;
import ru.innopolis.stc9.servlets.db.security.MD5hashImpl;
import ru.innopolis.stc9.servlets.pojo.Users;

public class UserService {
    private static UsersDAOImpl userDao = new UsersDAOImpl();
    static MD5hashImpl md5hash = new MD5hashImpl();

    public boolean checkAuth(String login, String password) {
        Users user = null;
        user = userDao.getUserByLogin(login);
        return (user != null) && (user.getPasswordHash().equals(md5hash.getHash( MD5hashImpl.getSALT() + password)));
    }

    public Integer getRole (String login){
        Users user = userDao.getUserByLogin(login);
        return user.getRole();
    }

    public Integer getId (String login){
        Users user = userDao.getUserByLogin(login);
        return user.getId();
    }




}
