package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class BodyTag extends BodyTagSupport {
    protected BodyContent bodyOut;
    protected Tag parent;
    private int count;
    public void setCount(int count) {
		this.count = count;
	}
    @Override
    public void setBodyContent(BodyContent b) {
    	this.bodyOut = b;
    }
    @Override
    public void setParent(Tag t) {
    	this.parent = t;
    }
    @Override
    public Tag getParent() {
    	// TODO Auto-generated method stub
    	return parent;
    }
    @Override
    public void doInitBody() throws JspException {
    	System.out.println("do... init... body...");
    }
    @Override
    public int doStartTag() throws JspException {
    	System.out.println("do start Tag...");
    	if(count > 0)
    		return EVAL_BODY_AGAIN;
    	return SKIP_BODY;
    }
    @Override
    public int doEndTag() throws JspException {
    	System.out.println("do end tag");
        try {
			bodyOut.writeOut(bodyOut.getEnclosingWriter());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return EVAL_PAGE;
    }
    @Override
    public int doAfterBody() throws JspException {
         System.out.println("do after body..");
         if(count>1){
        	 count --;
        	 return EVAL_BODY_AGAIN;
         }
    	return SKIP_BODY;
    }
    
    
    
}
