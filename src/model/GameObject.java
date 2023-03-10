public class GameObject {
	private int _startPoint;
	private int _endPoint;
	private String _id;

	public GameObject(String aId) {
		throw new UnsupportedOperationException();
	}

	public int getStartPoint() {
		return this._startPoint;
	}

	public void setStartPoint(int aStartPoint) {
		this._startPoint = aStartPoint;
	}

	public int getEndPoint() {
		return this._endPoint;
	}

	public void setEndPoint(int aEndPoint) {
		this._endPoint = aEndPoint;
	}

	public void getAttribute() {
		throw new UnsupportedOperationException();
	}

	public void setAttribute(Object aAttribute) {
		throw new UnsupportedOperationException();
	}

	public String getId() {
		return this._id;
	}

	public void setId(String aId) {
		this._id = aId;
	}
}