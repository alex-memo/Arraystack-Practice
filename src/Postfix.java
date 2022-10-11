
import java.util.*;
public class Postfix {

    private Stack<String> expStack;
    private PostfixEvaluator evaluator;
    
    ArrayList<Integer> arrayStore; 

    public Postfix () {

        // Add code here...
        expStack = new Stack<>();
        evaluator = new PostfixEvaluator();
        arrayStore = new ArrayList<>();

    }

	public void run () {
		String expression, action = "e";
		int result;

		try {
			Scanner in = new Scanner(System.in);
      
			do {
				if (action.equals("e")) {
					System.out.print("Enter a valid postfix expression:  ");
					expression = in.nextLine();

					result = evaluator.evaluate(expression.trim());
					System.out.println("The result is " + result);

                    // Add code here...
                    expStack.push(expression);
                    arrayStore.add(result);


                } else if (action.equals("r")) {

                    // Add code here...
                    int varNum = expStack.size() - 1;

                    if(varNum > 3)
                        showRecent(3);
                    else
                        showRecent(expStack.size());

                }

				System.out.println("\nWhat do you want to do?");
				System.out.println("\tType 'e' if you want to evaluate another postfix expression.");
				System.out.println("\tType 'r' if you want to see the recent expressions.");
				System.out.println("\tType any other key to quit.");
				action = in.nextLine();
				System.out.println();
			} while (action.equalsIgnoreCase("e") || action.equalsIgnoreCase("r"));
    	} catch (Exception IOException) {
    		System.out.println("Input exception reported");
    	}

	}
	
	private void showRecent (int numToShow) {

        // Add code here...
        int s = 0;
        s = expStack.size();
       
        for(int i = s - 1, j = 0; i >= 0; i--, j++){
            System.out.println("    "+(expStack).get(i)+"   =    "+arrayStore.get(i));
         
            if(j == 3)
                break;
        }

    }

	public static void main (String[] args) {
		Postfix pf = new Postfix();
		pf.run();
	}

}
