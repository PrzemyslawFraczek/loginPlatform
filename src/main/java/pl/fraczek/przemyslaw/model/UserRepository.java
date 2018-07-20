package pl.fraczek.przemyslaw.model;


public interface UserRepository {

    boolean exist(String name);

    User add(User user);

    User get(String name);

    void update(User user);
}
