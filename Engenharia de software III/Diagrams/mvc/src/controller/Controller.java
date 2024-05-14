package controller;

import model.observer.Subject;
import model.strategy.Strategy;

public class Controller {
    private Subject subject;

    public Controller(Subject subject) {
        this.subject = subject;
    }

    public void setStrategy(Strategy strategy) {
        // Lógica para configurar a estratégia
    }

    public void executeStrategy() {
        // Lógica para executar a estratégia
        subject.notifyObservers();
    }
}
