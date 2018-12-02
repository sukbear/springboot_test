package cn.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.test.pojo.Users;
public interface UsersMapper {
	void insertUser(Users users);
	List<Users> selectUsersAll();
	Users selectUsersById(Integer id);
	void updateUser(Users users);
	void deleteUserById(Integer id);
	int  insertList(List<Users> usersList);
}
