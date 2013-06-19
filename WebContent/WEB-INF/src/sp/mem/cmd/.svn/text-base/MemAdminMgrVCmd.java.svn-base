package sp.mem.cmd;

import javax.servlet.http.HttpServletRequest;

import kjf.action.KJFCommand;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.apache.struts.action.ActionForm;

import sp.mem.MemParam;

public class MemAdminMgrVCmd implements KJFCommand {
	
	private String next;
	
	public MemAdminMgrVCmd() {
    }
	
	public MemAdminMgrVCmd(String next_url) {
    	next = next_url; 
    }

	public String execute(HttpServletRequest request, ActionForm form) throws Exception {
        
        //검색조건 설정및 체크
    	MemParam pm = checkPm(request, form);
        request.setAttribute("pm", pm);     
        
        loadCondition(request);
        
        //수정 상태 이면 데이터  로드
        loadDetail(request);
        
        return next;
        
	}
	
    /**
     * 검색조건 초기값 설정및 체크
     * @param HttpServletRequest
     * @return SYSParam
     */
    private MemParam checkPm(HttpServletRequest request, ActionForm form)throws Exception{
    	
    	MemParam pm = (MemParam)form;
        //파라미터 디버깅
        KJFLog.debug(pm.toString(request));
       
        return pm;

    }
    
