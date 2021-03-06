/*******************************************************************************
 * Copyright 2015 uniVocity Software Pty Ltd
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

package com.univocity.parsers.common.record;

import com.univocity.parsers.common.fields.*;
import com.univocity.parsers.conversions.*;

public interface RecordMetaData {

	public int indexOf(Enum<?> column);

	public int indexOf(String headerName);

	public Class<?> typeOf(Enum<?> column);

	public Class<?> typeOf(String headerName);

	public Class<?> typeOf(int columnIndex);

	@SuppressWarnings("rawtypes")
	public void setTypeOfColumns(Class<?> type, Enum... columns);

	public void setTypeOfColumns(Class<?> type, String... headerNames);

	public void setTypeOfColumns(Class<?> type, int... columnIndexes);

	public <T> void setDefaultValueOf(Enum<?> column, T defaultValue);

	public <T> void setDefaultValueOf(String headerName, T defaultValue);

	public <T> void setDefaultValueOf(int columnIndex, T defaultValue);

	public Object defaultValueOf(Enum<?> column);

	public Object defaultValueOf(String headerName);

	public Object defaultValueOf(int columnIndex);

	@SuppressWarnings("rawtypes") 
	public <T extends Enum<T>> FieldSet<T> convertFields(Class<T> enumType, Conversion... conversions);

	@SuppressWarnings("rawtypes") 
	public FieldSet<String> convertFields(Conversion... conversions);

	@SuppressWarnings("rawtypes") 
	public FieldSet<Integer> convertIndexes(Conversion... conversions);

	public String[] headers();

}
