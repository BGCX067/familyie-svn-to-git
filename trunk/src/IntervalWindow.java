import java.awt.FlowLayout;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class IntervalWindow extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	java.awt.TextField _startField = new TextField();
	java.awt.TextField _endField = new TextField();
	java.awt.TextField _lengthField = new TextField();

	private Interval _subject;

	public IntervalWindow() {
		setLayout(new FlowLayout());
		add(_startField);
		add(_endField);
		add(_lengthField);

		final SymFocus sf = new SymFocus();
		_startField.addFocusListener(sf);
		_endField.addFocusListener(sf);
		_lengthField.addFocusListener(sf);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(30, 100);

		_subject = new Interval();
		_subject.addObserver(this);
		update(_subject, null);
	}

	class SymFocus extends java.awt.event.FocusAdapter {
		public void focusLost(java.awt.event.FocusEvent event) {
			Object object = event.getSource();
			if (object == _startField)
				StartField_FocusLost(event);
			else if (object == getEnd())
				EndField_FocusLost(event);
			else if (object == _lengthField)
				LengthField_FocusLost(event);
		}
	}

	void StartField_FocusLost(java.awt.event.FocusEvent event) {
		if (isNotInteger(_startField.getText()))
			_startField.setText("0");
		calculateLength();
	}

	private boolean isNotInteger(String text) {
		try {
			Integer.valueOf(text);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

	void EndField_FocusLost(java.awt.event.FocusEvent event) {
 		setEnd(_endField.getText());
		if (isNotInteger(getEnd()))
			 setEnd("0");
		calculateLength();
	}

	void LengthField_FocusLost(java.awt.event.FocusEvent event) {
		if (isNotInteger(_lengthField.getText()))
			_lengthField.setText("0");
		calculateEnd();
	}

	void calculateLength() {
		try {
			int start = Integer.parseInt(_startField.getText());
			int end = Integer.parseInt(getEnd());
			int length = end - start;
			_lengthField.setText(String.valueOf(length));
		} catch (NumberFormatException e) {
			throw new RuntimeException("Unexpected Number Format Error");
		}
	}

	void calculateEnd() {
		try {
			int start = Integer.parseInt(_startField.getText());
			int length = Integer.parseInt(_lengthField.getText());
			int end = start + length;
			setEnd(String.valueOf(end));
		} catch (NumberFormatException e) {
			throw new RuntimeException("Unexpected Number Format Error");
		}
	}

	String getEnd() {
		return _endField.getText();
	}

	void setEnd(String arg) {
		_endField.setText(arg);
	}

	public static void main(String[] args) {
		IntervalWindow iw = new IntervalWindow();
		iw.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {

	}
}