public class BeerBottles{
	public static void main(String []args){
		int n=99;
		String word="bottles";

		while(n>=2){
			System.out.println(n+" "+word+" of beer on the wall, "+n+" "+word+" of beer. ");
			n--;
			if(n==1)
				word="bottle";	
			System.out.println("Take one down and pass it around, "+n+" "+word+" of beer on the wall.");
			System.out.println("");
		}
		System.out.println("1 bottle of beer on the wall, 1 bottle of beer.");
		System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
	}
}
