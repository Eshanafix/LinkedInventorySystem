//hello :)

/**
 *  Name: Eshan Kwatra
 *  Date: 11/04/20
 *  School: University of Texas at Dallas
 *  NetID: exk190012
 *  Class: Computer Science II
 *  Section: 2336.503
 *  Professor: David Sims
 */

package LinkedInventoryManagement.PersistentStorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import LinkedInventoryManagement.Security.*;


/**
 * UsersOperations: This class should contain all the Users.dat file read, write
 * and update operations.
 */
public class UsersOperations {

    //Puts initial values into users.dat
    public static void instantiateUserList(){
        final String USER_FILE_NAME = "Users.dat";

        File userFile = new File(USER_FILE_NAME);

        try{
            PrintWriter printToUser = new PrintWriter(USER_FILE_NAME);
            //Password is America4Eva
            printToUser.println("Ronald, Reagan, RayRay, " + SecurityOperations.GetPasswordHash("America4Eva") + ", false");

            //Password is YesHello
            printToUser.println("Eshan, Kwatra, eKwatra, " + SecurityOperations.GetPasswordHash("YesHello") + ", true");

            printToUser.close();

        }
        catch(FileNotFoundException e){
            System.out.println("Error file not found");
            System.exit(0);
        }
    }

    //Authenticates user
    public static User readAuthenticateUser(User authenticatedUser, String username, String password){
        User tempUser = null;

        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("Users.dat"));
            String line;
            while((line = reader.readLine()) != null){
                //Take the line and put all the seperate values into an array of Strings
                String[] temp = line.split(", ");
                //Authenticates case insensitive
                if((username.compareToIgnoreCase(temp[2]) == 0) && (SecurityOperations.GetPasswordHash(password).compareToIgnoreCase(temp[3]) == 0)){
                    tempUser = new User(username, SecurityOperations.GetPasswordHash(password), Boolean.parseBoolean(temp[4]));
                    tempUser.setFirtsName(temp[0]);
                    tempUser.setLastName(temp[1]);
                }
            }
            reader.close();
        }
        catch(IOException o){
            System.out.println("Error Exiting Program");
            System.exit(0);
        }
        return tempUser;
    }

    public static void readWriteAddNewUser(User newUser, String userLine, ArrayList<String> previousLines){
        BufferedReader reader;

        try{

            reader = new BufferedReader(new FileReader("Users.dat"));
            String line;
            while((line = reader.readLine()) != null){
                previousLines.add(line);
            }

            //Adds all of the previous lines to the file and then writes the newset line after the for loop
            PrintWriter printToUser = new PrintWriter("Users.dat");
            for(int i = 0; i < previousLines.size(); i++){
                printToUser.println(previousLines.get(i));
            }
            printToUser.println(userLine.toString());
            printToUser.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error could not find file\nExiting...");
            System.exit(0);
        }
        catch(IOException o){
            System.out.println("Error Exiting Program");
            System.exit(0);
        }
    }

    public static void readWriteRemoveUser(String userName){
        //remove username from Users.dat, previous lines list to file can easily be rewritten
        ArrayList<String> previousLines = new ArrayList<String>();
        BufferedReader reader;
        
        //Boolean to check if user to be removed is actually there
        Boolean found = false;

        try{
            reader = new BufferedReader(new FileReader("Users.dat"));
            String line;
            while((line = reader.readLine()) != null){
                //Splits line up into array
                String[] temp = line.split(", ");

                //Checks for equality, case insensitive
                if(temp[2].toLowerCase().equals(userName.toLowerCase())){
                    found = true;
                }
                else{
                    //if the user is in the file it is not added to the previous lines list
                    previousLines.add(line);
                }
            }

            //If found is true then the user was found and file is rewritten, if not error outputted
            if(found){
                PrintWriter printToUser = new PrintWriter("Users.dat");
                for(int i = 0; i < previousLines.size(); i++){
                    printToUser.println(previousLines.get(i));
                }
                printToUser.close();
            }
            else{
                System.out.println("Error: User not found\n");
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Error could not find file\nExiting...");
            System.exit(0);
        }
        catch(IOException o){
            System.out.println("Error Exiting Program");
            System.exit(0);
        }
    }

    public static void readWriteChangeUserPassword(String username, String currentPassword, String newPassword){
        //Previous lines to easily rewrite to file
        ArrayList<String> previousLines = new ArrayList<String>();
        StringBuilder modfiyPassword = new StringBuilder();
        BufferedReader reader;
        String comma = ", ";

        try{
            reader = new BufferedReader(new FileReader("Users.dat"));
            String line;
            while((line = reader.readLine()) != null){
                String[] temp = line.split(", ");

                //User has already been authenticated, if we get to the line where the user is, the line is replaced with a different password
                if((username.compareToIgnoreCase(temp[2]) == 0) && (SecurityOperations.GetPasswordHash(currentPassword).compareToIgnoreCase(temp[3]) == 0)){
                    modfiyPassword.append(temp[0] + comma + temp[1] + comma + temp[2] + comma + SecurityOperations.GetPasswordHash(newPassword) + comma + temp[4]);
                    previousLines.add(modfiyPassword.toString());
                }
                else{
                    previousLines.add(line);
                }
            }

            PrintWriter printToUser = new PrintWriter("Users.dat");

            //rewrite file
            for(int i = 0; i < previousLines.size(); i++){
                printToUser.println(previousLines.get(i));
            }
            printToUser.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error could not find file\nExiting...");
            System.exit(0);
        }
        catch(IOException o){
            System.out.println("Error Exiting Program");
            System.exit(0);
        }
    }
}
    
