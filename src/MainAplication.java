import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainAplication {

    public static void main(String args[]){
        int nPancakes;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            nPancakes = Integer.parseInt(br.readLine());
        }
        catch (Exception e){
            System.out.println("Invalid input");
            System.out.println(e.getMessage());
        }
    }
}
