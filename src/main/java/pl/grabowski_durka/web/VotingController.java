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
import pl.grabowski_durka.dto.BuildingDto;
import pl.grabowski_durka.dto.VotingDto;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        VotingDto votingDto = new VotingDto();
        votingDto.setFlatVoteDtoList(flatService.findFlatsWithBuildingId(buildingId));
        votingDto.setBuilding(buildingService.findBuildingById(buildingId));
        ModelAndView mav = new ModelAndView("voteForm");
        mav.addObject("voting", votingDto);
        return mav;
    }

    @GetMapping(value = "voteForm/addVote")
    public String addVoting(Model model) {
        model.addAttribute("voting", new VotingDto());
        return "voteForm";
    }

    //zliczanie i zapisanie głosów
    @PostMapping(value = "voteForm/addVote")
    public String saveVoting(@ModelAttribute("voting") VotingDto form,
    BindingResult result, Model model){
        if (!result.hasErrors()){
            votingService.addVoting(form);
        }
        return "redirect: votings";
    }

    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map referenceData = new HashMap();
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("voteFor");
        webFrameworkList.add("voteAgainst");
        webFrameworkList.add("voteAbstain");
        referenceData.put("webFrameworkList", webFrameworkList);

        return referenceData;
    }
}
