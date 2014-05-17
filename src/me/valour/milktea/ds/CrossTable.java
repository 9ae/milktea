package me.valour.milktea.ds;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Alice Q. Wong
 * @version 1.0
 *
 * @param <T> row type
 * @param <S> column type
 * @param <V> cell type
 */
public class CrossTable<T,S,V> {

	protected Hashtable<Duo<T,S>,V> table;
	
	/**
	 * Create table
	 */
	public CrossTable(){
		table = new Hashtable<Duo<T,S>, V>();
	}
	
	/**
	 * Find the value given row and column objects
	 * @param row
	 * @param col
	 * @param defaultValue
	 * @return
	 */
	public V get(T row, S col, V defaultValue){
		V val = defaultValue;
		for(Duo<T,S> pair: table.keySet()){
			if(pair.equals(row, col)){
				val = table.get(pair);
				break;
			}
		}
		return val;
	}
	
	/**
	 * Set value
	 * @param row
	 * @param col
	 * @param val
	 */
	public void set(T row, S col, V val){
		Duo<T,S> d = null;
		for(Duo<T,S> pair: table.keySet()){
			if(pair.equals(row, col)){
				d = pair;
				break;
			}
		}
		if(d==null){
			d = new Duo<T,S>(row, col);
		} else {
			table.remove(d);
		}
		table.put(d,val);
	}
	
	/**
	 * Remove cell
	 * @param row
	 * @param col
	 * @return
	 */
	public V remove(T row, S col){
		Duo<T,S> d = null;
		for(Duo<T,S> pair: table.keySet()){
			if(pair.equals(row, col)){
				d = pair;
				break;
			}
		}
		
		if(d!=null){
			return table.remove(d);
		} else {
			return null;
		}
	}
	
	/**
	 * Add row
	 * @param row
	 * @param cols
	 * @param defaultValue
	 */
	public void addRow(T row, List<S> cols, V defaultValue){
		for(S c : cols){
			set(row,c, defaultValue);
		}
	}
	
	/**
	 * Add column
	 * @param col
	 * @param rows
	 * @param defaultValue
	 */
	public void addCol(S col, List<T> rows, V defaultValue){
		for(T r : rows){
			set(r, col, defaultValue);
		}
	}
	
	/**
	 * Remove row from table 
	 * @param row
	 */
	public void rmRow(T row){
		Set<Duo<T,S>> keySet = table.keySet();
		Iterator<Duo<T,S>> it = keySet.iterator();
		while(it.hasNext()){
			Duo<T,S> pair = it.next();
			if(pair.hasRow(row)){
				it.remove();
			}
		}
	}
	
	/**
	 * Remove column from table
	 * @param col
	 */
	public void rmCol(S col){
		Set<Duo<T,S>> keySet = table.keySet();
		Iterator<Duo<T,S>> it = keySet.iterator();
		while(it.hasNext()){
			Duo<T,S> pair = it.next();
			if(pair.hasCol(col)){
				it.remove();
			}
		}
	}
}
