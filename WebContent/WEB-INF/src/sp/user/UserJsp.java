/**
 * ���ϸ�   : UserJsp.java
 * ����	    : User  ����� ���� �Լ��� ����
 * �̷»���
 * CH00     :2006/07/15 ���ν� �����ۼ� 
 */
package sp.user;

import java.util.Vector;
import java.util.HashMap;
import kjf.util.*;


public class UserJsp{
	
	private String[][] selField = {{"USER_NAME","����"},{"USER_ID","���̵�"},{"USER_TEL","��ȭ��ȣ"},{"USER_MOBILE","�ڵ���"},{"USER_EMAIL","�̸���"}}; // �Խ��� Ÿ��
	private String[][] selCondition = {{"like","����˻�"},{"=","�ܾ���ġ"}}; //��� ����
		
	public Vector getFileld(){
		return KJFUtil.makeSelect(this.selField);
	}
	
	public Vector getCondition(){
		return KJFUtil.makeSelect(this.selCondition);
	}
	
}
