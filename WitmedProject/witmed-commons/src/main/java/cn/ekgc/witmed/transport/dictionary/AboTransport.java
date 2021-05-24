package cn.ekgc.witmed.transport.dictionary;


import cn.ekgc.witmed.base.pojo.vo.PageQueryVO;
import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.pojo.dictionary.vo.AboVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>智慧医疗-数据字典-证件类型传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "witmed-dic-provider")
@RequestMapping("/dic/Abo/trans")
public interface AboTransport {

	/**
	 * <b>根据查询视图分页查询</b>
	 * @param pageQueryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<AboVO> getPageByQuery(@RequestBody PageQueryVO<AboVO> pageQueryVO) throws Exception;

	/**
	 * <b>根据查询视图查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<AboVO> getListByQuery(@RequestBody AboVO queryVO) throws Exception;

	/**
	 * <b>保存视图信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody AboVO vo) throws Exception;

	/**
	 * <b>修改视图</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	boolean update(@RequestBody AboVO vo) throws Exception;

	/**
	 * <b>根据主键查询视图</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	AboVO getById(@RequestParam String id) throws Exception;

	/**
	 * <b>根据编码查询视图</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	AboVO getByCode(@RequestParam String code) throws Exception;
}
