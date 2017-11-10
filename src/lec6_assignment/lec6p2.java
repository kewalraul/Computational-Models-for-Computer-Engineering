package lec6_assignment;

public class lec6p2 {
	
	public static String[] tree;
	
	public void makebranches(int left,int right,int row) {
		
		if(left-right==0) {
			tree[row]+="X";
			return;
		}
		int mid=(left+right)/2;
		for(int i=left;i<=right;i++) {
			if(i==mid) {
				tree[row]+="X";
			}
			else
			{
				tree[row]+="-";
			}
		}
		makebranches(left, mid, row+1);
		makebranches(mid+1,right, row+1);
		
	}
	
	void display(String[] tree) {
		for (int i=0;i<tree.length;i++) {
			System.out.println(tree[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num_rows=0,n=1,treesize=32;
		int rowsize=treesize;
		while(treesize>0) {
			treesize=treesize-n;
			n=n+n;
			++num_rows;		
		}
		
		tree=new String[num_rows];
		lec6p2 obj=new lec6p2();
		for(int i = 0; i <tree.length; i++) {
			tree[i] = "";
		}
		obj.makebranches(0, rowsize-1, 0);
		obj.display(tree);
	}

}
