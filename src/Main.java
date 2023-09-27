public class Main {
    public static void main(String[] args) {
        ArvoreBinaria tree = new ArvoreBinaria();

        tree.insert(50);
        tree.insert(30);
        tree.insert(60);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);

        System.out.println("Árvore Binária de Busca:");
        tree.printArvore();

        int searchValue = 30;
        System.out.println("Buscar " + searchValue + ": " + tree.search(searchValue));

        int deleteValue = 30;
        tree.delete(deleteValue);
//        System.out.println("Removido " + deleteValue + " da árvore:");
        tree.printArvore();
    }
}