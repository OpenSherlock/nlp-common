/**
 * 
 */
package org.topicquests.asr.nlp.api;

import com.google.gson.JsonObject;

/**
 * @author jackpark
 * <p>Some abstractions are just paragraphs,
 * 	others are collections of sections with titles and paragraphs</p>
 */
public interface IAbstract {

	
	void addSection(String title, String text, String language);
	
	void addParagraph(String text, String language);
	
	JsonObject getData();
}
