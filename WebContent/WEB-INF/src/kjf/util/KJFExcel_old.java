package kjf.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


/**
 * 서식이 들어갈 경우 처리 필요...
 * <p>Subsystem		:  </p>
 * <p>Title			: Excel 유틸함수 </p>
 * <p>Description	: Excel 유틸함수를 구현하여 제공. </p>
 * <p>관련 TABLE		: </p>
 * @author 김경덕
 * @version 1.0	2003.05.29 <br/>
 */
public class KJFExcel_old {

	private POIFSFileSystem fs;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;

	private int startRow = 0;
	private int lastRow = 0;

	private int lastCell = 0; // 추가
	/**
	 *  생성자
	 *
	 *@param  source                     Description of the Parameter
	 *@exception  FileNotFoundException  Description of the Exception
	 *@exception  IOException            Description of the Exception
	 */
	public KJFExcel_old(InputStream source)
		throws FileNotFoundException, IOException {
		fs = new POIFSFileSystem(source);
		
		// 읽어들인 Excel파일을 다루기 위한 workbook instance를 생성시킨다.
		workbook = new HSSFWorkbook(fs);		
	}


	/**
	 * 시작열을 지정한다.
	 * @param startRow
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow - 1;
	}

	
	/**
	 * 시작열을 리턴한다.
	 * @return int
	 */
	public int getStartRow() {
		return startRow;
	}
	
	/**
	 * Merged Cell 여부를 검사한다.
	 * @param  row     Description of the Parameter
	 * @param  column  Description of the Parameter
	 * @return  boolean The mergedRegions value
	 */
	private boolean isMergedRegions(int row, int column) {
		int numRegions = 0;
		boolean result = false;
		
		try {
			numRegions = sheet.getNumMergedRegions();
			for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
				Region region = sheet.getMergedRegionAt(i);
				if (region.contains(row, (short) column)) {
					result = true;
					break;
				}
			}
		} catch (Exception e) {}
		
		return result;
	}


	/**
	 *  엑셀파일을 읽은 결과를 2차원 배열로 리턴한다.
	 * 
	 *@return  String[][]
	 */
	public String[][] read() throws Exception {

		// 생성된 workbook으로부터 sheet를 읽어 들인다.
		sheet = workbook.getSheetAt(0);
		lastRow = sheet.getLastRowNum();
		startRow = getStartRow();
		
		String[][] result = new String[lastRow -startRow+1][];

		for (int i = startRow; i <= lastRow; i++) {

			HSSFRow row = sheet.getRow(i);
			result[i-startRow] = new String[row.getLastCellNum()];
			
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				HSSFCell cell = row.getCell((short) j);
				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);

				if (cell == null) {
					break;
				}

				int cellType = cell.getCellType();
				// cell 타입에 따른 cell의 값을 출력시킨다
				switch (cellType) {
					case HSSFCell.CELL_TYPE_NUMERIC:		// 0
						double d = cell.getNumericCellValue();
						// 데이트 타입여부를 체크한다.
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							// format in form of YYYYMMDD
							SimpleDateFormat formatter =
								new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
							String cellText = formatter.format(HSSFDateUtil.getJavaDate(d));
							result[i-startRow][j] = cellText;
						} else {
							result[i-startRow][j] = String.valueOf(cell.getNumericCellValue());
						}
						break;
					case HSSFCell.CELL_TYPE_STRING:			// 1
						result[i-startRow][j] = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_FORMULA:		// 2
						result[i-startRow][j] = cell.getCellFormula();
						break;
					case HSSFCell.CELL_TYPE_BLANK:			// 3
						if( i-startRow >0 && isMergedRegions(i,j)) {
							result[i-startRow][j] = result[i-startRow-1][j];
						} else {
							result[i-startRow][j] = "";
						}
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:		// 4
						result[i-startRow][j] = String.valueOf(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_ERROR:			// 5
						result[i-startRow][j] = String.valueOf(cell.getErrorCellValue());
						break;
					default:
						break;
				}
			}
		}
		return result;
	}
	
	public void setLastCell(int lastCell){//	 추가
		this.lastCell = lastCell;
	}
}
