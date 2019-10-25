public class BST<T extends Comparable<T>>{

	private Node<T> root; 

	public BST(){
		root = null;
	}

	public boolean find(T item){
		return find(root, item);
	}

   private boolean find(Node<T> root, T item)
   {
   	if (root == null){
   		return false;
   	}
   	if (item.compareTo(root.returnData())==0){
   		return true;
   	}
   	if (item.compareTo(root.returnData())<0){
   		return find(root.left, item);
   	} else {
   		return find(root.right, item);
   	}
   }

	public void insert(T item){
		root = insert(root, item);
	}
	private Node<T> insert(Node<T> root, T item){
		if (root == null){
			return new Node<T>(item); 
		}
		if (item.compareTo(root.returnData()) < 0){
			root.left = insert(root.left, item);
		} else if (item.compareTo(root.returnData()) > 0){
			root.right = insert(root.right, item);
		}
		return root;
	}

	public void print(){
		print(this.root);
	}
	private void print(Node<T> root){
		if(root != null){
			print(root.left);
			System.out.println(root.returnData());
			print(root.right);
		}
	}

	public void delete(T item){
		root = delete(this.root, item);
	}
	private Node<T> delete(Node<T> root, T item){
		if (root == null){
			return null; 
		}
		if (item.compareTo(root.returnData()) == 0){
			if(root.left == null){
				return root.right;
			} else if (root.right == null){
				return root.left;
			}
			root.setData(findSmallest(root.right));
			delete(root.right, root.returnData());

		}
		if (item.compareTo(root.returnData()) < 0){
			root.left = delete(root.left, item);
		} else {
			root.right = delete(root.right, item);
		}
		return root;
	}

	private T findSmallest(Node<T> root){
		T smallest = root.returnData();

		while(root.left != null){
			if (root.left.returnData().compareTo(smallest) < 0){
				smallest = root.left.returnData();
				root = root.left;
			}
		}

		return smallest;
	}



}