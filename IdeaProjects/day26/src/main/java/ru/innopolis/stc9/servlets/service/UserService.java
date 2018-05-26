package ru.innopolis.stc9.servlets.service;

import ru.innopolis.stc9.servlets.db.dao.UsersDAOImpl;
import ru.innopolis.stc9.servlets.db.security.MD5hashImpl;
import ru.innopolis.stc9.servlets.pojo.Users;

public class UserService {
    static MD5hashImpl md5hash = new MD5hashImpl();
    private static UsersDAOImpl userDao = new UsersDAOImpl();

    public boolean checkAuth(String login, String password) {
        Users user = null;
        user = userDao.getUserByLogin(login);
        return (user != null) && (user.getPasswordHash().equals(md5hash.getHash(MD5hashImpl.getSALT() + password)));
    }

    public Integer getRole(String login) {
        Users user = userDao.getUserByLogin(login);
        return user.getRole();
    }

    public Integer getId(String login) {
        Users user = userDao.getUserByLogin(login);
        return user.getId();
    }


    public boolean checkOldPwd(String oldPassword, int uid) {
        String oldPasswordHash = userDao.getUserPwd(uid);
        if (oldPasswordHash.equals(oldPassword))
            return true;
        else {
            return false;
        }
    }

    public void updatePwd(String newPassword, int uid) {
        String newPasswordHash = md5hash.getHash(MD5hashImpl.getSALT() + newPassword);
        userDao.updateUserPwd(newPasswordHash, uid);
    }
}
