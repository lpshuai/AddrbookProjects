package cn.ekgc.witmed.dictionary.dao;

import cn.ekgc.witmed.pojo.dictionary.entity.Abo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>智慧医疗-数据字典-abo数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface AboDao {
	/**
	 * <b>根据查询实体查询实体列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Abo> findListByQuery(Abo query) throws Exception;

	/**
	 * <b>保存实体信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(Abo entity) throws Exception;

	/**
	 * <b>修改实体信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(Abo entity) throws Exception;
}
