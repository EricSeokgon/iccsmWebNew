package kjf.util;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * <p>Subsystem     :  </p>
 * <p>Title         : 기본적인 이미지 유틸함수 </p>
 * <p>Description   : 기본적인 이미지 유틸함수를 구현하여 제공. </p>
 * <p>관련 TABLE      : </p>
 * @author 김경덕
 * @version 1.0 2003.05.29 <br/>
 */
public class KJFImg {
	
	//=====================================================
	/*********************************************************************
	<%@ page contentType="text/html; charset=ksc5601" %>
	<%@ page import="java.io.*" %>
	<%@ page import="java.net.*" %>
	<%@ page import="kjf.cfg.*" %>
	<%@ page import="kjf.util.*" %>
	<img src="
	<%
		String path = "D:\\work\\JSP_Project\\attache\\career\\07010515314307.JPG";
		File file = new File(path);
	
		int fileSize = (int)file.length();  //파일 크기
		response.setHeader("Content-Length", ""+fileSize); 
	
		//파일 스트림을 저장하기 위한 바이트 배열 생성.  
		byte bytestream[] = new byte[fileSize]; 
	
		//파일 객체를 스트림으로 불러온다.
		out.clear();
		BufferedInputStream Bfin = new BufferedInputStream(new FileInputStream(file)); 
		BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream()); 
		int read = 0; 
		while ((read = Bfin.read(bytestream)) != -1){ 
		outs.write(bytestream,0,read); 
		} 
	%>
	">
	<%
		file = new File(path);
		KJFImg.resize(file, "D:\\work\\JSP_Project\\attache\\career\\dest\\", "07010515314307.JPG", 100, 100 );
	%>
	 **********************************************************************/
	
	public static final int SAME = -1;
	public static final int RATIO = 0;
	
	/**
	 * 이미지 리사이즈
	 * @param src          File
	 * @param path         String
	 * @param destFileName String
	 * @param width        int
	 * @param height       int
	 * @throws Exception
	 */
	public static void resize(File src, String path, String destFileName,  int width, int height) throws Exception{
		
		/*********************************************
		 * 이미지 섬네일(
		 * File file = new File(path + filename); // 실제 저장한 파일
		 * File dest = new File(path + "/Thumbnail/" + filename);
		 * KJFImg.resize(file, dest, destPath, 100, 100 );
		 *********************************************/
		
		File destFile 	= new File(path+destFileName);
		File destPath 	= new File(path);
		
		if(!destPath.exists()){
			destPath.mkdir();
			KJFLog.log("create folder : "+destPath);
		}
		
		FileInputStream fileinputstream = null;
		
		fileinputstream = new FileInputStream(src);
		resize(fileinputstream, destFile, width, height);
		
		if(fileinputstream != null){
			fileinputstream.close();
		}
	}
	
	/**
	 * 이미지 리사이즈
	 * @param src      InputStream
	 * @param dest     File
	 * @param width    int
	 * @param height   int
	 * @throws Exception
	 */
	public static void resize(InputStream src, File dest, int width, int height) throws Exception{
		
		BufferedImage srcImg = ImageIO.read(src);
		int srcWidth = srcImg.getWidth();
		int srcHeight = srcImg.getHeight();
		
		int destWidth = -1;
		int destHeight = -1;
		
		if(width == SAME){
			destWidth = srcWidth;
		}else if(width > 0){
			destWidth = width;			
		}
		
		if(height == SAME){
			destHeight = srcHeight;
		}else if(height > 0){
			destHeight = height;
		}
		
		if(width == RATIO && height == RATIO){
			destWidth = srcWidth;
			destHeight = srcHeight;
		}else if(width == RATIO){
			double ratio = ((double)destHeight)/((double)srcHeight);
			destWidth = (int)((double)srcWidth * ratio);
		}else if(height == RATIO){
			double ratio = ((double)destWidth)/((double)srcWidth);
			destHeight = (int)((double)srcHeight * ratio);			
		}
		
		BufferedImage destImg = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics2D g = destImg.createGraphics();
		g.drawImage(srcImg, 0,0, destWidth, destHeight, null);
		
		if(!dest.exists()){
			dest.mkdir();
		}
		
		ImageIO.write(destImg, "jpg", dest);
		
		KJFLog.log("end of resize" + destImg);
		
	}
	
	/**
	 * 썸네일 생성<br>
	 * ex)createThumbnail("c:/inetpub/c/big.jpg","c:/inetpub/c/big_result.jpg",320);
	 * @param soruce
	 * @param target
	 * @param targetW
	 * @throws Exception
	 */
    public static void createThumbnail(String soruce, String target, int targetW) throws Exception {
    	
        Image imgSource = new ImageIcon(soruce).getImage();

        if(imgSource != null){

	        int oldW = imgSource.getWidth(null);
	        int oldH = imgSource.getHeight(null);
	
	        int newW = targetW;
	        int newH = (targetW * oldH) / oldW;
	
	        Image imgTarget = imgSource.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	
	        int pixels[] = new int[newW * newH];
	
	        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, newW, newH, pixels, 0, newW);
	        pg.grabPixels();
	
	        BufferedImage bi = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_RGB);
	        bi.setRGB(0, 0, newW, newH, pixels, 0, newW);
	
	        FileOutputStream fos = new FileOutputStream(target);
	
	        JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(fos);
	
	        JPEGEncodeParam jep = jpeg.getDefaultJPEGEncodeParam(bi);
	        jep.setQuality(1, false);
	
	        jpeg.encode(bi, jep);
	
	        fos.close();	        
        }
    }
}
