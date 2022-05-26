package login.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);
    List<Role> findAll();
    Role saveAndFlush(Role role);
}
