package net.aspect.education.http.controller;

import jakarta.servlet.http.HttpServletRequest;
import net.aspect.education.database.dto.CompanyReadDto;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.database.entity.Role;
import net.aspect.education.database.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes(
        {"user"}
)
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

//    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
//    public String hello(Model model,
//                        @RequestParam("age") Integer age,
//                        @CookieValue("JSESSIONID") String jsessionId,
//                        @PathVariable("id") Integer id) {
//        model.addAttribute("user",
//                new UserReadDto(Long.valueOf(id), "username", LocalDate.now(), "Buba", "Pupow", Role.ADMIN, new CompanyReadDto(10, "PLEX")));
//
//        System.out.println("Path variable 'age': " + id);
//        System.out.println("Cookie value 'JSESSION ID:' " + jsessionId);
//        System.out.println("RequestParam get age: " + age);
//        return "/hello";
//    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public String bye(@SessionAttribute("user") UserReadDto user) {
        System.out.println(user);
        return "/hello";
    }

    @RequestMapping(value = "/hello")
    public String bye(Model model){
        CompanyReadDto companyReadDto = new CompanyReadDto(10, "Boo-ba");
        UserReadDto userReadDto =  new UserReadDto(10L,
                "oslik@mail.ru",
                LocalDate.now(),
                "Igor",
                "Igorev",
                Role.USER,
                null,
                companyReadDto);

        model.addAttribute("userReadDto", userReadDto);
        return "/hello";
    }
}
