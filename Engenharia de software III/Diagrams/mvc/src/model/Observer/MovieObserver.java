package model.observer;

public class MovieObserver implements Observer {
    @Override
    public void update() {
        // Lógica para lidar com a notificação de mudança nos filmes
        System.out.println("Atualizando visualização de filmes...");
    }
}
