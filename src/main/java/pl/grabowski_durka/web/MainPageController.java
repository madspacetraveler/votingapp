package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.grabowski_durka.bo.BuildingService;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class MainPageController {

    private final BuildingService buildingService;

    @GetMapping(value = "/")
    public String mainPage() {
        return "main";
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
