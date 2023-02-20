class Worker extends Thread {
    public void run() {
        try {
            for (int num = 0; num < 5; num++) {
                System.out.println("작업 스레드 : " + num);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }//end of run
}//end of Worker class

public class Mission0214 {
    public static void main(String args[]) {
        int alp = 'a';
        Worker worker = new Worker();
        worker.start();
        try {
            while (worker.isAlive()) {
                System.out.println("메인 스레드 : " + (char) alp++);
                Thread.sleep(500);
            }
        } catch (InterruptedException ex){}
    }// end of main
}//end of Mission0214 Class
