package com.example.SocailMedia.Models;

import com.example.SocailMedia.Entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserProfileModel {
    private int userProfileId;
    private String fullName;
    private String EmailId;
    private User user;
}
