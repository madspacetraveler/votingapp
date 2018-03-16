package pl.grabowski_durka.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.bo.BuildingService;

/**
 * @author Marcin
 */
@Controller
public class BuildingController {

    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping(value="/buildings")
    public ModelAndView buildingsPage(){
        ModelAndView mav = new ModelAndView("buildings");
        mav.addObject("buildings",buildingService.findBuildings());
        return mav;
    }
}
