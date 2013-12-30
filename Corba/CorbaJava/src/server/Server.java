package server;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import others.M;
import calculator.common.CalculatorHelper;

/**
 * 
 * @author Hannah Siegel
 * 
 */
public class Server {
	CalculatorImpl m_calcImpl = null;

	public Server(String[] args) {
		System.out.println("starting server");

		try {
			// TODO policies?

			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// get reference to rootpoa & activate the POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			//TODO:  am ende???
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB
			m_calcImpl = new CalculatorImpl(orb);

			// get object reference from the servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(m_calcImpl);

			//TODO noon ca marche pas cest c et c
            // The reference is converted to a character string
            String s = orb.object_to_string(ref);
            M.debug("The IOR of the object is: "+s);
            
            
			//Calculator href = (Calculator) CalculatorHelper.narrow(ref);

			//NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
			NamingContext ncRef = NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
			M.debug("Hello");
			   org.omg.CosNaming.NameComponent[] name = new org.omg.CosNaming.NameComponent[1];
	            name[0] = new NameComponent();
	            name[0].id = "CalculatorService";
	            name[0].kind = "";
				M.debug("Hello2");

			ncRef.rebind(name, ref); 
			M.debug("Hello3");

			System.out.println("Server ready and waiting for requests...");

			// wait for invocations from clients
			orb.run();

		}

		catch (Exception e) {
			M.printException(e);
			e.printStackTrace();
		}

		System.out.println("Server's done ...");

	}

}
