package net.linzhihui.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public int getMatchCount(String userName, String password) {
		if (userName.equals("admin") && password.equals("123456"))
			return 1;
		else
			return 0;
	}
}