    private void loadCondition(HttpServletRequest request)throws Exception{
        
        String[][] PTNR_TY = {{"","-선택-"},{"00","내부직원"},{"01","화주"},{"02","선사"},{"03","포더"},{"99","게스트"}};
        request.setAttribute("v_ptnr_ty", KJFUtil.makeSelect(PTNR_TY));
        
        String[][] STATE_CD = {{"","미국일 경우만 선택"},{"AL","Alabama"},
                  {"AK","Alaska"},{"AS","American Samoa"},{"AZ","Arizona"},{"AR","Arkansas"},{"CA","California"},
                  {"CO","Colorado"},{"CT","Connecticut"},{"DE","Delaware"},{"DC","District of Columbia"},{"FL","Florida"},
                  {"GA","Georgia"},{"GU","Guam"},{"HI","Hawaii"},{"ID","Idaho"}, {"IL","Illinois"},{"IN","Indiana"},
                  {"IA","Iowa"},{"KS","Kansas"},{"KY","Kentucky"},{"LA","Louisiana"},{"ME","Maine"},
                  {"MD","Maryland"}, {"MA","Massachusetts"},
                  {"MI","Michigan"}, {"MN","Minnesota"},
                  {"MS","Mississippi"},{"MO","Missouri"},
                  {"MT","Montana"},{"NE","Nebraska"},
                  {"NV","Nevada"},
                  {"NH","New Hampshire"},
                  {"NJ","New Jersey"},
                  {"NM","New Mexico"},
                  {"NY","New York"},
                  {"NC","Nortd Carolina"},
                  {"ND","Nortd Dakota"},
                  {"MP","Nortdern Mariana Islands"},
                  {"OH","Ohio"},
                  {"OK","Oklahoma"},
                  {"OR","Oregon"},
                  {"PA","Pennsylvania"},
                  {"PR","Puerto Rico"},
                  {"RI","Rhode Island"},
                  {"SC","Soutd Carolina"},
                  {"SD","Soutd Dakota"},
                  {"TN","Tennessee"},
                  {"TX","Texas"},
                  {"UM","U.S. Minor Outlying Islands"},
                  {"UT","Utah"},
                  {"VT","Vermont"},
                  {"VI","Virgin Islands of tde U.S."},
                  {"VA","Virginia"},
                  {"WA","Washington"},
                  {"WV","West Virginia"},
                  {"WI","Wisconsin"},
                  {"WY","Wyoming"}
              };
        request.setAttribute("v_state_cd", KJFUtil.makeSelect(STATE_CD));

        String[][] CONTRY_CD = {{"","선택하세요"},           
              {"AF","Afghanistan"},
              {"US","Alabama"},
              {"US","Alaska"},
              {"AL","Albania"},
              {"DZ","Algeria"},
              {"AS","American Samoa"},
              {"US","American Samoa"},
              {"AD","Andorra"},
              {"AO","Angola"},
              {"AI","Anguilla"},
              {"AQ","Antarctica"},
              {"AG","Antigua and Barbuda"},
              {"AR","Argentina"},
              {"US","Arizona"},
              {"US","Arkansas"},
              {"AM","Armenia"},
              {"AW","Aruba"},
              {"AU","Australia"},
              {"AT","Austria"},
              {"AZ","Azerbaijan"},
              {"BS","Bahamas"},
              {"BH","Bahrain"},
              {"BD","Bangladesh"},
              {"BB","Barbados"},
              {"BY","Belarus"},
              {"BE","Belgium"},
              {"BZ","Belize"},
              {"BJ","Benin"},
              {"BM","Bermuda"},
              {"BT","Bhutan"},
              {"BO","Bolivia"},
              {"BA","Bosnia and Herzegovina"},
              {"BW","Botswana"},
              {"BR","Brazil"},
              {"IO","British Indian Ocean Territory"},
              {"BN","Brunei Darussalam"},
              {"BG","Bulgaria"},
              {"BF","Burkina Faso"},
              {"BI","Burundi"},
              {"CI","C?e d'Ivoire"},
              {"US","California"},
              {"KH","Cambodia"},
              {"CM","Cameroon"},
              {"CA","Canada"},
              {"CV","Cape Verde"},
              {"KY","Cayman Islands"},
              {"CF","Central African Republic"},
              {"TD","Chad"},
              {"CL","Chile"},
              {"CN","China"},
              {"CX","Christmas Island"},
              {"CC","Cocos (Keeling) Islands"},
              {"CO","Colombia"},
              {"US","Colorado"},
              {"KM","Comoros"},
              {"CG","Congo"},
              {"CD","Congo, tde Democratic Republic of tde"},
              {"US","Connecticut"},
              {"CK","Cook Islands"},
              {"CR","Costa Rica"},
              {"HR","Croatia"},
              {"CU","Cuba"},
              {"CY","Cyprus"},
              {"CZ","Czech Republic"},
              {"US","Delaware"},
              {"DK","Denmark"},
              {"US","District of Columbia"},
              {"DJ","Djibouti"},
              {"DM","Dominica"},
              {"DO","Dominican Republic"},
              {"TP","East Timor"},
              {"EC","Ecuador"},
              {"EG","Egypt"},
              {"SV","El Salvador"},
              {"GQ","Equatorial Guinea"},
              {"ER","Eritrea"},
              {"EE","Estonia"},
              {"ET","Etdiopia"},
              {"FK","Falkland Islands (Malvinas)"},
              {"FO","Faroe Islands"},
              {"FJ","Fiji"},
              {"FI","Finland"},
              {"US","Florida"},
              {"FR","France"},
              {"GF","French Guiana"},
              {"PF","French Polynesia"},
              {"GA","Gabon"},
              {"GM","Gambia"},
              {"GE","Georgia"},
              {"US","Georgia"},
              {"DE","Germany"},
              {"GH","Ghana"},
              {"GI","Gibraltar"},
              {"GR","Greece"},
              {"GL","Greenland"},
              {"GD","Grenada"},
              {"GP","Guadeloupe"},
              {"GU","Guam"},
              {"US","Guam"},
              {"GT","Guatemala"},
              {"GN","Guinea"},
              {"GW","Guinea-Bissau"},
              {"GY","Guyana"},
              {"HT","Haiti"},
              {"US","Hawaii"},
              {"VA","Holy See (Vatican City State)"},
              {"HN","Honduras"},
              {"HK","Hong Kong "},
              {"HU","Hungary"},
              {"IS","Iceland"},
              {"US","Idaho"},
              {"US","Illinois"},
              {"IN","India"},
              {"US","Indiana"},
              {"ID","Indonesia"},
              {"XZ","Installations in International Waters"},
              {"US","Iowa"},
              {"IR","Iran, Islamic Republic of"},
              {"IQ","Iraq"},
              {"IE","Ireland"},
              {"IL","Israel"},
              {"IT","Italy"},
              {"JM","Jamaica"},
              {"JP","Japan"},
              {"JO","Jordan"},
              {"US","Kansas"},
              {"KZ","Kazakhstan"},
              {"US","Kentucky"},
              {"KE","Kenya"},
              {"KI","Kiribati"},
              {"KP","Korea, Democratic People's Republic of"},
              {"KR","Korea, Republic of"},
              {"KW","Kuwait"},
              {"KG","Kyrgyzstan"},
              {"LA","Lao People's Democratic Republic"},
              {"LV","Latvia"},
              {"LB","Lebanon"},
              {"LS","Lesotdo"},
              {"LR","Liberia"},
              {"LY","Libyan Arab Jamahiriya"},
              {"LI","Liechtenstein"},
              {"LT","Litduania"},
              {"US","Louisiana"},
              {"LU","Luxembourg"},
              {"MO","Macau"},
              {"MK","Macedonia, tde former Yugoslav Republic of"},
              {"MG","Madagascar"},
              {"US","Maine"},
              {"MW","Malawi"},
              {"MY","Malaysia"},
              {"MV","Maldives"},
              {"ML","Mali"},
              {"MT","Malta"},
              {"MH","Marshall Islands"},
              {"MQ","Martinique"},
              {"US","Maryland"},
              {"US","Massachusetts"},
              {"MR","Mauritania"},
              {"MU","Mauritius"},
              {"YT","Mayotte"},
              {"MX","Mexico"},
              {"US","Michigan"},
              {"FM","Micronesia, Federated States of"},
              {"US","Minnesota"},
              {"US","Mississippi"},
              {"US","Missouri"},
              {"MD","Moldova, Republic of"},
              {"MC","Monaco"},
              {"MN","Mongolia"},
              {"US","Montana"},
              {"MS","Montserrat"},
              {"MA","Morocco"},
              {"MZ","Mozambique"},
              {"MM","Myanmar"},
              {"NA","Namibia"},
              {"NR","Nauru"},
              {"US","Nebraska"},
              {"NP","Nepal"},
              {"NL","Netderlands"},
              {"AN","Netderlands Antilles"},
              {"US","Nevada"},
              {"NC","New Caledonia"},
              {"US","New Hampshire"},
              {"US","New Jersey"},
              {"US","New Mexico"},
              {"US","New York"},
              {"NZ","New Zealand"},
              {"NI","Nicaragua"},
              {"NE","Niger"},
              {"NG","Nigeria"},
              {"NU","Niue"},
              {"NF","Norfolk Island"},
              {"US","Nortd Carolina"},
              {"US","Nortd Dakota"},
              {"MP","Nortdern Mariana Islands"},
              {"US","Nortdern Mariana Islands"},
              {"NO","Norway"},
              {"US","Ohio"},
              {"US","Oklahoma"},
              {"OM","Oman"},
              {"US","Oregon"},
              {"PK","Pakistan"},
              {"PW","Palau"},
              {"PA","Panama"},
              {"PG","Papua New Guinea"},
              {"PY","Paraguay"},
              {"US","Pennsylvania"},
              {"PE","Peru"},
              {"PH","Philippines"},
              {"PN","Pitcairn"},
              {"PL","Poland"},
              {"PT","Portugal"},
              {"PR","Puerto Rico"},
              {"US","Puerto Rico"},
              {"QA","Qatar"},
              {"RE","R?nion"},
              {"US","Rhode Island"},
              {"RO","Romania"},
              {"RU","Russian Federation"},
              {"RW","Rwanda"},
              {"SH","Saint Helena"},
              {"KN","Saint Kitts and Nevis"},
              {"LC","Saint Lucia"},
              {"PM","Saint Pierre and Miquelon"},
              {"VC","Saint Vincent and tde Grenadines"},
              {"WS","Samoa"},
              {"SM","San Marino"},
              {"ST","Sao Tome and Principe"},
              {"SA","Saudi Arabia"},
              {"SN","Senegal"},
              {"SC","Seychelles"},
              {"SL","Sierra Leone"},
              {"SG","Singapore"},
              {"SK","Slovakia"},
              {"SI","Slovenia"},
              {"SB","Solomon Islands"},
              {"SO","Somalia"},
              {"ZA","Soutd Africa"},
              {"US","Soutd Carolina"},
              {"US","Soutd Dakota"},
              {"GS","Soutd Georgia and tde Soutd Sandwich Islands"},
              {"ES","Spain"},
              {"LK","Sri Lanka"},
              {"SD","Sudan"},
              {"SR","Suriname"},
              {"SJ","Svalbard and Jan Mayen"},
              {"SZ","Swaziland"},
              {"SE","Sweden"},
              {"CH","Switzerland"},
              {"SY","Syrian Arab Republic"},
              {"TW","Taiwan, Province of China"},
              {"TJ","Tajikistan"},
              {"TZ","Tanzania, United Republic of"},
              {"US","Tennessee"},
              {"US","Texas"},
              {"td","tdailand"},
              {"TG","Togo"},
              {"TO","Tonga"},
              {"TT","Trinidad and Tobago"},
              {"TN","Tunisia"},
              {"TR","Turkey"},
              {"TM","Turkmenistan"},
              {"TC","Turks and Caicos Islands"},
              {"TV","Tuvalu"},
              {"US","U.S. Minor Outlying Islands"},
              {"UG","Uganda"},
              {"UA","Ukraine"},
              {"AE","United Arab Emirates"},
              {"GB","United Kingdom"},
              {"US","United States"},
              {"UM","United States Minor Outlying Islands"},
              {"UY","Uruguay"},
              {"US","Utah"},
              {"UZ","Uzbekistan"},
              {"VU","Vanuatu"},
              {"VE","Venezuela"},
              {"US","Vermont"},
              {"VN","Viet Nam"},
              {"US","Virgin Islands of tde U.S."},
              {"VG","Virgin Islands, British"},
              {"VI","Virgin Islands, U.S."},
              {"US","Virginia"},
              {"WF","Wallis and Futuna"},
              {"US","Washington"},
              {"US","West Virginia"},
              {"EH","Western Sahara"},
              {"US","Wisconsin"},
              {"US","Wyoming"},
              {"YE","Yemen"},
              {"YU","Yugoslavia"},
              {"ZM","Zambia"},
              {"ZW","Zimbabwe"}
             };
        
        request.setAttribute("v_contry_cd", KJFUtil.makeSelect(CONTRY_CD));        
    	
    }
    
