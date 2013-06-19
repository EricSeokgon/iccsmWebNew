package kjf.util;

import kjf.ops.ReportEntity;

import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;


/**
 * <p>Subsystem		:  </p>
 * <p>Title			: �����÷��� ���� ��ƿ�Լ� </p>
 * <p>Description	: �����÷��� ��ƿ�Լ��� �����Ͽ� ����. </p>
 * <p>���� TABLE		: </p>
 * @author ����
 * @version 1.0	2003.05.29 <br/>
 */
public class KJFMi {

	/**
     * �Էµ� ReportEntity �� Dataset���� ��ȯ��  DatasetList�� ��� �ش�. 
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
				// 2010.01.11. XML �Ľ� ���� ������ NULL ���� �������� �ٲٱ�.
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

		/********* ������ Dataset�� DatasetList�� �߰� ************/
		dl.addDataset(ds);
	 }
	
	
	/**
     * �ڵ������ ����Ҷ�  ReportEntity �� arg�� �߰��Ͽ�  Dataset���� ��ȯ��  DatasetList�� ��� �ش�. 
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

		/********* ������ Dataset�� DatasetList�� �߰� ************/
		dl.addDataset(ds);
	 }
	
	/**
     * DataSet �� ��������, ��, "null"�� ""�� ��ȯ
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
