package calculator.common;


/**
* calculator/common/CalculatorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculator.idl
* Monday, December 30, 2013 4:18:27 o'clock PM CET
*/

public abstract class CalculatorPOA extends org.omg.PortableServer.Servant
 implements calculator.common.CalculatorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("sub", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // calculator/common/Calculator/add
       {
         int a = in.read_long ();
         int b = in.read_long ();
         int $result = (int)0;
         $result = this.add (a, b);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // calculator/common/Calculator/sub
       {
         int a = in.read_long ();
         int b = in.read_long ();
         int $result = (int)0;
         $result = this.sub (a, b);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:calculator/common/Calculator:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calculator _this() 
  {
    return CalculatorHelper.narrow(
    super._this_object());
  }

  public Calculator _this(org.omg.CORBA.ORB orb) 
  {
    return CalculatorHelper.narrow(
    super._this_object(orb));
  }


} // class CalculatorPOA
