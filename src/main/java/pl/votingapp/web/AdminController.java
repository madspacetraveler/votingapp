package pl.votingapp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.votingapp.bo.AccountService;
import pl.votingapp.bo.PersonService;
import pl.votingapp.dto.AccountDto;
import pl.votingapp.dto.PersonDto;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {
    private final PersonService personService;
    private final AccountService accountService;

    @GetMapping(value="/admin")
    public ModelAndView admin(){
        ModelAndView mav = new ModelAndView("admin/admin");
        mav.addObject("persons", personService.findPersons());
        mav.addObject("accounts", accountService.findAccounts());
        return mav;
    }

    @GetMapping(value="/admin/personList")
    public ModelAndView adminPersonList(){
        ModelAndView mav = new ModelAndView("admin/personList");
        mav.addObject("persons", personService.findPersons());
        mav.addObject("countPersons", personService.countPersons());
        return mav;
    }

    @GetMapping(value="/admin/accountList")
    public ModelAndView adminAccountList(){
        ModelAndView mav = new ModelAndView("admin/accountList");
        mav.addObject("accounts", accountService.findAccounts());
        mav.addObject("countAccounts", accountService.countAccounts());
        return mav;
    }

    @GetMapping(value="/admin/person")
    public ModelAndView person() {
        PersonDto personDto = new PersonDto();
        ModelAndView mav = new ModelAndView("admin/person");
        mav.addObject("persons", personDto);
        return mav;
    }

    @GetMapping(value="/admin/account")
    public ModelAndView addAccount() {
        AccountDto accountDto = new AccountDto();
        ModelAndView mav = new ModelAndView("admin/account");
        mav.addObject("accounts", accountDto);
        return mav;
    }

    @PostMapping(value = "/admin/person/add")
    public String savePerson(@ModelAttribute("add") PersonDto form,
                             BindingResult result, Model model){
        if (!result.hasErrors()){
            model.addAttribute("personAdd", personService.addPerson(form));
        }
        return "redirect:../../admin/personList";
    }

    @PostMapping(value = "/admin/account/add")
    public String saveAccount(@ModelAttribute("add") AccountDto form,
                              BindingResult result, Model model){
        if (!result.hasErrors()){
            model.addAttribute("accountAdd", accountService.addAccount(form));
        }
        return "redirect:../../admin/accountList";
    }

    @GetMapping(value = "/admin/person/delete")
    public String deletePerson(@RequestParam(name = "personId") String id) {
            personService.deletePerson(Long.valueOf(id));
        return "redirect:../../admin/personList";
    }

    @GetMapping(value = "/admin/account/delete")
    public String deleteAccount(@RequestParam(name = "accountId") String id) {
        accountService.deleteAccount(Long.valueOf(id));
        return "redirect:../../admin/accountList";
    }
}
