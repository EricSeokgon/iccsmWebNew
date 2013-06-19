package kjf.cfg;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import kjf.util.KJFUtil;

/**
 * <p>Subsystem   : 공통 </P>
 * <p>Title       : 환경변수 프로퍼티 </p>
 * <p>Description : 환경변수 프로퍼티</p>
 * <p>관련 TABLE  :
 * @author 김경덕
 * @version 1.0 2003.05.29 초기제작
 */
public class Config extends Properties {

    public Config() {
        try {
            // 현재 환경의 naming Context 획득하기
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            String propertyPath = (String)envCtx.lookup("ConfigProps");
            load(new FileInputStream(new File(propertyPath)));
        }
        catch (Exception ex) {
        }
    }
    
     /** 
    * property 값을 String 으로 가져온다.
    * @param   String str
    * @return   String
    */
	public   String get(String str)  {  
        if (str != null){
              str=str.trim();
        }
		return getProperty(str) ;
	} 

    /** 
    * property 값을 int로 가져온다.
    * @param   String str
    * @return   int
    */
	public   int  getInt(String str)  {  
		return KJFUtil.str2int(getProperty(str)) ;
	} 

    /** 
    * property 값을 long 으로 가져온다.
    * @param   String str
    * @return  long
    */
	public   long  getLogn(String str)  {  
		return KJFUtil.str2long(getProperty(str)) ;
	}

    /** 
    * property 값을 boolean 으로 가져온다.
    * @param   String str
    * @return  boolean
    */
	public   boolean  getBoolean(String str)  {  
		return KJFUtil.str2Boolean(getProperty(str)) ;
	} 

    public static final Config props = new Config();
}