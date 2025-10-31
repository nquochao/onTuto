package mypackage.tuto.prototype.beans;

public class Position {
	int x, y;

	public Position(int x2, int y2) {
		x = x2;
		y = y2;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position offsetX(int i) {
		x=x+i;
		return this;
	}
	public Position offsetY(int i) {
		y=y+i;
		return this;
	}
}
