package workflow.microservices.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import workflow.api.user.User;
import workflow.api.user.UserService;
import workflow.util.http.ServiceUtil;
import workflow.util.http.exceptions.InvalidInputException;
import workflow.util.http.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserServiceImpl implements UserService {

    private final ServiceUtil serviceUtil;

    @Autowired
    public UserServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<User> getUser(int userId) {

        if (userId < 1) {
            throw new InvalidInputException("Invalid userId: " + userId);
        }

        if (userId == 13) {
            throw new NotFoundException("No user found for userId: " + userId);
        }

        List<User> list = new ArrayList<User>();
        list.add(new User(7, "Georgi"));
        return list;
    }
}

