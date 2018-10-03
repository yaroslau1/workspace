package stream_two;

import java.util.Arrays;

/*
 * 
 *Программа работает с двумя байтами, поэтому корректно работает с типом int в диапазоне от -32768 до 32767
 * 
 * */

public class MainStreamTwo {
	public static void main(String [] args) {
		int in = -155; 
		byte[] data = new byte[2]; // <- assuming "in" value in 0..65535 range and we can use 2 bytes only

		data[0] = (byte)(in & 0xFF);
		data[1] = (byte)((in >> 8) & 0xFF);

		int high = data[1] >= 0 ? data[1] : 256 + data[1];
		int low = data[0] >= 0 ? data[0] : 256 + data[0];

		int res = low | (high << 8);
		
		fromBinToInt(dataToBin(data[1]) + dataToBin(data[0]));

		System.out.println("low = " + data[0] + "; bin = " + dataToBin(data[0]));
		System.out.println("high = " + data[1] + "; bin = " + dataToBin(data[1]));
		System.out.println(dataToBin(data[1])+dataToBin(data[0]));
		System.out.println((Integer.parseInt(dataToBin(data[1])+dataToBin(data[0]),2)-2)*(-1));
		System.out.println(Integer.parseInt("10000011",2));
		//System.out.println("high = " + data[1]);
		//System.out.println(toBinaryString((byte)data[1]));
		System.out.println("digit = " + res);

		/*for (byte i = 0; i <= 129; i++) {
			//System.out.println(toBinaryString(i));
		}
		
		byte a = (byte) 2;
		System.out.println((byte)a);
		
		String bs = Integer.toBinaryString(a);
		System.out.println(bs);
		bs = getCorrectBits(bs, 8);
		System.out.println(bs);*/

	}

	public String toBinaryString(byte i) {
		char digits[] = {'0', '1'};
		char[] buf = new char[8];
		int charPos = 8;
		byte radix = (byte)2;
		byte mask = (byte)(radix - 1);
		do {
			buf[--charPos] = digits[i & mask];
			i >>>= 1;
		} while (i != 0);
		return new String(buf, charPos, (8 - charPos));
	}
	
	private String getCorrectBits(String bitStr, int max){
	    //Create a temp str to add all the zeros
	    String tmpStr = "";
	    for(int i = 0; i < (max - bitStr.length()); i ++){
	        tmpStr += "0";
	    }

	    return tmpStr + bitStr;
	}
	
	public static String dataToBin(byte data) {
		String bs = null;
		if(data >= 0) {
			bs = Integer.toBinaryString(data);
			while (bs.length() < 8) {
				bs = "0" + bs;
			}
		}  else {
			bs = Integer.toBinaryString(data);
			bs = bs.substring(24, 32);
		}
		
		//System.out.println(bs);
		//System.out.println(Integer.parseInt(bs,2));
		return bs;

	}
	
	public static int fromBinToInt(String binaryString) {
		int decDigit = 0;		
		char[] binStringToArray = binaryString.toCharArray(); // Преобразуем строку в массив символов
	    System.out.println(Arrays.toString(binStringToArray));
	    if(binStringToArray[0] != '1') {
	    	int j = 0;
	    	for(int i = binStringToArray.length-1; i >= 0; i--) {
	    		decDigit += Character.getNumericValue(binStringToArray[i]) * Math.pow(2, j);
	    		j++;
	    	}
	    } else {
	    	for(int i = binStringToArray.length-1; i >= 0; i--) {
	    		binStringToArray[i] = binStringToArray[i] == '1' ? '0' : '1' ;	
	    		
	    	}
	    	int j = 0;
	    	for(int i = binStringToArray.length-1; i >= 0; i--) {
	    		decDigit += Character.getNumericValue(binStringToArray[i]) * Math.pow(2, j);
	    		j++;	
	    		
	    	}
	    	decDigit = (decDigit+1)*(-1);
	    }
	    System.out.println(Arrays.toString(binStringToArray));
	    
	    System.out.println(decDigit);
		return decDigit;
	}

}
