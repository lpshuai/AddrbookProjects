package cn.ekgc.addrbook.transport.impl;

import cn.ekgc.addrbook.pojo.entity.User;
import cn.ekgc.addrbook.pojo.vo.PageVO;
import cn.ekgc.addrbook.service.UserService;
import cn.ekgc.addrbook.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>用户功能传输层接口实现类</b>
 * @version 5.0.0
 */
@RestController("userTransport")
@RequestMapping("/user/trans")
public class UserTransportImpl implements UserTransport {
	@Autowired
	private UserService userService;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<User> getListByQuery(User query) throws Exception {
		return userService.getListByQuery(query);
	}

	/**
	 * <b>分页查询</b>
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<User> getPage(PageVO<User> pageVO) throws Exception {
		return userService.getPage(pageVO);
	}

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean saveUser(User user) throws Exception {
		return userService.savaUser(user);
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean updateUser(User user) throws Exception {
		return userService.updateUser(user);
	}

	/**
	 * <b>根据主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/delete")
	@Override
	public boolean deleteById(Long id) throws Exception {
		return userService.deleteById(id);
	}

	/**
	 * <b>根据主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public User getById(Long id) throws Exception {
		return userService.getById(id);
	}
}
