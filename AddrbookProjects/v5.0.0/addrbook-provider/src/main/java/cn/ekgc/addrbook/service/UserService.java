package cn.ekgc.addrbook.service;

import cn.ekgc.addrbook.pojo.entity.User;
import cn.ekgc.addrbook.pojo.vo.PageVO;

import java.util.List;

/**
 * <b>用户功能业务层接口</b>
 * @version 5.0.0
 */
public interface UserService {

	/**
	 * 根据查询对象查询列表
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<User> getListByQuery(User user ) throws Exception;

	/**
	 * 分页查询
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<User> getPage(PageVO<User> pageVO) throws Exception;

	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean savaUser(User user) throws Exception;

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean updateUser(User user) throws Exception;

	/**
	 * 根据主键删除用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean deleteById(Long id) throws Exception;

	/**
	 * 根据主键查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getById(Long id) throws Exception;

}
