package workflow.api.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    /**
     * Sample usage: "curl $HOST:$PORT/user/1".
     *
     * @param userId Id of the user
     * @return the user, if found, else null
     */
    @GetMapping(
            value = "/user/{userId}",
            produces = "application/json")
    List<User> getUser(@PathVariable int userId);
}
