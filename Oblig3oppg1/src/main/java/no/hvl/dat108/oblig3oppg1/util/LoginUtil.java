package no.hvl.dat108.oblig3oppg1.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {

    private final static int MAX_INTERACTIVE_INTERVAL = 30;

    public static void loggUtBruker(HttpSession session) {
        session.invalidate();
    }
    public static void loggInnBruker(HttpServletRequest request, String password) {
        loggUtBruker(request.getSession());
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("password",password);


    }
    public static boolean erBrukerInnlogget(HttpSession session) {
        return session != null && session.getAttribute("password") != null;
    }


}
