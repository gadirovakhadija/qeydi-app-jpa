package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teach_table", schema = "qeydi")
public class Teachway {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "teachway")
    private String teachway;

    public Teachway() {
    }

    public Teachway(int id, String teachway) {
        this.id = id;
        this.teachway = teachway;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeachway() {
        return teachway;
    }

    public void setTeachway(String teachway) {
        this.teachway = teachway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teachway teachway1 = (Teachway) o;

        if (id != teachway1.id) return false;
        if (teachway != null ? !teachway.equals(teachway1.teachway) : teachway1.teachway != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (teachway != null ? teachway.hashCode() : 0);
        return result;
    }
}
