package cn.ekgc.addrbook.service.impl;


import cn.ekgc.addrbook.dao.UserDao;
import cn.ekgc.addrbook.pojo.entity.User;
import cn.ekgc.addrbook.pojo.vo.PageVO;
import cn.ekgc.addrbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户功能业务层接口实现类</b>
 * @version 5.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * 根据查询对象查询列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<User> getListByQuery(User query) throws Exception {
		return userDao.findListByQuery(query);
	}

	/**
	 * 分页查询
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<User> getPage(PageVO<User> pageVO) throws Exception {
		return null;
	}

	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean savaUser(User user) throws Exception {
		int count = userDao.save(user);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean updateUser(User user) throws Exception {
		int count = userDao.update(user);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 根据主键删除用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean deleteById(Long id) throws Exception {
		int count = userDao.deleteById(id);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 根据主键查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getById(Long id) throws Exception {
		// 创建查询对象
		User query = new User();
		query.setId(id);
		// 列表查询
		List<User> list = userDao.findListByQuery(query);
		if (list != null && !list.isEmpty() ) {
			return list.get(0);
		}

		return null;
	}
}
