package client;
           

import org.omg.CosNaming.*;  // HelloClient will use the naming service.
import org.omg.CORBA.*;      // All CORBA applications need these classes.

import calculator.common.*;// The package containing our stubs.

/**
 
 *  
 *  @author Melanie Goebel
 * 
 * */
public class Client {
	public Client(String[] args){
		try
		{
		// Create and initialize the ORB
		ORB orb = ORB.init(args, null);

		// Get the root naming context
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContext ncRef = NamingContextHelper.narrow(objRef);

		// Resolve the object reference in naming
		NameComponent nc = new NameComponent("Calculate", "");
		NameComponent path[] = {nc};
		Calculator calculatorRef = CalculatorHelper.narrow(ncRef.resolve(path));

		// Call the Hello server object and print results
		int message = calculatorRef.add(0, 0);
		System.out.println( message);
		}
	catch(Exception e) {
		System.out.println("ERROR : " + e);
		e.printStackTrace(System.out);
		}  
	}
	}

