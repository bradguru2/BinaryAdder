package com.binary;

/**
 * Class showing how to add two binary string emulating how a CPU adds
 * @author bradley
 *
 */
public class StringAdder {

	public static String AddBinary(String a, String b)
    {
        int maxLen = a.length() > b.length() ? a.length() : b.length();
        int aDigit, bDigit, carry = 0, start = maxLen;
        int aIndex = a.length() - 1, bIndex = b.length() - 1;
        String answer = "";

        if (maxLen > 0)
        {
            //Allocate for carry
            char[] result = new char[maxLen + 1];

            while (start > 0)
            {
                aDigit = aIndex >= 0 ? a.charAt(aIndex--) - '0' : 0;
                bDigit = bIndex >= 0 ? b.charAt(bIndex--) - '0' : 0;

                //Modeled after Full Adder circuit logic
                int sum = aDigit ^ bDigit;
                result[start--] = (char)('0' + (sum ^ carry));
                carry = (aDigit & bDigit) | (carry & sum);
            }

            result[start] = (char)(carry + '0');

            //Removes 0's to the left of answer
            while (start < maxLen && result[start] == '0') start++;

            answer = new String(result, start, maxLen + 1 - start);
        }

        return answer;
    }
	
	public static void main(String[] args) {
		String sb1 = "1001";
		String sb2 = "1001";
		System.out.printf("%s + %s = %s", sb1, sb2, AddBinary(sb1, sb2));
	}

}
