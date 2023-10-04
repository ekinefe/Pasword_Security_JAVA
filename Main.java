import java.security.PublicKey;
import java.util.Scanner;

public class Main {
    public static int opp;
    public static Scanner scanner =new Scanner(System.in);
    public static String e1="\n\t!!!!SOMETHINGS WRONG!!!!\n\t\tPLEAS TRY AGAIN";
    public static void main(String[] args) {
        System.out.println(e1);

        System.out.println("\n\tPASSWORD_SECURITY");

        System.out.print("\nRandom Password Creater_______1" +
                "\nPassword Check________________2" +
                "\nEXIT__________________________0" +
                "\n\n\tChoose your operation:");
        opp=scanner.nextInt();
        if (opp==1){
            System.out.println("======================================================");
            RandomPasswordCreator.main(args);
        }
        else if (opp==2) {
            System.out.println("======================================================");
            PasswordCheck.main(args);
        }
        else if (opp==0) {
            System.exit(0);
        }

    }
    public static void exit(){
        System.out.println("\n\tPROGRAM IS OVER");
        System.exit(0);
    }
}