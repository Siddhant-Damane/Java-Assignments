package Java.maven.grp.Java.maven.art;

class RemoveDuplicates {
	
	private int length;
	private int[] temp;
	
	public int[] removeduplicates(int[] arr) {
		
		if(arr.length > 1){
			length = arr.length-1;
			temp = arr;
			myfun( 0, 1);
			
		}
		 
		
		return arr;
	}
	
	
	public int[] myfun( int one, int two_start){
		 
		//System.out.println("one is "+ one + "two is  " + two_start + "length is " + length);
		if(two_start != length){
			
			myfun(two_start,two_start+1);
			
		}
		
		if(temp[one] == temp[two_start]){
			int i = two_start;
			
			while (i != (length )){
			
				temp[i] = temp[i+1];
				i++;
				
			}
			
			temp[i ] =0;
			
		}
		
		
		return temp;
		
	}

}
