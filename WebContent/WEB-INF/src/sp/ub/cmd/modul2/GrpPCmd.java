/**
 * ���ϸ�   : GrpHCmd.java
 * ����     : ����� ���ڰ��� ���� cmd
 * �̷»���
 * CH00     : 2010/03/25 wbjeon
 */

package sp.ub.cmd.modul2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFDate;
import kjf.util.KJFFile;
import kjf.util.KJFLog;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.ub.UbParam;
import sp.webservice.UBAgentPortTypeProxy;

import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class GrpPCmd {
    
    private static DatasetList  dl = new DatasetList();
    
    private String send_plan_file_name =""; // ���������� ��� �뺸��
    private String send_plan_file_name2 =""; // ���������� ��� ����
    private String send_file_name = "";		// ������˻� ��� ����
    private String send_invest_file_name =""; // ������˻� �����߱�
    
    private String REG_NUM = "";		// ������ȣ (�ý���)
    private String CIV_RECV_NUM = "";	// �ο�������ȣ
    private String APPLPER_NM = "";		// ��û�� ������
    private String OPE_NAME = "";		// �ð��� ��ȣ��
    private String INSP_SPOT_ADDR = "";	// �ð����� �ּ�
    private String INSP_SPOT_DETAILADDR = "";	// �ð����� �����ּ�
    private String NAPPL_YN = "";		// �˻���(����/������)
    private String NAPPL_CAUSE ="";		// �˻���(������ ����)
    private String OFFICE_TYPE = "";	// ���๰ �뵵
    private String WORK_ITEM = "";		// �˻������
    private String RECV_DT = "";		// ��������
    private String WORK_ITEM_ETC = "";	// ��۰������� ����
    private String WORK_ITEM_ETC2 = "";	// ��۰������� ����
    private String AREA = "";			// ����
    private String NUM_FL = "";			// ����
    private String NUM_FL2 = "";			// ����
    private String BEF_PLANER_NAME = "";// ���� ��ü��
    private String APPLPER_REP = ""; 	// ��ǥ��
    private String COI_WRT_NUM = "";	// �������ȣ
    private String INSP_DT = "";		// �˻���
    
	private String ORPE_NM = "";		// [������] ������
	private String PLANER_NAME = "";	// [������] �ð���ü��
	private String PLANER_NM = "";		// [������] �����ڸ� 
	private String STRU_COMMIT_NUM =""; // [������] �����㰡��ȣ 
	private String STRU_ADDR_ADDR = ""; // [������] ���๰ ������ (�ּ�)
	private String STRU_ADDR_DETAILADDR = ""; // [������] ���๰ �󼼼����� (�ּ�2)

	private String SUV_APPL = "";		// [������] ���� ����(����/������/�������/����)
	private String INSP_OPIN ="";		// [������] ���� �ǰ�
	private String PRE_ITEM ="";		// [������] ���� ����
	
	private String ApplGugun="E"; 		//���ڰ��� �ý��� ����
	
	private String PLAN_ENT_CHG_YN ="";	//�����������ü�� ��������
	private String PLAN_ENT_CHG_YN_CONT ="";//����� �����������ü��
    
	public GrpPCmd() {
    }
    
    public void Grp_Exe(HttpServletRequest request, VariableList vl, ActionForm form) throws Exception {
    	UbParam pm = (UbParam)form;
    	
        String scRECV_NUM 		= vl.getValueAsString("admNum");
        String scSIDO_CODE 		= vl.getValueAsString("scSIDO_CODE");
        String scSIGUNGU_CODE 	= vl.getValueAsString("scSIGUNGU_CODE");
        
        String sendSysID		= vl.getValueAsString("sendSysID");
        String sendUserID		= vl.getValueAsString("sendUserID");
        String sendUserEmail	= vl.getValueAsString("sendUserEmail");
        String sendOrgName		= vl.getValueAsString("sendOrgName");
        String recvSysID		= vl.getValueAsString("recvSysID");
        String recvUserID		= vl.getValueAsString("recvUserID");
        
        String scServerAddr		= KJFUtil.print(vl.getValueAsString("scServerAddr"),"");	//�ñ��� ���� ����
        String process_nm		= KJFUtil.print(vl.getValueAsString("process_nm"),"BefUse");	//�������������,������˻���� ���ڰ��� ó�� ����
        
        ApplGugun		= KJFUtil.print(vl.getValueAsString("scAPPL_GUBUN"),"E");//���ڰ���ý��� ����
        
        /*  ���ڰ��� ����  �۾� */
        
        TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
    	TimeZone.setDefault(tz);
    	
        String ubID = ""+new Date().getTime();	//�� �۾� ����� ������ȣ ����
        
        String curDate			= KJFDate.getCurDatetime();
    	String curDateNoFormate = KJFDate.getChangDatePattern(curDate,"yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss");
    	
    	
    	pm.setSendSysID(sendSysID);
    	pm.setSendSysName("������Ż�����˻翬��ý���");
    	pm.setSendUserID(sendUserID);
    	pm.setSendUserEmail(sendUserEmail);
    	pm.setSendOrgName(sendOrgName);
    	pm.setSendDate(curDate);
    	pm.setSendDateNoFomate(curDateNoFormate);
    	pm.setRecvSysID(recvSysID);
    	pm.setRecvUserID(recvUserID);
    	pm.setScServerAddr(scServerAddr);
    	pm.setAdmNum(scRECV_NUM);
    	
    	pm.setScSIDO_CODE(scSIDO_CODE);
    	pm.setScSIGUNGU_CODE(scSIGUNGU_CODE);
    	pm.setUbID(ubID);
    	
    	if ("BefPlan".equals(process_nm)){
    		//���������� Ȯ�ΰ������
    		ebmsPlan_Query(pm); //���������� ������
    		ebmsPlanCall(pm);
    		if ("bsge".equals(pm.getScSIGUNGU_CODE())){
    			ebmsPlanCall2(pm);	//������ ����������
    		}
    	} else {
        	
        	ebms_Query(pm); //������˻� ������
        	
	    	//������˻� �������
	    	ebmsCall(pm);

	    	if ("����".equals(pm.getScNAPPL_YN())){
	    		//������˻� ��������
	    		ebmsCallInvest(pm);
	    	} else {
		    	//������˻� ��������
		    	ebmsCall_NAP_NO(pm); // �ο��� ��ȹ�
		    	//ebmsCall_NAP_INNER_NO(pm);
		    	ebmsCall_NAP_SIDO_NO(pm); // �õ� ��ȹ�
	    	}
    	}
    	
        request.setAttribute("dl", dl);  

    }
  
    
    /**
     * ���������� ���� ������
     * @param pm
     * @return
     * @throws Exception
     */    
    public void ebmsPlan_Query(UbParam pm) throws Exception {
       	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;
        
    	String selectSQL=
    		" SELECT WORK_ITEM_ETC AS WORK_ITEM_ETC2,PLANER_NAME,PLANER_NM,CIV_RECV_NUM, ORPE_NM,STRU_COMMIT_NUM, STRU_ADDR_ADDR,STRU_ADDR_DETAILADDR,CODE_NAME \n" +
    		" ,AREA,NUM_FL, USE,WORK_ITEM,WORK_ITEM_ETC,DECODE(SUV_APPL,'1','����',2,'������',3,'�������',4,'����') AS SUV_APPL,PCC.CODE_NAME AS OFFICE_TYPE,INSP_OPIN,RECV_DT,PRE_ITEM \n";
    	
    	String fromSQL = " FROM PT_UB_CONSTRUCTION PUC, PT_COM_CODE PCC  \n";
    	
    	String whereSQL = "WHERE RECV_NUM = '"	+ pm.getAdmNum()		+"' \n" +
    					  "  AND  SIDO_CODE = '"	+ pm.getScSIDO_CODE()	+"' \n" +
    					  "  AND  SIGUNGU_CODE = '"	+ pm.getScSIGUNGU_CODE()+"' \n" +
    					  "  AND PUC.USE = PCC.CODE(+) AND PCC.P_CODE='BLDDIV'";
    	  
   
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL); 
    	
    	if(rEntity != null){
        	if(rEntity.getRowCnt() > 0){
        		CIV_RECV_NUM 	= KJFUtil.print(rEntity.getValue(0, "CIV_RECV_NUM"),"");
        		ORPE_NM 		= KJFUtil.print(rEntity.getValue(0, "ORPE_NM"),"");
        		STRU_ADDR_ADDR 	= KJFUtil.print(rEntity.getValue(0, "STRU_ADDR_ADDR"))+ "" + KJFUtil.print(rEntity.getValue(0, "STRU_ADDR_DETAILADDR"));
        		AREA 	= KJFUtil.print(rEntity.getValue(0, "AREA"));
        		NUM_FL 	= KJFUtil.print(rEntity.getValue(0, "NUM_FL"));
        	    WORK_ITEM 		= KJFUtil.print(rEntity.getValue(0, "WORK_ITEM"),"").replace("//", "/");
				//WORK_ITEM_ETC   = KJFUtil.print(rEntity.getValue(0, "WORK_ITEM_ETC"),"").replace("//", "/").replace("�����������", "��������");
        	    
        	    WORK_ITEM_ETC   = KJFUtil.print(rEntity.getValue(0, "WORK_ITEM_ETC"),"").replace("//", "/");
        	    
        	    if (!"".equals(WORK_ITEM_ETC)){
	        	    if (WORK_ITEM_ETC.indexOf("��۰������ż���(") >=0){
	        	    	WORK_ITEM_ETC = WORK_ITEM_ETC.replace("���ż���","����")+"����"; 
	        	    }
        	    }
        	    WORK_ITEM_ETC2	= KJFUtil.print(rEntity.getValue(0, "WORK_ITEM_ETC2"));
        	    PLANER_NAME		= KJFUtil.print(rEntity.getValue(0, "PLANER_NAME"));
        	    PLANER_NM		= KJFUtil.print(rEntity.getValue(0, "PLANER_NM"));
				SUV_APPL		= KJFUtil.print(rEntity.getValue(0, "SUV_APPL"));        
				OFFICE_TYPE 	= KJFUtil.print(rEntity.getValue(0, "OFFICE_TYPE")); 
				INSP_OPIN 		= KJFUtil.print(rEntity.getValue(0, "INSP_OPIN")); 
				STRU_COMMIT_NUM = KJFUtil.print(rEntity.getValue(0, "STRU_COMMIT_NUM")); 
				RECV_DT			= KJFDate.getChangDatePattern(KJFUtil.print(rEntity.getValue(0, "RECV_DT")),"yyyyMMdd","yyyy.MM.dd");//KJFUtil.print(rEntity.getValue(0, "RECV_DT")); 
				PRE_ITEM 		= KJFUtil.print(rEntity.getValue(0, "PRE_ITEM"));
				
				pm.setScCIV_RECV_NUM(CIV_RECV_NUM.toUpperCase());
				
				if(CIV_RECV_NUM.length()>10){
					REG_NUM = Integer.toString( KJFUtil.str2int(pm.getScCIV_RECV_NUM().substring(11, pm.getScCIV_RECV_NUM().length())) );
				} else {
					REG_NUM = pm.getScCIV_RECV_NUM();
				}
        	}
    	}
    }
    
    
    /**
     * ���ڹ��� ���� ���� �Լ�(�̰͸� ȣ���ϸ� �� (������ ����)
     * @param pm
     * @throws Exception
     */
    public void ebmsPlanCall(UbParam pm ) throws Exception { 
    	    	
    	Random rand = new Random(System.currentTimeMillis());
    	
    	String destFolder = pm.getRecvUserID()
							+ pm.getSendSysID()
							+ pm.getRecvSysID()
							+ pm.getSendDateNoFomate()
							+ (rand.nextInt(9999) + 10000);
    	
//    	String dirPath = "D:\\work\\attache\\iccsm\\usebefore\\_ebms_dir\\";
    	String dirPath = Config.props.get("EBMS_FILE_DIR");
    	String embsPath = dirPath + pm.getSendUserID() + KJFFile.FILE_S + destFolder;
    	String filePath = embsPath + KJFFile.FILE_S;
    	
    	if(!makeEbmsPlanFile(pm, filePath)){
    		KJFLog.log("���� ���� ����");
    	}else{
    		KJFLog.log("���� ���� �Ϸ�");
    		if(!sendEbmsPlanFile(pm, filePath, destFolder)){
    			KJFLog.log("���� ���� ����");
        	}else{
        		KJFLog.log("���� ���� �Ϸ�");
        	}
    	}
    	
    	while(true){
            try{
            	KJFLog.log("���� ���� eof.inf");
            	Thread.sleep(1000);            	
            }catch(Exception e){
                System.out.println(e.toString());
            }
            break;
        }
    	
    	if(sendFile(pm, dirPath + "eof.inf", destFolder, "eof.inf")){
    		KJFLog.log("���� ���� eof.inf�Ϸ�");
    		File ebmsFiles = new File(embsPath);
    		
    		if(deleteEbmsFile(ebmsFiles)){
    			KJFLog.log(destFolder + " : ebms file deleted!");
    		}else{
    			KJFLog.log(destFolder + " : ebms file delete fail!");
    		}
    	}
    }
    
    /**
     * ���ڹ����� ���ڰ���� �۽����� ����
     * @param form
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean makeEbmsPlanFile(ActionForm form, String filePath)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    	String headerData 	= setHeaderFile(pm);	//header.inf ���� ����
    	String exchangeData = setExchangePlanFile(pm);	//exchange.xml ���� ����
    	String ozResultData = setAttachPlanFile(pm);	//attach_UBInvestResult.html ���� ����
    	
    	//header.inf ��  exchange.xml ���� ����
    	if( makeFile(filePath + "header.inf", headerData, "euc-kr") 
    			&& makeFile(filePath + "exchange.xml", exchangeData, "euc-kr")
    			&& makeFile(filePath + "attach_" + send_plan_file_name + ".html", ozResultData, "utf-8")){
    		
    		//���ϻ��� ����
    		flag = true;
    	}
    	
    	return flag;
    }
    
    
    /**
     * �������� exchange.xml ���� ���� ���� ������ (����������)
     * @param UbParam am
     * @return String
     * @throws Exception
     */
    private String setExchangePlanFile(UbParam pm)throws Exception{
    	StringBuffer xmlData  = new StringBuffer();
    	       	
    	if ("".equals(ORPE_NM)){
    		//send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+SUV_APPL.trim()+")"+pm.getScCIV_RECV_NUM();
    		send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+SUV_APPL.trim()+")"+REG_NUM;
    	} else if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    		send_plan_file_name = "���赵 Ȯ�� ��� �뺸��";
    	}
    	else {
    		//send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+ORPE_NM+"-"+SUV_APPL.trim()+")_"+pm.getScCIV_RECV_NUM();
    		send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+ORPE_NM+"-"+SUV_APPL.trim()+")_"+REG_NUM;
    	}
    	
    	xmlData.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>\n");
    	xmlData.append("<!DOCTYPE EXCHANGE SYSTEM \"exchange.dtd\">\n");
    	xmlData.append("<EXCHANGE>\n");
    	xmlData.append("	<HEADER>\n");
    	xmlData.append("		<COMMON>\n");
    	xmlData.append("			<SENDER>\n");
    	xmlData.append("				<SERVERID>" + pm.getSendSysID()		+ "</SERVERID>\n");
    	xmlData.append(" 				<USERID>"   + pm.getSendUserID() 	+ "</USERID>\n");
    	xmlData.append("				<EMAIL>"	+ pm.getSendUserEmail()	+ "</EMAIL>\n");
    	xmlData.append("			</SENDER>\n");
    	xmlData.append("			<RECEIVER>\n");
    	xmlData.append("				<SERVERID>" + pm.getRecvSysID()		+ "</SERVERID>\n");
    	xmlData.append("				<USERID>" 	+ pm.getRecvUserID()	+ "</USERID>\n");
    	xmlData.append("			</RECEIVER>\n");
    	xmlData.append("			<TITLE>������Ű��� ����ɻ��ǰ�("+SUV_APPL+")�뺸</TITLE>\n");
    	xmlData.append("			<CREATED_DATE>"	+ pm.getSendDate()		+ "</CREATED_DATE>\n");
    	
    	//�����ϰ�� ÷�������� ����
    	if ("����".equals(SUV_APPL)){
    		xmlData.append("			<ATTACHNUM>0</ATTACHNUM>\n");
    	} else {
    		xmlData.append("			<ATTACHNUM>1</ATTACHNUM>\n");
    	}
    	
    	xmlData.append("			<ADMINISTRATIVE_NUM>"+ pm.getAdmNum()		+ "</ADMINISTRATIVE_NUM>\n");
    	xmlData.append("		</COMMON>\n");
    	xmlData.append("		<DIRECTION>\n");
    	xmlData.append("			<TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("				<MODIFICATION_FLAG>\n");
    	xmlData.append("					<MODIFIABLE modifyflag=\"yes\"/>\n");
    	xmlData.append("				</MODIFICATION_FLAG>\n");
    	xmlData.append("			</TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("		</DIRECTION>\n");
    	xmlData.append("	</HEADER>\n");
    	xmlData.append("	<BODY><![CDATA[");
    	
    	if ("ggyc".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. �㰡�ο���-"+pm.getScCIV_RECV_NUM()+"("+ RECV_DT +") ȣ�� �����Դϴ�.\n");
    	}
    	else if ("gbus".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. �ο���-"+pm.getScCIV_RECV_NUM()+"("+ RECV_DT +") ȣ�� �����Դϴ�.\n");
    	}
    	else if ("gbcd".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. ���ð�-"+pm.getScCIV_RECV_NUM()+"("+ RECV_DT +") ȣ�� �����Դϴ�.\n");
    	}
    	else if ("gguw".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. ��������ΰ�-"+pm.getScCIV_RECV_NUM()+"("+ RECV_DT +") ȣ�� �����Դϴ�.\n");
    	}
     	else if ("cbji".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. �������߰����-"+pm.getScCIV_RECV_NUM()+"("+ RECV_DT +") ȣ�� �����Դϴ�.\n");
    	}
    	else if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. �ͻ��� ������ ������ ����մϴ�.\n");
    	}
    	else {
    		xmlData.append("        1. �����-"+pm.getScCIV_RECV_NUM()+"("+ RECV_DT +") ȣ�� �����Դϴ�.\n");
    	}
    	
    	if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        2. " + STRU_ADDR_ADDR + " �����㰡�� ���� ������Ű��� ���赵Ȯ�ΰ� �����Ͽ� ������Ű������ ��36���� ������ �ǰ� ���� ������Žü� ���� ���� � ���� �ɻ��ǰ��� ���Ӱ� ���� �뺸�մϴ�.\n\n");
    	}
    	else{
    	    xmlData.append("        2. ������Ű������ �� 36���� �ǰ� ������Ű��� ���赵Ȯ�ΰ� �����Ͽ� ���� ������Žü� ���� ���� �� �츮�� �Ұ����׿� ���� �ɻ��ǰ��� ���Ӱ� ���� �뺸�մϴ�.\n\n");
    	}
    	//xmlData.append("           ���� �� �츮�� �Ұ����׿� ���� �ɻ��ǰ��� ���Ӱ� ���� �뺸�մϴ�.\n");
    	xmlData.append("          ��. �� �� �� : " + ORPE_NM + " \n");
    	
    	
    	
    	if(!KJFUtil.isEmpty(NUM_FL)){
    		NUM_FL2 = "/"+NUM_FL;
    	
    		if (NUM_FL.indexOf("��") <0){
	    		if(NUM_FL.indexOf("F") < 0 || NUM_FL.indexOf("f") < 0 ){
		    		NUM_FL2 = NUM_FL + "F";   
		    	}
    		}
    	}
    	if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
        	xmlData.append("          ��. ��       ġ : " + STRU_ADDR_ADDR +" ("+NUM_FL+"��, "+"������ : "+AREA+"�� ) \n"); 
        	xmlData.append("          ��. �� �� �� : "+ OFFICE_TYPE+"\n");
    	}
    	else{
    	xmlData.append("          ��. ��  ġ : " + STRU_ADDR_ADDR +" ("+AREA+"�� /"+ NUM_FL2 +") \n"); 
    	
    	xmlData.append("          ��. �ֿ뵵 : "+ OFFICE_TYPE+"\n");
    	}
    	if (!KJFUtil.isEmpty(WORK_ITEM_ETC)){WORK_ITEM_ETC = " �� " + WORK_ITEM_ETC+" ��������";} else {WORK_ITEM_ETC=" ��������";}
    	
    	if(!KJFUtil.isEmpty(WORK_ITEM)){
	    	if ("/".equals(WORK_ITEM.substring(0,1))){
	    		WORK_ITEM = WORK_ITEM.substring(1,WORK_ITEM.length());
	    	}
	    	if (WORK_ITEM.lastIndexOf("/") >=0){
	    		WORK_ITEM = WORK_ITEM.substring(0, WORK_ITEM.length()-1);
	    	}
//	    	if(!"".equals(WORK_ITEM_ETC)){
//	    		WORK_ITEM = WORK_ITEM +",";
//	    	}
    	}
    	
    	
    	//xmlData.append("        �� �˻系��\n");
    	
    	if("������".equals(SUV_APPL )){
        	xmlData.append("          ��. �ɻ��� : " + WORK_ITEM+ WORK_ITEM_ETC + "\n");
        	xmlData.append("          ��. �ɻ��ǰ� : " + SUV_APPL + "\n");
    		xmlData.append("          ��. ������ ���� : " + INSP_OPIN + "\n"); //�߰�
    		xmlData.append("          ��. ���ϻ��� : " + PRE_ITEM + "\n"); //�߰�
    	} else if ("����".equals(SUV_APPL)){
    		xmlData.append("          ��. �ɻ��� : " + WORK_ITEM+ WORK_ITEM_ETC + "\n");
    		xmlData.append("          ��. �ɻ��ǰ� : " + SUV_APPL + ".  ��.\n");
    	} else {
        	xmlData.append("          ��. �ɻ��� : " + WORK_ITEM+ WORK_ITEM_ETC + "\n");
        	xmlData.append("          ��. �ɻ��ǰ� : " + SUV_APPL + "\n");
    	}
    	
    	if (!"����".equals(SUV_APPL)){
    		if (!"N".equals(ApplGugun)){
    			if ("cbji".equals(pm.getScSIGUNGU_CODE())){
    			xmlData.append("\n  ����  ���赵 Ȯ�� ��� �뺸�� 1��.  ��.\n");
    			}else{
    				xmlData.append("\n  �� �� : ���赵 Ȯ�� ��� �뺸�� 1��.  ��.\n");
    			}
    		}
    	}
    	
    	xmlData.append("	]]></BODY>\n");
    	
    	// �����ϰ�� ÷�������� ����
    	if (!"����".equals(SUV_APPL)){    		
    		xmlData.append("	<ATTACHMENTS>\n");
    		xmlData.append("		<ATTACHMENT filename=\"" + send_plan_file_name + ".html\">���赵 Ȯ��  ��� �뺸��("+ORPE_NM+"-"+SUV_APPL+") 1��</ATTACHMENT>\n");
    		xmlData.append("	</ATTACHMENTS>\n");
    	}
    	xmlData.append("</EXCHANGE>\n");
    	
    	return xmlData.toString();
    }
    
    
    /**
     * OZ ����Ʈ ��� ���� ���� ������[÷�ι�](����������)
     * @param pm
     * @return
     * @throws Exception
     */
    private String setAttachPlanFile(UbParam pm) throws Exception{
    	StringBuffer content = new StringBuffer();
    	
    	content.append("<html>\n");
        content.append("	<head>\n");
        content.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
        content.append("		<title>���赵 Ȯ�� ��� �뺸�� 1��</title>\n");
        content.append("	</head>\n");
        content.append("	<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n");
        content.append("	<iframe src=\"http://99.1.5.83/oz2/BeforeConsResultR.jsp?scRECV_NUM="+pm.getAdmNum()+"&SIDO_CODE="+pm.getScSIDO_CODE()+"&SIGUNGU_CODE="+ pm.getScSIGUNGU_CODE()+"\" width=\"100%\" height=\"100%\"></iframe>\n");
        content.append("	</body>\n");
        content.append("</html>\n");
        
        return content.toString();
    }
    
    /**
     * ������ ������ �ñ��� ������ �����Ѵ�. (����������)
     * @param ActionForm form
     * @param String filePath
     * @param String destFolder
     * @return boolean
     * @throws Exception
     */
    public boolean sendEbmsPlanFile(ActionForm form, String filePath, String destFolder)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    		
		if(sendFile(pm, filePath + "header.inf", destFolder, "header.inf")
				&& sendFile(pm, filePath + "exchange.xml", destFolder, "exchange.xml")
				&& sendFile(pm, filePath + "attach_" + send_plan_file_name + ".html", destFolder, "attach_" + send_plan_file_name + ".html")){
			flag = true;
			KJFLog.log("EBMS ���� ���� �Ϸ�");
		}else{
			flag = false;
			KJFLog.log("EBMS ���� ���� ����");
		}
    	return flag;
    }  
    
   //������ ���� ��� ���� 
    /**
     * ���ڹ��� ���� ���� �Լ�(�̰͸� ȣ���ϸ� �� (������ ����)
     * @param pm
     * @throws Exception
     */
    public void ebmsPlanCall2(UbParam pm ) throws Exception { 
    	    	
    	Random rand = new Random(System.currentTimeMillis());
    	
    	String destFolder = pm.getRecvUserID()
							+ pm.getSendSysID()
							+ pm.getRecvSysID()
							+ pm.getSendDateNoFomate()
							+ (rand.nextInt(9999) + 10000);
    	
//    	String dirPath = "D:\\work\\attache\\iccsm\\usebefore\\_ebms_dir\\";
    	String dirPath = Config.props.get("EBMS_FILE_DIR");
    	String embsPath = dirPath + pm.getSendUserID() + KJFFile.FILE_S + destFolder;
    	String filePath = embsPath + KJFFile.FILE_S;
    	
    	if(!makeEbmsPlanFileInvest(pm, filePath)){
    		KJFLog.log("���� ���� ����4");
    	}else{
    		KJFLog.log("���� ���� �Ϸ�4");
    		if(!sendEbmsPlanFileInvest(pm, filePath, destFolder)){
    			KJFLog.log("���� ���� ����4");
        	}else{
        		KJFLog.log("���� ���� �Ϸ�4");
        	}
    	}
    	
    	while(true){
            try{
            	KJFLog.log("���� ���� eof.inf4");
            	Thread.sleep(1000);            	
            }catch(Exception e){
                System.out.println(e.toString());
            }
            break;
        }
    	
    	if(sendFile(pm, dirPath + "eof.inf", destFolder, "eof.inf")){
    		KJFLog.log("���� ���� eof.inf�Ϸ�4");
    		File ebmsFiles = new File(embsPath);
    		
    		if(deleteEbmsFile(ebmsFiles)){
    			KJFLog.log(destFolder + " : ebms file deleted!");
    		}else{
    			KJFLog.log(destFolder + " : ebms file delete fail!");
    		}
    	}
    }
    
    /**
     * ���ڹ����� ���ڰ���� �۽����� ����
     * @param form
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean makeEbmsPlanFileInvest(ActionForm form, String filePath)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    	//String headerData 	= setHeaderFile(pm);	//header.inf ���� ����
    	//String exchangeData = setExchangePlanFile(pm);	//exchange.xml ���� ����
    	//String ozResultData = setAttachPlanFile(pm);	//attach_UBInvestResult.html ���� ����
    	String headerData 	= setHeaderFile_other(pm,"_Invest");	//header.inf ���� ����
    	String exchangeData = setExchangePlanFileInvest(pm,"_Invest");	//exchange.xml ���� ����
    	String ozResultData = setAttachPlanFileInvest(pm);	//attach_UBInvestResult.html ���� ����
    	
    	//header.inf ��  exchange.xml ���� ����
    	if( makeFile(filePath + "header.inf", headerData, "euc-kr") 
    			&& makeFile(filePath + "exchange.xml", exchangeData, "euc-kr")
    			&& makeFile(filePath + "attach_" + send_plan_file_name2 + ".html", ozResultData, "utf-8")){
    		
    		//���ϻ��� ����
    		flag = true;
    	}
    	
    	return flag;
    }
    
    
    /**
     * �������� exchange.xml ���� ���� ���� ������ (����������)
     * @param UbParam am
     * @return String
     * @throws Exception
     */
    private String setExchangePlanFileInvest(UbParam pm, String num)throws Exception{
    	StringBuffer xmlData  = new StringBuffer();
    	 /*      	
    	if ("".equals(ORPE_NM)){
    		//send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+SUV_APPL.trim()+")"+pm.getScCIV_RECV_NUM();
    		send_plan_file_name2 = "���赵 ���� ��� ����_("+SUV_APPL.trim()+")"+REG_NUM;
    	} else {
    		//send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+ORPE_NM+"-"+SUV_APPL.trim()+")_"+pm.getScCIV_RECV_NUM();
    		send_plan_file_name2 = "���赵 ���� ��� ����_("+ORPE_NM+"-"+SUV_APPL.trim()+")_"+REG_NUM;
    	}
    	    	*/
    	
    	if ("".equals(ORPE_NM)){
    		//send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+SUV_APPL.trim()+")"+pm.getScCIV_RECV_NUM();
    		send_plan_file_name2 = "���赵���� ��� ���� 1��";
    	} else {
    		//send_plan_file_name = "���赵 Ȯ�� ��� �뺸��_("+ORPE_NM+"-"+SUV_APPL.trim()+")_"+pm.getScCIV_RECV_NUM();
    		send_plan_file_name2 = "���赵���� ��� ���� 1��";
    	}
    	
    	xmlData.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>\n");
    	xmlData.append("<!DOCTYPE EXCHANGE SYSTEM \"exchange.dtd\">\n");
    	xmlData.append("<EXCHANGE>\n");
    	xmlData.append("	<HEADER>\n");
    	xmlData.append("		<COMMON>\n");
    	xmlData.append("			<SENDER>\n");
    	xmlData.append("				<SERVERID>" + pm.getSendSysID()		+ "</SERVERID>\n");
    	xmlData.append(" 				<USERID>"   + pm.getSendUserID() 	+ "</USERID>\n");
    	xmlData.append("				<EMAIL>"	+ pm.getSendUserEmail()	+ "</EMAIL>\n");
    	xmlData.append("			</SENDER>\n");
    	xmlData.append("			<RECEIVER>\n");
    	xmlData.append("				<SERVERID>" + pm.getRecvSysID()		+ "</SERVERID>\n");
    	xmlData.append("				<USERID>" 	+ pm.getRecvUserID()	+ "</USERID>\n");
    	xmlData.append("			</RECEIVER>\n");
    	xmlData.append("			<TITLE>������Ű��� ������ ���赵 ���� ���("+SUV_APPL+")����</TITLE>\n");
    	xmlData.append("			<CREATED_DATE>"	+ pm.getSendDate()		+ "</CREATED_DATE>\n");
    	
    	//�����ϰ�� ÷�������� ����
    	if ("����".equals(SUV_APPL)){
    		xmlData.append("			<ATTACHNUM>0</ATTACHNUM>\n");
    	} else {
    		xmlData.append("			<ATTACHNUM>1</ATTACHNUM>\n");
    	}
    	
    	//xmlData.append("			<ADMINISTRATIVE_NUM>"+ pm.getAdmNum()		+ "</ADMINISTRATIVE_NUM>\n");
    	xmlData.append("			<ADMINISTRATIVE_NUM>"+ pm.getAdmNum()		+ num+"</ADMINISTRATIVE_NUM>\n");
    	xmlData.append("		</COMMON>\n");
    	xmlData.append("		<DIRECTION>\n");
    	xmlData.append("			<TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("				<MODIFICATION_FLAG>\n");
    	xmlData.append("					<MODIFIABLE modifyflag=\"yes\"/>\n");
    	xmlData.append("				</MODIFICATION_FLAG>\n");
    	xmlData.append("			</TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("		</DIRECTION>\n");
    	xmlData.append("	</HEADER>\n");
    	xmlData.append("	<BODY><![CDATA[");
        xmlData.append("        ������Ű��� ������ ���赵 Ȯ�� ��û��(������ȣ-"+pm.getScCIV_RECV_NUM()+", " + RECV_DT + ")�� ���Ͽ�");
        xmlData.append(" ������Ű������ ��36���� ���Ͽ� ������ ����� ���Ӱ� ���� �����մϴ�.\n\n\n");
        xmlData.append("        �� ���䳻��\n");
    	
    	 	    	
    	xmlData.append("          1. ��û��(������) : " + ORPE_NM + " \n");
    	
    	if(!KJFUtil.isEmpty(NUM_FL)){
    		//NUM_FL = NUM_FL+"/";
    		NUM_FL = ", "+NUM_FL;
        	
    		if (NUM_FL.indexOf("��") <0){
	    		if(NUM_FL.indexOf("F") < 0 || NUM_FL.indexOf("f") < 0 ){
		    		NUM_FL = NUM_FL + "F";   
		    	}
    		}
		}    	
    	
    	xmlData.append("          2. ������ ���� : " + WORK_ITEM+ ", " + WORK_ITEM_ETC2 + "\n"); 
    	
    	xmlData.append("          3. ������� : "+ STRU_ADDR_ADDR + "  " + STRU_ADDR_DETAILADDR +" \n");
    	//xmlData.append("          ��. ��  ġ : " + STRU_ADDR_ADDR +" ("+AREA+"�� /"+ NUM_FL2 +") \n");
       	xmlData.append("          4. �뵵 �� �Ը� : "+ OFFICE_TYPE +" ("+AREA+"�� /"+ NUM_FL2 +") \n"); 
       	       	
      	//xmlData.append("          5. �ð���ü�� : " + PLANER_NAME + " / "+ PLANER_NM +"\n");
       	
   	 if (KJFUtil.isEmpty(PLANER_NAME)){
		xmlData.append("          5. �ð���ü�� : " + PLANER_NM + "\n");
 	}
 	else {
 		xmlData.append("          5. �ð���ü�� : " + PLANER_NAME+ "/" + PLANER_NM + "\n");
 	}
   	
       	
       	xmlData.append("          6. �˻��� : " + SUV_APPL + "\n");
    	
       	//xmlData.append("  ��     �� : ���� ��� ���� 1��.  ��.\n");
       	
    	if (!"����".equals(SUV_APPL)){
    		if (!"N".equals(ApplGugun)){
     			if ("cbji".equals(pm.getScSIGUNGU_CODE())){
        			xmlData.append("\n  ����  ���赵���� ��� ���� 1��.  ��.\n");
        			}else{
        			xmlData.append("  ��     �� : ���赵���� ��� ���� 1��.  ��.\n");
        			}
    			
    		}
    	}
    	
    	xmlData.append("	]]></BODY>\n");
    	
    	// �����ϰ�� ÷�������� ����
    	if (!"����".equals(SUV_APPL)){    		
    		xmlData.append("	<ATTACHMENTS>\n");
    		xmlData.append("		<ATTACHMENT filename=\"" + send_plan_file_name2 + ".html\">���赵���� ��� ���� 1��.  ��.</ATTACHMENT>\n");
    		xmlData.append("	</ATTACHMENTS>\n");
    	}
    	
    	xmlData.append("</EXCHANGE>\n");
    	
    	return xmlData.toString();
    }
    
    
    /**
     * OZ ����Ʈ ��� ���� ���� ������[÷�ι�](����������)
     * @param pm
     * @return
     * @throws Exception
     */
    private String setAttachPlanFileInvest(UbParam pm) throws Exception{
    	StringBuffer content = new StringBuffer();
    	
    	content.append("<html>\n");
        content.append("	<head>\n");
        content.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
        content.append("		<title>���赵 ���� ��� ���� 1��</title>\n");
        content.append("	</head>\n");
        content.append("	<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n");
        content.append("	<iframe src=\"http://99.1.5.83/oz2/BeforeConsResultNotiR.jsp?scRECV_NUM="+pm.getAdmNum()+"&SIDO_CODE="+pm.getScSIDO_CODE()+"&SIGUNGU_CODE="+ pm.getScSIGUNGU_CODE()+"\" width=\"100%\" height=\"100%\"></iframe>\n");
        content.append("	</body>\n");
        content.append("</html>\n");
        
        return content.toString();
    }
    
    /**
     * ������ ������ �ñ��� ������ �����Ѵ�. (����������)
     * @param ActionForm form
     * @param String filePath
     * @param String destFolder
     * @return boolean
     * @throws Exception
     */
    public boolean sendEbmsPlanFileInvest(ActionForm form, String filePath, String destFolder)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    		
		if(sendFile(pm, filePath + "header.inf", destFolder, "header.inf")
				&& sendFile(pm, filePath + "exchange.xml", destFolder, "exchange.xml")
				&& sendFile(pm, filePath + "attach_" + send_plan_file_name2 + ".html", destFolder, "attach_" + send_plan_file_name2 + ".html")){
			flag = true;
			KJFLog.log("EBMS ���� ���� �Ϸ�4");
		}else{
			flag = false;
			KJFLog.log("EBMS ���� ���� ����4");
		}
    	return flag;
    }  
    
    
    /**
     * ������˻� ���� ���� ������
     * @param pm
     * @return
     * @throws Exception
     */    
  public void ebms_Query(UbParam pm) throws Exception {
    	
    	ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;

        String selectSQL=
    		" SELECT CIV_RECV_NUM, APPLPER_NM, OPE_NAME, INSP_SPOT_ADDR, " +
    		" INSP_SPOT_DETAILADDR ,PROC_STE, NAPPL_YN,PCC.CODE_NAME AS OFFICE_TYPE,WORK_ITEM,"+
    		" PLAN_ENT_CHG_YN, PLAN_ENT_CHG_YN_CONT,"+
			" WORK_ITEM_ETC,AREA,USEBEFINSP_DELINUM,INSP_SPOT_NM,RECV_DT,NAPPL_CAUSE, NUM_FL,BEF_PLANER_NAME, APPLPER_REP,COI_WRT_NUM,INSP_DT \n"; //�߰�
    	
    	String fromSQL = " FROM PT_UB_USEBEFORE PUU, PT_COM_CODE PCC  \n";
    	
    	String whereSQL = "WHERE RECV_NUM = '"	+ pm.getAdmNum()		+"' \n" +
    					  "  AND  SIDO_CODE = '"	+ pm.getScSIDO_CODE()	+"' \n" +
    					  "  AND  SIGUNGU_CODE = '"	+ pm.getScSIGUNGU_CODE()+"' \n" +
    					  "  AND PUU.USE = PCC.CODE(+) --AND PCC.P_CODE='BLDDIV'";
    	
    	rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL); 
    	
    	if(rEntity != null){
        	if(rEntity.getRowCnt() > 0){
        		CIV_RECV_NUM 	= KJFUtil.print(rEntity.getValue(0, "CIV_RECV_NUM"));
        		APPLPER_NM 		= KJFUtil.print(rEntity.getValue(0, "APPLPER_NM"));
        	    OPE_NAME 		= KJFUtil.print(rEntity.getValue(0, "OPE_NAME"));
        	    INSP_SPOT_ADDR 	= KJFUtil.print(rEntity.getValue(0, "INSP_SPOT_ADDR"))+ "" + KJFUtil.print(rEntity.getValue(0, "INSP_SPOT_DETAILADDR"));
        	    INSP_SPOT_DETAILADDR = KJFUtil.print(rEntity.getValue(0, "INSP_SPOT_DETAILADDR"));
        	    NAPPL_YN 		= "1".equals(KJFUtil.print(rEntity.getValue(0, "NAPPL_YN")) )?"����":"������";//KJFUtil.print(rEntity.getValue(0, "NAPPL_YN"));
        	    OFFICE_TYPE 	= KJFUtil.print(rEntity.getValue(0, "OFFICE_TYPE"));
        	    WORK_ITEM 		= KJFUtil.print(rEntity.getValue(0, "WORK_ITEM"),"").replace("//", "/");
        	    RECV_DT			= KJFDate.getChangDatePattern(KJFUtil.print(rEntity.getValue(0, "RECV_DT")),"yyyyMMdd","yyyy.MM.dd");
				//WORK_ITEM_ETC   = KJFUtil.print(rEntity.getValue(0, "WORK_ITEM_ETC"),"").replace("//", "/").replace("�����������", "��������");
        	    WORK_ITEM_ETC   = KJFUtil.print(rEntity.getValue(0, "WORK_ITEM_ETC"),"").replace("//", "/");
        	    
        	    if (!"".equals(WORK_ITEM_ETC)){
	        	    if (WORK_ITEM_ETC.indexOf("��۰������ż���(") >=0){
	        	    	WORK_ITEM_ETC = WORK_ITEM_ETC.replace("���ż���","����")+"����"; 
	        	    }
        	    }        	    
        	    
			    AREA			= KJFUtil.print(rEntity.getValue(0, "AREA"));          //�߰� 
				NAPPL_CAUSE		= KJFUtil.print(rEntity.getValue(0, "NAPPL_CAUSE"));
				NUM_FL			= KJFUtil.print(rEntity.getValue(0, "NUM_FL"));
				BEF_PLANER_NAME	= KJFUtil.print(rEntity.getValue(0, "BEF_PLANER_NAME"));
				APPLPER_REP		= KJFUtil.print(rEntity.getValue(0, "APPLPER_REP"));
				COI_WRT_NUM		= KJFUtil.print(rEntity.getValue(0, "COI_WRT_NUM"));
				INSP_DT			= KJFDate.getChangDatePattern(KJFUtil.print(rEntity.getValue(0, "INSP_DT")),"yyyyMMdd","yyyy.MM.dd");//KJFUtil.print(rEntity.getValue(0, "INSP_DT"));
				
				PLAN_ENT_CHG_YN =  KJFUtil.print(rEntity.getValue(0, "PLAN_ENT_CHG_YN"),"");
				PLAN_ENT_CHG_YN_CONT =  KJFUtil.print(rEntity.getValue(0, "PLAN_ENT_CHG_YN_CONT"),"");
				
				pm.setScAPPLPER_NM(APPLPER_NM);
				pm.setScOPE_NAME(OPE_NAME);
				pm.setScNAPPL_YN(NAPPL_YN);
				pm.setScCIV_RECV_NUM(CIV_RECV_NUM.toUpperCase());
				
				if(CIV_RECV_NUM.length()>10){
					REG_NUM = Integer.toString( KJFUtil.str2int(pm.getScCIV_RECV_NUM().substring(11, pm.getScCIV_RECV_NUM().length())) );
				} else {
					REG_NUM = pm.getScCIV_RECV_NUM();
				}
				
		    	if(!KJFUtil.isEmpty(NUM_FL)){
		    		NUM_FL = NUM_FL+"F/";
		    		//NUM_FL = "/"+NUM_FL;
		        	
		    		if (NUM_FL.indexOf("��") <0){
			    		if(NUM_FL.indexOf("F") < 0 || NUM_FL.indexOf("f") < 0 ){
				    		//NUM_FL = NUM_FL + "F";   
			    			NUM_FL = NUM_FL;
				    	}
		    		}
        		}
		    	
		       	if(!KJFUtil.isEmpty(WORK_ITEM)){
			    	if ("/".equals(WORK_ITEM.substring(0,1))){
			    		WORK_ITEM = WORK_ITEM.substring(1,WORK_ITEM.length());
			    	}
			    	if (WORK_ITEM.lastIndexOf("/") >=0){
			    		WORK_ITEM = WORK_ITEM.substring(0, WORK_ITEM.length()-1);
			    	}
			    	if(!"".equals(WORK_ITEM_ETC)){
			    		WORK_ITEM = WORK_ITEM +",";
			    	}
		    	}
		    	
        	}
    	}
    }
    
    /**
     * ���ڹ��� ���� ���� �Լ�(�̰͸� ȣ���ϸ� ��
     * @param pm
     * @throws Exception
     */
    public void ebmsCall(UbParam pm ) throws Exception { 
    	    	
    	Random rand = new Random(System.currentTimeMillis());
    	
    	String destFolder = pm.getRecvUserID()
							+ pm.getSendSysID()
							+ pm.getRecvSysID()
							+ pm.getSendDateNoFomate()
							+ (rand.nextInt(9999) + 10000);
    	
//    	String dirPath = "D:\\work\\attache\\iccsm\\usebefore\\_ebms_dir\\";
    	String dirPath = Config.props.get("EBMS_FILE_DIR");
    	String embsPath = dirPath + pm.getSendUserID() + KJFFile.FILE_S + destFolder;
    	String filePath = embsPath + KJFFile.FILE_S;
    	
    	if(!makeEbmsFile(pm, filePath)){
    		KJFLog.log("���� ���� ����");
    	}else{
    		KJFLog.log("���� ���� �Ϸ�");
    		if(!sendEbmsFile(pm, filePath, destFolder)){
    			KJFLog.log("���� ���� ����");
        	}else{
        		KJFLog.log("���� ���� �Ϸ�");
        	}
    	}
    	
    	while(true){
            try{
            	KJFLog.log("���� ���� eof.inf");
            	Thread.sleep(1000);            	
            }catch(Exception e){
                System.out.println(e.toString());
            }
            break;
        }
    	
    	if(sendFile(pm, dirPath + "eof.inf", destFolder, "eof.inf")){
    		KJFLog.log("���� ���� eof.inf�Ϸ�");
    		File ebmsFiles = new File(embsPath);
    		
    		if(deleteEbmsFile(ebmsFiles)){
    			KJFLog.log(destFolder + " : ebms file deleted!");
    		}else{
    			KJFLog.log(destFolder + " : ebms file delete fail!");
    		}
    	}
    	

    }
    
    
    /**
     * ������ ������ �ñ��� ������ �����Ѵ�.
     * @param ActionForm form
     * @param String filePath
     * @param String destFolder
     * @return boolean
     * @throws Exception
     */
    public boolean sendEbmsFile(ActionForm form, String filePath, String destFolder)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    		
		if(sendFile(pm, filePath + "header.inf", destFolder, "header.inf")
				&& sendFile(pm, filePath + "exchange.xml", destFolder, "exchange.xml")
				&& sendFile(pm, filePath + "attach_" + send_file_name + ".html", destFolder, "attach_" + send_file_name + ".html")){
			flag = true;
			KJFLog.log("EBMS ���� ���� �Ϸ�");
		}else{
			flag = false;
			KJFLog.log("EBMS ���� ���� ����");
		}
    	return flag;
    }
    
    /**
     * ���ڹ����� ���ڰ���� �۽����� ����
     * @param form
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean makeEbmsFile(ActionForm form, String filePath)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    	String headerData 	= setHeaderFile(pm);	//header.inf ���� ����
    	String exchangeData = setExchangeFile(pm);	//exchange.xml ���� ����
    	String ozResultData = setAttachFile(pm);	//attach_UBInvestResult.html ���� ����
    	
    	//header.inf ��  exchange.xml ���� ����
    	if( makeFile(filePath + "header.inf", headerData, "euc-kr") 
    			&& makeFile(filePath + "exchange.xml", exchangeData, "euc-kr")
    			&& makeFile(filePath + "attach_" + send_file_name + ".html", ozResultData, "utf-8")){
    		
    		//���ϻ��� ����
    		flag = true;
    	}
    	
    	return flag;
    }

    private boolean deleteEbmsFile(File path) {
        if( path.exists() ) {
          File[] files = path.listFiles();
          for(int i=0; i<files.length; i++) {
             if(files[i].isDirectory()) {
            	 deleteEbmsFile(files[i]);
             }
             else {
               files[i].delete();
             }
          }
        }
        return( path.delete() );
      }
    
    
    /**
     * ���� ���� ����  �Լ�
     * @param file
     * @param data
     * @param charset
     * @return
     */
    private boolean makeFile(String file, String data, String charset){
    	boolean flag = false;
    	
    	try{
    		
    		String f = file;
    		
    		BufferedWriter fw = null;
    		
    		File filePath = new File(f);
    		File fileDir = filePath.getParentFile();  
    		fileDir.mkdirs();
    		
    		fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), charset)); 
    		fw.write(data);    		
    	    fw.close();
    	    
    	    flag = true;
    	   
	    }catch(Exception e){
	    	KJFLog.log(e.toString());
	    	e.printStackTrace();
	    }
	    
	    return flag;
    }
    
    /**
     * �����񽺸� �̿��Ͽ� �ñ��� ������ ���� ���� �����ϸ� true ��ȯ
     * @param UbParam pm
     * @param String sourceFile
     * @param String destFolder
     * @param String destFileName
     * @return boolean
     * @throws Exception
     */
    private boolean sendFile(UbParam pm, String sourceFile, String destFolder, String destFileName) throws Exception {
		boolean flag = false;
		String key= KJFSec.encode(pm.getScSIGUNGU_CODE());
		
		UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy(pm.getScServerAddr() + "/iccsWs/services/UBAgent");
		//UBAgentPortTypeProxy ub = new UBAgentPortTypeProxy("http://localhost/iccsWs/services/UBAgent");

		File file1 = new File(sourceFile);
		
		
		int result1 = ub.setEbmsFile(key
								,KJFFile.readFromFile(file1)
								,destFolder
								,destFileName);
		
		//int result1 = 1;
		
		if(result1 == 1){
			flag = true;
		}
		
		return flag;
	}
    
    
    /**
     * �������� ������� ���� ���� ������
     * @param UbParam pm
     * @return String
     * @throws Exception
     */
    private String setHeaderFile(UbParam pm)throws Exception{
    	StringBuffer content = new StringBuffer();
    	
    	content.append("type=send\n");
    	content.append("date=" 				+ pm.getSendDate()		+ "\n");
    	content.append("sender=" 			+ pm.getSendSysID()		+ "\n");
    	content.append("receiver=" 			+ pm.getRecvSysID()		+ "\n");
    	content.append("sender_userid=" 	+ pm.getSendUserID() 	+ "\n");
    	content.append("receiver_userid=" 	+ pm.getRecvUserID()	+ "\n");
    	content.append("sender_email=" 		+ pm.getSendUserEmail()	+ "\n");
    	content.append("sender_orgname="	+ pm.getSendOrgName()	+ "\n");
    	content.append("sender_systemname=" + pm.getSendSysName()	+ "\n");
    	content.append("administrative_num="+ pm.getAdmNum()		+ "\n");
    	
    	return content.toString();
    }

    
    /**
     * �������� ������� ���� ���� ������
     * @param UbParam pm
     * @return String
     * @throws Exception
     */
    private String setHeaderFile_other(UbParam pm,String num)throws Exception{
    	StringBuffer content = new StringBuffer();
    	
    	content.append("type=send\n");
    	content.append("date=" 				+ pm.getSendDate()		+ "\n");
    	content.append("sender=" 			+ pm.getSendSysID()		+ "\n");
    	content.append("receiver=" 			+ pm.getRecvSysID()		+ "\n");
    	content.append("sender_userid=" 	+ pm.getSendUserID() 	+ "\n");
    	content.append("receiver_userid=" 	+ pm.getRecvUserID()	+ "\n");
    	content.append("sender_email=" 		+ pm.getSendUserEmail()	+ "\n");
    	content.append("sender_orgname="	+ pm.getSendOrgName()	+ "\n");
    	content.append("sender_systemname=" + pm.getSendSysName()	+ "\n");
    	content.append("administrative_num="+ pm.getAdmNum()		+ num + "\n");
    	return content.toString();
    }
    /**
     * �������� exchange.xml ���� ���� ���� ������
     * @param UbParam pm
     * @return String
     * @throws Exception
     */
    private String setExchangeFile(UbParam pm)throws Exception{
    	StringBuffer xmlData  = new StringBuffer();
    	       	
    	if ("".equals(pm.getScAPPLPER_NM())){
    		//send_file_name = "�������()_"+pm.getScCIV_RECV_NUM();
    		send_file_name = "�������()_"+REG_NUM;    		
    	} else if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    		send_file_name = "������˻� �������";
    	} else {
    		//send_file_name = "�������("+pm.getScAPPLPER_NM().trim()+"("+pm.getScOPE_NAME().trim()+")"+pm.getScNAPPL_YN().trim()+")_"+pm.getScCIV_RECV_NUM();
    		send_file_name = "�������("+pm.getScAPPLPER_NM().trim()+"("+pm.getScOPE_NAME().trim()+")"+pm.getScNAPPL_YN().trim()+")_"+REG_NUM;    		
    	}
    	
    	xmlData.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>\n");
    	xmlData.append("<!DOCTYPE EXCHANGE SYSTEM \"exchange.dtd\">\n");
    	xmlData.append("<EXCHANGE>\n");
    	xmlData.append("	<HEADER>\n");
    	xmlData.append("		<COMMON>\n");
    	xmlData.append("			<SENDER>\n");
    	xmlData.append("				<SERVERID>" + pm.getSendSysID()		+ "</SERVERID>\n");
    	xmlData.append(" 				<USERID>"   + pm.getSendUserID() 	+ "</USERID>\n");
    	xmlData.append("				<EMAIL>"	+ pm.getSendUserEmail()	+ "</EMAIL>\n");
    	xmlData.append("			</SENDER>\n");
    	xmlData.append("			<RECEIVER>\n");
    	xmlData.append("				<SERVERID>" + pm.getRecvSysID()		+ "</SERVERID>\n");
    	xmlData.append("				<USERID>" 	+ pm.getRecvUserID()	+ "</USERID>\n");
    	xmlData.append("			</RECEIVER>\n");
    	//xmlData.append("			<TITLE>������Ű��� ������˻� �������(" + CIV_RECV_NUM.toUpperCase() + ")</TITLE>\n");
    	if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    	xmlData.append("			<TITLE>������Ű��� ������˻� �������(�ο� ��" + REG_NUM + "ȣ)</TITLE>\n");
    	}else{
    	xmlData.append("			<TITLE>������Ű��� ������˻� �������(" + REG_NUM + ")</TITLE>\n");
    	}
    	xmlData.append("			<CREATED_DATE>"	+ pm.getSendDate()		+ "</CREATED_DATE>\n");
    	xmlData.append("			<ATTACHNUM>1</ATTACHNUM>\n");
    	xmlData.append("			<ADMINISTRATIVE_NUM>"+ pm.getAdmNum()		+ "</ADMINISTRATIVE_NUM>\n");
    	xmlData.append("		</COMMON>\n");
    	xmlData.append("		<DIRECTION>\n");
    	xmlData.append("			<TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("				<MODIFICATION_FLAG>\n");
    	xmlData.append("					<MODIFIABLE modifyflag=\"yes\"/>\n");
    	xmlData.append("				</MODIFICATION_FLAG>\n");
    	xmlData.append("			</TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("		</DIRECTION>\n");
    	xmlData.append("	</HEADER>\n");
    	xmlData.append("	<BODY><![CDATA[");
    	
    	if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. �ο� ��"+REG_NUM+"(" + RECV_DT + ")ȣ�� �����Դϴ�.\n\n");
    		xmlData.append("        2. ������Ű��� ������˻� ��û�ǿ� ���Ͽ� ������Ű������ �� 36�� �� ���� ����� �� 36�� ������ ���Ͽ� �˻��� ����� �����մϴ�.\n\n");
    		xmlData.append("                              ��  �˻系�� ��\n\n");
    	}
    	else {
        	
        	xmlData.append("        ������Ű��� ������˻� ��û��(������ȣ-"+REG_NUM+" : " + RECV_DT + ")�� ���Ͽ�");
        	xmlData.append(" ������Ű������ ��36�� �� ���� �� ����� ��36�� ������ ���Ͽ� �˻��� ����� �����մϴ�.\n");
        	xmlData.append("        �� �˻系��\n");
    	}
    	
    	
    	xmlData.append("          - ��û��(������) : " + APPLPER_NM + "\n");
    	
    	xmlData.append("          - ������ ���� : " + WORK_ITEM + WORK_ITEM_ETC +"\n"); //����
    	xmlData.append("          - ������� : " + INSP_SPOT_ADDR + "\n");
    	
    	xmlData.append("          - �뵵 : "+ OFFICE_TYPE +"("+NUM_FL+AREA+"��)\n");    //�߰�
    	
    	if ("bsgs".equals(pm.getScSIGUNGU_CODE())){
    		if ("����".equals(PLAN_ENT_CHG_YN)){
    			int f_index = PLAN_ENT_CHG_YN_CONT.indexOf(":");
    			if (f_index > 0){    				
    				xmlData.append("          - ���� �� �ð���ü : " + PLAN_ENT_CHG_YN_CONT.substring(f_index + 1, PLAN_ENT_CHG_YN_CONT.length())+ "/" + OPE_NAME + "\n");	
    			} else {
    				xmlData.append("          - ���� �� �ð���ü : " + PLAN_ENT_CHG_YN_CONT+ "/" + OPE_NAME + "\n");
    			}
    		} 
    	
    		else {
    			xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME+ "/" + OPE_NAME + "\n");
    		}
    	}
    	//else if ("jnmp".equals(pm.getScSIGUNGU_CODE())){
    	 if (KJFUtil.isEmpty(BEF_PLANER_NAME)){
			xmlData.append("          - ���� �� �ð���ü : " + OPE_NAME + "\n");
    	}
    	else {
    		xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME+ "/" + OPE_NAME + "\n");
    	}
    	//}
    	
    	//xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME +"/"+OPE_NAME + "\n");
    	xmlData.append("          - �˻��� : "+NAPPL_YN+"\n");
    	
    	if("������".equals(NAPPL_YN )){
    	xmlData.append("          - ������ ���� : "+NAPPL_CAUSE+"\n"); //�߰�
    	}
    	
		if (!"N".equals(ApplGugun)){
			if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("\n��      ��  : 1. ������Ű��� ������˻�  ��� ���� 1��  \n");
    		xmlData.append("              2. ������Ű��� ������˻�  �˻� ��� 1��  \n");
    		xmlData.append("              3. ������Ű��� ������˻�  �˻� ���˻���  1��.  ��.\n");
			}else if ("cbji".equals(pm.getScSIGUNGU_CODE())){
			xmlData.append("\n  ����  ������Ű��� ������˻� ��� ���� 1��.  ��.\n");
			}else{
			xmlData.append("��      �� : ������Ű��� ������˻� ��� ���� 1��.  ��.\n");
			}
    	}

    	xmlData.append("	]]></BODY>\n");
    	xmlData.append("	<ATTACHMENTS>\n");
    	xmlData.append("		<ATTACHMENT filename=\"" + send_file_name + ".html\">������˻� ��� ����</ATTACHMENT>\n");
