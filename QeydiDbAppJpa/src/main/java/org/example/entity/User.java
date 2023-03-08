package org.example.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "age")
    private Integer age;
    @Basic
    @Column(name = "university")
    private String university;
    @Basic
    @Column(name = "point")
    private Integer point;
    @Basic
    @Column(name = "experience")
    private String experience;
    @Basic
    @Column(name = "teach_id")
    private Integer teachwayId;
    @Basic
    @Column(name = "subject_id")
    private Integer subjectId;

    @JoinColumn(name="teach_id",referencedColumnName = "id",nullable=false,
            updatable=false, insertable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Teachway teachway;

    @JoinColumn(name="subject_id",referencedColumnName = "id",nullable=false,
            updatable=false, insertable=false)
    @ManyToOne(fetch=FetchType.EAGER)
    private Subject subject;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "cost")
    private Double cost;
    @Basic
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(int id,String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String surname, int age, String university, int point, String experience, Integer teachwayId, Integer subjectId, String code, double cost) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.university = university;
        this.point = point;
        this.experience = experience;
        this.teachwayId = teachwayId;
        this.subjectId = subjectId;
        this.code = code;
        this.cost = cost;
    }

    public User(int id, String name, String surname, int age, String university, int point, String experience, Integer teachwayId, Integer subjectId, String email, String code, double cost, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.university = university;
        this.point = point;
        this.experience = experience;
        this.teachwayId = teachwayId;
        this.subjectId = subjectId;
        this.email = email;
        this.code = code;
        this.cost = cost;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getTeachwayId() {
        return teachwayId;
    }

    public void setTeachwayId(Integer teachwayId) {
        this.teachwayId = teachwayId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Teachway getTeachway() {
        return teachway;
    }

    public void setTeachway(Teachway teachway) {
        this.teachway = teachway;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (university != null ? !university.equals(user.university) : user.university != null) return false;
        if (point != null ? !point.equals(user.point) : user.point != null) return false;
        if (experience != null ? !experience.equals(user.experience) : user.experience != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (code != null ? !code.equals(user.code) : user.code != null) return false;
        if (cost != null ? !cost.equals(user.cost) : user.cost != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (teachway != null ? teachway.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
