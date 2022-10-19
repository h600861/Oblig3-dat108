package no.hvl.dat108.oblig3oppg1.controller;

import no.hvl.dat108.oblig3oppg1.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppinglistController {

    @Value("${app.message.requiresLogin}")
    private String REQUIRES_LOGIN_MESSAGE;

    @GetMapping("/${app.url.shoppinglist}")
    public String visWebshoppen(HttpSession session, RedirectAttributes ra) {
        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + "login";
        }

        synchronized (this){
            List<String> varer = (List<String>) session.getAttribute("varer");
            if (varer==null){
                varer = new ArrayList<>();
                session.setAttribute("varer",varer);
            }
    }
        return "shoppinglistView";
    }

    @PostMapping("/leggtil")
    public String leggTil(@RequestParam String vare, HttpSession session, RedirectAttributes ra){
        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + "login";
        }
        List<String> varer= (List<String>) session.getAttribute("varer");
        varer.add(vare);

        return "redirect:" + "shoppinglist";
    }

    @PostMapping("/fjern")
    public String fjern(@RequestParam String vare,HttpSession session, RedirectAttributes ra){
        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + "login";
        }
        List<String> varer= (List<String>) session.getAttribute("varer");
        varer.remove(vare);

        return "redirect:" + "shoppinglist";
    }

}
