package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.bo.BuildingService;
import pl.grabowski_durka.bo.FlatService;
import pl.grabowski_durka.bo.OwnerService;
import pl.grabowski_durka.bo.VotingService;
import pl.grabowski_durka.dto.VotingDto;
import pl.grabowski_durka.dto.VotingFormDto;
import pl.grabowski_durka.entity.Voting;

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
    private final VotingService votingService;



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
        mav.addObject("votings", votingService.findVotings());
        mav.addObject("voting", new VotingFormDto());
        return mav;
    }


    @GetMapping(value = "voteForm/addVote")
    public String addVoting(Model model) {
        model.addAttribute("voting", new VotingDto());
        return "voteForm";
    }

    @PostMapping(value = "voteForm/addVote")
    public String saveVoting(@ModelAttribute("voting") VotingDto form,
    BindingResult result, Model model){
        if (!result.hasErrors()){
            votingService.addVoting(form);
        }
        return "redirect: votings";
    }

}
