package forohub.forohub.utilidades;
import forohub.forohub.http.request.RoleRequest;
import forohub.forohub.http.response.RoleResponse;
import forohub.forohub.models.authenticate.Permission;
import forohub.forohub.models.authenticate.Role;
import forohub.forohub.repositorios.PermissionRepository;



import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoleUtils {

    @Autowired
    private static PermissionRepository permissionRepository;

    public static RoleResponse toRoleResponse(Role role){
        return RoleResponse.builder()
                .name(role.getName())
                .permissions(
                        role.getPermissions().stream()
                                .map(PermissionUtils::toPermissionResponse)
                                .toList()
                )
                .build();
    }

    public static Role toRole(RoleRequest roleRequest){
        List<Permission> permissions = new ArrayList<>();
        roleRequest.getPermissions().forEach( permissionRequest ->
                permissionRepository.findByNameAndEnable(permissionRequest.getName(),true).ifPresent(permissions::add)
        );
        return Role.builder()
                .name(roleRequest.getName())
                .permissions(permissions)
                .build();
    }

}