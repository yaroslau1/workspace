package com.work.listener;
import java.util.Arrays;

import jssc.SerialPort;  /*Р�РјРїРѕСЂС‚ РєР»Р°СЃСЃРѕРІ Р±РёР±Р»РёРѕС‚РµРєРё jssc*/
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class SendFrame {  /*РљР»Р°СЃСЃ С‡С‚РµРЅРёСЏ РёР· РїРѕСЂС‚Р°*/

	private static SerialPort serialPort; /*РЎРѕР·РґР°РµРј РѕР±СЉРµРєС‚ С‚РёРїР° SerialPort*/
	public static void main (String[] args) throws SerialPortException {  /* РўРѕС‡РєР° РІС…РѕРґР° РІ РїСЂРѕРіСЂР°РјРјСѓ*/
		String[] portNames = SerialPortList.getPortNames();
		for(int i = 0; i < portNames.length; i++){
			System.out.println(portNames[i]);
		}

		serialPort = new SerialPort ("COM9"); /*РџРµСЂРµРґР°РµРј РІ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ СЃСѓРїРµСЂРєР»Р°СЃСЃР° РёРјСЏ РїРѕСЂС‚Р° СЃ РєРѕС‚РѕСЂС‹Рј Р±СѓРґРµРј СЂР°Р±РѕС‚Р°С‚СЊ*/

		String str = "85 8 0 0 170"; // - batteries
		String str1 = "85 1 2 5 1 9 170"; // 55 01 02 05 01 09 AA - send
		try {
			serialPort.openPort();
			serialPort.setParams(921600,8,1,0);
			serialPort.writeBytes(str1.getBytes());
			//serialPort.closePort();
		}
		catch (SerialPortException ex) {
			System.out.println(ex);
		}
		
		for(int i = 0; i < 4000000; i++) {
			for(int j = 0; j < 400; j++) {
				for(int k = 0; k < 400; k++) {
					
				}
				
			}
		}

		try {
			//serialPort.openPort (); /*РњРµС‚РѕРґ РѕС‚РєСЂС‹С‚РёСЏ РїРѕСЂС‚Р°*/
			serialPort.setParams (921600,8,1,0); /*Р—Р°РґР°РµРј РѕСЃРЅРѕРІРЅС‹Рµ РїР°СЂР°РјРµС‚СЂС‹ РїСЂРѕС‚РѕРєРѕР»Р° UART*/
			serialPort.setEventsMask (SerialPort.MASK_RXCHAR); /*РЈСЃС‚Р°РЅР°РІР»РёРІР°РµРј РјР°СЃРєСѓ РёР»Рё СЃРїРёСЃРѕРє СЃРѕР±С‹С‚РёСЏ РЅР° РєРѕС‚РѕСЂС‹Рµ Р±СѓРґРµС‚ РїСЂРѕРёСЃС…РѕРґРёС‚СЊ СЂРµР°РєС†РёСЏ. Р’ РґР°РЅРЅРѕРј СЃР»СѓС‡Р°Рµ СЌС‚Рѕ РїСЂРёС…РѕРґ РґР°РЅРЅС‹С… РІ Р±СѓС„С„РµСЂ РїРѕСЂС‚Р°*/
			serialPort.addEventListener (new EventListener ()); /*РџРµСЂРµРґР°РµРј СЌРєР·РµРјРїР»СЏСЂ РєР»Р°СЃСЃР° EventListener РїРѕСЂС‚Сѓ, РіРґРµ Р±СѓРґРµС‚ РѕР±СЂР°Р±Р°С‚С‹РІР°С‚СЊСЃСЏ СЃРѕР±С‹С‚РёСЏ. РќРёР¶Рµ РѕРїРёСЃР°РЅ РєР»Р°СЃСЃ*/
		}
		catch (SerialPortException ex) {
			System.out.println (ex);
		}
		finally {
			serialPort.closePort();
		}
		System.out.println("End of programm!");
	}

	private static class EventListener implements SerialPortEventListener { /*РЎР»СѓС€Р°С‚РµР»СЊ СЃСЂР°Р±Р°С‚С‹РІР°СЋС‰РёР№ РїРѕ РїРѕСЏРІР»РµРЅРёСЋ РґР°РЅРЅС‹С… РЅР° COM-РїРѕСЂС‚*/
		public void serialEvent (SerialPortEvent event) {
			if (event.isRXCHAR ()/* && event.getEventValue () > 0*/){ /*Р•СЃР»Рё РїСЂРѕРёСЃС…РѕРґРёС‚ СЃРѕР±С‹С‚РёРµ СѓСЃС‚Р°РЅРѕРІР»РµРЅРЅРѕР№ РјР°СЃРєРё Рё РєРѕР»РёС‡РµСЃС‚РІРѕ Р±Р°Р№С‚РѕРІ РІ Р±СѓС„РµСЂРµ Р±РѕР»РµРµ 0*/
				try {
					byte data[] = serialPort.readBytes(20); /*РЎРѕР·РґР°РµРј СЃС‚СЂРѕРєРѕРІСѓСЋ РїРµСЂРµРјРµРЅРЅСѓСЋ  data, РєСѓРґР° Рё СЃРѕС…СЂР°РЅСЏРµРј РґР°РЅРЅС‹Рµ*/
					for(int i = 0; i < 20; i++) {
						System.out.println(data[i]);
					}
					serialPort.closePort();
				}
				catch (SerialPortException ex) {
					System.out.println (ex);
				}
			}
		}
	}
}