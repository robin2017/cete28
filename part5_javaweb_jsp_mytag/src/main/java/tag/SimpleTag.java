package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SimpleTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().println("SimplTagSupport Hello!");
	}
}
