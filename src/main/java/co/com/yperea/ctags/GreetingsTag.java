package co.com.yperea.ctags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * This class displays welcome massages basde on the time of day.
 */
public class GreetingsTag extends SimpleTagSupport {

    private int typeOfGreeting;

    /**
     * Sets type of greeting.
     *
     * @param typeOfGreeting the type of greeting
     */
    public void setTypeOfGreeting(int typeOfGreeting) {
        this.typeOfGreeting = typeOfGreeting;
    }

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
        if(typeOfGreeting == 1) {
            out.println("<h3>" + getFormalMessage() + "</h3>");
        } else {
            out.println("<h3>" + getInformalMessage() + "</h3>");
        }
    }

    /**
     * Get a formal greeting.
     */
    private String getFormalMessage () {

        LocalDateTime currentDateTime = LocalDateTime.now();
        String greetingMessage = "Good Evening.";

        if (currentDateTime.getHour() > 3 && currentDateTime.getHour() < 12) {
            greetingMessage = "Good Morning.";
        }else if (currentDateTime.getHour() < 18) {
            greetingMessage = "Good Afternoon.";
        }
        return greetingMessage;
    }

    /**
     * Get an informal greeting.
     */
    private String getInformalMessage () {

        LocalDateTime currentDateTime = LocalDateTime.now();
        String greetingMessage = "What's up?";

        if (currentDateTime.getHour() > 3 && currentDateTime.getHour() < 12) {
            greetingMessage = "Morning.";
        }else if (currentDateTime.getHour() < 18) {
            greetingMessage = "how’s it going so far?";
        }
        return greetingMessage;
    }
}
