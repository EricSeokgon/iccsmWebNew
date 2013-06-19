/**
 * 파일명   : ComCodeMgrCmd.java
 * 설명     : 공통코드관리 cmd
 * 이력사항
 * CH00     : 2006/09/21 양석환 최초작성
 */

package sp.cm.cmd;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.cfg.Config;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFMi;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.bas.cmd.ComCountCmd;

import com.ibm.icu.util.Calendar;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

public class RegReceiptMgrCodeCCmd implements KJFCommand
{

	private String next;
	private DatasetList dl = new DatasetList();
	private VariableList vl = new VariableList();

	public RegReceiptMgrCodeCCmd() {
	}

	public RegReceiptMgrCodeCCmd(String next_url) {
		next = next_url;
	}

	public String execute( HttpServletRequest request, ActionForm form ) throws Exception {

		/****** Service API 초기화 ******/
		PlatformRequest pReq = new PlatformRequest( request, Config.props.get( "ENCODING" ) );
		/** Web Server에서 XML수신 및 Parsing **/
		pReq.receiveData();
		/** 변수 획득 **/
		vl = pReq.getVariableList();

		String scDOC_CLASS = vl.getValueAsString( "scDOC_CLASS" );
		String scSIDO_CODE = vl.getValueAsString( "scSIDO_CODE" );

		ReportDAO rDAO = new ReportDAO();
		ReportEntity rMasterEntity = null;

		// 코드성 데이타 인 경우 항상 필드가 2개만 존재해야 함
		StringBuilder sQuery = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();

		// Deficit Codes Table
		sQuery.append( " SELECT DOC_NUM1, DOC_NUM2, DOC_NUM3, DOC_NUM4 " );
		sQuery.append( " FROM PT_R_DOC_NUM " );

		// 이 메서드는 RECV_NUM 생성 외 다른 목적으로 사용되지 않음.

		// 모든 공사업관리에 대해 접수번호를 자동생성한다.
		// 시도코드+yyyy+xxxx (bsbs20109999). 12자리
		scDOC_CLASS = "RECV_NUM";

		sWhere.append( " WHERE 1=1 " );
		sWhere.append( " AND DOC_CLASS = '" + scDOC_CLASS + "' " );
		sWhere.append( " AND SD_CODE = '" + scSIDO_CODE + "' " );

		rMasterEntity = rDAO.select( sQuery.toString() + sWhere.toString() );
		sQuery.delete( 0, sQuery.length() );

		if( rMasterEntity.getRowCnt() > 0 ) {
			// 연도 + 일련번호 체크
			String docNum2 = rMasterEntity.getValue( 0, "DOC_NUM2" );
			if( docNum2 == null || !docNum2.matches( "^\\d{8}$" ) ) {
				// 난감한데?
			}
			String preYear = docNum2.substring( 0, 4 );
			String preSeq = docNum2.substring( 4, 8 );

			String newYear = String.valueOf( Calendar.getInstance().get( Calendar.YEAR ) );
			String newSeq;

			if( preYear.equals( newYear ) ) {
				newSeq = KJFUtil.f_code_make( String.valueOf( Integer.parseInt( preSeq, 10 ) + 1 ), 4 );
			}
			else {
				newSeq = "0001";
			}

			docNum2 = newYear + newSeq;

			// 레코드를 삭제하고 넣으려했더니 구현이 안되어있다. 해당 메서드 찾는게 더 귀찮다. 새로 만들기.
			Dataset ds = new Dataset("output");
			ds.addColumn("DOC_NUM1",ColumnInfo.CY_COLINFO_STRING, 20);
      ds.addColumn("DOC_NUM2",ColumnInfo.CY_COLINFO_STRING, 20);
      ds.addColumn("DOC_NUM3",ColumnInfo.CY_COLINFO_STRING, 20);
      ds.addColumn("DOC_NUM4",ColumnInfo.CY_COLINFO_STRING, 20);
      
      ds.appendRow();
			ds.setColumn( 0, "DOC_NUM1", scSIDO_CODE );
			ds.setColumn( 0, "DOC_NUM2", docNum2 );
			ds.setColumn( 0, "DOC_NUM3", "" );
			ds.setColumn( 0, "DOC_NUM4", "" );

			dl.addDataset(ds);
			
			sQuery.append( " UPDATE PT_R_DOC_NUM SET DOC_NUM2 = '" + docNum2 + "'" );
			rDAO = new ReportDAO();
			rDAO.execute( sQuery.toString() + sWhere.toString() );
		}
		else {

			String newYear = String.valueOf( Calendar.getInstance().get( Calendar.YEAR ) );
			String newSeq = "0001";

			String docNum2 = newYear + newSeq;

			sQuery.append( " INSERT INTO PT_R_DOC_NUM (DOC_CLASS,SD_CODE,SGG_CODE,DOC_NUM1,DOC_NUM2) " );
			sQuery.append( " VALUES('" + scDOC_CLASS + "', '" + scSIDO_CODE + "', '" + scSIDO_CODE + "', '" + scSIDO_CODE + "', '" + docNum2 + "') " );
			rDAO = new ReportDAO();
			rDAO.execute( sQuery.toString() );
			ArrayList arrField = new ArrayList();
			arrField.add( scSIDO_CODE );
			arrField.add( docNum2 );
			arrField.add( null );
			arrField.add( null );
			rMasterEntity.addRow( arrField );
			KJFMi.ReEnt2Ds(dl,rMasterEntity,"output");
		}

		request.setAttribute( "dl", dl );

		return next;
	}
}