package sp.util;

import kjf.cfg.Config;
import kjf.util.KJFUtil;

public class DBFuncMaker {
	//0:Oracle 8i 이상, 1:Oracle 8 이하, 2:Ms-sql, 3:My-sql, 4:DB2
	public static final int DB_TYPE = KJFUtil.str2int(KJFUtil.print(Config.props.get("DB_TYPE"),"0"));

	public static String getCurrDateFunc(){
		if(DB_TYPE<2) return "sysdate()";
		else if(DB_TYPE==2) return "getdate()";
		else if(DB_TYPE==3) return "now()";
		else return null;
	}

}
