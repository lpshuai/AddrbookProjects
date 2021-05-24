package cn.ekgc.witmed.pojo.dictionary.vo;

import cn.ekgc.witmed.base.pojo.vo.BaseVO;
import cn.ekgc.witmed.pojo.dictionary.entity.Abo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

/**
 * <b>智慧医疗-数据字典-abo视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("智慧医疗-数据字典-Abo视图信息")
public class AboVO extends BaseVO {
	private static final long serialVersionUID = -4182058423274118452L;
	@ApiModelProperty("主键")
	private String id;                      // 主键
	@ApiModelProperty("文本信息")
	private String text;                    // 文本信息
	@ApiModelProperty("编码")
	private String code;                    // 编码
	@ApiModelProperty("说明")
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
	 * <b>根据实体信息转换为视图信息</b>
	 * @param entity
	 * @return
	 */
	public static AboVO parseFromEntity(Abo entity) {
		AboVO vo = new AboVO();

		if (vo != null) {
			BeanUtils.copyProperties(entity, vo);
		}

		return vo;
	}
}
