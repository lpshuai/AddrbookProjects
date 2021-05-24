package cn.ekgc.witmed.dictionary.service;

import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.pojo.dictionary.vo.AboVO;

import java.util.List;

/**
 * <b>智慧医疗-数据字典-abo业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AboService {
	/**
	 * <b>根据查询视图分页查询</b>
	 * @param pageVO
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	PageVO<AboVO> getPageByQuery(PageVO<AboVO> pageVO, AboVO queryVO) throws Exception;

	/**
	 * <b>根据查询视图查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<AboVO> getListByQuery(AboVO queryVO) throws Exception;

	/**
	 * <b>保存视图信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(AboVO vo) throws Exception;

	/**
	 * <b>修改视图信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean update(AboVO vo) throws Exception;

	/**
	 * <b>根据主键查询视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	AboVO getById(String id) throws Exception;

	/**
	 * <b>根据编码查询视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	AboVO getByCode(String code) throws Exception;
}
