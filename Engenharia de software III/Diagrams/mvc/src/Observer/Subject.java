import java.util.ArrayList;
import java.util.List;

public interface subject {
    void addNotification(String notification);
    void notifyObservers();
}

public class Model implements Subject {
    private List<Observer> observers;
    private List<String> notifications;

    public Model() {
        observers = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public void addNotification(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void addNotification(String notification) {
        notifications.add(notification);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
