public class Item {
        private int id;
        private int quantidade;
        private float precoUnitario;

        public Item(int id, int quantidade, float precoUnitario){
            this.id = id;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
        }
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public int getQuantidade() {
            return quantidade;
        }
    
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    
        public float getPrecoUnitario() {
            return precoUnitario;
        }
    
        public void setPrecoUnitario(float precoUnitario) {
            this.precoUnitario = precoUnitario;
        }
    
        public float calcularTotal() {
            return quantidade * precoUnitario;
        }
    }