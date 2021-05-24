package cn.ekgc.witmed.dictionary.transport.impl;

import cn.ekgc.witmed.base.pojo.vo.PageQueryVO;
import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.dictionary.service.AboService;
import cn.ekgc.witmed.pojo.dictionary.vo.AboVO;
import cn.ekgc.witmed.transport.dictionary.AboTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <b>智慧医疗-数据字典-abo传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("AboTransport")
@RequestMapping("/dic/Abo/trans")
public class AboTransportImpl implements AboTransport {
	@Autowired
	private AboService service;

	/**
	 * <b>根据查询视图分页查询</b>
	 * @param pageQueryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<AboVO> getPageByQuery(@RequestBody PageQueryVO<AboVO> pageQueryVO)
			throws Exception {
		// 提取分页视图和查询视图
		PageVO<AboVO> pageVO = pageQueryVO.getPageVO();
		AboVO queryVO = pageQueryVO.getQueryVO();
		return service.getPageByQuery(pageVO, queryVO);
	}

	/**
	 * <b>根据查询视图查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<AboVO> getListByQuery(@RequestBody AboVO queryVO) throws Exception {
		return service.getListByQuery(queryVO);
	}

	/**
	 * <b>保存视图信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody AboVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改视图</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody AboVO vo) throws Exception {
		return service.update(vo);
	}

	/**
	 * <b>根据主键查询视图</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public AboVO getById(@RequestParam String id) throws Exception {
		return service.getById(id);
	}

	/**
	 * <b>根据编码查询视图</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	@Override
	public AboVO getByCode(@RequestParam String code) throws Exception {
		return service.getByCode(code);
	}
}
