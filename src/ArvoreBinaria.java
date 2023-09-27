public class ArvoreBinaria {
    //root == raiz
    private Node root;
    //arvore comeca vazia
    public ArvoreBinaria() {
        root = null;
    }

   //insere um valor chamando o metodo aux.
//    public void insert(int value) {
//        root = insertRec(root, value);
//    }

    public void insert(int value) {
        root = insertRec(root, value);
        System.out.println("Inserido " + value + " na árvore:");
        printArvore(root, "");
    }
    private Node insertRec(Node root, int value) {
        //se tiver null, cria um no com o valor
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // verifica pra onde que vai esquerda/direita
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    //busca um valor chamando o metodo aux.
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.data == value) {
            return true;
        }

        if (value < root.data) {
            return searchRec(root.left, value);
        }

        return searchRec(root.right, value);
    }

//    public void delete(int value) {
//        root = deleteRec(root, value);
//    }

   //funcão paradeletar e tbm veficia se existe o valor ou não
    public void delete(int value) {
        if (!search(value)) {
            System.out.println("Valor " + value + " não encontrado. Não excluído.");
            return;
        }
        root = deleteRec(root, value);
        System.out.println("Excluído " + value + " da árvore:");
        printArvore(root, "");
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }
        // verifica se vai excluir pela direita ou esquerda
        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
            // se for igual
        } else {
            // se tiver 1 ou 0 filhos, retorno o mesmo ou null
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //se 2 filhos > deleta o menor a direita
            root.data = minValue(root.right);
            // delta o sucessor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void printArvore() {
        printArvore(root, "");
    }

    private void printArvore(Node root, String prefix) {
        if (root != null) {
            System.out.println(prefix + root.data);
            printArvore(root.left, prefix + "L---");
            printArvore(root.right, prefix + "R---");
        }
    }
}
