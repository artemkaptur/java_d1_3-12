package com.epam.springcoreintro.task1.service;

import com.epam.springcoreintro.task1.model.Position;
import com.epam.springcoreintro.task1.model.Salary;

import java.util.List;
import java.util.Optional;

public interface PositionService {

    Position createPosition(String title, String level, Salary salary);

    Position createPosition(Position position);

    List<Position> getPositions();

    Optional<Position> getPositionById(int id);

    Position updatePosition(int id, String title, String level, Salary salary);

    boolean deletePosition(Position position);

}
