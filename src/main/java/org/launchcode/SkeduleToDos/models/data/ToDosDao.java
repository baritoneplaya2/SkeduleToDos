package org.launchcode.SkeduleToDos.models.data;

import org.launchcode.SkeduleToDos.models.ToDos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ToDosDao extends CrudRepository<ToDos, Integer> {
    ToDos findById(int toDosId);
}
