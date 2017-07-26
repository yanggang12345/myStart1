package com.bdqn.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

/**
 * 生成验证码
 * <p>Title:RandomCodeGenerator<p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author 123456
 * <p>杨刚</p>
 */

public class RandomCodeGenerator {
	private static final char[] CHARS = "abcdefghijkmnpqrstovwxyz0123456789".toCharArray();
	private int length;
	private int fontSize = 14;
	private String randomCode = null;

	public RandomCodeGenerator(int length) {
		this.length = length;
	}

	public RandomCodeGenerator() {
		this(4);
	}

	public String getRandomCode() {
		if (randomCode == null) {
			// 生成验证码
			this.randomCode = initRandomCode();
		}
		return randomCode;
	}

	// 初始化验证码
	private String initRandomCode() {
		Set<Character> chars = new HashSet<>();
		Random r = new Random();
		while(chars.size() != length) {
			chars.add(CHARS[r.nextInt(CHARS.length)]);
		}
		
		char[] cs = new char[chars.size()];
		int index = 0;
		for (char c : chars) {
			cs[index++] = c;
		}
		return new String(cs).toUpperCase();
	}

	public BufferedImage generator(OutputStream output) throws IOException {
		int width = length * (fontSize + 2) + 10;
		int height = fontSize + 10;
		//创建一个缓存图片对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//得到画笔对象
		Graphics2D g = (Graphics2D)image.getGraphics();
		//设置前景色
		g.setColor(Color.PINK);
		//使用前景色填充距形
		g.fillRect(0, 0, width, height);
		Random r = new Random();
		//绘制干扰线
		for(int i = 0; i < 3; i++){
			//生成随机颜色
			Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			g.setColor(c);
			//画线
			g.drawLine(r.nextInt(width / 2), r.nextInt(height), r.nextInt(width / 2) + width / 2, r.nextInt(height));
		}
		
		g.setColor(Color.WHITE);
		Font font = new Font("Cooper Std", Font.PLAIN, fontSize);
		//设置字体
		g.setFont(font);
		if(randomCode == null)
			this.randomCode = getRandomCode();
		for(int i = 0; i < randomCode.length(); i++){
			//画字符
			g.drawString(randomCode.substring(i, i+1), 8 + fontSize * i, height / 2 + fontSize / 2);
		}
		//完成，并将验证码放入session中
		ServletActionContext.getRequest().getSession().setAttribute("checkCode", randomCode);
		image.flush();
		return image;
		
	}
	
	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	
	public static void main(String[] args) {
		RandomCodeGenerator rcg = new RandomCodeGenerator(6);
		System.out.println(rcg.getRandomCode());
		try {
			rcg.generator(new FileOutputStream("F:/a.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
