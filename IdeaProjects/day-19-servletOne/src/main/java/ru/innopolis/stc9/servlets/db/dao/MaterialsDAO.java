package ru.innopolis.stc9.servlets.db.dao;

import ru.innopolis.stc9.servlets.pojo.Materials;

public interface MaterialsDAO  {
    public void addMaterial(Materials material);
    public Materials getMaterialbyId(int id);
    public void updateMaterial(Materials material);
    public void deleteMaterialById(int id);
}
