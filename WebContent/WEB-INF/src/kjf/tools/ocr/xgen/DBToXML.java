package kjf.tools.ocr.xgen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;

import kjf.cfg.Config;
import kjf.ops.SuperToDB;
import kjf.util.KJFFile;
import kjf.util.KJFUtil;
import kjf.util.MsgException;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * @author Sewon
 *
 * BUILD 파일 ROOT에  생성이 됨 .생성 위치를 WEB-INF/src/sp/dao/xml 로변경
 * 테이블 삭제후 BUILD 파일 생성하면 지원진 테이블이 여전히 남아 있음
 */
public class DBToXML extends SuperToDB {

	private final static char all 	= 0;
	private final static char one 	= 1;

    private String filePath 		= null;
    private String sqlfilePath		= null;
    private char convertType 		= this.all;
    private String packageName 		= null;
    private String tableName 		= null;
    private String buildXMLRootDir	= null;
    private String buildXMLFile		= null;

    private Connection conn = null;
    private DatabaseMetaData dbmeta = null;

    private String catalog =null;
    private String schema =null;
    private ArrayList arr = new ArrayList();



	public DBToXML(){

	}



	public void excute( String TABLE_CD ) throws Exception{

//		if("ALL".equals(TABLE_CD.toUpperCase())){
//			convertType 	= this.all;
//		} else{
//			convertType 	= this.one;
//		}



		packageName 	= Config.props.get("PACKAGENAME")+".dao";
		buildXMLRootDir	= Config.props.get("PROJECT_ROOT")+"WEB-INF"+KJFFile.FILE_S;

		System.out.println("packageName: "+ packageName);
		System.out.println("buildXMLRootDir: "+ buildXMLRootDir);
		//파일 출력 경로
		filePath 		= buildXMLRootDir+"src"+KJFFile.FILE_S+"sp"+KJFFile.FILE_S+"dao"+KJFFile.FILE_S+"xml"+KJFFile.FILE_S+"";
		sqlfilePath 	= buildXMLRootDir+"src"+KJFFile.FILE_S+"sp"+KJFFile.FILE_S+"dao"+KJFFile.FILE_S+"sql"+KJFFile.FILE_S+"";
		buildXMLFile 	= buildXMLRootDir+"src"+KJFFile.FILE_S+"sp"+KJFFile.FILE_S+"dao"+KJFFile.FILE_S+"xml"+KJFFile.FILE_S+"build.xml";
		tableName 		= TABLE_CD.toUpperCase();



		KJFFile.fullDirMake(filePath);
		KJFFile.fullDirMake(sqlfilePath);

		KJFFile.deleteFile(filePath,"build.xml");

		conn = this.getConnection();
		dbmeta= conn.getMetaData();

		catalog = KJFUtil.print(Config.props.get("CATALOG"),null);
		schema = KJFUtil.print(Config.props.get("SCHEMA"),null);




		String[] types ={"TABLE"};
		ResultSet rs = null;
		 try {
			rs = dbmeta.getTables(catalog, schema , "%", types );

			while(rs.next()){

				String ls_tname=rs.getString("TABLE_NAME");

					System.out.println(ls_tname+",");
					arr.add(ls_tname);

			}

		}catch (Exception e) {
		   System.out.println(e);
		     throw e;
		} finally {
		   if(rs!=null)         rs.close();
		}


		try{
			//if(convertType == this.all){
				this.makeXMLAllTables(TABLE_CD.toUpperCase(),packageName);
			//}else{
			//	makeXML(tableName, packageName);
			//}

	    }catch (Exception e) {
	  	   System.out.println(e);
	        throw e;
	    } finally {
	      this.release(conn);
	    }

		System.out.println("Complete !");
	}

