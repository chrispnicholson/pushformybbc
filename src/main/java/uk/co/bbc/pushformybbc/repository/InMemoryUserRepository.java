package uk.co.bbc.pushformybbc.repository;

import org.springframework.stereotype.Repository;
import uk.co.bbc.pushformybbc.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris on 13-May-17.
 */
@Repository
public class InMemoryUserRepository implements UserRepository {
    HashMap<String, User> mapOfUsers = new HashMap<String, User>();

    @Override
    public boolean addUser(User user) {
        mapOfUsers.put(user.getUsername(), user);

        return mapOfUsers.containsKey(user.getUsername());
    }

    @Override
    public List<User> listAllUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.addAll(mapOfUsers.values());
        return users;
    }
}
