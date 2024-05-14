package view;

import controller.Controller;
import model.observer.MovieObserver;
import model.observer.Observer;
import model.observer.Subject;
import model.strategy.SearchStrategy;
import model.strategy.Strategy;

public class MovieClient {
    public static void main(String[] args) {
        // Configuração inicial
        Subject subject = new Subject();
        Controller controller = new Controller(subject);

        // Adiciona observador para atualização da visualização
        Observer movieObserver = new MovieObserver();
        subject.addObserver(movieObserver);

        // Define e executa uma estratégia
        Strategy strategy = new SearchStrategy();
        controller.setStrategy(strategy);
        controller.executeStrategy();
    }
}
