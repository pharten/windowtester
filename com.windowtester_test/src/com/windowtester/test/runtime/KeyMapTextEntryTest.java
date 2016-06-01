/*******************************************************************************
 *  Copyright (c) 2012 Google, Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Google, Inc. - initial API and implementation
 *******************************************************************************/
package com.windowtester.test.runtime;

import java.util.Locale;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.WT;
import com.windowtester.runtime.WidgetSearchException;
import com.windowtester.runtime.internal.concurrent.VoidCallable;
import com.windowtester.runtime.locator.WidgetReference;
import com.windowtester.runtime.swt.internal.widgets.DisplayReference;
import com.windowtester.test.locator.swt.AbstractLocatorTest;
import com.windowtester.test.locator.swt.shells.TextTestShell;

/**
 * Test the KeyMap entry strategy for non US keyboards
 * Have to change keyboard settings in Windows to language
 * and country of keyboard.
 * 
 * @author Keerti P
 *
 */
public class KeyMapTextEntryTest extends AbstractLocatorTest {

	
	public static String INTERNATIONAL_STRING = "�!\"�$%&/()=";
	public static String DUTCH_STRING = "1234567890&�'(��!��";
	TextTestShell _window;
	IUIContext ui;
	Text text; 
	
	@Override
	public void uiSetup() {
		_window = new TextTestShell();
		_window.open();
	} 
	
	@Override
	public void uiTearDown() {
		_window.getShell().dispose();
	}
	
	
	public void testKeyMapTextEntry() throws WidgetSearchException{
		ui =  getUI();
		
		text = _window.getText();
		ui.click(new WidgetReference(text));
		idle();
	
		turkishKeyboardTest();
//		accentKeyTest();
//		swedishKeyboardTest();
//		frenchKeyboardTest();
//		germanKeyboardTest();
//		belgianKeyboardTest();
/*		ui.click(2,new WidgetReference(text));
		ui.enterText(INTERNATIONAL_STRING);
		idle();
		ui.pause(400);
		assertEquals(INTERNATIONAL_STRING, new TextTester().getText(text));
*/		
	}
	
	
	private void idle() {
		//TODO: need IdleCondition
		DisplayReference.getDefault().execute(new VoidCallable() {
			public void call() throws Exception {
				while(Display.getDefault().readAndDispatch());
			}
		});
	}
	
	
	
//	private void swedishKeyboardTest() throws WidgetSearchException{
//		
//		WT.setLocaleToCurrent();
//		ui.pause(10000);
//		
//		// top row
///*		ui.click(2,new WidgetReference(text));
//		ui.enterText("�1234567890+"); 
//		ui.pause(10000);
//		
//		// top row + shift
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("�!\"#�%&/()=?"); //�!"#�%&/()=?
//		ui.pause(10000);
//		
//		// top row alt+ctrl
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("@�$�{[]}\\"); //@�$�{[]}\
//		ui.pause(10000);
//		
//		// 2nd row + shift
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("QWERTYUIOP�*"); //QWERTYUIOP�'
//		ui.pause(10000);
//		
//		// 2nd row 
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("qwertyuiop�'"); //
//		ui.pause(10000);
//		
//		
//		// 3rd row
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("asdfghjkl��"); //
//		ui.pause(10000);
//		 
//		// 3rd row + shift
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("ASDFGHJKL��"); //
//		ui.pause(10000);
//		
//		// 4th row
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("zxcvbnm,.-<"); //zxcvbnm,.-<
//		ui.pause(10000);
//		
//		// 4th row + shift
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("ZXCVBNM:_>;"); //
//		ui.pause(10000);
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("|�"); //
//		ui.pause(10000);
//		
//		// accent chars
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("���� ����� ���� ���� �����"); //���� ����� ���� ���� �����
//		ui.pause(10000);
//*/		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("����� ���� ���� ����� ����"); //����� ���� ���� ����� ����
//		ui.pause(10000);
//		
//		
//		WT.resetLocale();
//	}
//	
//	/**
//	 * no support for the dead keys - they use 2 key press for char gen � �
//	 * no support for � � �` � �
//	 * @throws WidgetSearchException
//	 */
//	private void belgianKeyboardTest() throws WidgetSearchException{
//		
//		WT.setLocaleToCurrent();
//		ui.pause(10000);
///*		ui.click(2,new WidgetReference(text));
//		ui.enterText("&�\"'(��!��)-"); // top row, &�"'(��!��)-
//		ui.pause(10000);
//		
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("��1234567890�_"); // top row shift ��1234567890�_
//		ui.pause(10000);
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("|@#{}"); // top row ctrl+alt |@#{}
//		ui.pause(10000);
//		
//		// second row
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("azertyuiop$�"); // 2nd row 
//		ui.pause(10000);
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("AZERTYUIOP*�"); // 2nd row shift AZERTYUIOP*�
//		ui.pause(20000);
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("�[]"); // 2nd row ctrl+alt
//		ui.pause(10000);
//		
//		// third row
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("qsdfghjklm�"); // 3rd row 
//		ui.pause(10000);
//	
//		// 
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("QSDFGHJKLM%"); // 3rd row shift
//		ui.pause(10000);
//
//		
//		// fourth row
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("<wxcvbn,;:="); // 4th row <wxcvbn,;:=
//		ui.pause(10000);
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText(">WXCVBN?./+"); // 4th row shift >WXCVBN?./+
//		ui.pause(10000);
//
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("\\~="); // 4th row ctrl+alt \~=
//		ui.pause(10000);
//				
//		
//
//		// 	accent chars	
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("����� ���� ���� ����� ����"); // ����� ���� ���� ����� ����
//		ui.pause(10000);
//*/		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("����� ���� ���� ����� ����"); // ����� ���� ���� ����� ����
//		ui.pause(10000);
//		
//		
//		WT.resetLocale();		
//	}
//	
//	
//	private void germanKeyboardTest() throws WidgetSearchException{
//		Locale.setDefault(new Locale("de","DE"));
//		WT.setLocaleToCurrent();
//		
//		if (WTLocale.isCurrent)
//			System.out.println("WT Locale is set to current");
//		else
//			System.out.println("WT Locale is set to US");
//		System.out.println("Locale is " + Locale.getDefault());
//		
//		ui.pause(20000);
//		// � not supported
//		ui.click(2,new WidgetReference(text));
//		//�����
////		ui.enterText("��������������²�+�?��"); //��������������²�+�?��
////		ui.pause(10000);
//		
//		// 
//		ui.click(2,new WidgetReference(text));
//		//ui.enterText("!\"�$%&/()=?");
//		ui.enterText("/");
//		ui.pause(10000);
//		//assertEquals("!\"�$%&/()=?", ((Text)new WidgetReference(text).getWidget()).getText().trim());
//		
//		//     
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("{[]}\\");
//		ui.pause(10000);
//		
//		// second row
//		//�
///*		ui.click(2,new WidgetReference(text));
//		ui.enterText("qwertzuiop+");
//		ui.pause(10000);
//		
//		//�
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("QWERTZUIOP*");
//		ui.pause(10000);
//		
//		//�
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("@~");
//		ui.pause(10000);
//		
//		//third row
//		//��
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("asdfghjkl#");
//		ui.pause(10000);
//		
//		//��
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("ASDFGHJKL'");
//		ui.pause(10000);
//		
//		// fourth row
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("<yxcvbnm,.-");
//		ui.pause(10000);
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText(">YXCVBNM;:_");
//		ui.pause(10000);
//		
//		//�
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("|");
//		ui.pause(10000);		
//*/		
//		WT.resetLocale();
//			
//	}
//	
//	
//	private void frenchKeyboardTest() throws WidgetSearchException{
//		
//		WT.setLocaleToCurrent();
//		ui.pause(20000);
//		//  
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("�����������"); // got �����������
//		ui.pause(10000);
//		
//		
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("&�\"'(-�_��)=");
//		ui.pause(10000);
//		
//		// top row shift
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("1234567890�+");
//		ui.pause(10000);
//	
//		// top row alt + ctrl, no ^ 
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("~~#{[|`\\^^@]}");
//		ui.pause(10000);
//		
//		// 2nd row, no ^ - will make accent
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("^azertyuiop$*"); // got azertyuiop�$* 
//		ui.pause(10000);
//		
//		//2nd row shift, no �
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("AZERTYUIOP��"); // got AZERTYUIOP��
//		ui.pause(10000);
//
//		// no �
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("��"); //
//		ui.pause(10000);
//		
//		// 3rd row �
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("qsdfghjklm"); // got qsdfghjklm
//		ui.pause(10000);
//		
//		// no %
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("QSDFGHJKLM%"); // got  
//		ui.pause(10000);
//		
//		// 4th row
//		ui.click(2,new WidgetReference(text));
//		ui.enterText("<wxcvbn,;:!"); // got <wxcvbn,;:!
//		ui.pause(10000);
//		
//		// with shift
//		ui.click(2,new WidgetReference(text));
//		ui.enterText(">WXCVBN?./�"); // got >WXCVBN?./�
//		ui.pause(10000);
//				
//		WT.resetLocale();
//		
//	}
	
