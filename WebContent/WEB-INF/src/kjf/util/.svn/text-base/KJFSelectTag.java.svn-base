package kjf.util;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

/**
 * <p>Subsystem		: °øÅë </p>
 * <p>Title			: °øÅë ÄÞº¸»óÀÚ Custom Tag </p>
 * <p>Description	:  </p>
 * <p>°ü·Ã TABLE		:  </p>
 * @author ±è°æ´ö
 * @version 1.0	2003.04.28 <br/> 
*/
public class KJFSelectTag extends TagSupport {

    private Vector item;
    private String name;
    private String value;
    private String text;
    private String script="";

    private KJFSelect sel =new KJFSelect();

    public Vector getItem() {
        return item;
    }

    public void setItem(Vector item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }


    public int doStartTag() throws javax.servlet.jsp.JspException
    {
        ServletRequest req = pageContext.getRequest();
        if(req instanceof HttpServletRequest)
        {
            JspWriter out = pageContext.getOut();

            try
            {
                out.println("<select name='"+name+"' "+script+">");
                if (item !=null){
                    for (int i = 0; i < item.size(); i++) {
                        sel = (KJFSelect)item.elementAt(i);
                        String code =sel.getCode();
                        String code_nm= sel.getCode_nm();
                        if(text ==null){
                        	out.println("<option value='"+code+"'  "+ ((KJFUtil.print(value)).equals(KJFUtil.print(code))? "selected":"")+" > "+code_nm+" </option>");
                        } else {
                        	out.println("<option value='"+code+"'  "+ ((KJFUtil.print(text)).equals(KJFUtil.print(code_nm))? "selected":"")+" > "+code_nm+" </option>");
                        }
                    }
                }

                out.println("</select>");
            }catch(IOException ie)
            {
                throw new JspTagException("KJFSelectTag.doStartTag. error : "+ie.toString());
            }
        }
        return Tag.SKIP_BODY;
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}