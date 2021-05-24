package cn.ekgc.witmed.dictionary.service.impl;

import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.base.util.IdGenerator;
import cn.ekgc.witmed.dictionary.dao.AboDao;
import cn.ekgc.witmed.dictionary.service.AboService;
import cn.ekgc.witmed.pojo.dictionary.entity.Abo;
import cn.ekgc.witmed.pojo.dictionary.vo.AboVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>智慧医疗-数据字典-abo业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("AboService")
@Transactional
public class AboServiceImpl implements AboService {
	@Autowired
	private AboDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询视图分页查询</b>
	 * @param pageVO
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<AboVO> getPageByQuery(PageVO<AboVO> pageVO, AboVO queryVO)
			throws Exception {
		// 将查询视图切换为查询实体
		Abo query = Abo.parseFromVO(queryVO);
		// 进行分页查询列表
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		List<Abo> entityList = dao.findListByQuery(query);
		// 根据 entityList 创建 PageInfo 对象
		PageInfo<Abo> pageInfo = new PageInfo<Abo>(entityList);
		// 提取结果集合数据转换到视图列表中
		List<AboVO> voList = new ArrayList<AboVO>();
		if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()) {
			for (Abo entity : pageInfo.getList()) {
				voList.add(AboVO.parseFromEntity(entity));
			}
		}
		pageVO.setList(voList);

		// 提取分页其他数据
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalSize((long) pageInfo.getPages());

		return pageVO;
	}

	/**
	 * <b>根据查询视图查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<AboVO> getListByQuery(@RequestBody AboVO queryVO) throws Exception {
		// 将查询视图切换为查询实体
		Abo query = Abo.parseFromVO(queryVO);
		// 进行列表查询
		List<Abo> entityList = dao.findListByQuery(query);
		// 提取结果集合数据转换到视图列表中
		List<AboVO> voList = new ArrayList<AboVO>();
		if (entityList != null && !entityList.isEmpty()) {
			for (Abo entity : entityList) {
				voList.add(AboVO.parseFromEntity(entity));
			}
		}
		return voList;
	}

	/**
	 * <b>保存视图信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(AboVO vo) throws Exception {
		// 将保存视图切换为保存实体
		Abo entity = Abo.parseFromVO(vo);
		// 设置主键
		entity.setId(idGenerator.createId());
		// 保存信息
		if (dao.save(entity) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改视图信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(AboVO vo) throws Exception {
		// 将修改视图切换为修改实体
		Abo entity = Abo.parseFromVO(vo);
		// 进行修改
		if (dao.update(entity) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>根据主键查询视图信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public AboVO getById(String id) throws Exception {
		// 创建查询实体
		Abo query = new Abo();
		query.setId(id);
		// 进行列表查询
		List<Abo> entityList = dao.findListByQuery(query);
		if (entityList != null && !entityList.isEmpty()) {
			return AboVO.parseFromEntity(entityList.get(0));
		}
		return null;
	}

	/**
	 * <b>根据编码查询视图信息</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public AboVO getByCode(String code) throws Exception {
		// 创建查询实体
		Abo query = new Abo();
		query.setCode(code);
		// 进行列表查询
		List<Abo> entityList = dao.findListByQuery(query);
		if (entityList != null && !entityList.isEmpty()) {
			return AboVO.parseFromEntity(entityList.get(0));
		}
		return null;
	}
}
