package org.studyroom.control;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 26/04/2014
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class PostChecker {

    public static String check(String input) {
        System.out.println(input);
        String output = input;
        if (output.contains("www.youtube.com/watch?")) {
            input = input.substring(0, input.indexOf("www.youtube.com/watch?"));
            output = input.substring(0, input.indexOf("www.youtube.com/watch?"));
            int i = input.indexOf("www.youtube.com/watch?");
            String link = "";
            for (; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    break;
                }
            }
            output = "<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/" +
                    input.substring(0, i) + "\" frameborder=\"0\" allowfullscreen></iframe>" +
                    input.substring(i);
        }
        System.out.println(output);
        return output;
    }
}
