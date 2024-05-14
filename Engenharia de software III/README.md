# Engenharia de Software III
<table>
    <tr>
        <th>Tipos de Padrões</th>
        <th>Antipadrões</th>
        <th>Definição</th>
        <th>O que resolve</th>
        <th>Funcionalidades em Java</th>
    </tr>
    <tr>
        <td>Strategy</td>
        <td>Switch Statements</td>
        <td>O Padrão Strategy permite definir uma família de algoritmos intercambiáveis, útil quando diferentes algoritmos podem ser usados.</td>
        <td>Resolve a seleção dinâmica de algoritmos, sem modificar o código cliente.</td>
        <td>Java Comparable/Comparator</td>
    </tr>
    <tr>
        <td>Observer</td>
        <td>Observers Everywhere</td>
        <td>O Padrão Observer estabelece uma dependência um-para-muitos entre objetos, usado para implementar sistemas de eventos.</td>
        <td>Lida com a notificação automática de mudanças de estado para múltiplos objetos dependentes.</td>
        <td>Event Handling</td>
    </tr>
    <tr>
        <td>Composite</td>
        <td>Unintentional Complexity</td>
        <td>O Padrão Composite permite tratar objetos individuais e composições de objetos de maneira uniforme.</td>
        <td>Resolve a criação de estruturas hierárquicas compostas.</td>
        <td>Swing GUI Components</td>
    </tr>
    <tr>
        <td>Facade</td>
        <td>God Class</td>
        <td>O Padrão Facade fornece uma interface simplificada para subsistemas complexos.</td>
        <td>Aborda a complexidade de subsistemas, oferecendo um ponto de entrada único para os clientes.</td>
        <td>Java Database Connectivity (JDBC)</td>
    </tr>
    <tr>
        <td>Singleton</td>
        <td>Global State</td>
        <td>O Padrão Singleton garante uma única instância de uma classe e acesso global a ela.</td>
        <td>Resolve a criação acidental de múltiplas instâncias e controla o acesso global a recursos.</td>
        <td>Runtime Environment (Ambiente de Execução)</td>
    </tr>
</table>

### (Diagramas UML e Códigos Referentes aos Design Patterns aprendidos na Aula)


- ### Strategy

    <div>
    <img src='../Engenharia de software III/Diagrams/strategy/Strategy.jpg'> </img>
    </div>


```java
    // Interface para a Strategy
interface Strategy {
    List<Movie> execute(List<Movie> data);
}

// Strategy para Pesquisar Filmes
class SearchStrategy implements Strategy {
    private String searchTerm;

    public SearchStrategy(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public List<Movie> execute(List<Movie> data) {
        List<Movie> searchResults = new ArrayList<>();
        for (Movie movie : data) {
            if (movie.getTitle().contains(searchTerm) || movie.getDescription().contains(searchTerm)) {
                searchResults.add(movie);
            }
        }
        return searchResults;
    }
}

// Strategy para Filmes Mais Assistidos
class MostWatchedStrategy implements Strategy {
    @Override
    public List<Movie> execute(List<Movie> data) {
        // Implementação para encontrar os filmes mais assistidos
        // ...
        return null;
    }
}

// Strategy para Filmes Favoritos
class FavoritedStrategy implements Strategy {
    @Override
    public List<Movie> execute(List<Movie> data) {
        // Implementação para buscar os filmes favoritos
        // ...
        return null;
    }
}

// Classe de contexto para a Strategy interface
class MovieList {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Movie> filterMovies(List<Movie> data) {
        return strategy.execute(data);
    }
}

// Cliente
public class MovieClient {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        // Adicione filmes à lista 'movies'

        MovieList movieList = new MovieList();

        // Estratégia de pesquisa
        movieList.setStrategy(new SearchStrategy("comedy"));
        List<Movie> searchResults = movieList.filterMovies(movies);
        // Exiba os resultados da pesquisa

        // Estratégia de filmes mais assistidos
        movieList.setStrategy(new MostWatchedStrategy());
        List<Movie> mostWatchedMovies = movieList.filterMovies(movies);
        // Exiba os filmes mais assistidos

        // Estratégia de filmes favoritos
        movieList.setStrategy(new FavoritedStrategy());
        List<Movie> favoritedMovies = movieList.filterMovies(movies);
        // Exiba os filmes favoritos
    }
}

class Movie {
    private String title;
    private String description;
}


 ```

- ### Observer

    <div>
    <img src='../Engenharia de software III/Diagrams/observer/Observer.jpg'> </img>    
    </div>

```java 
    public interface Subject {
        void subscribe(Subscriber subscriber);
        void unsubscribe(Subscriber subscriber);
        void notifySubscribers(String filename);
    }

    public class Publisher implements Subject {
        private final List<Subscriber> subscribers = new ArrayList<>();

        @Override
        public void subscribe(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        @Override
        public void unsubscribe(Subscriber subscriber) {
            subscribers.remove(subscriber);
        }

        @Override
        public void notifySubscribers(String filename) {
            for (Subscriber subscriber : subscribers) {
            subscriber.update(filename);
            }
        }

        public void doSomething() {
            String filename = "data.txt";
            notifySubscribers(filename);
        }
    }

    public interface Subscriber {
        void update(String filename);
    }

    public class EmailAlertListener implements Subscriber {

        @Override
        public void update(String filename) {
            System.out.println("EmailAlertListener: New file: " + filename);
        }
    }

    public class LoggingListener implements Subscriber {

    @Override
    public void update(String filename) {
            System.out.println("LoggingListener: New file: " + filename);
        }
    }

    public class ObserverDemo {

    public static void main(String[] args) {
            Publisher publisher = new Publisher();

            Subscriber emailAlertListener = new EmailAlertListener();
            publisher.subscribe(emailAlertListener);

            Subscriber loggingListener = new LoggingListener();
            publisher.subscribe(loggingListener);

            publisher.doSomething();
        }
    }

```

