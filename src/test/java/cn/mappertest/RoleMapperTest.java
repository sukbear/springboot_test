package cn.mappertest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.test.App;
import cn.test.mapper.RoleMapper;
import cn.test.pojo.Role;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RoleMapperTest {
	@Autowired
	private RoleMapper roleMapper;

	/*
	 * @Test public void testGetAll() { List<Role> list = new ArrayList<Role>();
	 * list = roleMapper.getAll(); Assert.assertNotNull(list); }
	 */
	@Test
	public void testGetOne() {
		Role role = new Role();
		role = roleMapper.getOne(1);
		System.out.println(role.getName());
		System.out.println(role.getLevel());
		Assert.assertEquals(role.getName(), "admin");
	}
}
