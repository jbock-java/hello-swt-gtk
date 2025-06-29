package gg.bockig;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class HelloWorld {
  public static void main (String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    Label label = new Label(shell, SWT.NONE);
    label.setText("Hello, World!");
    label.pack();
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
