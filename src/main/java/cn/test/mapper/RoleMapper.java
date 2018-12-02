package cn.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.test.pojo.Role;

public interface RoleMapper {
	@Select("SELECT *FROM role")
	@Results({
		@Result(property = "name", column = "name"),
		@Result(property = "level", column = "level")	
	})
	List<Role> getAll();
	
	
	@Select("SELECT * FROM role WHERE id = #{id}")
	@Results({
		@Result(property = "name", column = "name"),
		@Result(property = "level", column = "level")	
	})
	Role getOne(Integer id);
}
