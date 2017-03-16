package ru.javarush.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javarush.crud.model.User;
import ru.javarush.crud.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/users")
    public String getUsers(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("users", userService.getPageList(offset, maxResults));
        model.addAttribute("count", userService.count());
        model.addAttribute("offset", offset);
        return "/users";
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public String addUserForm(Model model) {
         model.addAttribute("user", new User());
        return "/add-user";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user,
                             BindingResult result, HttpServletRequest request) {

        user.setCreatedDate(new Timestamp(new Date().getTime()));
        userService.add(user);

        return "redirect:/users";
    }

    @RequestMapping(value = {"/users/edit"}, method = RequestMethod.POST)
    public String editUserForm(@RequestParam(value="userEdit", required=true) Integer id,
                               Model model) {
        User user = userService.get(id);
        model.addAttribute("userEdit", user);
        return "/edit-user";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userEdit") User userEdit,
                           BindingResult result, HttpServletRequest request) {
        Integer userId =  Integer.parseInt(request.getParameter("OldUserId"));
        User user = userService.get(userId);
        user.setName(userEdit.getName());
        user.setAge(userEdit.getAge());
        user.setIsAdmin(userEdit.isAdmin());

        userService.update(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value="userDeleted", required=true) Integer id,
                         Model model) {

        User userDeleted = userService.get(id);
        userService.delete(userDeleted);

        return "redirect:/users";
    }

    @RequestMapping(value = "/users/search", method = RequestMethod.POST)
    public String searchUser(Model model, HttpServletRequest request) {
        List<User> users = null;
        String result = request.getParameter("search");

        if (result.isEmpty()){
            return "redirect:/users";
        }
        else {
            users = userService.getByName(result);

            if (users.size() != 0) {
                model.addAttribute("searchUsers", users);
                return "/search";
            }
            else {
                request.setAttribute("noResults", true);
                return "/search";
            }
        }

    }
}
