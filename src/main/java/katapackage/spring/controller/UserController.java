package katapackage.spring.controller;



import katapackage.spring.model.User;
import katapackage.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    public UserController( UserService service){
        this.service=service;
        addUsers();
    }
    private void addUsers(){
        service.save(new User("Ruby","Jefferson","contutitutionmf@111.prez"));
        service.save(new User("Abraham","Peepoo","theatrelova@69.am"));
        service.save(new User("Ogre","Magi","missisluck@dumbo.com"));
    }


    @GetMapping("/get")
    public String getUser(ModelMap model){
        model.addAttribute("users",service.getUsers());
      return "pages/getall";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id, Model model){
        model.addAttribute("user",service.show(id));
        return "pages/show";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){

        return "pages/newUser";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
        return "pages/newUser";
        }
        service.save(user);
        return "redirect:users/get";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")int id){
        model.addAttribute("user", service.show(id));
        return "pages/editUser";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")  User user,BindingResult bindingResult,@PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "pages/editUser";
        }
        service.update(id,user);
        return "redirect:/users/get";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        service.delete(id);
        return "redirect:/users/get";
    }
}
