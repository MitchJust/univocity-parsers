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
package com.univocity.parsers.common.processor;

import com.univocity.parsers.common.*;
import com.univocity.parsers.conversions.*;

import java.util.*;

/**
 *
 * A {@link RowProcessor} implementation for converting rows extracted from any implementation of {@link AbstractParser} into columns of objects.
 * <p>This uses the value conversions provided by {@link Conversion} instances.</p>
 *
 * <p> For each row processed, a sequence of conversions will be executed to generate the appropriate object. Each resulting object will then be stored in
 * 	a list that contains the values of the corresponding column. </p>
 *
 * <p> At the end of the process, the user can access the lists with values parsed for all columns using the methods {@link #getColumnValuesAsList()},
 * {@link #getColumnValuesAsMapOfIndexes()} and {@link #getColumnValuesAsMapOfNames()}. </p>
 *
 * <p><b>Note:</b> Storing the values of all columns may be memory intensive. For large inputs, use a {@link BatchedObjectColumnProcessor} instead</p>
 *
 * @see AbstractParser
 * @see RowProcessor
 * @see ColumnReaderProcessor
 * @see Conversion
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:parsers@univocity.com">parsers@univocity.com</a>
 *
 */
public class ObjectColumnProcessor extends ObjectRowProcessor implements ColumnReaderProcessor<Object> {

	private final ColumnSplitter<Object> splitter;

	/**
	 * Constructs a column processor, pre-allocating room for 1000 rows.
	 */
	public ObjectColumnProcessor() {
		this(1000);
	}

	/**
	 * Constructs a column processor pre-allocating room for the expected number of rows to be processed
	 * @param expectedRowCount the expected number of rows to be processed
	 */

	public ObjectColumnProcessor(int expectedRowCount) {
		splitter = new ColumnSplitter<Object>(expectedRowCount);
	}

	@Override
	public final String[] getHeaders() {
		return splitter.getHeaders();
	}

	@Override
	public final List<List<Object>> getColumnValuesAsList() {
		return splitter.getColumnValues();
	}

	@Override
	public final void putColumnValuesInMapOfNames(Map<String, List<Object>> map) {
		splitter.putColumnValuesInMapOfNames(map);
	}

	@Override
	public final void putColumnValuesInMapOfIndexes(Map<Integer, List<Object>> map) {
		splitter.putColumnValuesInMapOfIndexes(map);
	}

	@Override
	public final Map<String, List<Object>> getColumnValuesAsMapOfNames() {
		return splitter.getColumnValuesAsMapOfNames();
	}

	@Override
	public final Map<Integer, List<Object>> getColumnValuesAsMapOfIndexes() {
		return splitter.getColumnValuesAsMapOfIndexes();
	}

	@Override
	public void rowProcessed(Object[] row, ParsingContext context) {
		splitter.addValuesToColumns(row, context);
	}

	@Override
	public void processStarted(ParsingContext context) {
		super.processStarted(context);
		splitter.reset();
	}
}
