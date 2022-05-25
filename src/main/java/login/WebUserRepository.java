package login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebUserRepository extends CrudRepository<WebUser, Integer> {

}
