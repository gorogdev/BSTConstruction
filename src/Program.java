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

        public int getMinVal(BST bst){
            BST currentNode = bst;
            while(currentNode.left != null){
                currentNode = currentNode.left;
            }
            return currentNode.value;
        }

        public BST remove(int value) {
            BST temp= removeHelper(this, value);
            return temp;
        }

        public BST removeHelper(BST bst, int value){
            BST currentNode = bst;
            //no bst exists
            if(bst == null) return null;
            //bst has no children
            if(bst.left == null && bst.right == null) return null;

            //check value, determine direction
            if(currentNode.value < value){
                currentNode.right = removeHelper(currentNode.right, value);
            } else if(currentNode.value > value){
                currentNode.left = removeHelper(currentNode.left, value);
            } else{ //value equals current node value

                //has zero children
                if(currentNode.left == null && currentNode.right == null){
                    return null;
                }

                //has only left child
                if(currentNode.left != null && currentNode.right == null){
                    //the left child replaces its parent
                    currentNode.value = currentNode.left.value; //move value up
                    currentNode.right = currentNode.left.right != null ? currentNode.left.right : null; //old child's right
                    currentNode.left = currentNode.left.left != null ? currentNode.left.left : null;   //old child's left
                    return currentNode;
                }

                //has only right child
                if(currentNode.left == null && currentNode.right != null){
                    //right child replaces parent
                    currentNode.value = currentNode.right.value;
                    currentNode.left = currentNode.right.left != null ? currentNode.right.left : null;
                    currentNode.right = currentNode.right.right != null ? currentNode.right.right : null;
                    return currentNode;
                }

                //has both children
                if(currentNode.left != null && currentNode.right != null){
                    int min = currentNode.getMinVal(currentNode);
                    currentNode.value = min;
                    currentNode.right = removeHelper(currentNode.right, min);
                    return currentNode;
                }
            }
            return currentNode;
        }
    }
}
