import java.util.Scanner;

public class LogIn {
    public static void main(String[] args) {
        System.out.println("Введите логин");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        System.out.println("Введит пароль");
        String password = scanner.nextLine();
        System.out.println("Введите пароль для проверки");
        String confirmPassword = scanner.nextLine();
        String regex = "[\\w]{1,20}";
        try{
            check(login,password,confirmPassword,regex);
        } catch (WrongPasswordException | WrongLoginException e){
            System.out.println(e);
        }
    }
    public static boolean check(String login, String password, String confirmPassword, String regex)
        throws WrongLoginException, WrongPasswordException{
        if (!login.matches(regex)){
            throw new WrongLoginException("Incorrect login");
        }else if (!password.matches(regex)||!confirmPassword.matches(regex)||!password.equals(confirmPassword)){
            throw new WrongPasswordException("Incorrect password");
        }
        return true;
    }
}
