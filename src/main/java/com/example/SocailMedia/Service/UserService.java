package com.example.SocailMedia.Service;

import com.example.SocailMedia.Entity.Post;
import com.example.SocailMedia.Entity.User;
import com.example.SocailMedia.Models.PostModel;
import com.example.SocailMedia.Models.UserModel;
import com.example.SocailMedia.Repository.Friends_Repo;
import com.example.SocailMedia.Repository.Post_Repo;
import com.example.SocailMedia.Repository.User_Repo;
import com.example.SocailMedia.Repository.userProfile_Repository;
import com.oracle.wls.shaded.org.apache.bcel.generic.PUSH;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    User_Repo userRepo;
    @Autowired
    Post_Repo post;
    @Autowired
    Friends_Repo friends;
    @Autowired
    userProfile_Repository userprofile;

    public String addUser(User user)
    {
      userRepo.save(user);
      return "Saved succesfully";
    }
    public List<User> display()
    {
        return userRepo.findAll();
    }
    public void remove(int id)
    {
        userRepo.deleteById(id);
    }
    public User userProfile(int id)
    {
        User user=userRepo.findById(id).orElse(null);
        return user;
    }
    public String savepost(Post post,int userId)
    {
      User user1=userRepo.findById(userId).orElse(null);
      List<Post> postList=user1.getPosts();
      postList.add(post);
      user1.setPosts(postList);
      post.setUser(user1);
      userRepo.save(user1);
      return "userentered succesfully";
    }
    public List<Post> viewPost(int userId)
    {
        User user1=userRepo.findById(userId).orElse(null);
        return user1.getPosts();
    }
}
