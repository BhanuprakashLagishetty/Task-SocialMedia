package com.example.SocailMedia.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue
    private int userProfileId;
    private String fullName;
    private String EmailId;
    @OneToOne(mappedBy = "userProfile")
    private User user;
}
