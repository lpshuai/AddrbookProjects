package cn.ekgc.addrbook.transport;


import cn.ekgc.addrbook.pojo.entity.User;
import cn.ekgc.addrbook.pojo.vo.PageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>用户功能传输层接口</b>
 * @version 5.0.0
 */
@FeignClient(name = "addrbook-provider")
@RequestMapping("/user/trans")
public interface UserTransport {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<User> getListByQuery(@RequestBody User query) throws Exception;

	/**
	 * <b>分页查询</b>
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<User> getPage(@RequestBody PageVO<User> pageVO) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean saveUser(@RequestBody User user) throws Exception;

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	boolean updateUser(@RequestBody User user) throws Exception;

	/**
	 * <b>根据主键删除用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/delete")
	boolean deleteById(@RequestParam Long id) throws Exception;

	/**
	 * <b>根据主键查询用户信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	User getById(@RequestParam Long id) throws Exception;

}
