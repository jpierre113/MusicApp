package com.example.musicapp.controller;

import com.example.musicapp.models.UserProfile;
import com.example.musicapp.service.UserProfileServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {

    private UserProfileController userProfileController;

    @Before
    public void initializeUserProfileController(){
        userProfileController = new UserProfileController();
        userProfileController.setUserProfileService(new UserProfileServiceStub());
    }

    @Test
    public void createUserProfile_SavesUserProfile_Success() throws Exception{
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("carol@music.com");

        UserProfile newProfile = userProfileController.createUserProfile("carol", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
    }
}
