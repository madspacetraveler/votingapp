package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.bo.BuildingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainPageController {

    private final BuildingService buildingService;

    @GetMapping(value = "/main")
    public String mainPage() {
        return "main";
    }

    @PostMapping(value = "/main")
    public String mainPostPage() {
        return "main";
    }

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "main";
    }

/*    @GetMapping(value="/buildings")
    public ModelAndView testPage(){
        ModelAndView mav = new ModelAndView("buildingsPage");
        mav.addObject("buildingsPage", buildingService.findBuildings());
        return mav;
    }*/

}
