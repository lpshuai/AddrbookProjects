package cn.ekgc.addrbook.pojo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <b>分页试图信息</b>
 * @param <E>
 * @version 5.0.0
 */
public class PageVO<E> implements Serializable {
	private static final long serialVersionUID = -5014591423229271519L;
	private Integer pageNum;                    // 当前页码
	private Integer pageSize;                   // 每页显示数量
	private List<E> list;                       // 分页列表
	private Long totalCount;                    // 总条数
	private Integer totalPage;                  // 总页数

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
