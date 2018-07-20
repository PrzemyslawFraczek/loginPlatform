package pl.fraczek.przemyslaw.view;

import java.util.Scanner;

public class Reader {
    private Scanner scanner = new Scanner(System.in);

    public String readInforamtion(){
        return scanner.next();
    }
    public void display(String massage){
        System.out.println(massage);
    }
}
