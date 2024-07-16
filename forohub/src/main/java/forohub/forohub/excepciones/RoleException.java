package forohub.forohub.excepciones;
import lombok.Getter;

@Getter
public class RoleException extends Exception{
    public RoleException(String message) {
        super(message);
    }
}