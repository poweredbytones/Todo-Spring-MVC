package org.launchcode.models.data;

import org.launchcode.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Anthony
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

    List<User> findByusername(String username);
}