package com.vcube.SpringTask;

import java.util.List;

public interface PersonDAO {
    List<Person> getAll();
    Person getById(int id);
    void create(Person person);
    void update(Person person);
    void delete(int id);
}

