import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Mission0216 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("클라이언트 >> 날짜 서버의 IP 주소:");

        String serverAddress = sc.nextLine();

        try (Socket client = new Socket(serverAddress, 9000);
             BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));) {
            String answer = br.readLine();
            System.out.println(answer);
        } catch (Exception e) {
        }
    }// end of main
}// end of Mission0216Class
