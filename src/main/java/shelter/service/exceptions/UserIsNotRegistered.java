package shelter.service.exceptions;

public class UserIsNotRegistered extends Exception{
    public UserIsNotRegistered(String message) {
        super(message);
    }
}
