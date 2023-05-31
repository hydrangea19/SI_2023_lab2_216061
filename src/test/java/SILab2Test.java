import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SILab2Test {
    @Test
    public void EveryBranch(){
        //when user = null
        List<User> allUsers = new ArrayList<>();
        User user = null;
        Assertions.assertThrows(RuntimeException.class, () -> {SILab2.function(user, allUsers);});

        //when username = null, password is less than 8
        User user1 = new User(null, "asdfg", "user@gmail.com");
        List<User> allUsers1 = new ArrayList<>();
        boolean result1 = SILab2.function(user1, allUsers1);
        Assertions.assertFalse(result1);

        //when password has a space
        User user2 = new User("user", "asdf ghjkl*", "user@gmail.com");
        List<User> allUsers2 = new ArrayList<>();
        boolean result2 = SILab2.function(user2, allUsers2);
        Assertions.assertFalse(result2);

        //when password doesn't have a special character
        User user3 = new User("user", "asdfghjklm", "user@gmail.com");
        List<User> allUsers3 = new ArrayList<>();
        boolean result3 = SILab2.function(user3, allUsers3);
        Assertions.assertFalse(result3);

        //when everything is correct
        User user4 = new User("user", "asdfghjkl*", "user@gmail.com");
        User user5 = new User("diellza", "asdfghjklmn#", "diellza@gmail.com");
        List<User> allUsers4 = new ArrayList<>();
        allUsers4.add(user5);   //idk what im doing
        boolean result4 = SILab2.function(user4, allUsers4);
        Assertions.assertTrue(result4);
    }
    @Test
    public void MultipleCondition(){
        //user is null
        User user1 = new User(null, "asdfghjkl*", "user@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user1, new ArrayList<>()));

        //password is null
        User user2 = new User("user", null, "user@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user2, new ArrayList<>()));

        //email is null
        User user3 = new User("user", "asdfghjkl*", null);
        Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(user3, new ArrayList<>()));

        //all are false
        User user4 = new User("user", "asdfghjk*", "user@gmail.com");
        List<User> allUsers4 = new ArrayList<>();
        boolean result = SILab2.function(user4, allUsers4);
        Assertions.assertFalse(result);

    }
}
