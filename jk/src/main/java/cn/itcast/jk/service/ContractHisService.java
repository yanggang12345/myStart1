package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ContractHisService {
	public List<Contract> findPage(Page page);		//分页查询
	public List<Contract> find(Map paraMap);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public ContractVO view(String contractId);		//关联对象的查询一个
	
	public void pigeinhole(String[] contractIds);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void pigeouthole(String[] contractIds);			//批量删除；支持整数型和字符串类型ID
	
}
