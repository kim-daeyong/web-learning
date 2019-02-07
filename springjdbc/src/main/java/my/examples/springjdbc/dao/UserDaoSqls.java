package my.examples.springjdbc.dao;

public class UserDaoSqls {
	public static final String SELECT_USERS =
			"SELECT user_id, nickname, email, passwd, regdate from user order by user_id desc limit :start, :limit";

	public static final String SELECT_USER_BY_EMAIL =
			"SELECT user_id, nickname, email, passwd, regdate from user where email = :email";

	public static final String UPDATE_USER =
			"update user set nickname = :nickname where user_id = :user_id";
}
