package org.studyroom.control.utilities;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 26/04/2014
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class Converter {

//    public static String encode(String input) {
//        return "<iframe width=\"320\" height=\"240\" src=\"//www.youtube.com/embed/" + input
//                + "\" frameborder=\"0\" allowfullscreen></iframe><br/>";
//    }

    public static String encode(String input) {
        return "[youtubeVideo]" + input + "[/youtubeVideo]\n";
    }

    public static String getMedia(HttpServletRequest req) {
        String output = "<br/>";
        int i = 1;
        if (req.getParameter("1") != null) {
            do {
                output += encode(req.getParameter(i + "").split("watch?v=")[1]);
                i++;
            } while (req.getParameter(i + "") != null);
        }
        return output;
    }

    public static String decode(String input) {
//        return input;
        return input.replace("[youtubeVideo]", "<iframe width=\"320\" height=\"240\" src=\"//www.youtube.com/embed/")
                .replace("[/youtubeVideo]", "\" frameborder=\"0\" allowfullscreen></iframe>");
    }

}
