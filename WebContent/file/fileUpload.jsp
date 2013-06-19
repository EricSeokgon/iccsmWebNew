<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.io.*"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="java.awt.Graphics2D" %>
<%@ page import="java.awt.Image" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.awt.geom.AffineTransform" %>
<%@ page import="javax.swing.ImageIcon" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGCodec" %>
<%@ page import="com.sun.image.codec.jpeg.JPEGImageEncoder" %>
<%@ page import="sp.webservice.UBAgentPortTypeProxy" %>

<%
    	String _cookie = null;
    	Cookie theCookie = null;
    	Cookie cookies[] = request.getCookies();
    	if (cookies != null) {
		    for(int i=0, n=cookies.length; i < n; i++) {
		    	theCookie = cookies[i];
		    	if (theCookie.getName().equals("FileParam")) {
			        try {
			        	_cookie = theCookie.getValue().toString();
			        } catch (NumberFormatException ignored) {
			        	_cookie = null;
			        }
			        	break;
		      	}
		    }
    	}

//System.out.println("_cookie --->[" + _cookie + "]");
    	
		String rtn_val = "";
		String sido_code = request.getParameter("sido_code");
		String sigg_code = request.getParameter("sigg_code");
		
		String pathType = request.getParameter("pathType");
		String idpath = request.getParameter("idpath");
		String sv_url = request.getParameter("sv_url");

    int len = request.getContentLength();
    //InputStream _istream = new BufferedInputStream(request.getInputStream());
    InputStream _istream = request.getInputStream();

		String confPath = config.getServletContext().getRealPath("");
		
		String filePath = confPath + "/"+pathType+"/" +sido_code+"/" ;
		
		if("usebefore".equals(pathType)){		
			filePath += sigg_code+"/"+idpath+"/";
		}else if("cytyseal".equals(pathType)){		
			filePath = confPath + "/"+pathType+"/"+ sigg_code+"/";
		}else if("User".equals(pathType)){		
			filePath = confPath + "/file/"+pathType+"/"+ sido_code + "/" + idpath+ "/";
			//filePath = confPath + "/file/"+pathType+"/"+ sigg_code + "/" + idpath+ "/";		
			//filePath = confPath + "\\file\\"+pathType+"\\"+ sigg_code + "\\" + idpath+ "\\";			
		}else if("Offseal".equals(pathType)){		
			filePath = confPath + "/file/"+pathType+"/" + sigg_code + "/" + idpath+ "/";			
		}else{ 	
			if(!"N".equals(idpath)){			
				filePath += idpath+"/";
			}
		}

		KJFFile.dirMake(filePath);
		
		filePath += _cookie;
		System.out.println("filePath --->[" + filePath + "]");	
		//OutputStream s = new BufferedOutputStream(new FileOutputStream(filePath));
		
		OutputStream s = new FileOutputStream(filePath);
			
		byte[] buffer = new byte[8192];
		int size = buffer.length;
			
		while (true) {
				int n = _istream.read(buffer);
				
				if (n <= 0) {
					break;
				}
				s.write(buffer, 0, n);
				
		}
			
		s.close();
		
		if ("User".equals(pathType)){		
			 int maxDim = 140;
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
			}			
		
///////////////////////////////////////////////////////////////
 
		
		
///////////////////////////////////////////////////////////////
    	theCookie = null;
    	rtn_val = "SUCC::" ;
    	
//System.out.println(rtn_val);
    	theCookie = new Cookie ("FileParam", rtn_val);
    	response.setContentType("text/html");
    	response.addCookie(theCookie);
    	
    	if("usebefore".equals(pathType)){
			UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(sv_url+"/iccsWs/services/UBAgent");  
			String key= KJFSec.encode(sigg_code);   
			File file = new File(filePath); 
			int result = ub.setFile(key,KJFFile.readFromFile(file),idpath,_cookie);
			System.out.println("발송 값 : "+result);
			System.out.println("0 : 전송실패");
			System.out.println("1 : 완료 ");
		}
   	
  	
%>

