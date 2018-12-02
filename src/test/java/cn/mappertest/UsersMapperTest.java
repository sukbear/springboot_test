package cn.mappertest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.test.App;
import cn.test.mapper.UsersMapper;
import cn.test.pojo.Users;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UsersMapperTest {
	@Autowired
	private UsersMapper usersMapper;
	@Test
	public void testInsert() {
		System.out.println(System.currentTimeMillis());
		for(long i = 0L; i < 5000000;i++) {
			Users users = new Users();
			users.setName("test"+i);
			users.setAge(20);
			usersMapper.insertUser(users);
		}
		System.out.println(System.currentTimeMillis());
	}
	/*@Test
	//测试事务不提交至数据库
	//测试提交至远程git
	public void testInsertList() {
		List<Users> list = new ArrayList<Users>();
		for(int i = 0; i < 5000000;i++) {
			Users users = new Users();
			users.setName("tom"+i);
			users.setAge(0+i);
			list.add(users);
		}
		int result = usersMapper.insertList(list);
		Assert.assertEquals(5, result);
	}*/
}
