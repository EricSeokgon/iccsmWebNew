package kjf.util;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <p>Subsystem		: 공통 </p>
 * <p>Title			: 공통 라디오 Custom Tag </p>
 * <p>Description	: 공통 라디오 Custom Tag</p>
 * @author 오두식
 * @version 1.0	2007.05.07 <br/>
 */
public class KJFRadioTag extends TagSupport {

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
                if (item !=null){
                    for (int i = 0; i < item.size(); i++) {
                        sel = (KJFSelect)item.elementAt(i);
                        String code =sel.getCode();
                        String code_nm= sel.getCode_nm();
                        String isChecked = ((KJFUtil.print(text)).equals(KJFUtil.print(code_nm))? "checked":"");

//                        if("".equals(KJFUtil.print(value)) && i==0) isChecked="checked";
                        if(text ==null){
                        	isChecked = ((KJFUtil.print(value)).equals(KJFUtil.print(code))? "checked":"");
                        }

                        out.println("<input type='radio' name='"+name+"' value='"+code+"'  "+isChecked+" "+script+">"+code_nm+" ");
                    }
                }

            }catch(IOException ie)
            {
                throw new JspTagException("KJFRadioTag.doStartTag. error : "+ie.toString());
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