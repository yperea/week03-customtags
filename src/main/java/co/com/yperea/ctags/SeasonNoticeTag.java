package co.com.yperea.ctags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Shows a Season notice.
 */
public class SeasonNoticeTag extends SimpleTagSupport {

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
        out.println("<p>" + getSeasonalNotice() + "</p>");
    }

    /**
     * Get a Season notice message.
     */
    private String getSeasonalNotice() {
        String seasonalMessage = "Enjoy it while you can... before it gets cold!";
        LocalDate currentDate = LocalDate.now();

        if(currentDate.getMonthValue() == 1
                || currentDate.getMonthValue() == 2
                || currentDate.getMonthValue() == 10
                || currentDate.getMonthValue() == 12 ) {

            seasonalMessage = "Winter is a wonderful time!";
        }
        return seasonalMessage;
    }
}