//    	xmlData.append("		<ADMINISTRATIVE_DB>\n");
//    	xmlData.append("			<XMLFILE filename=\"sample.xml\">���������</XMLFILE>\n");
//    	xmlData.append("			<XSLFILE filename=\"sample.xsl\">����������ǽ�Ÿ�Ͻ�Ʈ</XSLFILE>\n");
//    	xmlData.append("		</ADMINISTRATIVE_DB>\n");
    	xmlData.append("	</ATTACHMENTS>\n");
    	xmlData.append("</EXCHANGE>\n");
    	
    	return xmlData.toString();
    }
    
    /**
     * OZ ����Ʈ ��� ���� ���� ������(÷�ι�)
     * @param pm
     * @return
     * @throws Exception
     */
    private String setAttachFile(UbParam pm) throws Exception{
    	StringBuffer content = new StringBuffer();
    	
    	content.append("<html>\n");
        content.append("	<head>\n");
        content.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
        content.append("		<title>������˻� ��� ����</title>\n");
        content.append("	</head>\n");
        content.append("	<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n");
        content.append("	<iframe src=\"http://99.1.5.83/oz2/UBInvestResultNotiR.jsp?scRECV_NUM="+pm.getAdmNum()+"&SIDO_CODE="+pm.getScSIDO_CODE()+"&SIGUNGU_CODE="+ pm.getScSIGUNGU_CODE()+"\" width=\"100%\" height=\"100%\"></iframe>\n");
        content.append("	</body>\n");
        content.append("</html>\n");
        
        return content.toString();
    }
    
    
    /**
     * ���ڹ��� ���� ���� �Լ�(�̰͸� ȣ���ϸ� ��
     * @param pm
     * @throws Exception
     */
    public void ebmsCallInvest(UbParam pm ) throws Exception { 
    	    	
    	Random rand = new Random(System.currentTimeMillis());
    	String destFolder = pm.getRecvUserID()
							+ pm.getSendSysID()
							+ pm.getRecvSysID()
							+ pm.getSendDateNoFomate()
							+ (rand.nextInt(9999) + 10000);
    	
    	//String dirPath = "D:\\work\\attache\\iccsm\\usebefore\\_ebms_dir\\";
    	String dirPath = Config.props.get("EBMS_FILE_DIR");
    	String embsPath = dirPath + pm.getSendUserID() + KJFFile.FILE_S + destFolder;
    	String filePath = embsPath + KJFFile.FILE_S;
    	
    	if(!makeEbmsFileInvest(pm, filePath)){
    		KJFLog.log("���� ���� ����2");
    	}else{
    		KJFLog.log("���� ���� �Ϸ�2");
    		if(!sendEbmsFileInvest(pm, filePath, destFolder)){
    			KJFLog.log("���� ���� ����2");
        	}else{
        		KJFLog.log("���� ���� �Ϸ�2");
        	}
    	}
    	
    	while(true){
            try{
            	KJFLog.log("���� ����2 eof.inf");
            	Thread.sleep(1000);            	
            }catch(Exception e){
                System.out.println(e.toString());
            }
            break;
        }
    	
    	if(sendFile(pm, dirPath + "eof.inf", destFolder, "eof.inf")){
    		KJFLog.log("���� ����2 eof.inf�Ϸ�");
    		File ebmsFiles = new File(embsPath);
    		
    		if(deleteEbmsFile(ebmsFiles)){
    			KJFLog.log(destFolder + " : ebms2 file deleted!");
    		}else{
    			KJFLog.log(destFolder + " : ebms2 file delete fail!");
    		}
    	}
    }
    /**
     * ���ڹ����� ���ڰ���� �۽����� ����
     * @param form
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean makeEbmsFileInvest(ActionForm form, String filePath)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    	String headerData 	= setHeaderFile_other(pm,"_Invest");	//header.inf ���� ����
    	String exchangeData = setExchangeFileInvest(pm,"_Invest");	//exchange.xml ���� ����
    	String ozResultData = setAttachFileInvest(pm);	//attach_UBInvestResult.html ���� ����

    	//header.inf ��  exchange.xml ���� ����
    	if( makeFile(filePath + "header.inf", headerData, "euc-kr") 
    			&& makeFile(filePath + "exchange.xml", exchangeData, "euc-kr")
    			&& makeFile(filePath + "attach_"+send_invest_file_name + ".html", ozResultData, "utf-8")){
    		
    		//���ϻ��� ����
    		flag = true;
    	}
    	
    	return flag;
    }
    /**
     * ������ ������ �ñ��� ������ �����Ѵ�.
     * @param ActionForm form
     * @param String filePath
     * @param String destFolder
     * @return boolean
     * @throws Exception
     */
    public boolean sendEbmsFileInvest(ActionForm form, String filePath, String destFolder)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
 
		if(sendFile(pm, filePath + "header.inf", destFolder, "header.inf")
				&& sendFile(pm, filePath + "exchange.xml", destFolder, "exchange.xml")
				&& sendFile(pm, filePath + "attach_"+send_invest_file_name + ".html", destFolder, "attach_"+send_invest_file_name + ".html")){
			flag = true;
			KJFLog.log("EBMS ���� ���� �Ϸ�");
		}else{
			flag = false;
			KJFLog.log("EBMS ���� ���� ����");
		}

    	
    	return flag;
    }    
    
    /**
     * �������� exchange.xml ���� ���� ���� ������
     * @param UbParam pm
     * @return String
     * @throws Exception
     */
    private String setExchangeFileInvest(UbParam pm, String num)throws Exception{
    	StringBuffer xmlData  = new StringBuffer();
    	
   		//send_invest_file_name = "������Ű��������˻�����1��_"+pm.getScCIV_RECV_NUM();
   		send_invest_file_name = "������Ű��������˻�����1��_"+REG_NUM;
    	
       	xmlData.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>\n");
    	xmlData.append("<!DOCTYPE EXCHANGE SYSTEM \"exchange.dtd\">\n");
    	xmlData.append("<EXCHANGE>\n");
    	xmlData.append("	<HEADER>\n");
    	xmlData.append("		<COMMON>\n");
    	xmlData.append("			<SENDER>\n");
    	xmlData.append("				<SERVERID>" + pm.getSendSysID()		+ "</SERVERID>\n");
    	xmlData.append(" 				<USERID>"   + pm.getSendUserID() 	+ "</USERID>\n");
    	xmlData.append("				<EMAIL>"	+ pm.getSendUserEmail()	+ "</EMAIL>\n");
    	xmlData.append("			</SENDER>\n");
    	xmlData.append("			<RECEIVER>\n");
    	xmlData.append("				<SERVERID>" + pm.getRecvSysID()		+ "</SERVERID>\n");
    	xmlData.append("				<USERID>" 	+ pm.getRecvUserID()	+ "</USERID>\n");
    	xmlData.append("			</RECEIVER>\n");
    	xmlData.append("			<TITLE>������Ű��� ������˻� ���� ����(������ȣ-"+ REG_NUM +")</TITLE>\n");
    	xmlData.append("			<CREATED_DATE>"	+ pm.getSendDate()		+ "</CREATED_DATE>\n");
    	xmlData.append("			<ATTACHNUM>1</ATTACHNUM>\n");
    	xmlData.append("			<ADMINISTRATIVE_NUM>"+ pm.getAdmNum()		+ num+"</ADMINISTRATIVE_NUM>\n");
    	xmlData.append("		</COMMON>\n");
    	xmlData.append("		<DIRECTION>\n");
    	xmlData.append("			<TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("				<MODIFICATION_FLAG>\n");
    	xmlData.append("					<MODIFIABLE modifyflag=\"yes\"/>\n");
    	xmlData.append("				</MODIFICATION_FLAG>\n");
    	xmlData.append("			</TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("		</DIRECTION>\n");
    	xmlData.append("	</HEADER>\n");
    	xmlData.append("	<BODY><![CDATA[");
    	
    	if ("jnwd".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        1. �ͻ��� ������ ������ ����մϴ�.\n\n");
    		xmlData.append("        2. ���ϲ��� ��û�Ͻ� "+INSP_SPOT_DETAILADDR+"���๰�� ���� ������Ű��� ������˻��\n");
    		xmlData.append("�����Ͽ� ������Ű���� �� ��36�� �� ���� ����� ��36�� ������ ���Ͽ� �˻��� ��� �����Ͽ�\n");
    		xmlData.append("���Ӱ� ���� ������Ű��� ����� �˻� ������ �����մϴ�.\n\n");
    		xmlData.append("                              ��  ���γ��� ��\n");
    	}
    	else if ("gguw".equals(pm.getScSIGUNGU_CODE()))
    	{
        	xmlData.append("        1. ��� ������� ������ ���� �����Ͽ� �ֽ��� ���� �帳�ϴ�.\n");
        	xmlData.append("        2. ���ϲ��� ��û�Ͻ� ���๰(������ȣ-"+REG_NUM+" : " + RECV_DT + ")�� ���Ͽ� ������Ű������ ��36�� �� ���� �� ����� ��36�� ������ ���Ͽ� �˻��� ��� �����Ͽ� ���Ӱ� ���� ������Ű��� ������˻� ������ �����մϴ�.\n");
        	//xmlData.append("           ��36�� �� ���� �� ����� ��36�� ������ ���Ͽ� �˻��� ��� �����Ͽ� \n");
        	//xmlData.append("           ���Ӱ� ���� ������Ű��� ����� �˻� ������ �����մϴ�.\n");    	
        	xmlData.append("        �� ���γ���\n");
    	}
    	else {
        	xmlData.append("        1. ��� ������� ������ ���� �����Ͽ� �ֽ��� ���� �帳�ϴ�.\n");
        	xmlData.append("        2. ���ϲ��� ��û�Ͻ� �Ʒ� ���๰(������ȣ-"+REG_NUM+" : " + RECV_DT + ")�� ���Ͽ� ������Ű������ ��36�� �� ���� �� ����� ��36�� ������ ���Ͽ� �˻��� ��� �����Ͽ� ���Ӱ� ���� ������Ű��� ����� �˻� ������ �����մϴ�.\n");
        	//xmlData.append("           ��36�� �� ���� �� ����� ��36�� ������ ���Ͽ� �˻��� ��� �����Ͽ� \n");
        	//xmlData.append("           ���Ӱ� ���� ������Ű��� ����� �˻� ������ �����մϴ�.\n");    	
        	xmlData.append("        �� ���γ���\n");
    	}
 
    	
    	xmlData.append("          - ��û��(������) : " + APPLPER_NM + "\n");
    	xmlData.append("          - ������ ���� : " + WORK_ITEM + WORK_ITEM_ETC +"\n"); //����    	
    	xmlData.append("          - ������� : " + INSP_SPOT_ADDR + "\n");  
    	xmlData.append("          - �뵵 : "+ OFFICE_TYPE +"("+NUM_FL+AREA+"��)\n");    //�߰�
    	
    	
    	if ("bsgs".equals(pm.getScSIGUNGU_CODE())){
    		if ("����".equals(PLAN_ENT_CHG_YN)){
    			int f_index = PLAN_ENT_CHG_YN_CONT.indexOf(":");
    			if (f_index > 0){    				
    				xmlData.append("          - ���� �� �ð���ü : " + PLAN_ENT_CHG_YN_CONT.substring(f_index + 1, PLAN_ENT_CHG_YN_CONT.length())+ "/" + OPE_NAME + "\n");	
    			} else {
    				xmlData.append("          - ���� �� �ð���ü : " + PLAN_ENT_CHG_YN_CONT+ "/" + OPE_NAME + "\n");
    			}
    		} else {
    			xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME+ "/" + OPE_NAME + "\n");
    		}
    	} else {
    		xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME+ "/" + OPE_NAME + "\n");
    	}
    	
    	//xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME +"/"+OPE_NAME + "\n");
		xmlData.append("          - �˻��� : " + NAPPL_YN + "\n");
		
    	if("������".equals(NAPPL_YN )){
    	xmlData.append("          - ������ ����   : " + NAPPL_CAUSE + "\n"); //�߰�
    	}
    	//else{
    	//	xmlData.append("      �� �� �� ȣ   : " + USEBEFINSP_DELINUM + " \n"); //�߰�
    	//}
    	
		if (!"N".equals(ApplGugun)){
 			if ("cbji".equals(pm.getScSIGUNGU_CODE())){
    			xmlData.append("\n  ����  ������Ű��� ������˻� ����  1��.  ��.\n");
    			}
 			else if("jnwd".equals(pm.getScSIGUNGU_CODE())){
 				xmlData.append("��  �� : ������Ű��� ������˻� ����  1��.  ��.\n");
 			}
 			else if("gguw".equals(pm.getScSIGUNGU_CODE())){
 				xmlData.append("\n ��     �� : ������Ű��� ������˻� ����  1��.  ��.\n");
 			}
 			else{
    			xmlData.append("��      �� : ������Ű��� ������˻� ����  1��.  ��.\n");
    			}
			   
    	}
    	
    	xmlData.append("	]]></BODY>\n");
    	xmlData.append("	<ATTACHMENTS>\n");
    	xmlData.append("		<ATTACHMENT filename=\"" + send_invest_file_name + ".html" + "\">������˻�����1������</ATTACHMENT>\n");
    	xmlData.append("	</ATTACHMENTS>\n");
    	xmlData.append("</EXCHANGE>\n");
    	
    	return xmlData.toString();
    }    
    
    /**
     * OZ ����Ʈ ������˻����� ���� ���� ������(÷�ι�)
     * @param pm
     * @return
     * @throws Exception
     */
    private String setAttachFileInvest(UbParam pm) throws Exception{
    	StringBuffer content = new StringBuffer();
    	
    	content.append("<html>\n");
        content.append("	<head>\n");
        content.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
        content.append("		<title>������Ű��� ������˻�����</title>\n");
        content.append("	</head>\n");
        content.append("	<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n");
        content.append("	<iframe src=\"http://99.1.5.83/oz2/UBInvestR.jsp?scRECV_NUM="+pm.getAdmNum()+"&SIDO_CODE="+pm.getScSIDO_CODE()+"&SIGUNGU_CODE="+ pm.getScSIGUNGU_CODE()+"\" width=\"100%\" height=\"100%\"></iframe>\n");
        content.append("	</body>\n");
        content.append("</html>\n");
        
        return content.toString();
    } 
    
    /**
     * 
     *  ���ڰ��� �����ս� ��ȹ� ���
     *  1. �ο��� ���� ebmsCall_NAP_NO
     *  2. �õ� ����   ebmsCall_NAP_SIDO_NO
     */
 
    
    /**
     * ���ڹ��� ���� ���� �Լ�(�̰͸� ȣ���ϸ� ��)  [�ο� ��ȹ�] 
     * @param pm
     * @throws Exception
     */
    public void ebmsCall_NAP_NO(UbParam pm ) throws Exception { 
    	    	
    	Random rand = new Random(System.currentTimeMillis());
    	String destFolder = pm.getRecvUserID()
							+ pm.getSendSysID()
							+ pm.getRecvSysID()
							+ pm.getSendDateNoFomate()
							+ (rand.nextInt(9999) + 10000);
    	
    	//String dirPath = "D:\\work\\attache\\iccsm\\usebefore\\_ebms_dir\\";
    	String dirPath = Config.props.get("EBMS_FILE_DIR");
    	String embsPath = dirPath + pm.getSendUserID() + KJFFile.FILE_S + destFolder;
    	String filePath = embsPath + KJFFile.FILE_S;
    	
    	if(!makeEbmsFile_NAP_NO(pm, filePath)){
    		KJFLog.log("���� ���� ����3");
    	}else{
    		KJFLog.log("���� ���� �Ϸ�3");
    		if(!sendEbmsFile_NAP_NO(pm, filePath, destFolder)){
    			KJFLog.log("���� ���� ����3");
        	}else{
        		KJFLog.log("���� ���� �Ϸ�3");
        	}
    	}
    	
    	while(true){
            try{
            	KJFLog.log("���� ����3 eof.inf");
            	Thread.sleep(1000);            	
            }catch(Exception e){
                System.out.println(e.toString());
            }
            break;
        }
    	
    	if(sendFile(pm, dirPath + "eof.inf", destFolder, "eof.inf")){
    		KJFLog.log("���� ����2 eof.inf�Ϸ�");
    		File ebmsFiles = new File(embsPath);
    		
    		if(deleteEbmsFile(ebmsFiles)){
    			KJFLog.log(destFolder + " : ebms3 file deleted!");
    		}else{
    			KJFLog.log(destFolder + " : ebms3 file delete fail!");
    		}
    	}
    }
    
    /**
     * ���ڹ����� ���ڰ���� �۽����� ����
     * @param form
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean makeEbmsFile_NAP_NO(ActionForm form, String filePath)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    	String headerData 	= setHeaderFile_other(pm,"_NAP_NO");	//header.inf ���� ����
    	String exchangeData = setExchangeFile_NAP_NO(pm,"_NAP_NO");	//exchange.xml ���� ����

    	if( makeFile(filePath + "header.inf", headerData, "euc-kr") 
    			&& makeFile(filePath + "exchange.xml", exchangeData, "euc-kr")
    			){
    		   		
    		//���ϻ��� ����
    		flag = true;
    	}
    	
    	return flag;
    }
    
    /**
     * �������� exchange.xml ���� ���� ���� ������
     * @param UbParam pm
     * @return String
     * @throws Exception
     */
    private String setExchangeFile_NAP_NO(UbParam pm, String num)throws Exception{
    	StringBuffer xmlData  = new StringBuffer();
   
    	xmlData.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>\n");
    	xmlData.append("<!DOCTYPE EXCHANGE SYSTEM \"exchange.dtd\">\n");
    	xmlData.append("<EXCHANGE>\n");
    	xmlData.append("	<HEADER>\n");
    	xmlData.append("		<COMMON>\n");
    	xmlData.append("			<SENDER>\n");
    	xmlData.append("				<SERVERID>" + pm.getSendSysID()		+ "</SERVERID>\n");
    	xmlData.append(" 				<USERID>"   + pm.getSendUserID() 	+ "</USERID>\n");
    	xmlData.append("				<EMAIL>"	+ pm.getSendUserEmail()	+ "</EMAIL>\n");
    	xmlData.append("			</SENDER>\n");
    	xmlData.append("			<RECEIVER>\n");
    	xmlData.append("				<SERVERID>" + pm.getRecvSysID()		+ "</SERVERID>\n");
    	xmlData.append("				<USERID>" 	+ pm.getRecvUserID()	+ "</USERID>\n");
    	xmlData.append("			</RECEIVER>\n");
    	xmlData.append("			<TITLE>������Ű��� ������˻� ������ ���� ���� �뺸</TITLE>\n");
    	xmlData.append("			<CREATED_DATE>"	+ pm.getSendDate()		+ "</CREATED_DATE>\n");
    	xmlData.append("			<ATTACHNUM>0</ATTACHNUM>\n");
    	xmlData.append("			<ADMINISTRATIVE_NUM>"+ pm.getAdmNum()		+ num + "</ADMINISTRATIVE_NUM>\n");
    	xmlData.append("		</COMMON>\n");
    	xmlData.append("		<DIRECTION>\n");
    	xmlData.append("			<TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("				<MODIFICATION_FLAG>\n");
    	xmlData.append("					<MODIFIABLE modifyflag=\"yes\"/>\n");
    	xmlData.append("				</MODIFICATION_FLAG>\n");
    	xmlData.append("			</TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("		</DIRECTION>\n");
    	xmlData.append("	</HEADER>\n");
    	xmlData.append("	<BODY><![CDATA[");
//    	xmlData.append("        1. �ο� ������ȣ "+REG_NUM+"(" + RECV_DT + ")ȣ�� �����Դϴ�.\n");
//    	xmlData.append("        2. ���ϲ��� ��û�Ͻ� �Ʒ� ���๰�� ���Ͽ� ������Ű������ ��36�� ������ ��\n");
//    	xmlData.append("��, ������Ű��� ������˻縦 �ǽ��� ���, ���� ������ؿ� �������ϰ� �ð��� �κ���\n");
//    	xmlData.append("�־�, ������ �뺸�Ͽ��� ��ġ �� ��˻縦 ��û�Ͻñ� �ٶ��ϴ�.\n");   
    	xmlData.append("        1. ��� ������� ������ ���� �����Ͽ� �ֽ��� ���� �帳�ϴ�.\n");
    	xmlData.append("        2. ���ϲ��� ��û�Ͻ� �Ʒ� ���๰(�ο�������ȣ-"+REG_NUM+" : "+RECV_DT+")�� ���Ͽ� ������Ű������ ��36��  �� ���� �� ����� ��26���� ������ ���Ͽ� �˻��� ��� ���� ����� �������ϰ� �ð��� �κ��� �־� �뺸�Ͽ��� ��ð��� ��˻縦 ��û�Ͻñ� �ٶ��ϴ�.\n");
    	//xmlData.append("��Ű������ ��36��  �� ���� �� ����� ��26���� ������ ���Ͽ� �˻��� ��� ���� �����\n");
    	//xmlData.append("�������ϰ� �ð��� �κ��� �־� �뺸�Ͽ��� ��ð��� ��˻縦 ��û�Ͻñ� �ٶ��ϴ�.\n");       	
    	xmlData.append("        �� ������˻� ��û ����\n");
    	xmlData.append("          - ��û��(������) : " + APPLPER_NM + " \n");   	
    	xmlData.append("          - ������ ���� : " + WORK_ITEM + WORK_ITEM_ETC +" \n");
    	xmlData.append("          - ������� : " + INSP_SPOT_ADDR + " \n");  
    	
//    	if(!KJFUtil.isEmpty(NUM_FL))
//    		NUM_FL = NUM_FL+", ";

    	xmlData.append("          - �뵵 �� ������ : " + OFFICE_TYPE +"("+NUM_FL+AREA + "��)\n");    //�߰�
    	if ("bsgs".equals(pm.getScSIGUNGU_CODE())){
    		if ("����".equals(PLAN_ENT_CHG_YN)){
    			int f_index = PLAN_ENT_CHG_YN_CONT.indexOf(":");
    			if (f_index > 0){    				
    				xmlData.append("          - ���� �� �ð���ü : " + PLAN_ENT_CHG_YN_CONT.substring(f_index + 1, PLAN_ENT_CHG_YN_CONT.length())+ "/" + OPE_NAME + "\n");	
    			} else {
    				xmlData.append("          - ���� �� �ð���ü : " + PLAN_ENT_CHG_YN_CONT+ "/" + OPE_NAME + "\n");
    			}
    		} else {
    			xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME+ "/" + OPE_NAME + "\n");
    		}
    	} else {
    		xmlData.append("          - ���� �� �ð���ü : " + BEF_PLANER_NAME+ "/" + OPE_NAME + "\n");
    	}
    	
    	//xmlData.append("          - ���� �� �����ü : " + OPE_NAME + "\n");
		xmlData.append("          - �˻��� : " + NAPPL_YN + "\n");
		
    	if("������".equals(NAPPL_YN )){
    	xmlData.append("        �� ������ ���� : " + NAPPL_CAUSE + "\n"); //�߰�
    	}
    	
    	xmlData.append("	]]></BODY>\n");
    	xmlData.append("</EXCHANGE>\n");
    	
    	return xmlData.toString();
    }   
    
    /**
     * ������ ������ �ñ��� ������ �����Ѵ�.
     * @param ActionForm form
     * @param String filePath
     * @param String destFolder
     * @return boolean
     * @throws Exception
     */
    public boolean sendEbmsFile_NAP_NO(ActionForm form, String filePath, String destFolder)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;

    	if(sendFile(pm, filePath + "header.inf", destFolder, "header.inf")
				&& sendFile(pm, filePath + "exchange.xml", destFolder, "exchange.xml")
				){
			flag = true;
			KJFLog.log("EBMS ���� ���� �Ϸ�");
		}else{
			flag = false;
			KJFLog.log("EBMS ���� ���� ����");
		}
		
    	return flag;
    }    
    
    /**
     * ���ڹ��� ���� ���� �Լ�(�̰͸� ȣ���ϸ� ��)  [�õ� ��ȹ�]
     * @param pm
     * @throws Exception
     */
    public void ebmsCall_NAP_SIDO_NO(UbParam pm ) throws Exception { 
    	    	
    	Random rand = new Random(System.currentTimeMillis());
    	String destFolder = pm.getRecvUserID()
							+ pm.getSendSysID()
							+ pm.getRecvSysID()
							+ pm.getSendDateNoFomate()
							+ (rand.nextInt(9999) + 10000);
    	
    	//String dirPath = "D:\\work\\attache\\iccsm\\usebefore\\_ebms_dir\\";
    	String dirPath = Config.props.get("EBMS_FILE_DIR");
    	String embsPath = dirPath + pm.getSendUserID() + KJFFile.FILE_S + destFolder;
    	String filePath = embsPath + KJFFile.FILE_S;
    	
    	if(!makeEbmsFile_NAP_SIDO_NO(pm, filePath)){
    		KJFLog.log("���� ���� ����3 SIDO");
    	}else{
    		KJFLog.log("���� ���� �Ϸ�3");
    		if(!sendEbmsFile_NAP_SIDO_NO(pm, filePath, destFolder)){
    			KJFLog.log("���� ���� ����3 SIDO");
        	}else{
        		KJFLog.log("���� ���� �Ϸ�3 SIDO");
        	}
    	}
    	
    	while(true){
            try{
            	KJFLog.log("���� ����3 eof.inf");
            	Thread.sleep(1000);            	
            }catch(Exception e){
                System.out.println(e.toString());
            }
            break;
        }
    	
    	if(sendFile(pm, dirPath + "eof.inf", destFolder, "eof.inf")){
    		KJFLog.log("���� ���� SIDO eof.inf�Ϸ�");
    		File ebmsFiles = new File(embsPath);
    		
    		if(deleteEbmsFile(ebmsFiles)){
    			KJFLog.log(destFolder + " : ebms3 SIDO file deleted!");
    		}else{
    			KJFLog.log(destFolder + " : ebms3 SIDO file delete fail!");
    		}
    	}
    }
    
    /**
     * ���ڹ����� ���ڰ���� �۽����� ����
     * @param form
     * @param filePath
     * @return
     * @throws Exception
     */
    public boolean makeEbmsFile_NAP_SIDO_NO(ActionForm form, String filePath)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;
    	
    	String headerData 	= setHeaderFile_other(pm,"_NAP_SIDO");	//header.inf ���� ����
    	String exchangeData = setExchangeFile_NAP_SIDO_NO(pm,"_NAP_SIDO");	//exchange.xml ���� ����

    	if( makeFile(filePath + "header.inf", headerData, "euc-kr") 
    			&& makeFile(filePath + "exchange.xml", exchangeData, "euc-kr")
    			){
    		   		
    		//���ϻ��� ����
    		flag = true;
    	}
    	
    	return flag;
    }
    
    /**
     * �������� exchange.xml ���� ���� ���� ������
     * @param UbParam pm
     * @return String
     * @throws Exception
     */
    private String setExchangeFile_NAP_SIDO_NO(UbParam pm, String num)throws Exception{
    	StringBuffer xmlData  = new StringBuffer();
   
    	xmlData.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>\n");
    	xmlData.append("<!DOCTYPE EXCHANGE SYSTEM \"exchange.dtd\">\n");
    	xmlData.append("<EXCHANGE>\n");
    	xmlData.append("	<HEADER>\n");
    	xmlData.append("		<COMMON>\n");
    	xmlData.append("			<SENDER>\n");
    	xmlData.append("				<SERVERID>" + pm.getSendSysID()		+ "</SERVERID>\n");
    	xmlData.append(" 				<USERID>"   + pm.getSendUserID() 	+ "</USERID>\n");
    	xmlData.append("				<EMAIL>"	+ pm.getSendUserEmail()	+ "</EMAIL>\n");
    	xmlData.append("			</SENDER>\n");
    	xmlData.append("			<RECEIVER>\n");
    	xmlData.append("				<SERVERID>" + pm.getRecvSysID()		+ "</SERVERID>\n");
    	xmlData.append("				<USERID>" 	+ pm.getRecvUserID()	+ "</USERID>\n");
    	xmlData.append("			</RECEIVER>\n");
    	xmlData.append("			<TITLE>������Ű��� ������˻� ������ ��ü 1�� �˸�</TITLE>\n");
    	xmlData.append("			<CREATED_DATE>"	+ pm.getSendDate()		+ "</CREATED_DATE>\n");
    	xmlData.append("			<ATTACHNUM>0</ATTACHNUM>\n");
    	xmlData.append("			<ADMINISTRATIVE_NUM>"+ pm.getAdmNum()		+ num + "</ADMINISTRATIVE_NUM>\n");
    	xmlData.append("		</COMMON>\n");
    	xmlData.append("		<DIRECTION>\n");
    	xmlData.append("			<TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("				<MODIFICATION_FLAG>\n");
    	xmlData.append("					<MODIFIABLE modifyflag=\"yes\"/>\n");
    	xmlData.append("				</MODIFICATION_FLAG>\n");
    	xmlData.append("			</TO_DOCUMENT_SYSTEM>\n");
    	xmlData.append("		</DIRECTION>\n");
    	xmlData.append("	</HEADER>\n");
    	xmlData.append("	<BODY><![CDATA[");
    	
    	if ("bsgs".equals(pm.getScSIGUNGU_CODE())){
    		xmlData.append("        ������ �ο������-"+REG_NUM+" "+RECV_DT+"ȣ�� ������ ������Ű��� ����� �˻� ��û�ǰ�\n");
    	} else {
    		xmlData.append("        �ο������-"+REG_NUM+" "+RECV_DT+"ȣ�� ������ ������Ű��� ����� �˻� ��û�ǰ�\n");
    	}
    	xmlData.append(" �����Ͽ� ������Ű������ ��36�� �� ���� �� ����� ��36�� ������ ���Ͽ� �˻��� ���,\n");
    	xmlData.append(" ���� ������ؿ� �������ϰ� �ð��� �κ��� �־� ������ ó���Ͽ����� �˷��帳�ϴ�.\n");
    	xmlData.append("        1. ��ü�� : " + APPLPER_NM +" ��ǥ�� "+ APPLPER_REP+" [��Ϲ�ȣ ��"+COI_WRT_NUM+"ȣ]  \n");
    	xmlData.append("        2. �˻��� : " + INSP_DT + " \n");   	
    	xmlData.append("        3. ���������� : " + INSP_SPOT_ADDR +"\n");

//    	if(!KJFUtil.isEmpty(NUM_FL))
//    		NUM_FL = NUM_FL+", ";

    	xmlData.append("        4. ���๰�뵵 : " + OFFICE_TYPE +"("+NUM_FL+AREA+"��)\n");
    	xmlData.append("        5. ������ ���� : " + NAPPL_CAUSE + "\n");
		
    	xmlData.append("	]]></BODY>\n");
    	xmlData.append("</EXCHANGE>\n");
    	
    	return xmlData.toString();
    }   
    
    /**
     * ������ ������ �ñ��� ������ �����Ѵ�.
     * @param ActionForm form
     * @param String filePath
     * @param String destFolder
     * @return boolean
     * @throws Exception 
     */
    public boolean sendEbmsFile_NAP_SIDO_NO(ActionForm form, String filePath, String destFolder)throws Exception{
    	UbParam pm = (UbParam)form;
    	boolean flag = false;

    	if(sendFile(pm, filePath + "header.inf", destFolder, "header.inf")
				&& sendFile(pm, filePath + "exchange.xml", destFolder, "exchange.xml")
				){
			flag = true;
			KJFLog.log("EBMS SIDO ���� ���� �Ϸ�");
		}else{
			flag = false;
			KJFLog.log("EBMS SIDO ���� ���� ����");
		}
		
    	return flag;
    }      
}