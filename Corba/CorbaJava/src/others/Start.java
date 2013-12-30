
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
                        	String a [] = new String [4];

                        	a [0]= "-ORBInitialPort";
                        	a [1]= "1050";
                        	a [2]= "-ORBInitialHost";
                        	a [3]= "-localhost&";
                                new Client(null);
                        }
                        else if(arg[0].equals("Server")){
                        	String a [] = new String [4];
                        	a [0]= "-ORBInitialPort";
                        	a [1]= "1050";
                        	a [2]= "-ORBInitialHost";
                        	a [3]= "-localhost&";

                        	new Server(null);   //TODO: Aendern!!                     
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