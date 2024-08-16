package foodorder;

import foodorder.User;
import java.util.HashMap;
import java.util.Map;

public class userservice {
    private Map<String, User> users;

    public userservice() {
        users = new HashMap<>();
    }

    public boolean registerUser(String username, String password, String address, String phoneNumber) {
        if (users.containsKey(username)) {
            return false;  // Username already exists
        }
        User newUser = new User(username, password, address, phoneNumber);
        users.put(username, newUser);
        return true;
    }

    public User loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }

    public boolean updateAddress(String username, String newAddress) {
        User user = users.get(username);
        if (user != null) {
            user.updateAddress(newAddress);
            return true;
        }
        return false;
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
