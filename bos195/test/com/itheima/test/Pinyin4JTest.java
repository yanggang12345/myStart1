package com.itheima.test;


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.itheima.bos.utils.PinYin4jUtils;

public class Pinyin4JTest {
	@Test
	public void test(){
		String province="河北省";
		String city="石家庄市";
		String district="长安区";
		
		//城市编码---->>shijiazhuang
		city=city.substring(0,city.length()-1);
		String[] stringToPinyin = PinYin4jUtils.stringToPinyin(city);
		
		String citycode=StringUtils.join(stringToPinyin,"");
		System.out.println(citycode);
		
		//简码---》》HBSJZCA
		province=province.substring(0, province.length()-1);
		district=district.substring(0, district.length()-1);
		String info=province+city+district;
		String[] headByString = PinYin4jUtils.getHeadByString(info);
		String shortcode="";
		shortcode = StringUtils.join(headByString,"");
		System.out.println(shortcode);
		
	}
}
