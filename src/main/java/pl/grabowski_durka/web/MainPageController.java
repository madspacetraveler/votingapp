package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.bo.BuildingService;
import pl.grabowski_durka.bo.FlatService;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MainPageController {

    private final BuildingService buildingService;
    private final FlatService flatService;

    @GetMapping(value = "/")
    public ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("buildings",buildingService);
        mav.addObject("flats",flatService);
        return mav;
    }

/*    @PostMapping(value = "/main")
    public String mainPostPage() {
        return "main";
    }*/


/*    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "index";
    }*/

}