    /**
     * Data를 load
     * @param HttpServletRequest
     * @return
     */
    private void loadDetail(HttpServletRequest request)throws Exception{
        
        ReportDAO    rDAO        = new ReportDAO();
        ReportEntity rEntity     = null;



        //SELECT 항목 SQL...
        String selectSQL =
            "SELECT                                                         \n"+ 
            "           STAFF_CD,                                           \n"+
            "           PASSWORD,                                           \n"+
            "           FNAME,                                              \n"+
            "           LNAME,                                              \n"+
            "           CONAME,                                             \n"+
            "           DEPTNM,                                             \n"+
            "           ADDR,                                               \n"+
            "           ZIP_CD,                                             \n"+
            "           TEL_INT,                                            \n"+
            "           TEL_AREA,                                           \n"+
            "           TEL_NUM,                                            \n"+
            "           TEL_EXT,                                            \n"+
            "           FAX_INT,                                            \n"+
            "           FAX_AREA,                                           \n"+
            "           FAX_NUM,                                            \n"+
            "           MOBILE_NO,                                          \n"+
            "           EMAIL_ADDR,                                         \n"+
            "           CITY_CODE,                                          \n"+
            "           CONTRY_CODE,                                          \n"+
            "           STATE_CODE,                                         \n"+
            "           PTNR_CODE,                                          \n"+
            "           PTNR_TYPE,                                          \n"+        
            "           ADMIN,                                              \n"+
            "           USER_LEVEL,                                         \n"+
            "           USER_TYPE,                                          \n"+
            "           USER_CHK,                                           \n"+
            "           USER_TMNL,                                          \n"+
            "           USER_APP,                                           \n"+
            "           USER_GROUP,                                         \n"+
            "           GENDER,                                             \n"+
            "           AGE,                                                \n"+
            "           BIRTHDAY,                                           \n"+  
            "           USER_NOTY,                                          \n"+
            "           JOIN_DATE,                                          \n"+
            "           UPDATE_CD,                                          \n"+
            "           UPDATE_TIME,                                        \n"+
            "           BRNUM,                                              \n"+
            "           RRNUM                                               \n";
        
        String fromSQL=
            "FROM                                                           \n"+
            "    WEB_IP_USER                                                \n";



        String whereSQL = 
        	"WHERE	STAFF_CD='"+request.getParameter("STAFF_CD")+"'	\n";
        
           

 
        rEntity    = rDAO.select(selectSQL+fromSQL+whereSQL);
        
        request.setAttribute("rEntity", rEntity);



    }//end loadDetail  

}
