package no.hvl.dat108.oblig3oppg1.controller;

import no.hvl.dat108.oblig3oppg1.util.LoginUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {

    @Value("${app.message.invalidPassword}")
    private String INVALID_PASSWORD_MESSAGE;

    @Value("${app.message.Password}")
    private String RIGHT_PASSWORD;

    @GetMapping
    public String hentLoginSkjema() {
        return "loginView";
    }

    @PostMapping
    public String provAaLoggeInn(@RequestParam String password, HttpServletRequest request, RedirectAttributes ra) {

        if (!Objects.equals(password, RIGHT_PASSWORD)){
            ra.addFlashAttribute("redirectMessage", INVALID_PASSWORD_MESSAGE);
            return "redirect:" + "login";
        }
        LoginUtil.loggInnBruker(request,password);
        return "redirect:" + "shoppinglist";
    }

}
