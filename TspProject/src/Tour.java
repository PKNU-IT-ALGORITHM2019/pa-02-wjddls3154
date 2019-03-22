
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

 

public class Tour {

	
	static int z=0;
	
	static long figtime;

	static point[] position= new point[1000]; //좌표위치

	static int[] fig;
	
	static int pointX; //x좌표

	static int pointY; //y좌표

	static double interval=0;


	public static void main(String[] args) {

		for(int i=0;i<7;i++) {

			long start = System.currentTimeMillis() ; 

			read("input"+i+".txt"); //input으로 시작하는 txt 읽는다

			interval = 10000; // interval 설정

			permute(0,0);

			System.out.println(interval);

			for(int j=0;j<z;j++) {

				System.out.print(fig[j]+" ");

			}

			System.out.print(fig[0]+" ");

			long end = System.currentTimeMillis(); 


		}

	}

	public static void swap(int k, int i) {

		point itmp;

		itmp = position[k]; //같다

		position[k] = position[i]; //같다

		position[i] = itmp; //같다

}

	public static void permute(int k,double total) {

		if(interval < total) {

			return;

		}

		else if(k == z) {

			total += distanceFrom(k-1,0);

			if(interval > total) {

				interval = total;

			for(int i=0;i<z;i++) 

				fig[i]=position[i].num;

			

		  }

		}else {	

		for(int i=k;i<z;i++) {

			swap(k,i);

			permute(k+1,total+distanceFrom(k-1,k));

			swap(k,i);

		  }

		}

	}

	

	public static void read(String file) {

		 try{

	            Scanner scanner = new Scanner(new File(file));

	            z = scanner.nextInt(); 

	            position = new point[z];

	            fig = new int[z];

	            for(int j=0;j<z;j++) {

	            	pointX = scanner.nextInt(); //x좌표 next
	            	pointY = scanner.nextInt(); //y좌표 next
	            	position[j] = new point(pointX,pointY,j);

	            }

	            scanner.close();

	        }

		 catch (NullPointerException npe) {

	            // TODO: handle exception

	        }catch(IOException e){

	            System.out.println(e);

	        }
		 
	}

	public static double distanceFrom(int i,int j) {

	if(i==-1) {
		return 0;
	}

		double deltaXSq = position[i].x-position[j].x;
		double deltaYSq = position[i].y-position[j].y;
		double distance = Math.sqrt((Math.pow(deltaXSq, 2) + Math.pow(deltaYSq, 2)));
		
		return distance;

	}

}