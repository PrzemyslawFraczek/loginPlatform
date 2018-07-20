package pl.fraczek.przemyslaw.model;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements UserRepository {

    private final Map<String ,User> users = new HashMap<>();

    @Override
    public boolean exist(String name) {
        return users.containsKey(name);
    }

    @Override
    public User add(User user) {
        users.put(user.getName(),user);
        return user;
    }

    @Override
    public User get(String name) {
        return users.get(name);
    }

    @Override
    public void update(User user) {
        users.replace(user.getName() ,user);
    }
}
