package denis.controller;


import denis.dao.DvdDao;
import denis.dao.UserDao;
import denis.dao.RoleDao;

import denis.model.Dvd;
import denis.model.User;
import denis.service.DvdService;
import denis.service.SecurityService;
import denis.service.UserService;
import org.hibernate.HibernateException;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DvdService dvdService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DvdDao dvdDao;

    @Autowired
    private RoleDao roleDao;

   /* @Autowired
    private QueryDao queryDao;
*/
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/welcome";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @Transactional
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.findByUsername(auth.getName());
        /*List<Dvd> dvdList = new ArrayList<>();
        for (Dvd dvd : user.getDvds()) {
            dvdList.add(dvd);
            System.out.println(dvd.getDvdName());
        }*/

        List<Dvd> dvdListUserLocation = new ArrayList<>();
        for (Dvd dvdLocation : user.getDvds1()) {
            dvdListUserLocation.add(dvdLocation);
            //System.out.println(dvdLocation.getDvdName());
        }

        model.addAttribute("dvdListUserLocation", dvdListUserLocation);
        return "welcome";
    }

    @RequestMapping(value = "/diskForm", method = RequestMethod.GET)
    public String diskForm(Model model) {
        model.addAttribute("diskForm", new Dvd());
        return "diskForm";
    }

    @RequestMapping(value = "/diskForm", method = RequestMethod.POST)
    public String newDisk(@ModelAttribute("diskForm") Dvd diskForm, BindingResult bindingResult, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.findByUsername(auth.getName());

        dvdService.save(diskForm, user);
        return "redirect:/welcome";
    }

    /*
    value - указываем шаблон url куда будет форма отправлять данные.
    method - тип метода http запроса. Другие обрабатываться не будут.
     */
    /*
        @RequestParam - указываем, что данный аргумент метода, является значение с формы с именем как название аргумент в java.
        author, text - приходят значения из input тегов.
     */
    @RequestMapping(value = {"/listFreeDisk"}, method = RequestMethod.GET)
    public String listFreeDisk( Model model) {
        List<Dvd> dvdFree = dvdService.findBygiven(0); //незанятые диски
        model.addAttribute("dvdFree", dvdFree);
        return "listFreeDisk";
    }
    @RequestMapping(value = {"/update"}, method = RequestMethod.GET)
    public String listFreeDisk(@RequestParam Long diskId) {
        dvdService.updateDvd(diskId);
        return "listFreeDisk";
    }


    /*@RequestMapping(value = {"/diskTakeFromUser"}, method = RequestMethod.GET)
    public String listGivFromUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userDao.findByUsername(auth.getName());
        //Диски юзера
        List<Dvd> dvdListUser = new ArrayList<>();
        for (Dvd dvd : user.getDvds()) {
            dvdListUser.add(dvd);
            System.out.println(dvd.getDvdName());
        }
        //Диски отданные
        List<Dvd> dvdTake = dvdDao.findBygiven(1);
        List<Dvd> dvdTakeFromUser = new ArrayList<>();
        for(Dvd dvd : dvdListUser){
            for (Dvd dvd1 : dvdTake){
                if(dvd.getId() == dvd1.getId()){
                    dvdTakeFromUser.add(dvd);
                }
            }
        }

        //System.out.println(dvdTake.size());
        //model.addAttribute("dvdTakeFromUser", dvdTakeFromUser);

        return "listFreeDisk";
    }*/
}
