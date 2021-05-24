package cn.ekgc.witmed.dictionary.controller;

import cn.ekgc.witmed.base.controller.BaseController;
import cn.ekgc.witmed.base.pojo.vo.PageQueryVO;
import cn.ekgc.witmed.base.pojo.vo.PageVO;
import cn.ekgc.witmed.base.pojo.vo.ResponseVO;
import cn.ekgc.witmed.pojo.dictionary.vo.AboVO;
import cn.ekgc.witmed.transport.dictionary.AboTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <b>智慧医疗-数据字典-abo控制层类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "智慧医疗-数据字典-证件类型控制层类", tags = "智慧医疗-数据字典-证件类型接口")
@RestController("AboController")
@RequestMapping("/dic/Abo")
public class AboController extends BaseController {
	@Autowired
	private AboTransport transport;

	/**
	 * <b>根据查询视图分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图分页查询")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryPageByQuery(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                                   @RequestBody AboVO queryVO) throws Exception {
		// 创建 QueryPageVO 对象
		PageQueryVO<AboVO> pageQueryVO = new PageQueryVO<AboVO>(
				new PageVO<AboVO>(pageNum, pageSize), queryVO);

		PageVO<AboVO> pageVO = transport.getPageByQuery(pageQueryVO);

		return ResponseVO.getSuccessResponseVO(new PageQueryVO<AboVO>(pageVO, queryVO));
	}

	/**
	 * <b>根据查询视图查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图列表查询")
	@PostMapping("/list")
	public ResponseVO queryListByQuery(@RequestBody AboVO queryVO) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getListByQuery(queryVO));
	}

	/**
	 * <b>保存视图</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存视图信息")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody AboVO vo) throws Exception {
		// 判断是否填写 code 情况
		if (vo.getCode() != null && !"".equals(vo.getCode().trim())) {
			// 根据编码查询相关视图，判断是否出现 code 重复现象
			AboVO selectVO = transport.getByCode(vo.getCode());
			// 此时用户所给定的 code 未被占用
			if (selectVO == null) {
				// 编码未被占用，可以使用
				if (transport.save(vo)) {
					return ResponseVO.getSuccessResponseVO("保存成功");
				} else {
					return ResponseVO.getErrorResponseVO("保存失败");
				}
			} else {
				return ResponseVO.getErrorResponseVO("该编码已被占用");
			}
		} else {
			return ResponseVO.getErrorResponseVO("请填写编码信息");
		}
	}

	/**
	 * <b>修改视图</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "修改视图信息")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody AboVO vo) throws Exception {
		// 判断是否出现修改 code 的情况
		if (vo.getCode() != null && !"".equals(vo.getCode().trim())) {
			// 根据编码查询相关视图，判断是否出现 code 重复现象
			AboVO selectVO = transport.getByCode(vo.getCode());
			// 此时用户所给定的 code 未被占用
			if (selectVO == null || selectVO.getId().equals(vo.getId())) {
				if (transport.update(vo)) {
					return ResponseVO.getSuccessResponseVO("修改成功");
				} else {
					return ResponseVO.getErrorResponseVO("修改失败");
				}
			} else {
				// 编码被占用
				return ResponseVO.getErrorResponseVO("编码已被占用");
			}
		} else {
			if (transport.update(vo)) {
				return ResponseVO.getSuccessResponseVO("修改成功");
			} else {
				return ResponseVO.getErrorResponseVO("修改失败");
			}
		}
	}

	/**
	 * <b>根据主键修改状态</b>
	 * @param id
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键修改状态")
	@GetMapping("/status/{id}/{status}")
	public ResponseVO changeStatus(@PathVariable("id") String id, @PathVariable("status") String status) throws Exception {
		// 创建视图对象
		AboVO vo = new AboVO();
		vo.setId(id);
		vo.setStatus(status);
		// 进行修改
		if (transport.update(vo)) {
			return ResponseVO.getSuccessResponseVO("修改成功");
		}

		return ResponseVO.getErrorResponseVO("修改失败");
	}

	/**
	 * <b>根据主键查询视图</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询视图信息")
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getById(id));
	}

	/**
	 * <b>根据编码查询视图</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据编码查询视图信息")
	@GetMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception {
		return ResponseVO.getSuccessResponseVO(transport.getByCode(code));
	}
}
