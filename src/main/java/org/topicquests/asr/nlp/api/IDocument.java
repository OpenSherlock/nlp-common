/*
 * Copyright 2023 TopicQuests Foundation
 *  This source code is available under the terms of the Affero General Public License v3.
 *  Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
 */
package org.topicquests.asr.nlp.api;

import com.google.gson.JsonObject;

/**
 * @author jackpark
 * An interface which can be extended for document types
 */
public interface IDocument extends IAddressable {
	public static final String
		PUBLICATION_TYPE		= "doc",
		CONVERSATION_TYPE		= "conv";
	
	public static final String
		PUBLICATION_KEY			= "pub",
		AUTHOR_KEY				= "author",
		ABSTRACT_KEY			= "abs",
		BODY_KEY				= "body",
		TYPE_KEY				= "type";
	
	void setPMCID(String pmcid);
	void setPMID(String pmid);
	void setISBN(String isbn);
	void setDOI(String doi);
	
	String getPMCID();
	String getPMID();
	String getISBN();
	String getDOI();

	
	void setBody(String text);
	

	void setType(String t);
	String getType();
	
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	String getBody();
	
	JsonObject getData();

}
