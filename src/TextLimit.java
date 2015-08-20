/* Program for Data entry by asv130130 (Name:- AMOL VAZE )*/
// Code for limiting characters being inserted into textfield

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextLimit extends PlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int limit;

	TextLimit(int limitation) {
		super();
		this.limit = limitation;
	}

	public void insertString(int offset, String str, AttributeSet set)
			throws BadLocationException {
		if (str == null)
			return;

		else if ((getLength() + str.length()) <= limit) {
			str = str.toUpperCase();
			super.insertString(offset, str, set);

		}
	}
}
