package cn.ekgc.witmed.pojo.dictionary.entity;

import cn.ekgc.witmed.base.pojo.entity.BaseEntity;
import cn.ekgc.witmed.pojo.dictionary.vo.AboVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>智慧医疗-数据字典-abo血型实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Abo extends BaseEntity {
	private static final long serialVersionUID = -7566870908625426779L;
	private String id;                      // 主键
	private String text;                    // 文本信息
	private String code;                    // 编码
	private String remark;                  // 说明

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * <b>根据视图信息转换为实体信息</b>
	 * @param vo
	 * @return
	 */
	public static Abo parseFromVO(AboVO vo) {
		Abo entity = new Abo();

		if (vo != null) {
			BeanUtils.copyProperties(vo, entity);
		}

		return entity;
	}
}
