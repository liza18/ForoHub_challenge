package forohub.forohub.utilidades;
import forohub.forohub.http.request.PermissionRequest;
import forohub.forohub.http.response.PermissionResponse;
import forohub.forohub.models.authenticate.Permission;

public class PermissionUtils {

    public static PermissionResponse toPermissionResponse(Permission permission){
        return PermissionResponse.builder()
                .id(permission.getId())
                .name(permission.getName())
                .build();
    }

    public static Permission toPermission(PermissionRequest permissionRequest){
        return Permission.builder()
                .name(permissionRequest.getName())
                .build();
    }

}