package org.studyroom.control;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 26/04/2014
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class PostChecker {

    public static String embeddableVideo(String input) {
        return "<iframe width=\"320\" height=\"240\" src=\"//www.youtube.com/embed/" + input.split("=")[1]
                + "\" frameborder=\"0\" allowfullscreen></iframe>";
    }

    public static String getMedia(HttpServletRequest req) {
        String output = "  \n";
        if (req.getParameter("media1").length() > 5) {
            output = output.concat(PostChecker.embeddableVideo(req.getParameter("media1"))).concat("  \n");
        }
        if (req.getParameter("media2").length() > 5) {
            output = output.concat(PostChecker.embeddableVideo(req.getParameter("media2"))).concat("  \n");
        }
        if (req.getParameter("media3").length() > 5) {
            output = output.concat(PostChecker.embeddableVideo(req.getParameter("media3"))).concat("  \n");
        }
        return output;
    }
}
