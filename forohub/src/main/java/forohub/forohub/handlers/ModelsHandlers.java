package forohub.forohub.handlers;
import forohub.forohub.excepciones.PermissionException;
import forohub.forohub.excepciones.RoleException;
import forohub.forohub.excepciones.TopicException;
import forohub.forohub.excepciones.UserException;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ModelsHandlers {

    @ExceptionHandler(PermissionException.class)
    public String handlePermissionException(PermissionException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(TopicException.class)
    public String handleTopicException(TopicException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UserException.class)
    public String handleUserException(UserException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(RoleException.class)
    public String handleRoleException(RoleException exception) {
        return exception.getMessage();
    }

}