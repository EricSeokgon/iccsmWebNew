/**
 * 파일명   : UserJsp.java
 * 설명	    : User  모듈의 공통 함수를 정의
 * 이력사항
 * CH00     :2006/07/15 오두식 최초작성 
 */
package sp.user;

import java.util.Vector;
import java.util.HashMap;
import kjf.util.*;


public class UserJsp{
	
	private String[][] selField = {{"USER_NAME","성명"},{"USER_ID","아이디"},{"USER_TEL","전화번호"},{"USER_MOBILE","핸드폰"},{"USER_EMAIL","이메일"}}; // 게시판 타입
	private String[][] selCondition = {{"like","유사검색"},{"=","단어일치"}}; //사용 유무
		
	public Vector getFileld(){
		return KJFUtil.makeSelect(this.selField);
	}
	
	public Vector getCondition(){
		return KJFUtil.makeSelect(this.selCondition);
	}
	
}
