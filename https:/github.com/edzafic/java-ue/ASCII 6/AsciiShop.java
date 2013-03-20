import java.util.Scanner;


public class AsciiShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner sc= new Scanner(System.in);
	String befehl=sc.next();
	
	if (!befehl.equals("create")){
		System.out.println("INPUT MISMATCH");
		return;
	}
	
	if(!sc.hasNextInt()){
		System.out.println("INPUT MISMATCH");
	}
	
	int x=sc.nextInt();
	if (x<=0 ||!sc.hasNextInt()){
		System.out.println("INPUT MISMATCH");
	}
	
	int y=sc.nextInt();
	if(y<=0){
		System.out.println("INPUT MISMATCH");
	}
	
	AsciiImage ai= new AsciiImage (x,y);
	
	
	while(sc.hasNext() ){
		String command=sc.next();
		
		if(command.equals("clear")){
			ai.clear();
		}
		
		else if(command.equals("print")){
			System.out.println(ai.toString());
		}
		
		else if(command.equals("load")){
			if(!sc.hasNextLine()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			
			String abbruch= sc.next();
			sc.nextLine();
			String zeile="";
			
			while(sc.hasNextLine()){
				zeile=sc.nextLine();
				if(zeile.contains(abbruch)){
					break;
				}
				
				if (!ai.load(zeile)){
					System.out.println("INPUT MISMATCH");
					
					return;
				}
				
				if(ai.getCounter()>ai.getHight()){
					System.out.println("INPUT MISMATCH");
					break;
				}
				
			}
			
		}
		
		else if(command.equals("replace")){
			if(!sc.hasNext()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			String a=sc.next();
			if(a.length()>1){
				System.out.println("INPUT MISMATCH");
				break;
			}
			char oldChar = a.charAt(0);
			
			if(!sc.hasNext()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			String b=sc.next();
			if(b.length()>1){
				System.out.println("INPUT MISMATCH");
				break;
			}
			char newChar = b.charAt(0);
			ai.replace(oldChar, newChar);
		}
	
	
		
		else if(command.equals("transpose")){
			ai.transpose();
		}
		
		else if(command.equals("fill")){
			
			if(!sc.hasNextInt()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			
			int c=sc.nextInt();
			if (c<0 || c>=ai.getWidth() ||!sc.hasNextInt()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			
			int d=sc.nextInt();
			if(d<0 || d>ai.getHight()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			
			if(!sc.hasNext()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			String a=sc.next();
			if(a.length()>1){
				System.out.println("INPUT MISMATCH");
				break;
			}
			char b=a.charAt(0);
			ai.setToReplace(c, d);
			ai.fill(c,d,b);
		
		
		}
		
		else if(command.equals("centroid")){
			String a=sc.next();
			sc.nextLine();
			if(a.length()>1){
				System.out.println("INPUT MISMATCH");
				break;
			}
			char b=a.charAt(0);
			System.out.println(ai.getCentroid(b).toString());
		}
	
		else if(command.equals("grow")){
			String a=sc.next();
		//	sc.nextLine();
			if(a.length()>1){
				System.out.println("INPUT MISMATCH");
				break;
			}
			char b=a.charAt(0);
			ai.growRegion(b);
		}
		
		else if(command.equals("line")){
			if (!sc.hasNextInt()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			int x0= sc.nextInt();
			if (x0<0 || x0>=ai.getWidth()){
				System.out.println("INPUT MISMATCH");
				
			}
			if (!sc.hasNextInt()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			int y0= sc.nextInt();
			if (y0<0 || y0>=ai.getHight()){
				System.out.println("INPUT MISMATCH");
				
			}
			
			if (!sc.hasNextInt()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			int x1= sc.nextInt();
			if (x1<0 || x1>=ai.getWidth()){
				System.out.println("INPUT MISMATCH");
				
			}
			
			if (!sc.hasNextInt()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			int y1= sc.nextInt();
			if (y1<0 || y1>=ai.getHight()){
				System.out.println("INPUT MISMATCH");
				
			}
			
			if (!sc.hasNext()){
				System.out.println("INPUT MISMATCH");
				break;
			}
			char c=sc.next().charAt(0);
			ai.drawLine(x0, y0, x1, y1, c);
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	}
	

}
