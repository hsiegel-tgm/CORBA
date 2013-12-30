package others;

/**
 * The Class M is just needed to implementing some methods which i didn't wanted to but into the real code
 * 
 * @author Hannah Siegel
 * @version 2013-12-08
 *
 */
public class M {
        
        /**
         * The function debug is used to make debug messages.
         * @param x String - output
         */
        public static void debug(String x) {
                System.out.println("debug "+x);
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
}