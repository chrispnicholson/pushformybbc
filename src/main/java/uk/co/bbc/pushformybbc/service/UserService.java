package uk.co.bbc.pushformybbc.service;

import uk.co.bbc.pushformybbc.dto.User;

import java.util.List;

/**
 * Created by Chris on 16-May-17.
 */
public interface UserService {

    public boolean addUser(User user);

    public List<User> getAllUsers();
}
