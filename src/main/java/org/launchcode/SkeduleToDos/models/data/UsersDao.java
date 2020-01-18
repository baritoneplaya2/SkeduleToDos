package org.launchcode.SkeduleToDos.models.data;

import org.launchcode.SkeduleToDos.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersDao extends CrudRepository<Users, Integer> {
    Users findByEmail(String email);
}
