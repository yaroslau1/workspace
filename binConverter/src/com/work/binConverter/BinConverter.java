package com.work.binConverter;

import java.util.Arrays;

public class BinConverter {

	public static void main(String[] args) {
		byte data1 =  (byte) 10;
		byte data2 =  (byte) 10;
		byte data3 =  (byte) 10;
		
		byte[] ecg = {92, -1, -49, -108, 0, -8, 102, -42, 0, -55, 109, -47, 0, -1, -58, 79, 0, -1, -36, 24, -128, -1, -44, 110, -128, -56, 24, -3, -128, -1, -53, -77, -128, -59, 92, -1, -49, 64, 0, -1, -61, 102, 0, -54, 17, -107, 0, -1, -58, 43, 0, -1, -36, 4, -128, -1, -45, -46, -128, -56, -62, -87, -128, -1, -53, 71, -128, -59, 92, -1, -50, -8, 0, -1, -59, 14, 0, -54, -69, 73, 0, -1, -59, -41, 0, -1, -37, -8, -128, -1, -45, -26, -128, -55, 112, -59, -128, -1, -54, -45, -128, -59, 92, -1, -50, 104, 0, -1, -60, 54, 0, -53, 99, -51, 0, -1, -59, -25, 0, -1, -36, 40, -128, -1, -45, -26, -128, -54, 29, 17, -128, -1, -53, 75, -128, -59, 92, -1, -50, -116, 0, -1, -60, 18, 0, -52, 6, 57, 0, -1, -59, -61, 0, -1, -37, -56, -128, -1, -45, -82, -128, -54, -63, -75, -128, -1, -54, -25, -128, -59, 92, -1, -50, 108, 0, -1, -60, 38, 0, -52, -92, -63, 0, -1, -59, -97, 0, -1, -37, -120, -128, -1, -45, 62, -128, -53, 96, -67, -128, -1, -54, -69, -128, -59, 92, -1, -50, 56, 0, -1, -60, 14, 0, -51, 77, 41, 0, -1, -59, -85, 0, -1, -37, 112, -128, -1, -46, -18, -128, -52, 7, 85, -128, -1, -54, 111, -128, -59, 92, -1, -50, 0, 0, -1, -61, 58, 0, -51, -20, -59, 0, -1, -59, 99, 0, -1, -37, 76, -128, -1, -45, 6, -128, -52, -93, 73, -128, -1, -54, 51, -128, -59, 92, -1, -51, -76, 0, -1, -62, -18, 0, -50, -110, -3, 0, -1, -59, 119, 0, -1, -37, 68, -128, -1, -46, -30, -128, -51, 66, 49, -128, -1, -54, 27, -128, -59, 92, -1, -51, -76, 0, -1, -62, -74, 0, -49, 72, 45, 0, -1, -59, 63, 0, -1, -37, 16, -128, -1, -46, -46, -128, -51, -22, -95, -128, -1, -55, -57, -128, -59, 92, -1, -51, -108, 0, -1, -62, 46, 0, -48, 4, 25, 0, -1, -59, 51, 0, -1, -37, 100, -128, -1, -46, -78, -128, -50, -109, -127, -128, -1, -55, -9, -128, -59, 92, -1, -51, 4, 0, -1, -63, -38, 0, -48, -48, 9, 0, -1, -60, -21, 0, -1, -37, -128, -128, -1, -46, 114, -128, -49, 67, -99, -128, -1, -55, -21, -128, -59, 92, -1, -52, -72, 0, -1, -63, -22, 0, -47, -52, 57, 0, -1, -60, -61, 0, -1, -37, 76, -128, -1, -46, -114, -128, -48, 13, -67, -128, -1, -54, 3, -128, -59, 92, -1, -52, -80, 0, -1, -63, -46, 0, -45, 75, -59, 0, -1, -60, 127, 0, -1, -37, 112, -128, -1, -46, -90, -128, -47, 11, -35, -128, -1, -55, -21, -128, -59, 92, -1, -52, 104, 0, -1, -63, 42, 0, -42, 116, -107, 0, -1, -60, -73, 0, -1, -37, 68, -128, -1, -46, 70, -128, -46, 115, 37, -128, -1, -55, -105, -128, -59, 92, -1, -52, 20, 0, -1, -64, -46, 0, -26, 15, 121, 0, -1, -60, -45, 0, -1, -38, -20, -128, -1, -46, 46, -128, -43, -75, -71, -128, -1, -55, 55, -128, -59, 92, -1, -53, -20, 0, -1, -64, 118, 0, -3, 26, -95, 0, -1, -60, -97, 0, -1, -37, -128, -128, -1, -46, 30, -128, -29, -2, 37, -128, -1, -55, -81, -128, -59, 92, -1, -53, -16, 0, -1, -64, 30, 0, -1, -52, -71, 0, -1, -60, 99, 0, -1, -37, 16, -128, -1, -47, -38, -128, -5, -39, 57, -128, -1, -55, -125, -128, -59, 92, -1, -53, -64, 0, -1, -65, -50, 0, -1, -52, 117, 0, -1, -60, 7, 0, -1, -38, -116, -128, -1, -47, 98, -128, -1, -56, 117, -128, -1, -56, -37, -128, -59, 92, -1, -53, 120, 0, -1, -65, -114, 0, -1, -52, 33, 0, -1, -60, 27, 0, -1, -38, -124, -128, -1, -47, 46, -128, -1, -57, -71, -128, -1, -56, -5, -128, -59};
		int[] temp = new int[20];
		int j = 0;
		int count = 0;
		for(int i = 0; i < ecg.length; i++) {
			if(ecg[i] == 92) {
				temp[j] = Integer.parseInt(dataToBin(ecg[i+1]) + dataToBin(ecg[i+2]) + dataToBin(ecg[i+3]),2);
				j++;
				i += 3;
				count++;
				
			}
		}
		
		System.out.println(Arrays.toString(temp));
		System.out.println(count);
		
		String all = dataToBin(data1) + dataToBin(data2) + dataToBin(data3);
		
		
		int a = Integer.parseInt(all,2);
		
		//System.out.println(a);
		
		


	}

	private static String dataToBin(byte data) {
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

}