package pl.votingapp.web;

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
import pl.votingapp.bo.BuildingService;
import pl.votingapp.bo.FlatService;
import pl.votingapp.bo.PersonService;
import pl.votingapp.bo.VotingService;
import pl.votingapp.dto.FormValidatorDto;
import pl.votingapp.dto.VotingDto;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class VotingController {

    private final BuildingService buildingService;
    private final FlatService flatService;
    private final VotingService votingService;
    private final PersonService personService;

    @GetMapping(value = "/votings")
    public ModelAndView votingsPage() {
        ModelAndView mav = new ModelAndView("votings/votings");
        mav.addObject("votings", votingService.findVotings());
        mav.addObject("countVotings", votingService.countVotings());
        mav.addObject("countResolutions", votingService.countResolutions());
        mav.addObject("kindOfVotings", "Wszystkie uchwały");
        return mav;
    }

    @GetMapping(value = "/votings/accepted")
    public ModelAndView votingsAcceptedPage() {
        ModelAndView mav = new ModelAndView("votings/votings");
        mav.addObject("votings", votingService.findAcceptedVotings());
        mav.addObject("countVotings", votingService.countVotings());
        mav.addObject("countResolutions", votingService.countResolutions());
        mav.addObject("kindOfVotings", "Uchwały zaakceptowane");
        return mav;
    }

    @GetMapping(value = "/votings/rejected")
    public ModelAndView votingsRejectedPage() {
        ModelAndView mav = new ModelAndView("votings/votings");
        mav.addObject("votings", votingService.findRejectedVotings());
        mav.addObject("countVotings", votingService.countVotings());
        mav.addObject("countResolutions", votingService.countResolutions());
        mav.addObject("kindOfVotings", "Uchwały odrzucone");
        return mav;
    }

    @GetMapping(value = "/votings/byBuilding")
    public ModelAndView votingsByBuildingPage() {
        ModelAndView mav = new ModelAndView("votings/byBuilding");
        mav.addObject("buildings",buildingService.findBuildings());
        mav.addObject("countBuildings",buildingService.countBuildings());
        mav.addObject("flats",flatService);
        return mav;
    }

    @GetMapping(value = "/votings/byBuilding/{buildingId}")
    public ModelAndView votingsByBuildingPage(@PathVariable("buildingId") Long id) {
        ModelAndView mav = new ModelAndView("votings/votings");
        mav.addObject("votings", votingService.findVotingsByBuildingId(id));
        mav.addObject("countVotings", votingService.countVotings());
        mav.addObject("countResolutions", votingService.countResolutions());
        mav.addObject("kindOfVotings", "Wszystkie uchwały z wybranego budynku");
        return mav;
    }

    @GetMapping(value = "/preVoteForm")
    public ModelAndView preVoteFormPage() {
        ModelAndView mav = new ModelAndView("votings/preVoteForm");
        mav.addObject("buildings",buildingService.findBuildings());
        mav.addObject("countBuildings",buildingService.countBuildings());
        mav.addObject("flats",flatService);
        return mav;
    }

    @GetMapping(value = "/voteForm")
    public String voteFormPage() {
        return "votings/voteForm";
    }

    @GetMapping(value = "/voteForm/{buildingId}")
    public ModelAndView voteFormPageWithBuilding(@PathVariable("buildingId") Long buildingId) {
        VotingDto votingDto = new VotingDto();
        votingDto.setFlatVoteDtoList(flatService.findFlatsWithBuildingId(buildingId));
        votingDto.setBuilding(buildingService.findBuildingById(buildingId));
        FormValidatorDto formValidatorDto = new FormValidatorDto();
        ModelAndView mav = new ModelAndView("votings/voteForm");
        mav.addObject("voting", votingDto);
        mav.addObject("persons", personService.findPersonsNameAndSurname());
        mav.addObject("validator", formValidatorDto);
        return mav;
    }

    @GetMapping(value = "voteForm/addVote")
    public String addVoting(Model model) {
        model.addAttribute("voting", new VotingDto());
        return "votings/voteForm";
    }

    @PostMapping(value = "voteForm/apply")
    public String saveVoting(@ModelAttribute("voting") VotingDto form,
        BindingResult result, Model model){
        FormValidatorDto formValidatorDto = votingService.validateVoting(form);
        if (!result.hasErrors()&&formValidatorDto.isAllGood()){
            model.addAttribute("votingAdded", votingService.addVoting(form));
            return "votings/votingAdded";
        } else {
            model.addAttribute("persons", personService.findPersonsNameAndSurname());
            model.addAttribute("validator", formValidatorDto);
            form.setFlatVoteDtoList(flatService.findFlatsWithBuildingId(form.getBuilding().getId()));
            form.setBuilding(buildingService.findBuildingById(form.getBuilding().getId()));
            model.addAttribute("voting", form);
            return "votings/voteForm";
        }
    }

    @GetMapping(value = "/votingAdded/{votingId}")
    public ModelAndView votingsAddedPage(@PathVariable("votingId") Long id) {
        ModelAndView mav = new ModelAndView("votings/votingAdded");
        mav.addObject("votingAdded", votingService.findVotingById(id));
        return mav;
    }

    @GetMapping(value = "votings/{votingId}")
    public ModelAndView votingDetailsPage(@PathVariable("votingId") Long id){
        ModelAndView mav = new ModelAndView("votings/votingDetails");
        mav.addObject("voting", votingService.findVotingById(id));
        return mav;
    }



}
