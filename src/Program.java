import java.util.*;

class Program {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST currentNode = this;
            while(true){
                //check left
                if (currentNode.value > value){
                    if(currentNode.left == null){
                        currentNode.left = new BST(value);
                        break;
                    } else{
                        currentNode = currentNode.left;
                    }
                }
                //check right
                if (currentNode.value <= value){
                    if(currentNode.right == null){
                        currentNode.right = new BST(value);
                        break;
                    } else{
                        currentNode = currentNode.right;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            BST currentNode = this;
            while(true){
                if(currentNode.value == value) return true;
                //check whether to go left
                if(currentNode.value > value){
                    if(currentNode.left == null){
                        break;
                    } else{
                        currentNode = currentNode.left;
                        continue;
                    }
                }
                //check whether to go right
                if(currentNode.value < value){
                    if(currentNode.right == null){
                        break;
                    } else{
                        currentNode = currentNode.right;
                        continue;
                    }
                }
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            return this;
        }
    }
}
