public class View implements Observer {
    private String type;
    private ControllerInterface controller;
    private String notification;

    public View(String type, ControllerInterface controller) {
        this.type = type;
        this.controller = controller;
    }

    public void createView() {
        // Implementation of view creation logic
    }

    public void update(String str) {
        this.notification = str;
        display();
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof Model) {
            Model model = (Model) subject;
            this.notification = model.getNotifications().get(model.getNotifications().size() - 1);
            display();
        }
    }

    public void display() {
        System.out.println("Notification: " + notification);
    }
}