package com.misu.utils;


import java.awt.Color;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.util.Random;

	import javax.imageio.ImageIO;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	/**
	 * 生成图片验证码
	 */
@WebServlet("/PictureValidate.do")
public class PictureValidate extends HttpServlet {
		private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	        //int m = 0xFFFF; 16进制
	        //int n = 020;8进制
			HttpSession session = request.getSession(); 
			// 1.创建画布对象（默认为黑色）
			BufferedImage image = new BufferedImage(70, 40, BufferedImage.TYPE_3BYTE_BGR);
			// 将画布上每个像素块都设置为不同的颜色
			// for (int i = 0; i < 100; i++) {
			// for (int j = 0; j < 30; j++) {
			// image.setRGB(i, j, (int) (Math.random() * 0xFF0000));
			// }
			// }
			// 2.创建画笔对象
			Graphics g = image.getGraphics();
			// 设置画笔的颜色
			g.setColor(Color.white);
			// // 利用画笔将画布改为白色
			g.fillRect(0, 0, image.getWidth(), image.getHeight());

			// 3.在画布上写字
			// 重新调整画笔的颜色
			g.setColor(Color.RED);
			// 设置文字的字体，字形，大小
			Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
			g.setFont(font);
			// 随机写入字符和数字，共四位
			Random random = new Random();
	        //接收最终产生的验证码
			StringBuffer buffer = new StringBuffer();
	        //接收所有的数字和英文字母大小写
			String str = "";
			for (char i = 'a'; i <= 'z'; i++) {
				str += i;
			}
			for (char i = 'A'; i <= 'Z'; i++) {
				str += i;
			}
			for (int i = 0; i <= 9; i++) {
				str += (i + "");
			}
			char[] charArray = str.toCharArray();
			int len = charArray.length;
	         //随机产生四个作为验证码
			for (int i = 0; i < 4; i++) {
	            //随机数
				int  index = random.nextInt(len);
	            //随机画笔颜色
				g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
	            //写在什么位置
				g.drawString(charArray[index]+"", i*15+9, image.getHeight()/2);
				buffer.append(charArray[index]);
			}
	        session.setAttribute("vcode", buffer.toString());
	        System.out.println(buffer.toString());
			// 在图片上加五条干扰项
			for (int i = 0; i < 5; i++) {
				// 随机画笔的颜色
				g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
				int x1 = random.nextInt(image.getWidth());
				int y1 = random.nextInt(image.getHeight());
				int x2 = random.nextInt(image.getWidth());
				int y2 = random.nextInt(image.getHeight());
	         //随机划线
				g.drawLine(x1, y1, x2, y2);
			}

			// 将创建的图片输出到浏览器
			// 告诉浏览器返回的数据类型 // mimeType:text/html text/css test/js video/mp4 video/avi image/png
			response.setContentType("image/png");
			// 获取字节输出流，将图片输出到浏览器
			OutputStream out = response.getOutputStream();
	        //利用ImageIO将图片写入
			ImageIO.write(image, "png", out);
	        //关闭流		
			out.close();
		}

	}

