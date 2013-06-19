package kjf.util;

import kjf.ops.ReportEntity;

import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;


/**
 * <p>Subsystem		:  </p>
 * <p>Title			: 마이플랫폼 전용 유틸함수 </p>
 * <p>Description	: 마이플랫폼 유틸함수를 구현하여 제공. </p>
 * <p>관련 TABLE		: </p>
 * @author 김경덕
 * @version 1.0	2003.05.29 <br/>
 */
public class KJFMi {

	/**
     * 입력된 ReportEntity 를 Dataset으로 변환후  DatasetList에 담아 준다. 
     * @param DatasetList dl, ReportEntity rEntity, String ds_id
     * @return ReportEntity
     */	
	public  static void ReEnt2Ds(DatasetList dl, ReportEntity rEntity, String ds_id){
		
		Dataset ds = new Dataset(ds_id);
		
		for(int j=0; j< rEntity.getFieldCnt();j++ ){			
			ds.addColumn(rEntity.getName(j),ColumnInfo.CY_COLINFO_STRING, 20);
			//System.out.println(rEntity.getName(j)+": "+ rEntity.getType(j) );
		}
		
		//System.out.println(rEntity.getRowCnt());
		
		for(int i=0; i< rEntity.getRowCnt();i++){
			int row = ds.appendRow();
			for(int j=0; j< rEntity.getFieldCnt();j++ ){
				
				/*
				// 2010.01.11. XML 파싱 에러 때문에 NULL 문자 공백으로 바꾸기.
				StringBuffer sb = new StringBuffer( rEntity.getValue(i,j) );
				
				for( int x = 0; x < sb.length(); x++ ) {
					char ascii = sb.charAt( x );
					//if( (ascii >= 0x00 && ascii <= 0x08) || ascii == 0x11 || ascii == 0x12 || (ascii >= 0x14 && ascii <= 0x31) ) {
					if( ascii == 0x00 ) {
						sb.setCharAt( x, ' ' );
					}
				}
				ds.setColumn(row, rEntity.getName(j), sb.toString() );
				*/
				
				ds.setColumn(row, rEntity.getName(j), rEntity.getValue(i,j).replace( '\0', ' ' ) );
			
			}
		}	

		/********* 생성된 Dataset을 DatasetList에 추가 ************/
		dl.addDataset(ds);
	 }
	
	
	/**
     * 코드용으로 사용할때  ReportEntity 를 arg를 추가하여  Dataset으로 변환후  DatasetList에 담아 준다. 
     * @param DatasetList dl, ReportEntity rEntity, String ds_id, String code, String code_name
     * @return ReportEntity
     */	
	public  static void ReEnt2CodeDs(DatasetList dl, ReportEntity rEntity, String ds_id, String code, String code_name){
		
		Dataset ds = new Dataset(ds_id);
		
		for(int j=0; j< rEntity.getFieldCnt();j++ ){			
			ds.addColumn(rEntity.getName(j),ColumnInfo.CY_COLINFO_STRING, 20);
			//System.out.println(rEntity.getName(j)+": "+ rEntity.getType(j) );
		}
		
		int add_row = ds.appendRow();
			
		ds.setColumn(add_row, rEntity.getName(0), code);
		ds.setColumn(add_row, rEntity.getName(1), code_name);
		
		for(int i=0; i< rEntity.getRowCnt();i++){
			int row = ds.appendRow();
			for(int j=0; j< rEntity.getFieldCnt();j++ ){			
				ds.setColumn(row, rEntity.getName(j), rEntity.getValue(i,j).replace( '\0', ' ' ));
			}
		}	

		/********* 생성된 Dataset을 DatasetList에 추가 ************/
		dl.addDataset(ds);
	 }
	
	/**
     * DataSet 값 가져오기, 단, "null"을 ""로 반환
     * @param Dataset ds, int rowno, String id
     * @return String
     */	
	public  static String dsGet(Dataset ds, int rowno, String id){
		
		String value;
		try{
			value = ds.getColumn(rowno,id)+"";
		//System.out.println("---id------"+id);
		//System.out.println("----value-----"+value);
		//System.out.println("-----rowno----"+rowno);

		}catch(NullPointerException e){
			value=null;
			
		}
		
		if( value == null )
			return "";
		else
			return value;
	} 
	 
}
