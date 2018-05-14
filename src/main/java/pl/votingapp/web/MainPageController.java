package pl.votingapp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.votingapp.bo.BuildingService;
import pl.votingapp.bo.FlatService;
import pl.votingapp.bo.VotingService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MainPageController {

    private final BuildingService buildingService;
    private final FlatService flatService;
    private final VotingService votingService;

    @GetMapping(value = "/")
    public ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("buildings", buildingService);
        mav.addObject("flats", flatService);
        mav.addObject("resolutions", votingService);
        return mav;
    }

    @GetMapping(value = "/menu")
    public ModelAndView menu() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("username", loggedInUser.getName());
        return mav;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }
}