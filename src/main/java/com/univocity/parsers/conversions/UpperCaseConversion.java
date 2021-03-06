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
package com.univocity.parsers.conversions;

/**
 * Converts an input String to its upper case representation
 *
 * The {@link UpperCaseConversion#revert(String)} implements the same behavior of {@link UpperCaseConversion#execute(String)}. Null inputs produce null outputs.
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:parsers@univocity.com">parsers@univocity.com</a>
 *
 */
public class UpperCaseConversion implements Conversion<String, String> {

	/**
	 * Applies the toUpperCase operation in the input and returns the result.
	 * Equivalent to {@link UpperCaseConversion#revert(String)}
	 * @param input the String to be converted to upper case
	 * @return the upper case representation of the given input, or null if the input is null.
	 */
	@Override
	public String execute(String input) {
		if (input == null) {
			return null;
		}
		return input.toUpperCase();
	}

	/**
	 * Applies the toUpperCase operation in the input and returns the result.
	 * Equivalent to {@link UpperCaseConversion#execute(String)}
	 * @param input the String to be converted to upper case
	 * @return the upper case representation of the given input, or null if the input is null.
	 */
	@Override
	public String revert(String input) {
		return execute(input);
	}

}
