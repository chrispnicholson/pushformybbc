package uk.co.bbc.pushformybbc.repository;

import uk.co.bbc.pushformybbc.dto.User;

import java.util.List;

/**
 * Created by Chris on 13-May-17.
 */
public interface UserRepository {
    public boolean addUser(User user);

    public List<User> listAllUsers();
}
