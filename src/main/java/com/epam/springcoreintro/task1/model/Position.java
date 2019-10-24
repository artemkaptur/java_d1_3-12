package com.epam.springcoreintro.task1.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Position {

    @NotNull(message = "Id should be assigned")
    private Integer id;
    @Size(min = 3, max = 20, message = "The size of title should be between 3 and 20")
    private String title;
    private String level;
    private Salary starterSalary;

    public Position(Integer id, String title, String level, Salary starterSalary) {
        this.id = id;
        this.title = title;
        this.level = level;
        this.starterSalary = starterSalary;
    }

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Salary getStarterSalary() {
        return starterSalary;
    }

    public void setStarterSalary(Salary starterSalary) {
        this.starterSalary = starterSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getId() == position.getId() &&
                getStarterSalary() == position.getStarterSalary() &&
                getTitle().equals(position.getTitle()) &&
                getLevel() == position.getLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getLevel(), getStarterSalary());
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", level=" + level +
                ", starterSalary=" + starterSalary +
                '}';
    }

}
