/*
 * Copyright 2023 TopicQuests Foundation
 *  This source code is available under the terms of the Affero General Public License v3.
 *  Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
 */
package org.topicquests.asr.nlp.api;

/**
 * @author jackpark
 * All features use BIGINTs as database identifiers
 */
public interface IAddressable {
	public static final String ID_KEY = "id";

	void setId(long id);
	
	long getId();
}
