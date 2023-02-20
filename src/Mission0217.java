import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Mission0217
{
    public static void main(String[] args) {
        System.out.println("서버 가동 시작");

        try(ServerSocket serversocket = new ServerSocket(9900)){ //TCP방식
            System.out.println("클라이언트 접속 대기중...");

            Socket ClientSocket = serversocket.accept();        // 클라이언트 접속 대기
            System.out.println("클라이언트가 서버에 접속되었습니다.");

            BufferedReader br = null;       // 옛날 방식의 생성자 생성
            PrintWriter pw = null;
            try{
                br = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
                pw = new PrintWriter(ClientSocket.getOutputStream(),true);

                String line;
                while((line = br.readLine())!=null){
                    System.out.println("클라이언트로 부터 받은 메뉴 : "+ line);
                    switch (line){
                        case "1":       // Create
                            String pname = br.readLine();
                            System.out.println("클라이언트로 부터 받은 상품 이름 : "+ line);
                            String pprice = br.readLine();
                            System.out.println("클라이언트로 부터 받은 상품 가격 : "+ line);
                            String pamount = br.readLine();
                            System.out.println("클라이언트로 부터 받은 상품 재고 : "+ line);
                        case "2":       // Update
                            pname = br.readLine();
                            System.out.println("클라이언트로 부터 받은 상품 이름 : "+ line);
                            pprice = br.readLine();
                            System.out.println("클라이언트로 부터 받은 상품 가격 : "+ line);
                            pamount = br.readLine();
                            System.out.println("클라이언트로 부터 받은 상품 재고 : "+ line);

                        case "3":       // Delete
                            String pnum = br.readLine();


                        case "4":       // Exit
                    }
                    pw.println(line);                           // 클라이언트로 메세지 송신
                }
            }catch(IOException e){
                throw new RuntimeException(e);
            } finally{
                if(br != null)              // 일반적인 close() 사용방식....?
                    br.close();
                if(pw != null)
                    pw.close();
            }
        } catch (IOException ex) {
            System.out.println("접속 실패!");
        }
    } // end of main
} // end of class
