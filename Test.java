public class Test{
	public static void main(String[] args){
		String name="Mukund";
		boolean result=name instanceof String;
		System.out.println(result);

		int a[]={1,2,3,4,5};
		for(int x: a){
			System.out.println(x);
		}
		int [] numbers = {10, 20, 30, 40, 50};

	        for(int i=0;i<5;i++ ) {
		  System.out.print( numbers[i] );
		  System.out.print(",");
	        }
	        System.out.print("\n");
	        String [] names = {"James", "Larry", "Tom", "Lacy"};

	        for( String nam : names ) {
		  System.out.print( nam );
		  System.out.print(",");
	        }
	}
}
