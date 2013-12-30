package server;

import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;

import calculator.common.CalculatorPOA;

/**
 * @author Hannah Siegel 
 * @version 2013-12-30
 */
public class CalculatorImpl extends CalculatorPOA {   
    private ORB m_orb;
    
 
    public CalculatorImpl(ORB orb){
        m_orb = orb;
    }
  
    public boolean shutdown() throws SystemException {
        m_orb.shutdown(false);
        return true;
    }

	public int add(int a, int b) {
		return (a+b);
	}

	public int sub(int a, int b) {
		return (a-b);
	}
    
}
