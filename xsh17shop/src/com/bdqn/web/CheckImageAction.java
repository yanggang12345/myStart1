package com.bdqn.web;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.bdqn.common.RandomCodeGenerator;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 检查验证码
 * <p>Title:CheckImageAction<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @date 2017年7月26日 下午3:58:56
 * @author 123456
 * <p>杨刚</p>
 */
public class CheckImageAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		OutputStream output = null;
		RandomCodeGenerator rcg = new RandomCodeGenerator();
		BufferedImage image = rcg.generator(output);
		ImageIO.write(image, "jpg", ServletActionContext.getResponse()
				.getOutputStream());
		return NONE;
	}
}
