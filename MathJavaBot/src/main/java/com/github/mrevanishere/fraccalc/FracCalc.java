package com.github.mrevanishere.fraccalc;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	String fexp = "";
    	System.out.println("Format examples:\n"
    			+ "20 / 5 * -1 + 8"
    			+ "\n-24_1/3 * 2" 
    			+ "\n3_2/4 * 4/3");
    	while (true) {
    		try {
	    	System.out.print("Type in mixed num or fraction: ");
	    	fexp = input.nextLine();
	    	if (fexp.equals("quit")) {
	    		System.out.println("Done.");
	    		break;
	    	}
			String ans = produceAnswer(fexp);
			System.out.println(ans);
    		} catch (StringIndexOutOfBoundsException outofbounds) {
    			System.out.println("Error: Incorrect Format");
    		} catch (ArithmeticException zero) {
    			System.out.println("Error: Cannot / by zero");
    		} catch (Exception e) {
    			System.out.println("Error: " + e);
    		}
    	}
    }
    
    public static String produceAnswer(String input) { 
    	int sLen = input.length();
		// order of operations //
    	int operatorCount = nOperators(input);
    	while (operatorCount > 1) {
    		if (input.contains("* ") || input.contains("/ ")) {
        		for (int i = 0; i < sLen-2; i++) {
            		if (input.substring(i, i+1).equals("*") ||
        				input.substring(i, i+2).equals("/ ")) {
            			input = ooo(input, i);
            			break;
                	} 
            	}
        	} else if (input.contains("+ ") || input.contains("- ")) {
        		for (int i = 0; i < sLen-2; i++) {
            		if (input.substring(i, i+1).equals("+") ||
        				input.substring(i, i+2).equals("- ")) {
            			input = ooo(input, i);
            			break;
                	} 
            	}
        	}
    		operatorCount = nOperators(input);
    	}
    	
    	// split into numbers//
    	String operator = "";
    	String op1 = "";
    	String op2 = "";
    	int space1 = input.indexOf(" ");
    	operator = input.substring(space1+1, space1+2);
    	op1 = input.substring(0, space1);
    	op2 = input.substring(space1+3);
    	int wh1 = getWhole(op1);
    	int nume1 = getNumerator(op1);
    	int denom1 = getDenom(op1);
    	int wh2 = getWhole(op2);
    	int nume2 = getNumerator(op2);
    	int denom2 = getDenom(op2);
    	//String op1Parts = ("whole:"+ wh1+" numerator:"+nume1+" denominator:"+denom1);
    	//String op2Parts = ("whole:"+ wh2+" numerator:"+nume2+" denominator:"+denom2);
    	//System.out.println(op1Parts);
    	//System.out.println(operator);
    	//System.out.println(op2Parts);
    	
    	// Calculate //
    	String ans = "";
		int newNume = 0;
		int newWhole = 0;
		int newDom = denom1*denom2;
		int sign1 = 1;
		int sign2 = 1;
		if (wh1 < 0) {
			sign1 = -1;
		}
		if (wh2 < 0) {
			sign2 = -1;
		}
		nume1 = (nume1 +(wh1 * denom1 * sign1))*sign1;
		nume2 = (nume2 +(wh2 * denom2 * sign2))*sign2;
    	// operations
    	if (operator.equals("+")) {
    		nume1 *= denom2;
    		nume2 *= denom1;
    		newWhole = (nume1+nume2) / newDom;
    		newNume = (nume1+nume2) % newDom;    		
		} else if (operator.equals("-")) {
			nume1 *= denom2;
    		nume2 *= denom1;
    		newWhole = (nume1-nume2) / newDom;
    		newNume = (nume1-nume2) % newDom; 
		} else if (operator.equals("*")) {
    		newWhole = (nume1*nume2) / (newDom);
    		newNume = (nume1*nume2) % (newDom);
    	} else if (operator.equals("/")) {
			newDom = nume2*denom1;
    		newWhole = (nume1*denom2)/ (newDom);
    		newNume = (nume1*denom2) % (newDom);
    	}
    	// formatting //
    	//System.out.println("whole:"+ newWhole+" numerator:"+newNume+" denominator:"+newDom);
    	if (newNume == 0) {
			ans += (newWhole);
		} else {
			ans = simp(newNume, newDom, newWhole);
		}
        return ans;
    }
    
    // 
    public static int nOperators(String input) {
    	int numOfOperators = 0;
    	for (int j = 0; j < input.length()-2; j++) {
    		if (input.substring(j, j+1).equals("*") ||
					input.substring(j, j+2).equals("/ ") ||
					input.substring(j, j+1).equals("+") ||
        			input.substring(j, j+2).equals("- ")) {
    			numOfOperators++;
    		}
    	}
    	//System.out.println(op);
    	return numOfOperators;
    }
    
    // order of operations - uses recursion
    public static String ooo(String input, int i) {
    	int sLen = input.length();
		//System.out.println(input.substring(i, i+1));
		int leftBound = 0;
		int rightBound = 0;
		for (int j = i+2; j < sLen-2; j++) {
    		if (input.substring(j, j+1).equals("*") ||
				input.substring(j, j+2).equals("/ ") ||
				input.substring(j, j+1).equals("+") ||
    			input.substring(j, j+2).equals("- ")) {
    			//System.out.println("inner right: " + input.substring(i+2, j-1));
    			rightBound = j-1;
    	    	break;
    		} else if (j == sLen-3) {
    			//System.out.println("inner right: " + input.substring(i+2, sLen));
    			rightBound = sLen;
    			break;
    		}
		}	
		for (int j = i-1; j > 0; j--) {
    		if (input.substring(j, j+1).equals("*") ||
				input.substring(j, j+2).equals("/ ") ||
				input.substring(j, j+1).equals("+") ||
    			input.substring(j, j+2).equals("- ")) {
    	    	//System.out.println("inner left: " + input.substring(j+2, i-1));
    			leftBound = j+2;
    			break;
    		} else if (j == 1) {
    			//System.out.println("inner left: " + input.substring(0, i-1));
    			leftBound = 0;
    			break;
    		}
		}
		String doFirst = input.substring(leftBound, rightBound);
		//System.out.println("inner: " + doFirst);
		input = input.substring(0, leftBound) +produceAnswer(doFirst) + input.substring(rightBound, sLen);
		//System.out.println("New: " +input);
		return input;
    }
    
    // simplify fractions into mixed numbers
    public static String simp(int gcd, int d, int whole) {
    	int nume = gcd;
    	int deno = d;
    	// gcd //
		while (d != 0) {
			int r = gcd % d;
			gcd = d;
			d = r;
		}
		//System.out.println("Nume: " + nume + ", Denom:" + deno);
		nume /= gcd;
		deno /= gcd;
		
		if (whole == 0) {
			return (nume + "/" + deno);
		} else {
			return (whole+"_"+Math.abs(nume) + "/" + Math.abs(deno));
		}
    }
    
    public static int getWhole(String in) {
    	String sWhole = "";
    	int under = in.indexOf('_');
    	int div = in.indexOf('/');
    	int whole = 0;
    	//System.out.println(under);
    	
    	if (under > 0) {
    		sWhole = in.substring(0, under);
    		whole = Integer.parseInt(sWhole);
    	} else if (div < 0){
    		sWhole = in.substring(0);
    		whole = Integer.parseInt(sWhole);
    	} else {
    		whole = 0;
    	}
    	// System.out.println(whole);
    	return whole;
    }
    
    public static int getNumerator(String in) {
    	String sNume = "";
    	int div = in.indexOf('/');
    	int under = in.indexOf('_');
    	int nume = 0;
    	
    	//System.out.println(div);
    	if (div > 1) {
    		sNume = in.substring(under+1, div);
    		nume = Integer.parseInt(sNume);
    	} else if (div > 0) {
    		sNume = in.substring(0, div);
    		nume = Integer.parseInt(sNume);
    	} else {
    		nume = 0;
    	}
    	// System.out.println(whole);
    	return nume;
    }
    
    public static int getDenom(String in) {
    	String sDenom = "";
    	int denom = 1;
    	int div = in.indexOf('/');
    	int under = in.indexOf('_');
    	if (div > 0) {
    		sDenom = in.substring(div+1);
    		denom = Integer.parseInt(sDenom);
    	} else {
    		denom = 1;
    	}
    	// System.out.println(whole);
    	return denom;
    }
}

