package com.epam.springcoreintro.task3.service.impl;

import com.epam.springcoreintro.task1.model.Position;
import com.epam.springcoreintro.task1.model.Salary;
import com.epam.springcoreintro.task1.service.PositionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class PositionServiceImpl implements PositionService {

    private List<Position> positions = new ArrayList<>();

    @Override
    public Position createPosition(String title, String level, Salary salary) {
        int newId = positions.size();
        Position newPosition = new Position(newId, title, level, salary);
        positions.add(newPosition);
        return newPosition;
    }

    @Override
    public Position createPosition(Position position) {
        positions.add(position);
        return position;
    }

    @Override
    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public Optional<Position> getPositionById(int id) {
        return positions.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Position updatePosition(int id, String title, String level, Salary salary) {
        Position updatedPosition = new Position(id, title, level, salary);
        positions = positions.stream().filter(p -> p.getId() != id).collect(toList());
        positions.add(updatedPosition);
        return updatedPosition;
    }

    @Override
    public boolean deletePosition(Position position) {
        if (positions.contains(position)) {
            positions.remove(position);
            return true;
        }
        return false;
    }

}
