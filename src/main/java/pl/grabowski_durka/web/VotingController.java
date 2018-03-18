package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.bo.BuildingService;
import pl.grabowski_durka.bo.FlatService;
import pl.grabowski_durka.bo.OwnerService;
import pl.grabowski_durka.dto.BuildingDto;
import pl.grabowski_durka.entity.Building;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))


public class VotingController {

    @GetMapping(value = "/votings")
    public String votingsPage() {
        return "votings";
    }

    private final BuildingService buildingService;
    private final FlatService flatService;
    private final OwnerService ownerService;


    @GetMapping(value = "/preVoteForm")
    public ModelAndView preVoteFormPage() {

        ModelAndView mav = new ModelAndView("preVoteForm");
        mav.addObject("buildings",buildingService.findBuildings());

        return mav;
    }

    @GetMapping(value = "/voteForm")
    public String voteFormPage() {
        return "voteForm";
    }



    @GetMapping(value = "/voteForm/{buildingId}")
    public ModelAndView voteFormPageWithBuilding(@PathVariable("buildingId") Long buildingId) {
        ModelAndView mav = new ModelAndView("voteForm");
        mav.addObject("building", buildingService.findBuildingById(buildingId));
        mav.addObject("flats", flatService.findFlatsWithBuildingId(buildingId));
        mav.addObject("owners", ownerService.findOwners());
        //mav.addObject("owner", ownerService.findOwnerOfFlat());

        return mav;
    }




}
