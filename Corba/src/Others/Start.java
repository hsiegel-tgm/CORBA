
package Others;

import Server.Server;
import Client.Client;

public class Start {
	public static void main(String arg[]){
		if((!(arg.length==0))||(!(arg==null))){
			if(arg[0].equals("Client")){
				new Client();
			}
			else if(arg[0].equals("Server")){
				new Server();			
			}
			else{
				printUsage();
			}
		}
		else{
			printUsage();
		}
	}
	
	public static void printUsage(){
		System.out.println("usage: ");	
		System.exit(-1);
	}
}
