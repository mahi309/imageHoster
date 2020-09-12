package constatnt;

public class AppConstant {
	
public static final String edit = "Only the owner of the image can edit the image";
public static final String delete = "Only the owner of the image can edit the image";
public static final String passwordValidation = "Password must contain atleast 1 alphabet, 1 number & 1 special character";
public static final String passwordRegex="^(?=.*[a-zA-Z])"
        + "(?=.*[0-9])"
        + "(?=.*[@#$%^&+=])"
        + "(?=\\S+$).{0,10}$"; 
public static final String loginFailure="Invalid credentials.Please login Again";
public static final String userNameError="Please enter the user name";
public static final String passwordError="Please entered the password";
}
