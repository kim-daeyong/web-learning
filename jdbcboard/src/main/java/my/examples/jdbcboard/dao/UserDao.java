package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.User;

public interface UserDao {
    void addUser(User user);

    String getPasswdByEmail(String email);
}
