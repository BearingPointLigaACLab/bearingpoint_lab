package model;

public abstract class Cell {

	private Line row;
	private Line column;
	private String value;

	public Line getRow() {
		return row;
	}

	public void setRow(Line row) {
		this.row = row;
	}

	public Line getColumn() {
		return column;
	}

	public void setColumn(Line column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
