package boardgame;

public class Board {
	private int rows, columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		
		if (rows < 1 || columns < 1) {
			throw new BoardException("Necess�rio ao menos 1 linha e coluna para criar um tabuleiro");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posi��o (" + row + "," + column + ") n�o � valida!");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o (" + position + ") n�o � valida!");
		}

		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece (Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Posi��o (" + position + ") j� esta sendo usada!");
		}
		pieces[position.getRow()] [position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
				
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o (" + position + ") n�o � valida!");
		}

		return piece(position) != null;
	}
	
	
	
}
