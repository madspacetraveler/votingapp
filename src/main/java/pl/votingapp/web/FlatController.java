package pl.votingapp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.votingapp.bo.FlatService;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlatController {

    private final FlatService flatService;

    @GetMapping(value="/flats")
    public ModelAndView flatsPage(){
        ModelAndView mav = new ModelAndView("flats");
        mav.addObject("flats", flatService.findFlats());
        mav.addObject("countFlats", flatService.countFlats());
        return mav;
    }

    @GetMapping(value = "/flats/{flatId}")
    public ModelAndView voteFormPageWithBuilding(@PathVariable("flatId") Long flatId) {
        ModelAndView mav = new ModelAndView("flatDetails");
        mav.addObject("flat", flatService.findFlatById(flatId));
        return mav;
    }
}
