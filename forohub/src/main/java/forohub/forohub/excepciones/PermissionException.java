package forohub.forohub.excepciones;

import lombok.Getter;

@Getter
public class PermissionException extends Exception{
    public PermissionException(String message){
        super(message);
    }

}