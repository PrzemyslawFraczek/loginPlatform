package pl.fraczek.przemyslaw.model;


public interface UserRepository {
    boolean exist(String name);

    User add(User user);
}
