package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.bo.BuildingService;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))


public class VotingController {

    @GetMapping(value = "/votings")
    public String votingsPage() {
        return "votings";
    }

    private final BuildingService buildingService;


    @GetMapping(value = "/preVoteForm")
    public ModelAndView preVoteFormPage() {

        ModelAndView mav = new ModelAndView("preVoteForm");
        mav.addObject("preVoteForm",buildingService.findBuildings());

        return mav;
    }

    @GetMapping(value = "/voteForm")
    public String voteFormPage() {
        return "voteForm";
    }



    @GetMapping(value = "/voteForm/{id}")
    public ModelAndView voteFormPageWithBuilding(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("voteForm");
        mav.addObject("voteForm", buildingService.findBuildingById(id));
        return mav;
    }




}
