class Node<T extends Comparable<T>>{
	private T data;
	Node<T> left;
	Node<T> right;

	public Node(T data){
		this.data = data; 
		this.right = null;
		this.left = null;
	}

	public T returnData(){
		return this.data;
	}

	public void setData(T x){
		this.data = x;
	}
}