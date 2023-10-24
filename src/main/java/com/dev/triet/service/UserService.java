package com.dev.triet.service;

import com.dev.triet.entities.User;
import com.dev.triet.dto.UserSearchModel;
import com.dev.triet.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class UserService extends BaseService<User> {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean checkIfUserExist(String email) {
		String sql = "select * from tbl_users u where u.email = '" + email + "'";
		List<User> users = this.executeByNativeSQL(sql, 0).getData();

		if (users == null || users.size() <= 0)
			return false;
		return true;
    }

	@Override
	protected Class<User> clazz() {
		return User.class;
	}

	public User loadUserByUsername(String userName) {
		String sql = "select * from tbl_users u where u.username = '" + userName + "'";
		List<User> users = this.executeByNativeSQL(sql, 0).getData();

		if (users == null || users.size() <= 0)
			return null;
		return users.get(0);
	}

	public boolean RegisterUser(User user) {
		if (checkIfUserExist(user.getEmail())){
			return false;
		}
		user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword()));
		userRepository.save(user);
		return true;
	}

	public PagerData<User> search(UserSearchModel searchModel) {
		String sql = "SELECT * FROM tbl_users p WHERE 1=1";

		if (!StringUtils.isEmpty(searchModel.keyword)) {
			sql += " and (p.username like '%" + searchModel.keyword + "%'" + " or p.email like '%" + searchModel.keyword
					+ "%')";
		}
		return executeByNativeSQL(sql, searchModel == null ? 0 : searchModel.getPage());
	}


}
