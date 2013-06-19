<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="kjf.ops.*" %>
<%@ page import="kjf.util.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="/KJFTags" prefix="KTags" %>


<KTags:KJFSelect item="<%=(Vector)request.getAttribute("v_scSGG_CD")%>"
				 name="SIGUNGU_CODE"
				 value=""
				 script="class='input_bbs' "/>   