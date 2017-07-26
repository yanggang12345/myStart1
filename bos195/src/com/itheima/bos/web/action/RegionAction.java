package com.itheima.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Region;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.utils.PinYin4jUtils;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {
	private File myFile;
	
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}



	/**
	 * 批量导入
	 * @return
	 * 
	 */
	public String importXls() throws Exception{
		String flag="1";
		try {
			HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(myFile));
			HSSFSheet sheet=workbook.getSheetAt(0);
			List<Region> list=new ArrayList<Region>();
			for(Row row :sheet){
				int rowNum=row.getRowNum();
				if(rowNum==0){
					//第一行：标题行，忽略
					continue;
				}
				String id=row.getCell(0).getStringCellValue();
				String province=row.getCell(1).getStringCellValue();
				String city=row.getCell(2).getStringCellValue();
				String district=row.getCell(3).getStringCellValue();
				String postcode=row.getCell(4).getStringCellValue();
				Region region=new Region(id, province, city, district, postcode, null, null, null);
				
				//城市编码---->>shijiazhuang
				city=city.substring(0,city.length()-1);
				String[] stringToPinyin = PinYin4jUtils.stringToPinyin(city);
				
				String citycode=StringUtils.join(stringToPinyin,"");
				
				//简码---》》HBSJZCA
				province=province.substring(0, province.length()-1);
				district=district.substring(0, district.length()-1);
				String info=province+city+district;
				String[] headByString = PinYin4jUtils.getHeadByString(info);
				String shortcode = StringUtils.join(headByString,"");
				
				region.setCitycode(citycode);
				region.setShortcode(shortcode);
				list.add(region);
			}
			regionService.saveBatch(list);
		} catch (Exception e) {
			flag="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
		
	}
	
	
	/*
	 * 分页查询
	 */
	 public String pageQuery() throws IOException{
		
		 regionService.pageQuery(pageBean);
		 
		 this.writePageBean2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
		 return NONE;
	 }
	 
	 private String q;
	 /*
	  * 查询所有的区域数据，返回json
	  */
	 public String getQ() {
		return q;
	}



	public void setQ(String q) {
		this.q = q;
	}



	public String listajax() throws IOException{
		 List<Region> list=null;//regionService.findAll();
		 if(StringUtils.isNotBlank(q)){
			 list=regionService.findByQ(q);
		 }else{
			 list=regionService.findAll();
		 }
		 String[] excludes=new String[]{"subareas"};
		 this.writeList2Json(list, excludes);
		return NONE;
	 }



	

}
