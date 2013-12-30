package server;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


/**
 *  
 *  @author Hannah Siegel
 * 
 */
public class Server {
	
	public Server(String [] args){
		System.out.println("starting server");
		
		    try{
		    	//java.util.Properties props = new java.util.Properties();
		    	//props.setProperty("jacorb.implname","StandardNS");
			    // ORB orb = ORB.init(args, props);

		    	// create and initialize the ORB
		      ORB orb = ORB.init(args, null);

		      // get reference to rootpoa & activate the POAManager
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      
		      
		        //TODO das war bei ihnen vor der ready ausgabe??
		      rootpoa.the_POAManager().activate();

		      // create servant and register it with the ORB
		      HelloImpl helloImpl = new HelloImpl();
		      helloImpl.setORB(orb); 

		      // get object reference from the servant
		      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
		      Hello href = HelloHelper.narrow(ref);
		          
		      // get the root naming context
		      // NameService invokes the name service
		      org.omg.CORBA.Object objRef =
		          orb.resolve_initial_references("NameService");
		      // Use NamingContextExt which is part of the Interoperable
		      // Naming Service (INS) specification.
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		      // bind the Object Reference in Naming
		      String name = "Hello";
		      NameComponent path[] = ncRef.to_name( name );
		      ncRef.rebind(path, href);

		      System.out.println("Server ready and waiting for requests...");

		      // wait for invocations from clients
		      orb.run();
		      
		      
		      
		      // Get a reference to the Naming Service root_context
	            org.omg.CORBA.Object rootContextObj = orb.resolve_initial_references("NameService");

	            // Narrow to the correct type
	            org.omg.CosNaming.NamingContext nc = org.omg.CosNaming.NamingContextHelper.narrow(rootContextObj);

	            // Create a reference to the servant
	            crypImpl = new CryptographicImpl(orb);

	            // Activate object
	            byte[] id = myPOA.activate_object(crypImpl);
	            
	            // Get a CORBA reference with the POA through the servant
	            org.omg.CORBA.Object o = myPOA.servant_to_reference(crypImpl);

	            // The reference is converted to a character string
	            String s = orb.object_to_string(o);
	            System.out.println("The IOR of the object is: "+s);
	            
	            org.omg.CosNaming.NameComponent[] name = new org.omg.CosNaming.NameComponent[1];
	            name[0] = new NameComponent();
	            name[0].id = "CryptographicService";
	            name[0].kind = "";
	            
	            // Bind the object into the name service
	            nc.rebind(name, o);

	        
	            

	           
		      
		      
		      
		    } 
		        
		      catch (Exception e) {
		        System.err.println("ERROR: " + e);
		        e.printStackTrace(System.out);
		      }
		          
		      System.out.println("Server's done ...");
		        
		  }
		
	}


