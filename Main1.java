class Customer {
    void requestAvailability(EventSystem system, String date) {
        system.checkVenueAvailability(this, date);
    }

    void receiveAvailabilityInfo(boolean available) {
        if (available) {
            System.out.println("Клиент: Ақпарат алдым. Площадка қолжетімді!");
        } else {
            System.out.println("Клиент: Басқа күн іздеймін...");
        }
    }

    void confirmBooking(EventSystem system) {
        system.processPayment();
    }

    void receivePaymentResult(boolean success) {
        if (success) {
            System.out.println("Клиент: Брондау расталды!");
        } else {
            System.out.println("Клиент: Қайта төлем жасаймын.");
        }
    }

    void receiveFeedbackRequest() {
        System.out.println("Клиент: Қызметті бағалау!");
    }
}

class EventSystem {
    PaymentGateway paymentGateway;
    VenueAdmin admin;
    Contractor[] contractors;
    Manager manager;

    EventSystem(PaymentGateway pg, VenueAdmin ad, Contractor[] c, Manager m) {
        paymentGateway = pg;
        admin = ad;
        contractors = c;
        manager = m;
    }

    void checkVenueAvailability(Customer customer, String date) {
        boolean available = true;
        customer.receiveAvailabilityInfo(available);
    }

    void processPayment() {
        boolean success = paymentGateway.pay();
        if (success) {
            admin.notifyBookingConfirmed();
        }
    }

    void organizeEvent() {
        admin.prepareTasks();
        for (Contractor c : contractors) c.receiveTask();
        for (Contractor c : contractors) c.completeTask();
        admin.receiveReport();
    }

    void finishEvent(Customer customer) {
        customer.receiveFeedbackRequest();
        manager.receiveFeedbackReport();
    }
}

class PaymentGateway {
    boolean pay() {
        System.out.println("Платеж өткізіліп жатыр...");
        return true;
    }
}

class VenueAdmin {
    void notifyBookingConfirmed() {
        System.out.println("Админ: Брон расталды!");
    }
    void prepareTasks() {
        System.out.println("Админ: Тапсырмалар жасалды");
    }
    void receiveReport() {
        System.out.println("Админ: Барлығы дайын!");
    }
}

class Contractor {
    void receiveTask() {
        System.out.println("Подрядчик: Тапсырма алынды");
    }
    void completeTask() {
        System.out.println("Подрядчик: Тапсырма аяқталды");
    }
}

class Manager {
    void receiveFeedbackReport() {
        System.out.println("Менеджер: Клиент пікірлерін алдым!");
    }
}

public class Main1 {
    public static void main(String[] args) {
        Contractor[] contractors = {new Contractor(), new Contractor()};
        EventSystem system = new EventSystem(new PaymentGateway(), new VenueAdmin(), contractors, new Manager());
        Customer customer = new Customer();

        customer.requestAvailability(system, "12.12.2025");
        customer.confirmBooking(system);
        system.organizeEvent();
        system.finishEvent(customer);
    }
}
