package com.company;

import javax.swing.*;
import java.util.HashMap;

public class User {
    private static User user = new User();
    private HashMap<String, String> userType = new HashMap<>();
    private HashMap<String, String> users = new HashMap<>();
    private String currentUser;
    private String currentUserType;
    /**
     * Singleton method for User object
     *
     * @return User object.
     */
    public static User getInstance() {
        return user;
    }
    /**
     * User Singleton constructor which runs getInstance() upon being called.
     *
     * @return User object.
     * @see public static User getInstance()
     */
    public User() {
        addUser("trevor", "pw123");
        addUser("sanyam", "pw123");
        addUserType("trevor", "patient");
        addUserType("sanyam", "clinician");
        getInstance();
    }
    public void removeUser(String username) {
        this.users.remove(username);
    }
    public boolean doesUserExist(String username) {
        if(this.users.containsKey(username)){
            return true;
        }
        return false;
    }

    /**
     * Add user and their password to Hashmap
     * @param username
     * @param password
     */
    public void addUser(String username, String password) {
        this.users.put(username, password);
    }

    /**
     * Add user and their usertype to Hashmap
     * @param username
     * @param userType
     */
    public void addUserType(String username, String userType) {
        this.userType.put(username, userType);
    }

    /**
     *
     * @param username
     * @return boolean check if the username is correct or not
     */
    public boolean isCorrectUser(String username) {
        for (String i : this.users.keySet()) {
            if (i.equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @param password
     * @return boolean check if the password is correct or not
     */
    public boolean isCorrectPassword(String username, String password) {
        if (users.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * Displays an error if the username or password are wrong
     * @param username
     * @param password
     * @return boolean check if the username and password are correct or not
     */
    public boolean doLogin(String username, String password) {
        if (user.isCorrectUser(username)) {
            if (user.isCorrectPassword(username, password)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Username");
        }
        return false;
    }
    public String getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
    public String getUserType(String username) {
        return this.userType.get(username);
    }
    public void setCurrentUserType(String currentUserType) {
        this.currentUserType = currentUserType;
    }
}