<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page language="java"%>
<%@ page import="com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page import="java.io.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="java.awt.Graphics2D" %>
<%@ page import="java.awt.geom.AffineTransform" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGCodec" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGImageEncoder" %>


<%@ page import="java.awt.Image" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.swing.ImageIcon" %>

<%@ page import="java.awt.image.PixelGrabber" %>
<%@ page import="java.io.File"%>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.imageio.ImageIO" %>

<%

	String default_charset = "utf-8";
	// ZLIB_COMP,LZSS_COMP,XML
	int default_encode_method = PlatformRequest.ZLIB_COMP;
		
	PlatformRequest platformRequest = new PlatformRequest(request, default_charset);

	PlatformResponse platformResponse = new PlatformResponse(response, default_encode_method, default_charset);
	//System.out.println("--->" + request.getContentLength());	
	PlatformData in_data = null;
 
	VariableList out_vl = new VariableList();
	DatasetList  out_dl = new DatasetList();
	
	try { 

	 	if ( request.getContentLength() > 0 )
	 	{
			 platformRequest.receiveData();
	 	}
	 	else
	 	{
			out_vl.addStr("ErrorCode", "-1");
			out_vl.addStr("ErrorMsg","입력할 Dataset를 넘겨받지 못하였습니다.");
			platformResponse.sendData(out_vl, out_dl);
			return;
	 	}
 	
		in_data = platformRequest.getPlatformData();
			
		VariableList in_vl = platformRequest.getVariableList();
		DatasetList in_dl = platformRequest.getDatasetList();
	
		Dataset inds = in_data.getDatasetList().getDataset("input");
		Dataset inds2 = in_data.getDatasetList().getDataset("input2");
	
		if (inds2 == null)
		{
			out_vl.addStr("ErrorCode", "-1");
			out_vl.addStr("ErrorMsg","입력 Dataset을 찾을 수 없습니다.[input]");
			platformResponse.sendData(out_vl, out_dl);
			return;
		}
		
		String id ="";
		String sigungu_code ="";
		
		for (int i = 0 ; i < inds2.getRowCount(); i++)
		{
			id = inds2.getColumn(i, "OFFI_ID").toString();
			sigungu_code = inds2.getColumn(i, "SIGUNGU_CODE").toString();
		}
		
		if (inds == null)
		{
			out_vl.addStr("ErrorCode", "-1");
			out_vl.addStr("ErrorMsg","입력 Dataset을 찾을 수 없습니다.[input]");
			platformResponse.sendData(out_vl, out_dl);
			return;
		}
		
		int irow = inds.getRowCount();
	
		int nrow = 0;
		
		/* 기본 설정 */

		for (int i = 0 ; i < irow ; i++)
		{
			String filename;
			
			Variant aa;
			System.out.println("filename:" + inds.getColumn(i, "file_name") + ", path:" + inds.getColumn(i, "path") + 	", filesize:" + inds.getColumn(i, "filesize"));
			
			byte[] file = inds.getColumn(i, "content").getBinary();
	
			filename = inds.getColumn(i, "file_name").toString();
			//System.out.println(file);		
			ByteArrayInputStream is = new ByteArrayInputStream(file);
	
			//String filePath = "/data/webroot/ICCSM/file/User";
			String filePath = "/data/webroot/ICCSM/file/User/"+sigungu_code+"/"+id;
			//filePath = "D:\\work\\JSP_Project\\iccsm\\file\\User\\"+sigungu_code+"\\"+id;
			String descfilePath = filePath;
			KJFFile.dirMake(filePath);
			
			filePath = filePath + "/" + filename;
			//filePath = filePath + "\\" + filename;
			
			FileOutputStream s = new FileOutputStream(filePath);
			
			byte[] in = new byte[(int)file.length];  
			int len = 0;  
			int byteData = 0;
			int offset = 0;
			int ch;
			while ((len = is.read(in, offset, in.length)) != -1 );
			len = is.read(in, offset, in.length);
			
			s.write(in);			//서버로 파일 write
			
			is.close();
			s.close();
			
		
			///////////////////////////////////////////////////////////////
			// 이미지 확장자가 JPG로만 저장
				File src = new File(filePath); 
//				File dest =new File(filePath.replace(".bmp",".jpg").replace(".png",".jpg").replace(".gif",".jpg"));
				File dest =new File(filePath);
				int height = 140; int width = 118;
				Image srcImg = null;
				String suffix = src.getName().substring(src.getName().lastIndexOf(".")+1).toLowerCase();
				
				if (suffix.equals("bmp") || suffix.equals("png") || suffix.equals("jpg")){
					srcImg = ImageIO.read(src);
				} else {
					srcImg = new ImageIcon(src.toURL()).getImage();
				}
	
				int srcWidth = srcImg.getWidth(null);
				int srcHeight = srcImg.getHeight(null);
				int destWidth = -1, destHeight = -1;
	
				if (width == -1 ){
					destWidth = srcWidth;
				} else if (width > 0){
					destWidth = width;
				}
				
				if (height == -1 ){
					destHeight = srcHeight;
				} else if (height > 0){
					destHeight = height;
				}			
				
				if (srcWidth >= srcHeight){
					if (srcWidth > width){
						double ratio = ((double)srcWidth)/((double)width);
						destWidth = width;
						destHeight = (int)((double)srcHeight/ratio);
					} else {
						// if (gubun == 1){destWidth = srcWidth; destHeight=srcHeight;}
					}			
				} else {
					if (srcHeight > height){
						double ratio = ((double)srcHeight)/((double)height);
						srcHeight = height;
						destWidth = (int)((double)srcHeight/ratio);
					} else {
						// if (gubun == 1){destWidth = srcWidth; destHeight=srcHeight;}
					}			
						
				}
				//고정
				destWidth = width;
				destHeight = height;
				Image imgTarget = srcImg.getScaledInstance(destWidth,destHeight,Image.SCALE_SMOOTH);
				int  pixels[] = new int[destWidth * destHeight];
				PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth, destHeight, pixels, 0, destWidth);
				
				try{
					pg.grabPixels();
				} catch(InterruptedException e){
					throw new IOException (e.getMessage());
				} catch(Exception e){
					e.printStackTrace();
				}
		   BufferedImage destImg =  new BufferedImage(destWidth,destHeight,BufferedImage.TYPE_INT_RGB);
		   destImg.setRGB(0,0,destWidth,destHeight,pixels,0 , destWidth);

		  if (suffix.equals("bmp")){
			 ImageIO.write(destImg,"bmp", dest);
			} else if  (suffix.equals("png")){
			 ImageIO.write(destImg,"png", dest);
			} else if  (suffix.equals("jpg")){
			 ImageIO.write(destImg,"jpg", dest);
			}
			// src.delete();

	///////////////////////////////////////////////////////////////
			
			
			// 이미지 축소 85*113
/*			   int maxDim = 140;
				 Image inImage = new ImageIcon(filePath).getImage();
			   double scale = (double)maxDim/(double)inImage.getHeight(null);
			   if (inImage.getWidth(null) > inImage.getHeight(null)) {
			   	scale = (double)maxDim/(double)inImage.getWidth(null);
			   }
			   
			   int scaledW = (int)(scale*inImage.getWidth(null));
			   int scaledH = (int)(scale*inImage.getHeight(null));
						   
			   BufferedImage outImage = new BufferedImage(scaledW, scaledH, BufferedImage.TYPE_INT_RGB);
			   
			   AffineTransform tx =  new AffineTransform();
			   
			   if (scale < 1.0d) { tx.scale(scale, scale);}
			   
			   Graphics2D g2d =  outImage.createGraphics();
			   g2d.drawImage(inImage, tx, null);
			   g2d.dispose();
			   
			   OutputStream os =  new FileOutputStream(filePath);
			   
				 JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
				 encoder.encode(outImage);	
			   os.close();
			   
			break;
			*/
			
		} //for

	} catch(IOException io){
		io.printStackTrace();
	} catch(Exception ex){
		ex.printStackTrace();
	}
	
		
	out_vl.addStr("ErrorCode", "0");
	out_vl.addStr("ErrorMsg","OK");
	
	PlatformData pdata = new PlatformData (out_vl, out_dl);

	platformResponse.sendData(out_vl, out_dl);

	
	
%>