package com.windowtester.test.locator.swt;

import static com.windowtester.runtime.swt.locator.SWTLocators.treeItem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.windowtester.runtime.IUIContext;

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
public class TreeItemLocatorSlashTest extends AbstractTreeItemLocatorTest {


	protected void createTreeContents(Tree tree) {
		TreeItem root = new TreeItem(tree, SWT.NONE);
		root.setText("myMdaService");
		new TreeItem(root, SWT.NONE).setText("src/main/resources");
		new TreeItem(root, SWT.NONE).setText("src/main/java");
	}
	
	public void testDrive() throws Exception {
		IUIContext ui = getUI();
		ui.click(treeItem("myMdaService/src\\/main\\/resources"));
		ui.click(treeItem("myMdaService/src\\/main\\/java"));
	}


	
	
	
	
}
