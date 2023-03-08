package org.example.dao.inter;

import org.example.entity.Subject;

import java.util.List;

public interface SubjectDaoInter {
    List<Subject> getAll();
    public Subject getById(int subjectId);
    boolean updateSubject(Subject sb);
    boolean removeSubject(int subjectId);
}
