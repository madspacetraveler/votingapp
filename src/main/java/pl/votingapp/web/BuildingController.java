package pl.votingapp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.votingapp.bo.BuildingService;
import pl.votingapp.bo.FlatService;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BuildingController {

    private final BuildingService buildingService;
    private final FlatService flatService;

    @GetMapping(value="/buildings/{buildingId}")
    public ModelAndView buildingsPage(@PathVariable("buildingId") Long id){
        ModelAndView mav = new ModelAndView("buildingDetails");
        mav.addObject("building",buildingService.findBuildingById(id));
        return mav;
    }

    @GetMapping(value="/buildings")
    public ModelAndView buildingsPage(){
        ModelAndView mav = new ModelAndView("buildings");
        mav.addObject("buildings",buildingService.findBuildings());
        mav.addObject("countBuildings",buildingService.countBuildings());
        mav.addObject("flats",flatService);
        return mav;
    }
}
