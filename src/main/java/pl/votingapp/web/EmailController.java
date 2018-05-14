package pl.votingapp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.votingapp.bo.SendEmail;
import pl.votingapp.dto.VotingDto;


@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class EmailController {

    //private final VotingService votingService;

    @GetMapping(value = "sendEmail")
    public String sendEmailPage(@ModelAttribute("voting") VotingDto form,
                                BindingResult result, Model model) {
        SendEmail sendEmail = new SendEmail();
        //model.addAttribute("votingAdded", form);
        sendEmail.send("Wlazl kotek na plotek");
        return "votings/"+89;
    }



}



