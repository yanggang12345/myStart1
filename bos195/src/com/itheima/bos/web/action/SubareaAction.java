package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Region;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.utils.FileUtils;
import com.itheima.bos.web.action.base.BaseAction;
/**
 * 分区管理
 */
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	
	public String add(){
		subareaService.save(model);
		return "list";
	}
	public String pageQuery() throws IOException{
		//在查询之前，封装条件
		DetachedCriteria detachedCriteria2 = pageBean.getDetachedCriteria();
		String addresskey=model.getAddresskey();
		Region region=model.getRegion();
		
		if(StringUtils.isNotBlank(addresskey)){
			//按照地址关键字模糊查询
			detachedCriteria2.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		
		if(region !=null){
			//创建别名，用于多表联查
			detachedCriteria2.createAlias("region", "r");
			String province=region.getProvince();
			String city=region.getCity();
			String district=region.getDistrict();
			
			if(StringUtils.isNotBlank(province)){
				//按照省进行模糊查询
				detachedCriteria2.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)){
				//按照省进行模糊查询
				detachedCriteria2.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)){
				//按照省进行模糊查询
				detachedCriteria2.add(Restrictions.like("r.district", "%"+district+"%"));
			}
		}
		subareaService.pageQuery(pageBean);
		String[] excludes=new String[]{"currentPage","detachedCriteria","pageSize","subareas","decidedzone"};
		this.writePageBean2Json(pageBean, excludes);
		return NONE;
	}
	/*
	 * 使用POI导入Excel文件，提供下载
	 */
	public String exportXls() throws IOException{
		List<Subarea> list=subareaService.findAll();
		
		//在内存中创建一个Excel文件，通过输出流写到客户端提供下载
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建一个sheet页
		HSSFSheet sheet=workbook.createSheet("分区数据");
		//创建标题行
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("区域编码");
		headRow.createCell(2).setCellValue("关键字");
		headRow.createCell(3).setCellValue("起始号");
		headRow.createCell(4).setCellValue("结束号");
		headRow.createCell(5).setCellValue("单双号");
		headRow.createCell(6).setCellValue("位置信息");
		
		for (Subarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getRegion().getId());
			dataRow.createCell(2).setCellValue(subarea.getAddresskey());
			dataRow.createCell(3).setCellValue(subarea.getStartnum());
			dataRow.createCell(4).setCellValue(subarea.getEndnum());
			dataRow.createCell(5).setCellValue(subarea.getSingle());
			Region region = subarea.getRegion();
			dataRow.createCell(6).setCellValue(region.getProvince()+region.getCity()+region.getDistrict());
			
		}
		String filename="分区数据.xls";
		String agent=ServletActionContext.getRequest().getHeader("User-Agent");
		filename=FileUtils.encodeDownloadFilename(filename, agent);
		//一个流两个头
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		
		ServletActionContext.getResponse().setContentType(contentType);
		ServletActionContext.getResponse().setHeader("content-disposition", "attchment;filename="+filename);
		workbook.write(out);
		return NONE;
	}
	/*
	 * 查询没有关联到定区的分区
	 */
	public String listajax() throws IOException{
		
		List<Subarea> list=subareaService.findListNotAssociation();
		String[] excludes=new String[]{"decidedzone","region"};
		this.writeList2Json(list, excludes);
		return NONE;
		
	}
}
