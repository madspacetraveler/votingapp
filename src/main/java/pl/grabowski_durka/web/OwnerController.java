package pl.grabowski_durka.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.grabowski_durka.bo.FlatService;
import pl.grabowski_durka.bo.OwnerService;

/**
 * @author Marcin
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OwnerController {

    private final OwnerService ownerService;
    private final FlatService flatService;

    @GetMapping(value="/owners")
    public ModelAndView owners(){
        ModelAndView mav = new ModelAndView("owners");
        mav.addObject("owners", ownerService.findOwners());
        mav.addObject("countOwners", ownerService.countOwners());
        mav.addObject("flats", flatService.findFlats() );
        return mav;
    }

    @GetMapping(value = "/owners/{ownerId}")
    public ModelAndView owner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("ownerDetails");
        mav.addObject("owner", ownerService.findOwnerById(ownerId));
        return mav;
    }
}
