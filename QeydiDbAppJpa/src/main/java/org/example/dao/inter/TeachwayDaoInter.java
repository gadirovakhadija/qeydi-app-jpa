package org.example.dao.inter;

import org.example.entity.Teachway;

import java.util.List;

public interface TeachwayDaoInter {
    List<Teachway> getAll();
    public Teachway getById(int teachwayId);
    boolean updateTeachway(Teachway tw);
    boolean removeTeachway(int teachwayId);
}
