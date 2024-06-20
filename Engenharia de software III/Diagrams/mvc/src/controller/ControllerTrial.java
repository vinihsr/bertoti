public class ControllerTrial implements ControllerInterface {
    private View view;
    private Subject model;

    public ControllerTrial(View view, Subject model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public String update(String str) {
        model.addNotification(str);
        return str;
    }

    @Override
    public void notify() {
        model.notifyObservers();
    }

    @Override
    public void save() {
        // Implementation of save logic
    }
}