- ### Composite

    <div>
    <img src='../Engenharia de software III/Diagrams/composite/Composite.jpg'> </img>    
    </div>


```java

// Interface para o Componente
interface Componente {
    void operacao();
}

// Implementação de Botao
class Botao implements Componente {
    @Override
    public void operacao() {
        System.out.println("Botão: Operação");
    }
}

// Implementação de Input
class Input implements Componente {
    @Override
    public void operacao() {
        System.out.println("Input: Operação");
    }
}

// Implementação de Div, que é um componente composto
class Container implements Componente {
    private List<Componente> elementos = new ArrayList<>();

    public void adicionar(Componente elemento) {
        elementos.add(elemento);
    }

    public void remover(Componente elemento) {
        elementos.remove(elemento);
    }

    public List<Componente> getElementos() {
        return elementos;
    }

    @Override
    public void operacao() {
        for (Componente elemento : elementos) {
            elemento.operacao();
        }
    }
}

// Classe de demonstração do Composite
public class DemoComposite {

    public static void main(String[] args) {
        Container container = new Container();
        container.adicionar(new Botao());
        container.adicionar(new Input());

        Container outroContainer = new Container();
        outroContainer.adicionar(new Input());
        outroContainer.adicionar(new Botao());
        container.adicionar(outroContainer);

        container.operacao();
    }
}

```

- ### Singleton

    <div>
    <img src='../Engenharia de software III/Diagrams/singleton/Singleton.jpg'> </img>
    </div>

```java
public class ConexaoBD {
    private static ConexaoBD instancia;
    private String stringConexao;

    private ConexaoBD(String stringConexao) {
        this.stringConexao = stringConexao;
        // Simula inicialização da conexão
        System.out.println("ConexaoBD: Inicializando conexão...");
    }

    public static ConexaoBD obterInstancia(String stringConexao) {
        if (instancia == null) {
            synchronized (ConexaoBD.class) {
                if (instancia == null) {
                    instancia = new ConexaoBD(stringConexao);
                }
            }
        }
        return instancia;
    }

    // Métodos específicos para interagir com o conector do banco de dados
    public void executarConsulta(String consulta) {
        System.out.println("ConexaoBD: Executando consulta: " + consulta);
    }
}


```

- ### Facade

    <div>
    <img src='../Engenharia de software III/Diagrams/facade/Facade.jpg'> </img>
    </div>

```java
// Interface para a Fachada de Pagamento
public interface PagamentoFacade {
    boolean processarPagamento(int idPedido, double valor, String metodoPagamento);
}

// Classe de Processamento de Pagamento
public class ProcessadorPagamento {
    private final ServicoPedido servicoPedido;
    private final ServicoPagamento servicoPagamento;

    public ProcessadorPagamento(ServicoPedido servicoPedido, ServicoPagamento servicoPagamento) {
        this.servicoPedido = servicoPedido;
        this.servicoPagamento = servicoPagamento;
    }

    public boolean processarPagamento(int idPedido, double valor, String metodoPagamento) {
        Pedido pedido = servicoPedido.obterPedido(idPedido);
        if (pedido == null) {
            return false;
        }
        if (pedido.getValorDevido() != valor) {
            return false;
        }
        return servicoPagamento.efetuarPagamento(valor, metodoPagamento);
    }
}

// Classe de Serviço de Pedido
public class ServicoPedido {
    // Simula a lógica de obter os detalhes do pedido
    public Pedido obterPedido(int idPedido) {
        // ...
        return new Pedido(idPedido, 100.0, "pendente");
    }
}

// Classe de Serviço de Pagamento
public class ServicoPagamento {
    // Simula lógica de processamento de pagamento
    public boolean efetuarPagamento(double valor, String metodoPagamento) {
        // ...
        return true;
    }
}

// Cliente de Pagamento
public class ClientePagamento {

    public static void main(String[] args) {
        ServicoPedido servicoPedido = new ServicoPedido();
        ServicoPagamento servicoPagamento = new ServicoPagamento();
        PagamentoFacade pagamentoFacade = new ProcessadorPagamento(servicoPedido, servicoPagamento);

        int idPedido = 1;
        double valor = 100.0;
        String metodoPagamento = "cartao_de_credito";

        boolean sucesso = pagamentoFacade.processarPagamento(idPedido, valor, metodoPagamento);
        if (sucesso) {
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.println("Falha no pagamento!");
        }
    }
}

class Pedido {
    private int id;
    private double valorDevido;
    private String status;

    public Pedido(int id, double valorDevido, String status) {
        this.id = id;
        this.valorDevido = valorDevido;
        this.status = status;
    }

    // Getters e setters
    // ...
}


```
