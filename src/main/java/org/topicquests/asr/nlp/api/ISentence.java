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
public interface ISentence extends IAddressable {
	public static final String
		PARAGRAPH_ID	= "para_id",
		DOCUMENT_ID		= "doc_id",
		TEXT_FIELD		= "txt",
		PRED_FIELD		= "preds",
		NOUN_FIELD		= "noun",
		PNOUN_FIELD		= "pnoun",	// proper nouns
		RESNOUN_FIELD	= "rnoun", 	// resolved nouns
		VERB_FIELD		= "verb",
		SPACY_FiELD		= "spacy",	//JSON blob from spacy POS
		//CONCEPT_FIELD	= "cons", 	// ontology data
		WD_FIELD		= "wd",		//Wikidata identities
		DBP_FIELD		= "dbp", 	//DBpedia blobs
		TRIPLE_FIELD	= "trpl",
		CONJUNCT_FIELD	= "conj",
		DISJUNCT_FIELD	= "disj",
		NOMINAL_FIELD	= "nom", 	// e.g. "pandemic of"
		SUCHAS_FIELD	= "suchas";
	
	JsonObject getData();
	
	void setParagraphId(long id);
	
	/**
	 * Default return is {@code -1}
	 * @return
	 */
	long getParagraphId();
	
	void setDocumentId(long id);
	
	/**
	 * Default return is {@code -1}
	 * @return
	 */
	long getDocumentId();
	
	void setText(String text);
	String getText();
	
	void setPredicatePhrases(JsonArray preds);
	
	/**
	 * Might return {@code null}
	 * @return
	 */
	JsonArray getPredicatePhrases();
	
	
	void setSpacyData(JsonArray spacyJson);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getSpacyData();
	
	
	//void addWikidataId(String wikidata);
	void setWikiData(JsonArray wikidata);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getWikiData();
	
	//void addDBpediaData(String dbpJson);
	void setDBpediaData(JsonArray dbpedia);
	
	void setNoun(JsonArray noun);
	/**
	 * Can return @code null}
	 * @return
	 */
	JsonArray getNouns();
	
	void setProperNoun(JsonArray noun);
	/**
	 * Can return @code null}
	 * @return
	 */
	JsonArray getProperNouns();

	void setVerb(JsonArray verb);
	/**
	 * Can return @code null}
	 * @return
	 */
	JsonArray getVerbs();

	void setResolvedNouns(JsonArray nouns);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getResolvedNouns();
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getDBpediaData();
	
	void addSimpleTriple(JsonObject trip);
	
	void setSimpleTriples(JsonArray triples);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getSimpleTriples();
	
	void addConjunct(JsonObject conj);
	void setConjuncts(JsonArray conjs);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getConjuncts();
	
	void addDisjunct(JsonObject disj);
	void setDisjuncts(JsonArray disjs);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray getDisjuncts();
	
	boolean hasDisjuncts();
	
	boolean hasConjuncts();
	
	void addNominalPhrase(JsonObject nom);
	void setNominalPhrases(JsonArray noms);
	
	/**
	 * Can return {@code null}
	 * @return
	 */	
	JsonArray getNominalPhrases();
	
	void addSuchAs(JsonObject suchas);
	void setSuchAs(JsonArray suchas);
	
	/**
	 * Can return {@code null}
	 * @return
	 */	
	JsonArray getSuchAs();
	
	boolean hasNominals();
}
