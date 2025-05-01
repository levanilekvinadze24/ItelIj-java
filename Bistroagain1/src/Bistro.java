public class Bistro {
    private int seats;
    private Thread order, meal, waiter;

    public Bistro(int n) {
        n = seats;

    }

    public synchronized void dine(int price) {
        while (seats <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        seats++;
        notifyAll();
        while (order != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        order = Thread.currentThread();
        notifyAll();
        notifyAll();
        StringBuilder sb = new StringBuilder();
        sb.append("guest");
        sb.append(Thread.currentThread().threadId());
        sb.append("orders for");
        sb.append(price);
        sb.append("lari");
        System.out.println(sb);
        order = null;
        notifyAll();

        StringBuilder sb1 = new StringBuilder();
        sb1.append("Guest");
        sb1.append(Thread.currentThread().threadId());
        sb1.append("eats");
        System.out.println(sb1);
        seats++;
        notifyAll();
    }

    public synchronized void serve() {
        do{
            while (order == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        Thread newcostumer =  order;

            order = null;
            notifyAll();
         while(meal != null){
             try {
                 wait();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }

         meal = order;
            notifyAll();
         System.out.println("enjoyy bro");
        } while (true);
    }

    public synchronized void shutdown(){
        waiter.interrupt();
    }
}
