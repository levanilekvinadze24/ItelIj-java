class BookShop {
    private int totalBooks;
    private int booksSold;

    public BookShop(int totalBooks) {
        this.totalBooks = totalBooks;
        this.booksSold = 0;
    }

    public synchronized void buyBook(int customerId, int booksToBuy) {
        if (booksSold + booksToBuy <= totalBooks) {
            booksSold += booksToBuy;
            System.out.println("Customer " + customerId + " bought " + booksToBuy + " books.");
        } else {
            System.out.println("Customer " + customerId + " could not buy " + booksToBuy + " books. Not enough stock.");
        }
    }
}

class Customer implements Runnable {
    private BookShop bookShop;
    private int customerId;
    private int booksToBuy;

    public Customer(BookShop bookShop, int customerId, int booksToBuy) {
        this.bookShop = bookShop;
        this.customerId = customerId;
        this.booksToBuy = booksToBuy;
    }

    @Override
    public void run() {
        bookShop.buyBook(customerId, booksToBuy);
    }
}

public class BookShopSimulation {
    public static void main(String[] args) {
        BookShop bookShop = new BookShop(10000);

        Thread customer1Thread = new Thread(new Customer(bookShop, 1, 5000));
        Thread customer2Thread = new Thread(new Customer(bookShop, 2, 5000));

        customer1Thread.start();
        customer2Thread.start();

        try {
            customer1Thread.join();
            customer2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total books sold: ");
    }
}

