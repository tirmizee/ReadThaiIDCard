package com.cardreader;

/**
 * @author Pratya Yeekhaday
 *
 * @param <T> responseDataType
 */
public interface CardReader<T> {

	T readCard() throws Exception;
	
}
