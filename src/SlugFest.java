import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SlugFest extends RefQueue{
	int timer = 0;
	RefQueue[] lines = new RefQueue[5];
	int[] cStartTime = new int[5];
	
	public static void main(String[] args) throws IOException{
		SlugFest sf = new SlugFest();
		// check number of command line arguments is at least 2
		if(args.length < 2){
			System.out.println("Usage: java –jar SlugFest.jar <input file> <output file>");
			System.exit(1);
		}
		// open files
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new File(args[1]));
		// read lines from in, write lines to out

		sf.getArrivals(0, args[0]); 

		// close files
		in.close();
		out.close();
	}
	
	public void getArrivals(int time, String filename) throws FileNotFoundException {
		Scanner input = new Scanner(new File(filename));
		
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			String[]numbers = line.split("\\s+");
			
			int lineNumber = Integer.parseInt(numbers[0]);
			String nameCustomer = numbers[1];
			int arrivalTime = Integer.parseInt(numbers[2]);
			int timeofService = Integer.parseInt(numbers[3]);
			
			BankTeller b = new BankTeller(lineNumber, nameCustomer, arrivalTime, timeofService);
			System.out.println(b.arrivalTime);
			System.out.println(b.lineNumber);
			 if(b.arrivalTime == time) {
				 switch(b.lineNumber) {
				 case 1: 
					 lines[0].enqueue(b);
					 System.out.println(b.arrivalTime);
					 if(lines[0].size == 1){
						 cStartTime[0] = time;
					 }
				 case 2: 
					 lines[1].enqueue(b);
					 if(lines[1].size == 1){
						 cStartTime[1] = time;
					 }
				 case 3: 
					 lines[2].enqueue(b);
					 if(lines[2].size == 1){
						 cStartTime[2] = time;
					 }
				 case 4: 
					 lines[3].enqueue(b);
					 if(lines[3].size == 1){
						 cStartTime[3] = time;
					 }
				 case 5: 
					 lines[4].enqueue(b);
					 if(lines[4].size == 1){
						 cStartTime[4] = time;
					 }
				 }
			 }
		}
		time++;
	}

	
	
}
