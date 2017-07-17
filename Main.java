/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.search.trees;

/**
 *
 * @author tony.tian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*BinarySearchTrees bst = new BinarySearchTrees();
        bst.add('d');
        bst.add('s');
        bst.add('f');
        bst.add('a');
        bst.add('a');
        bst.add('b');
        bst.add('c');
        bst.add('d');
        bst.main();*/
        //bst.remove(15);
        //System.out.println();
        //bst.main();
        
        AVL avl = new AVL();
        avl.insert(11);
        avl.insert(5);
        avl.insert(17);
        avl.insert(3);
        avl.insert(8);
        avl.insert(15);
        avl.insert(27);
        avl.insert(29);
        avl.insert(28);
        avl.insert(30);
        avl.insert(26);
        avl.printTree();
    }
}
