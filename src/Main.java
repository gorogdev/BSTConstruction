public class Main {
    public static void main(String[] args) {

        System.out.println("Testing BST Construction");

        Program.BST bst = new Program.BST(5);
        bst.insert(3).insert(55).insert(2);
        int testLeft = bst.left.value;
        int testRight = bst.right.value;


        System.out.println("Testing left: " + testLeft);
        System.out.println("Testing right: " + testRight);

        //test grandchild
        System.out.println("Testing left grandchild: " + bst.left.left.value);

//        System.out.println("Testing, contains 2: " + bst.contains(2));
//        System.out.println("Testing, contains 3: " + bst.contains(3));
//        System.out.println("Testing, contains 5: " + bst.contains(5));
//        System.out.println("Testing, contains 55: " + bst.contains(55));
//        System.out.println("Testing, contains -6: " + bst.contains(-6));
//        System.out.println("Testing, contains 777: " + bst.contains(777));


        bst.remove(2);
        System.out.println("removed 2, testing....");
        System.out.println("Testing, contains 2: " + bst.contains(2));
        System.out.println("Testing, contains 3: " + bst.contains(3));
        System.out.println("Testing, contains 5: " + bst.contains(5));
        System.out.println("Testing, contains 55: " + bst.contains(55));



    }
}