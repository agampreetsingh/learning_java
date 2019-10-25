import java.util.Objects;
import java.util.Scanner;

public class MoreOrLess {

    public static void main(String[] args) {
        System.out.println("Hello, I've generated a random integer between 0 and 100, can you find it ?");
        Scanner scanner = new Scanner(System.in);

        Integer value = (int)(Math.random() * 100);
        Integer step = 0;
        Integer current;
        do {
            step++;
            current = scanner.nextInt();
            if(current > value){
                System.out.println("Less");
            }else if(current < value){
                System.out.println("More");
            }
        }while(!Objects.equals(value, current));

        System.out.println(String.format("Congratulations you find %d in %d steps", value, step));
    }
}
