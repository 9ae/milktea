package me.valour.milktea.ds;

/**
 * 
 * @author Alice Q. Wong
 * @version 1.0
 * @param <T>
 * @param <S>
 */
public class Duo<T,S> {

	private final T row;
	private final S col;
	
	/**
	 * Make new 2-tuple
	 * @param x
	 * @param y
	 */
	public Duo(T x, S y) { 
	    this.row = x; 
	    this.col = y; 
	} 
	
	/**
	 * Check if the values are equal
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean equals(T x, S y){
		return row.equals(x) && col.equals(y);
	}
	
	/**
	 * If the first value is the same as x
	 * @param x
	 * @return
	 */
	public boolean hasRow(T x){
		return row.equals(x);
	}
	
	/**
	 * If the second value is the same as y
	 * @param y
	 * @return
	 */
	public boolean hasCol(S y){
		return col.equals(y);
	}

	/**
	 * @return the row
	 */
	public T getRow() {
		return row;
	}

	/**
	 * @return the col
	 */
	public S getCol() {
		return col;
	}
	
	
}
