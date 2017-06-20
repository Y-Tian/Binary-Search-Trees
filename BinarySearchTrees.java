/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.search.trees;
import java.util.*;

/**
 *
 * @author tony.tian
 */
public class BinarySearchTrees {
    
    private Node root;
    private ArrayList<Comparable> pre = new ArrayList<>();
    private ArrayList<Comparable> post = new ArrayList<>();
    private ArrayList<Comparable> in = new ArrayList<>();
    
    public BinarySearchTrees()
    {
        root = null;
    }
    
    public void add(Comparable c)
    {
        Node n = new Node(c);
        if(root == null)
        {
            root = n;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true)
        {
            parent = current;
            if(c.compareTo(current.getData()) < 0)
            {
                current = current.getLeft();
                if(current == null)
                {
                    parent.setLeft(n);
                    return;
                }
            }
            else
            {
                current = current.getRight();
                if(current == null)
                {
                    parent.setRight(n);
                    return;
                }
            }
        }
    }
    
    public void remove(Comparable c)
    {
        Node temp = root;
        Node current = root;
        boolean left = false;
        while(current.getData() != c)//finds the chosen 
        {
            temp = current;
            if(current.getData().compareTo(c) > 0)
            {
                left = true;
                current = current.getLeft();
            }
            else
            {
                current = current.getRight();
            }
            if(current == null)
            {
                System.out.println("Not a part of the tree");
                return;
            }
        }
        if(current.getLeft() == null && current.getRight() == null)//if chosen node has no children//deletes that node
        {
            if(current == root)
            {
                root = null;//deletes the root
            }
            if(left)
            {
                temp.setLeft(null);
            }
            else
            {
                temp.setRight(null);
            }
        }
        else if(current.getRight() == null)//if chosen only has one child//check left first
        {
            if(current == root)
            {
                root = current.getLeft();
            }
            else if(left)
            {
                temp.setLeft(current.getLeft());
            }
            else
            {
                temp.setRight(current.getLeft());
            }
        }
        else if(current.getLeft() == null)//check right
        {
            if(current == root)
            {
                root = current.getRight();
            }
            else if(left)
            {
                temp.setLeft(current.getRight());
            }
            else
            {
                temp.setRight(current.getRight());
            }
        }
        else if(current.getLeft() != null && current.getRight() != null)//check
        {
            Node child = removeHelper(current);
            if(current == root)
            {
                root = child;
            }
            else if(left)
            {
                temp.setLeft(child);
            }
            else
            {
                temp.setRight(child);
            }
            child.setLeft(current.getLeft());
        }
    }
    
    public Node removeHelper(Node n)
    {
        Node child = null;
        Node parent = null;
        Node current = n.getRight();
        while(current != null)
        {
            parent = child;
            child = current;
            current = current.getLeft();
        }
        if(child != n.getRight())
        {
            parent.setLeft(child.getRight());
            child.setRight(n.getRight());
        }
        return child;
    }
    
    public Node get(Comparable c)
    {
        Node current = root;
        while(current != null)
        {
            if(current.getData() == c)
            {
                break;
            }
            else if(current.getData().compareTo(c) > 0)
            {
                current = current.getLeft();
            }
            else
            {
                current = current.getRight();
            }
        }
        return current;
    }
    
    public Comparable[] toArrayPre()
    {
        toArrayPreHelper(root);
        System.out.print(pre);
        return pre.toArray(new Comparable[pre.size()]);
    }
    
    public void toArrayPreHelper(Node n)
    {
        pre.add(n.getData());
        if(n.getLeft() != null)
        {
            toArrayPreHelper(n.getLeft());
        }
        if(n.getRight() != null)
        {
            toArrayPreHelper(n.getRight());
        }
    }
    
    public Comparable[] toArrayPost()
    {
        toArrayPostHelper(root);
        System.out.println(post);
        return post.toArray(new Comparable[post.size()]);
    }
    
    public void toArrayPostHelper(Node n)
    {      
        if(n.getLeft() != null)
        {
            toArrayPostHelper(n.getLeft());
        }
        if(n.getRight() != null)
        {
            toArrayPostHelper(n.getRight());
        }
        post.add(n.getData());
    }
    
    public Comparable[] toArrayIn()
    {
        toArrayInHelper(root);
        System.out.println(in);
        return in.toArray(new Comparable[in.size()]);
    }
    
    public void toArrayInHelper(Node n)
    {
        if(n.getLeft() != null)
        {
            toArrayInHelper(n.getLeft());
        }
        in.add(n.getData());
        if(n.getRight() != null)
        {
            toArrayInHelper(n.getRight());
        }    
    }
    
    public void main()//main method
    {
        printTreeMap(root);
        System.out.println();
        System.out.println("preOrder: ");
        toArrayPre();
        System.out.println();
        System.out.println("postOrder: ");
        toArrayPost();
        System.out.println("inOrder: ");
        toArrayIn();
    }
    
    public void printTree(Node n)//TESTING
    {
        if(n != null)
        {
            printTree(n.getLeft());
            System.out.println(" " + n.getData());
            printTree(n.getRight());
        }
    }
    
    public void printTreeMap(Node n)//testing
    {
        printTreeMapHelper(n);
        if(n.getLeft() != null)
        {
            printTreeMap(n.getLeft());
        }
        if(n.getRight() != null)
        {
            printTreeMap(n.getRight());
        }    
    }
    
    public void printTreeMapHelper(Node n)//testing helper
    {
        System.out.print("Parent: " + n.getData() + " ");
        if(n.getLeft() != null)
        {
            System.out.print("Left: " + n.getLeft().getData() + " ");
        }
        if(n.getRight() != null)
        {
            System.out.print("Right: " + n.getRight().getData() + " ");
        }
        System.out.println();
    }
    
    private class Node
    {
        private Node left;
        private Node right;
        private Comparable data;
        
        private Node(Comparable c)
        {
            data = c;
            left = null;
            right = null;
        }
        
        private Node getLeft()
        {
            return left;
        }
        
        private Node getRight()
        {
            return right;
        }
        
        private void setLeft(Node n)
        {
            left = n;
        }
        
        private void setRight(Node n)
        {
            right = n;
        }
        
        private Comparable getData()
        {
            return data;
        }
    }
    
}
