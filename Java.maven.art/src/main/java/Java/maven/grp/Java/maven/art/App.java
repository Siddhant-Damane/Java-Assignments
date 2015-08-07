package Java.maven.grp.Java.maven.art;



public class App 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RemoveDuplicates rd = new RemoveDuplicates();
		
		int[] arr = new int[] { 1, 2, 3, 3, 4, 5,5,5,6 };
		
		rd.removeduplicates(arr);
		
		for(int i=0 ; i<(arr.length);i++)
		System.out.print(" " + arr[i] + " ");
		
	}
}
