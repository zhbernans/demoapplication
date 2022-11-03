package demoapplication.service;


import demoapplication.model.Role;
import demoapplication.repository.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService{

    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo){
        this.roleRepo=roleRepo;
    }

    public Role getById(Long id){
        return roleRepo.findById(id).orElse(null);
    }

    public Role save(Role role){
        return roleRepo.save(role);
    }

    public void delete(Long id){
        roleRepo.deleteById(id);
    }
}
