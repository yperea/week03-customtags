package co.com.yperea.ctags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * This class outputs the Hello word.
 */
public class HelloTag extends SimpleTagSupport {

    StringWriter stringWriter = new StringWriter();

    /**
     * Default processing of the tag does nothing.
     *
     * @throws JspException Indicate an error occurred while processing this tag.
     * @throws IOException Throw IOException if there was an error writing to the output stream
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();
        getJspBody().invoke(stringWriter);
        out.println("<h1>Hello " + stringWriter.toString() + "</h1>");
    }
}
