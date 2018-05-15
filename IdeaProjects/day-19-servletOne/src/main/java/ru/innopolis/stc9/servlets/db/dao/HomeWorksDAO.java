package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.HomeWorks;

public interface HomeWorksDAO {

    public void addHomeWork(HomeWorks homework);

    public void updateHomeWork(HomeWorks homework);

    public  HomeWorks getHomeWorkAnswer(int timetable_id);

    public boolean isHomeWorkEmpty(int timetable_id);

}
