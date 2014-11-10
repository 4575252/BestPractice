package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.thread;

class Account {
    String name;
    float amount;
    
    
    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    public void deposit(float amt) {
        float tmp = amount;
        tmp += amt;
        
        try {
            Thread.sleep(100);//模拟其它处理所需要的时间，比如刷新数据库等
        } catch (InterruptedException e) {
            // ignore
        }
        
        amount = tmp;
    }

    public void withdraw(float amt) {
        float tmp = amount;
        tmp -= amt;

        try {
            Thread.sleep(100);//模拟其它处理所需要的时间，比如刷新数据库等
        } catch (InterruptedException e) {
            // ignore
        }        

        amount = tmp;
    }

    public float getBalance() {
        return amount;
    }
}



public class AccountTest{
    private static int NUM_OF_THREAD = 3;
    static Thread[] threads = new Thread[NUM_OF_THREAD];
    
    public static void main(String[] args){
        final Account acc = new Account("John", 1000.0f);
        final Account acb = new Account("John", 1000.0f);
        for (int i = 0; i< NUM_OF_THREAD; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                        acc.deposit(100.0f);
                        acb.withdraw(100.0f);
                }
            });
            threads[i].start();
        }

        for (int i=0; i<NUM_OF_THREAD; i++){
            try {
                threads[i].join(); //等待所有线程运行结束
            } catch (InterruptedException e) {
                // ignore
            }
        }
        System.out.println("Finally, John's balance is:" + acc.getBalance());
        System.out.println("Finally, John's balance is:" + acb.getBalance());
    }

}