/*
 * Copyright 2023 TopicQuests Foundation
 *  This source code is available under the terms of the Affero General Public License v3.
 *  Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
 */
package org.topicquests.asr.nlp.api;

import org.topicquests.support.api.IResult;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public interface IWordGram extends IAddressable, ILiveObject {
	public static final String
		ID_KEY			= "id",
		SENT_EDGES_KEY	= "sedges",
		LOX_KEY			= "lox", 	// locators
		IN_KEY			= "inLinks", // {sentenceId, gramId}
		OUT_KEY			= "outLinks", // {sentenceId, gramId}
		DBPED_KEY		= "dbp",	// dbpedia
		WIKID_KEY		= "wikd",	// wikidata
		TENSE_KEY		= "tense",  // predicate tense,e.g.past,present,
		NEGATION_KEY	= "neg",	// boolean
		EPI_KEY		= 	"epi",		// epistemic status,e.g. speculative,can be null
		POS_KEY			= "pos",	// part of speech
		WORDS_KEY		= "words",	// the text for this gram
		INVERSE_KEY		= "inverse",// inverse predicate - only for passive predicates
		CANNON_KEY		= "cannon",	// canonical NER
		SYNONYM_KEY		= "synon",	// synonyms
		ANTONYM_KEY		= "anton",	// antonyms
		HYPONYM_KEY		= "hypon",
		HYPERNYM_KEY	= "hypern",
		EXTENSION_KEY	= "extns";	// for extension properties	
	
	
	JsonObject getData();
	
	/**
	 * <p>If {@code languageCode} == {@code null}, defaults to {@code en}<p>
	 * <p>If nothing is available for a specified {@code languageCode}returns {@code null}
	 * @param languageCodea 2 or 3-letter code - can be {@code null}
	 * @return
	 */
	String getWords(String languageCode);
	
	/**
	 * <p>Setting {@code words} means you can give this wordgram its wordsin
	 *  any language</p>
	 * @param words
	 * @param languageCode a 2 or 3-letter code - can be {@code null}
	 */
	void setWords(String words, String languageCode);
	
	
	
	////////////////////////////////////
	// Edges
	//	They are now associated with SentenceId in a map
	//  Here, we can indicate the tense (past, pressent,...) 
	//	and the epistemic status,e.g. speculation - for that sentence
	//	THIS applies only to when a canonical form or inverse is selected
	/**
	 * 
	 * @param sentenceId
	 * @param tense  can be {@code null}
	 * @param epi    can be {@code null}
	 */
	void setSentenceId(long sentenceId, String tense, String epi);
	
	//JsonArray listInLinks();
	//JsonArray listOutLinks();
	
	/**
	 * Can return {@code null}
	 * @param sentenceId
	 * @return
	 */
	JsonObject getSentenceEdge(long sentenceId);
	
	
	/**
	 * <p>For live object updating</p>
	 * <p>A sentence edge is constructed from a new sentence impacting a wordgram.
	 * Since the wordgram might have come from an active-passive or speculative situation,
	 * we have the ability to mirror the tense and epistemicStatus of that wordgram in this
	 * sentence edge</p>
	 * @param sentenceId TODO
	 * @param inLinkTargetId
	 * @param outlinkTargetId
	 * @param tense
	 * @param epistemicStatus
	 * @return returns {@code null} if not used on alive object
	 */
	IResult addSentenceEdge(long sentenceId, long inLinkTargetId, long outlinkTargetId,
			String tense, String epistemicStatus);

	
	/**
	 * Called from database
	 * @param edge
	 */
	void setSentenceEdges(JsonObject edges);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonObject getSentenceEdges();
	
	void addInLink(long sentenceId, long gramId);
	void addOutlink(long sentenceId, long gramId);
	//
	////////////////////////////////////
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listTopicLocators();
	
	void addTopicLocator(long locator);
	
	void setTopicLocators(JsonArray locators);
	
	/**
	 * For predicates, indicates a <em>not</em>
	 * @param isNeg
	 */
	void setNegation(boolean isNeg);
	boolean getNegation();
	
	/**
	 * Can return {@code null}
	 * @return - list of JSON objects
	 */
	String getDBpedia();
	
	void setDBpedia(String dbPediaJson);
	
	/**
	 * Can return {@code null}
	 * @return list of wikidata identifiers
	 */
	String getWikidata();
	
	void setWikidata(String wikidataId);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listPOS();
	
	void addPOS(String pos);
	
	void setPOS(JsonArray pos);
	
	void setInverseTerm(long inverseTermId);
	/**
	 * Can return {@code -1} if no inverse termexists
	 * @return
	 */
	long getInverseTerm();
	
	/**
	 * Shortcut
	 * @return
	 */
	boolean hasInverseTerm();
	
	void setCannonTerm(long cannonTermId);
	/**
	 * Can return {@code -1} if no cannonical term exists
	 * @return
	 */
	long getCannonTerm();
	
	/**
	 * Shortcut
	 * @return
	 */
	boolean hasCannonicalTerm();
	
	void addSynonymTerm(long synonymTermId);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listSynonyms();
	
	void addAntonymTerm(long antonymTermId);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listAntonyms();
	
	void addHyponymTerm(long hypoTermId);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listHyponyms();
	
	void addHypernymTerm(long hyperTermId);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listHypernyms();
	
	/**
	 * Predicate tense,e.g.past
	 * @param tense
	 */
	void setTense(String tense);
	/**
	 * Can return {@code null}
	 * @return
	 */
	String getTense();
	/**
	 * Epistemic status e.g. speculative
	 * @param status
	 */
	void setEpistemicStatus(String status);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	String getEpistemicStatus();
	
	/**
	 * <p>An <em>extension property</em> is one we haven't thought of yet.</p>
	 * <p>To enable processing, the {@code key} should be distinctive, such as, e.g. {@code _myKey}</p>
	 * @param key
	 * @param value
	 */
	void addExtensionProperty(String key, String value);
	//void addExtensionProperty(String key, JsonObject value);
	//void addExtensionProperty(String key, JsonArray value);

	/**
	 * @param key
	 * @return
	 */
	JsonObject getExtensionProperty(String key);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonObject getExtensionPropeties();
}