    public void makeXML(String tableName, String packageName)throws Exception{




    	if(tableName != null) {

    		if(!arr.contains(tableName)){
    			throw new MsgException(tableName+" 테이블이 존재 하지 않습니다.");
    		}

	        try{

	        	Document doc= new DocumentImpl();

	            Element element = this.makeRootTag(doc, tableName, packageName);
	            File file = new File(filePath);
	            if(! file.exists()){
	                file.mkdir();
	            }
	            String fileName = filePath + tableName + ".xml";

	            this.makeDescTag(doc, element, tableName);
	            this.makePrimarykeyTag(doc, element, tableName);
	            this.makeContentsTag(doc, element, tableName);
	            this.saveXML(doc, fileName);


	            BuildXML buildXML = new BuildXML();
	            Document buildXMLDoc = buildXML.makeBuildXML(buildXMLRootDir, fileName, buildXMLFile);

	            this.saveXML(buildXMLDoc, buildXMLFile);

	            System.out.println("XML Saved : " + fileName);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
    	}
    }

   /**
    *
    * @param packageName
    */
	public void makeXMLAllTables(String tableNames ,String packageName)throws Exception {

		String[] tableName =KJFUtil.str2strs(tableNames,",");

        for(int i=0; i < tableName.length ; i++){
            makeXML(tableName[i].trim(), packageName);
        }


//		String[] types ={"TABLE"};
//        ResultSet rs = null;
//        try {
//	        rs = dbmeta.getTables(catalog, schema , "%", types );
//
//
//	        ArrayList arr = new ArrayList();
//
//	        while(rs.next()){
//
//            	String ls_tname=rs.getString("TABLE_NAME");
//            	if(ls_tname.length() < 30  ){
//            		arr.add(ls_tname);
//            		System.out.println( ls_tname );
//            	}
//	        }
//
//            for(int i=0; i < arr.size(); i++){
//                makeXML((String)arr.get(i), packageName);
//            }
//
//        }catch (Exception e) {
//     	   System.out.println(e);
//           throw e;
//       } finally {
//         if(rs!=null)         rs.close();
//       }

	}

	/**
     *
     * @param doc
     * @param tableName
     * @param packageName
     * @param dbtype
     * @return
	 */
	private Element makeRootTag(Document doc, String tableName, String packageName){
		Element element = doc.createElement("table");
		doc.appendChild(element);

		Attr attr = doc.createAttribute("name");
		attr.setValue(tableName);
		element.setAttributeNode(attr);

		attr = doc.createAttribute("schema");
		attr.setValue("");
		element.setAttributeNode(attr);

		attr = doc.createAttribute("pkgname");
		attr.setValue(packageName);
		element.setAttributeNode(attr);

        return element;
	}


    /**
     *
     * @param doc
     * @param root
     * @param tableName
     */
	private void makeDescTag(Document doc, Element root, String tableName){
        Element element = doc.createElement("desc");
        element.setNodeValue(tableName);
        root.appendChild(element);
	}

	private void makePrimarykeyTag(Document doc, Element root, String tableName) throws Exception {

        Element element = doc.createElement("primarykey");
        root.appendChild(element);


        ResultSet rs = null;
        try {
	        rs = dbmeta.getPrimaryKeys(catalog, schema , tableName);

	        while(rs.next()){
            	Element key = doc.createElement("key");
                Text value = doc.createTextNode("value");
                key.appendChild(value);
                value.setData( rs.getString("COLUMN_NAME"));
                element.appendChild(key);
	        }


        }catch (Exception e) {
     	   System.out.println(e);
           throw e;
       } finally {
         if(rs!=null)         rs.close();
       }
	}

	private void makeContentsTag(Document doc, Element root, String tableName)throws Exception {

        Element element = doc.createElement("contents");
        root.appendChild(element);



        ResultSet rs = null;


        try {

	        rs = dbmeta.getColumns(catalog, schema ,tableName, "%");
	        while ( rs.next() ) {

               makeFieldTag(doc, element, rs);
           }


        }catch (Exception e) {
     	   System.out.println(e);
           throw e;
       } finally {
         if(rs!=null)         rs.close();
       }

	}


	private void makeFieldTag(Document doc, Element content, ResultSet rs) throws Exception{
        Element field = doc.createElement("field");
        content.appendChild(field);

        Attr attr = doc.createAttribute("name");

        //COLUMN_NAME
        attr.setValue( rs.getString("COLUMN_NAME").toUpperCase());
        field.setAttributeNode(attr);

        //DATA_TYPE
        String dbType = rs.getString("TYPE_NAME");

        //COLUMN_SIZE
        int dbDataLength =  rs.getInt("COLUMN_SIZE");

        String type = null;
        dbType = dbType.toUpperCase();


        if(dbType.startsWith("DATE") ||
                dbType.startsWith("TIMESTAMP")){
            type ="Date";

        }else if(dbType.startsWith("CLOB")){
            type ="String";
        }else{
            type ="String";
        }

        attr = doc.createAttribute("type");
        attr.setValue( type);
        field.setAttributeNode(attr);

        attr = doc.createAttribute("dbtype");
        if(dbType.equals("DATE") || dbType.equals("CLOB")){
            attr.setValue(dbType);
        }else{
            attr.setValue(dbType+"("+dbDataLength+")");
        }

        field.setAttributeNode(attr);

        attr = doc.createAttribute("desc");
        field.setAttributeNode(attr);

        //NULLABLE
        String nullable = rs.getString("IS_NULLABLE");;

        if(nullable.toUpperCase().equals("NO")){
            nullable = "notnull";
        } else {
            nullable = null;
        }

        String max = null;

        //CHAR_LENGTH
        int maxLength = dbDataLength;
        if(maxLength>0){
            max = "maxsize="+maxLength;
        }

        String constStr = null;
        if(nullable !=null && max != null){
            constStr = nullable+";"+max;

        }else if(nullable == null && max != null){
            constStr = max;

        }else if(nullable != null && max == null){
            constStr = nullable;
        }

        attr = doc.createAttribute("const");
        if(constStr != null){
            attr.setValue(constStr);
        }
        field.setAttributeNode(attr);
    }


    private void saveXML(Document doc, String fileName){
        try{
              File file = new File(fileName);

              System.out.println("fileName:"+fileName);
              if( ! file.exists()){
                  file.createNewFile();
              } else {
            	  if(file.delete()){
            		  System.out.println("Previous XML deleted !");
            	  }
              }

              OutputFormat    format  = new OutputFormat( doc );   //Serialize DOM
              StringWriter  stringOut = new StringWriter();        //Writer will be a String\
              XMLSerializer    serial = new XMLSerializer( stringOut, format );
              serial.asDOMSerializer();                            // As a DOM Serializer
              serial.serialize((Element) doc.getFirstChild() );

             OutputStream os = new FileOutputStream(file);
             os.write(stringOut.toString().getBytes());
             os.close();

         }catch(Exception e){
             e.printStackTrace();
         }
    }


//    public Connection getConnection(){
//        Connection dbCon = null;
////        try{
////            if(dbCon == null){
////                Context initContext = new InitialContext();
////                Context envContext = (Context)initContext.lookup("java:/comp/env");
////                DataSource ds = (DataSource)envContext.lookup("jdbc/dbtoxml");
////                dbCon = ds.getConnection();
////            }
////
////        }catch (NamingException ne) {
////            System.out.println(ne.getMessage());
////        }catch(Exception se){
////            System.out.println(se.getMessage());
////        }
////
////        if(dbCon == null){
//
//            try {
//                Class.forName(dbDriverName);
//                dbCon = DriverManager.getConnection(dbUrl, dbUser, dbId);
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return dbCon;
//    }


//    public void close(Connection con, PreparedStatement pstmt, ResultSet rs){
//        try{
//            if(rs != null) rs.close();
//            close(con, pstmt);
//        }catch (Exception e1){
//        	e1.printStackTrace();
//        }
//    }
//
//    public void close(Connection con, PreparedStatement pstmt){
//        try{
//            if(pstmt != null) pstmt.close();
//            if(con != null) con.close();
//        }catch (Exception e1){
//        	e1.printStackTrace();
//        }
//    }
}


