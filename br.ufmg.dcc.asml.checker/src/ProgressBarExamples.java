import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class ProgressBarExamples {
  Display display = new Display();
  Shell shell = new Shell(display);

  public ProgressBarExamples() {
    ProgressBar pb1 = new ProgressBar(shell, SWT.NULL);
    pb1.setSelection(60);
    pb1.setBounds(100, 10, 200, 20);
    Label label = new Label(shell, SWT.NULL);
    label.setText("(default)");
    label.setAlignment(SWT.RIGHT);
    label.setBounds(10, 10, 80, 20);
    shell.pack();
    shell.open();
    // Set up the event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        // If no more entries in event queue
        display.sleep();
      }
    }
    display.dispose();
  }


  public static void main(String[] args) {
    new ProgressBarExamples();
  }
}