

/**
 * The Class Methods is just needed to implementing some methods which i didn't wanted to but into the real code
 * 
 * @author Hannah Siegel
 * @version 2013-12-08
 *
 */
public class Methods {
	
	/**
	 * The function debug is used to make debug messages.
	 * @param x String - output
	 */
	public static void debug(String x) {
		//System.out.println(x);
	}
	
	/**
	 * The method printException is printing a pretty Exception
	 * 
	 * @param e Exception
	 */
	public static void printException(Exception e) {
		String error = e.toString();
		if (error != null && error.indexOf(':') >= 0) {
			if (error.contains(";"))
				error = error.substring(error.indexOf(':') + 1,
						error.indexOf(';')).trim();
			else if (error.contains("("))
				error = error.substring(error.indexOf(':') + 1,
						error.indexOf('(')).trim();
			else {
				error = error.substring(error.indexOf(':') + 1).trim();

			}
		}
		System.out.println("There was an Exception:");
		System.out.println(error);
	}
	
	/**
	 * The function checkArguments checks the programm parameters
	 * 
	 * @param arg Programm parameters
	 * @return true if the Arguments are okay, false if not
	 */
	public static boolean checkArguments(String arg[]) {
		if(arg.length==0){
			return false;
		}
		else if (arg[0].equals("Balancer") && arg.length == 1) {
			return true;
		}
		else if (arg[0].equals("Client") && arg.length == 5) {
			for (int i = 0; i < arg.length; i++) {
				if (arg[i].equalsIgnoreCase("-a")) {
					String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
					if (!(arg[i + 1].matches(IPADDRESS_PATTERN))) {
						return false;
					}
					i++;
				}
				if (arg[i].equalsIgnoreCase("-n")) {
					try {
						Integer.parseInt(arg[i + 1]);
					} catch (NumberFormatException e) {
						return false;
					}
					i++;
				}
			}
			return true;

		} 
		else if (arg[0].equals("Server") && arg.length == 5) {
			for (int i = 0; i < arg.length; i++) {
				if (arg[i].equalsIgnoreCase("-a")) {
					String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
					if (!(arg[i + 1].matches(IPADDRESS_PATTERN))) {
						return false;
					}
					i++;
				}
				if (arg[i].equalsIgnoreCase("-n")) {
					try {
						Integer.parseInt(arg[i + 1]);
					} catch (NumberFormatException e) {
						return false;
					}
					i++;
				}
			}
			return true;
		}
		else if (arg[0].equals("ManyClients") && arg.length == 5) {
			for (int i = 0; i < arg.length; i++) {
				if (arg[i].equalsIgnoreCase("-a")) {
					String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
					if (!(arg[i + 1].matches(IPADDRESS_PATTERN))) {
						return false;
					}
					i++;
				}
				if (arg[i].equalsIgnoreCase("-n")) {
					try {
						Integer.parseInt(arg[i + 1]);
					} catch (NumberFormatException e) {
						return false;
					}
					i++;
				}
			}
			return true;
		}
		else {
			return false;
		}

	}

	/**
	 * The method usage prints the usage of the program
	 */
	public static void usage() {
		System.out.println("To start Balancer:");
		System.out.println("Balancer");
		System.out.println("To start many servers:");
		System.out.println("Server -a <ip adress> -n <number of servers>");
		System.out.println("To start client:");
		System.out.println("Client -a <ip adress> -n <number of digits>");
		System.out.println("To start many clients to test the balancer");
		System.out.println("ManyClients -a <ip adress> -n <number of clients>");
	}

}
