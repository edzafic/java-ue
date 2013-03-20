import java.util.ArrayList;


public class AsciiImage  {

	private int width=0;
	private int height=0;
	private char [][] bild;
	int counter=0;
	char toReplace;
	char [][] backup ;



	public AsciiImage(int width, int height){
		this.width=width;
		this.height=height;
		this.bild= new char [this.width][this.height];
		this.backup= new char [this.width][this.height];
		clear();

	}

	public AsciiImage(AsciiImage img){
		AsciiImage ai= img;
	}


	public void clear (){

		char c='.';

		for (int i=0; i<this.width; i++){
			for (int j=0; j<this.height;j++){
				this.bild[i][j]=c;
				//this.backup[i][j]=c;
			}
		}


	}

	public int getCounter(){
		return this.counter;
	}

	public AsciiPoint getCentroid(char c){
		int result = 0;
		int x=0;
		int y=0;
		for (int i=0; i<this.height;i++){
			for (int j=0; j<this.width;j++){
				if(bild[j][i]==c){
					x=x+j;
					y=y+i;
					result++;
				}
			}
		}
		int mx=x/result;
		int my=y/result;
		//	System.out.println(y + " " + result);
		AsciiPoint ap = new AsciiPoint(mx,my);
		if(result==0){
			return null;
		}
		else return ap;

	}

	public char getPixel(AsciiPoint p){
		char c=' ';
		c= bild[p.getX()][p.getY()];
		return c;
	}

	public ArrayList<AsciiPoint> getPointList(char c){

		ArrayList al = new ArrayList<AsciiPoint>();
		for (int i=0; i<this.height;i++){
			for(int j=0; j<this.width;j++){
				if (bild[i][j]==c){
					AsciiPoint ap = new AsciiPoint(i,j);
					al.add(ap);
				}
			}
		}

		return al;	
	}

	public void growRegion(char c){
		
		// prva OPCIJA sa ArrayListama
		//ArrayList<Integer> iovi = new ArrayList<Integer>();
		//ArrayList<Integer> jotovi = new ArrayList<Integer>();
		
		// druga OPCIJA sa array-ima
		int[] iPositions = new int[width];
		int[] jPositions = new int[height];
		int counter =0;
		
		// prodji kroz bild
		for(int i=0; i<this.width-1;i++){
			for (int j=0; j<this.height-1;j++){
				// samo nadji koordinate u bildu gdje se nalazi c
				if (this.bild[i][j]==c){
					
					// prva OPCIJA sa ArrayListama
					//iovi.add(i);	// ubaci i u iove
					//jotovi.add(j);	// ubaci j u jotove
					
					// druga OPCIJA sa array-ima
					iPositions[counter] = i;
					jPositions[counter] = j;
					counter++;

				}

			}
		}
		
		/*
		// prva OPCIJA sa ArrayListama
		for(int k=0; k<iovi.size(); k++){
			// gornji
			if (jotovi.get(k)>0 &&  this.bild[iovi.get(k)][jotovi.get(k)-1]=='.'){
				this.bild[iovi.get(k)][jotovi.get(k)-1]=c;
			}
			// desni
			if (iovi.get(k)<this.width && this.bild[iovi.get(k)+1][jotovi.get(k)]=='.'){
				this.bild[iovi.get(k)+1][jotovi.get(k)]=c;
			}
			// lijevi
			if (iovi.get(k)>0 && this.bild[iovi.get(k)-1][jotovi.get(k)]=='.'){
				this.bild[iovi.get(k)-1][jotovi.get(k)]=c;
			}
			// donji
			if(jotovi.get(k)<this.height && this.bild[iovi.get(k)][jotovi.get(k)+1]=='.'){
				this.bild[iovi.get(k)][jotovi.get(k)+1]=c;
			}
				
		}
		*/
		
		// druga OPCIJA sa array-ima
		while(counter>0){
			counter--;
			// gornji
			if (jPositions[counter]>0 &&  this.bild[iPositions[counter]][jPositions[counter]-1]=='.'){
				this.bild[iPositions[counter]][jPositions[counter]-1]=c;
			}
			// desni
			if (iPositions[counter]<this.width && this.bild[iPositions[counter]+1][jPositions[counter]]=='.'){
				this.bild[iPositions[counter]+1][jPositions[counter]]=c;
			}
			// lijevi
			if (iPositions[counter]>0 && this.bild[iPositions[counter]-1][jPositions[counter]]=='.'){
				this.bild[iPositions[counter]-1][jPositions[counter]]=c;
			}
			// donji
			if(jPositions[counter]<this.height && this.bild[iPositions[counter]][jPositions[counter]+1]=='.'){
				this.bild[iPositions[counter]][jPositions[counter]+1]=c;
			}
				
		}
		
		
	}

	public void setPixel(AsciiPoint p, char c){
		bild[p.getX()][p.getY()]=c;
	}

	public int getHight(){
		return this.height;

	}

	public char getPixel(int x, int y){


		char c=bild[x][y];
		return c;
	}

	public int getWidth(){
		return this.width;
	}

	public void replace (char oldChar, char newChar){

		for (int i=0; i<this.height;i++){
			for (int j=0; j<this.width;j++){
				if (bild[j][i]==oldChar){
					bild[j][i]=newChar;
				}
			}
		}
	}

	public void setPixel(int x, int y, char c){
		bild[x][y]=c;
	}

	public String toString(){
		String result="";
		for(int i=0;i<this.height;i++){
			for(int j=0; j<this.width;j++){
				result=result + bild[j][i];
			}
			result=result + "\n";
		}


		return result;
	}

	public void transpose(){
		char [][] backup= new char [this.height][this.width];
		for (int i =0; i<this.height;i++){
			for(int j=0; j<this.width;j++){
				backup[i][j]=bild[j][i];

			}
		}
		int b=this.height;
		this.height=this.width;
		this.width=b;
		bild=backup;

	}
	public void setToReplace(int x, int y){

		this.toReplace=bild[x][y];

	}
	public void fill(int x, int y, char c){

		if(x<0 || x>=this.width || y<0 || y>= this.height){

			return;
		}


		if (bild[x][y]!=this.toReplace){
			return ;
		}

		bild[x][y]=c;

		fill(x+1,y,c);
		fill(x-1,y,c);
		fill(x,y+1,c);
		fill(x,y-1,c);
	}

	public boolean load(String zeile){

		if(zeile.length()!=this.width){
			return false;
		}

		for(int i=0; i<zeile.length();i++){
			bild[i][counter]=zeile.charAt(i);
		}
		counter++;
		return true;


	}
	public void drawLine (int x0, int y0, int x1, int y1, char c){

		int dx=x1-x0;
		int dy=y1-y0;
		int dxa=Math.abs(x1-x0);
		int dya=Math.abs(y1-y0);
		double steps=0;

		if(dxa>=dya){
			steps=(double)dxa;
		}
		else steps=(double)dya;

		double x=x0;
		double y=y0;
		bild[(int)Math.round(x)][(int)Math.round(y)]=c;

		for (int i=0; i<steps;i++){
			x=x+(dx/steps);
			y=y+(dy/steps);
			//	System.out.println(x+"  "+y);
			bild[(int)Math.round(x)][(int)Math.round(y)]=c;
		}

	}




}
