/*******************************************************************************
 * Copyright 2014 uniVocity Software Pty Ltd
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.univocity.parsers.tsv;

import com.univocity.parsers.common.*;

import java.util.*;

/**
 * The TSV format configuration, for tab-separated inputs. It offers the options in the default configuration in {@link Format}, as well as
 * the {@link #escapeChar} character for escaping \t, \n, \r and \ in TSV values.
 *
 * Delimiters are defined as tab characters '\t'
 *
 * @see com.univocity.parsers.common.Format
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:parsers@univocity.com">parsers@univocity.com</a>
 *
 */
public class TsvFormat extends Format {

	private char escapeChar = '\\';

	/**
	 * Defines the character used for escaping special characters in TSV inputs: \t, \n, \r and \ . Defaults to '\\'
	 * @param escapeChar the escape character
	 */
	public void setEscapeChar(char escapeChar) {
		this.escapeChar = escapeChar;
	}

	/**
	 * Returns the character used for escaping special characters in TSV inputs: \t, \n, \r and \
	 * @return the escape character.
	 */
	public char getEscapeChar() {
		return escapeChar;
	}

	/**
	 * Identifies whether or not a given character is used for escaping special characters in TSV (\t, \n, \r and \).
	 * @param ch the character to be verified
	 * @return true if the given character is escape character, false otherwise
	 */
	public boolean isEscapeChar(char ch) {
		return this.escapeChar == ch;
	}

	@Override
	protected TreeMap<String, Object> getConfiguration() {
		TreeMap<String, Object> out = new TreeMap<String, Object>();
		out.put("Escape character", escapeChar);
		return out;
	}
}