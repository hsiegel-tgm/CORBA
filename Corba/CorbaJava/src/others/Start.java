
package others;

import server.Server;
import client.Client;

public class Start {
        public static void main(String arg[]){
        	System.out.println("Willkommen! \n");
        	if((arg==null)||arg.length==0){
        		printUsage();
        	}
        	else{
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
               
        }
        
        public static void printUsage(){
                System.out.println("usage: ");        
                System.exit(-1);
        }
}