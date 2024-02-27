package com.example.SocailMedia.Controller;

import com.example.SocailMedia.Entity.Post;
import com.example.SocailMedia.Entity.User;
import com.example.SocailMedia.Entity.UserProfile;
import com.example.SocailMedia.Models.PostModel;
import com.example.SocailMedia.Models.UserModel;
import com.example.SocailMedia.Service.UserService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    public int UserId1=0;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String home(){
        return "index";
    }

    //adding user
    @RequestMapping("/addUser")
    public String addUser()
    {
        return "addUser";
    }
    @RequestMapping("/SaveUser")
    public String SaveUser(String userName, String fullName, String EmailId, Model model)
    {
        User user=new User();
        user.setUserName(userName);
        UserProfile userProfile=new UserProfile();
        userProfile.setEmailId(EmailId);
        userProfile.setFullName(fullName);
        user.setUserProfile(userProfile);
        userService.addUser(user);
        List<User>u=userService.display();
        model.addAttribute("all",u);

        return "viewEmployees";
    }
    @RequestMapping("/viewUsers")
    public String viewUsers(Model model)
    {
        List<User>u=userService.display();
        model.addAttribute("all",u);
        return "viewEmployees";

    }
    @RequestMapping("/removeemployee")
    public String removeemployee(int eid)
    {
        userService.remove(eid);
        return "redirect:/viewUsers";
    }
    @RequestMapping("/SearchEmployee")
    public String SearchEmployee( int eid,Model model)
    {
        System.out.println("METHOD CALLED");
        System.out.println(eid);
        User e2=userService.userProfile(eid);
        UserId1=e2.getUserId();
//        System.out.println(e2.getEname());
        model.addAttribute("user",e2);
        return "singleEmployee";
    }
    @RequestMapping("/Addposts")
    public String Addposts(int userId)
    {
        UserId1=userId;
        return "addPost";
    }

    @RequestMapping("/SavePost")
    public String SavePost(Post post,Model model)
    {
        userService.savepost(post,UserId1);
        List<User>u=userService.display();
        model.addAttribute("all",u);
        return "viewEmployees";
    }

    @RequestMapping("/ViewPosts")
    public String ViewPosts(int userId,Model model)
    {
        UserId1=userId;
        List<Post>postList=userService.viewPost(userId);
        model.addAttribute("post",postList);
        model.addAttribute("userId",userId);
        return "ViewPosts";
    }

}
