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
package com.univocity.parsers.common.fields;

import com.univocity.parsers.common.*;

import java.util.*;

/**
 * A FieldSelector capable of deselecting fields by their name in a record.
 *
 * <p> This selector stores undesired fields and will return the indexes of those fields that are not part of the selection.
 *
 * @see FieldSelector
 * @see FieldSet
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:parsers@univocity.com">parsers@univocity.com</a>
 *
 */
public class ExcludeFieldNameSelector extends FieldSet<String> implements FieldSelector {

	/**
	 * Returns the indexes of any that are part of a sequence of headers but not part of the selection.
	 * @param headers the sequence of headers that might have some elements selected by this FieldSelector
	 * @return the positions of all elements which were not selected.
	 */
	@Override
	public int[] getFieldIndexes(String[] headers) {
		headers = ArgumentUtils.normalize(headers);

		// removes duplicates if any
		Set<String> chosenFields = new HashSet<String>(this.get());
		ArgumentUtils.normalize(chosenFields);

		Object[] unknownFields = ArgumentUtils.findMissingElements(headers, chosenFields);
		if (unknownFields.length > 0) {
			throw new IllegalStateException("Unknown field names: " + Arrays.toString(unknownFields));
		}

		int[] out = new int[headers.length - chosenFields.size()];

		int j = 0;
		for (int i = 0; i < headers.length; i++) {
			if (!chosenFields.contains(headers[i])) {
				out[j++] = i;
			}
		}

		return out;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String describe() {
		return "undesired " + super.describe();
	}
}
