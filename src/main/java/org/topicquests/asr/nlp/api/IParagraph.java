/*
 * Copyright 2023 TopicQuests Foundation
 *  This source code is available under the terms of the Affero General Public License v3.
 *  Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
 */

package org.topicquests.asr.nlp.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public interface IParagraph  extends IAddressable {
	public static final String
		SENTENCE_ID_FIELD		= "sIds",
		CONCEPTS_FIELD			= "concepts";

	void setDocumentId(long id);
	
	/**
	 * Default return is {@code -1}
	 * @return
	 */
	long getDocumentId();

	void setText(String text);
	String getText();

	void addSentenceId(long id);
	void setSentenceIds(JsonArray ids);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getSentenceIds();
	
	/**
	 * Concepts are Ontology entries detected by spaCy in each sentence
	 * @param concepts
	 */
	void setParagraphConcepts(JsonArray concepts);
	
	/**
	 * can return {@code null}
	 * @return
	 */
	JsonArray getParagraphConcepts();
	
	JsonObject getData();
}
