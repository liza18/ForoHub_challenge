package forohub.forohub.repositorios;
import forohub.forohub.models.authenticate.Permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

    Optional<Permission> findByNameAndEnable(String name, boolean enable);

    List<Permission> findByEnable(boolean enable);

    Permission findByName(String permission);
}