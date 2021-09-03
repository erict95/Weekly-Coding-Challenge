package arrayToTree;

public class ArrayToTree {
	
	public static void main(String[] args) {
		TreeNodeConstructor root;
		int arr[] = new int[]{4, 1, 2, 3, 6, 5, 7};
		sortArray(arr);
		int n = arr.length;
		root = sortedArrayToBST(arr, 0, n - 1);
		System.out.println("Preorder traversal of constructed BST");
		preOrder(root);
	}
	
	//A function that will sort your array before it is converted to a balanced binary search tree
	public static int[] sortArray(int arr[]) {
		for (int x = 0; x < (arr.length-1); x++) {
			if((x+1) > (arr.length-1))
				break;
			else if (arr[x] > arr[x+1]) {
				arr[x] = arr[x] + arr[x+1];
				arr[x+1] = arr[x] - arr[x+1];
				arr[x] = arr[x] - arr[x+1];
			}
		}
		return arr;
	}
	
	//A function that constructs Balanced Binary Search Tree from a sorted array
	public static TreeNodeConstructor sortedArrayToBST(int arr[], int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNodeConstructor TreeNodeConstructor = new TreeNodeConstructor(arr[mid]);
		TreeNodeConstructor.left = sortedArrayToBST(arr, start, mid - 1);
		TreeNodeConstructor.right = sortedArrayToBST(arr, mid + 1, end);
		
		return TreeNodeConstructor;
	}

	// A utility function to print root traversal of BST
	public static void preOrder(TreeNodeConstructor TreeNodeConstructor) {
		if (TreeNodeConstructor == null) {
			return;
		}
		System.out.print(TreeNodeConstructor.data + " ");
		preOrder(TreeNodeConstructor.left);
		preOrder(TreeNodeConstructor.right);
	}
}