	public void accentKeyTest() throws WidgetSearchException{
		
		//a dispatcher for raw SWT events
//		final DisplayEventDispatcher _dispatcher = new DisplayEventDispatcher();
		
		WT.setLocaleToCurrent();
		ui.pause(20000);
		//  
		ui.click(2,new WidgetReference(text));
		ui.enterText("Fr�mmichen");
	//	ui.enterText("a�����������������");  // a��������������
	/*	final char c = 0x5e;
		_dispatcher.keyDown(c);
    	_dispatcher.keyUp(c);
    	char ch = 'a';
    	_dispatcher.keyDown(ch);
    	_dispatcher.keyUp(ch);
	*/	ui.pause(10000);
		
		WT.resetLocale();
		
		
	}
	
	private void turkishKeyboardTest() throws WidgetSearchException {
		
		Locale.setDefault(new Locale("tr","US"));
		System.out.println(Locale.getDefault());
		WT.setLocaleToCurrent();
	
		ui.pause(20000);
		
		
		// 1st line
/*		ui.click(2,new WidgetReference(text));
		ui.enterText("\"1234567890*-"); // got 
		ui.pause(10000);
		
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("�!'^+%&/()=?_"); // got �!'^+%&/()=?_
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("qwertyuop,"); // no �
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("QWERTYUIOP;"); // no �
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("asdfghjkli"); // no 
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("ASDFGHJKL"); // no �
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("��"); // no �
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("zxcvbnm��."); // no 
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("ZXCVBNM��:"); // no 
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("@�"); // no 
		ui.pause(10000);
		
		ui.click(2,new WidgetReference(text));
		ui.enterText("<>�#$�{[]}\\|"); // <>�#$�{[]}\|
		ui.pause(10000);
*/		
		ui.click(2,new WidgetReference(text));
		ui.enterText("a������������������"); // no a������������������
		ui.pause(10000);
		
		
		WT.resetLocale();
	}
}
