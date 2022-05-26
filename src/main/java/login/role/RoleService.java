package login.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role saveOrUpdate(Role role) {
        return roleRepository.saveAndFlush(role);
    }

}
