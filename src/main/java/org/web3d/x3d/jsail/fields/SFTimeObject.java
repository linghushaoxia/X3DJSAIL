/*
Copyright (c) 1995-2017 held by the author(s).  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer
      in the documentation and/or other materials provided with the
      distribution.
    * Neither the name of the Web3D Consortium (http://www.web3D.org)
      nor the names of its contributors may be used to endorse or
      promote products derived from this software without specific
      prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*/

package org.web3d.x3d.jsail.fields;

import org.web3d.x3d.jsail.*;
import org.web3d.x3d.sai.InvalidFieldValueException;

/**
 * This utility class provides a concrete implementation corresponding to SFTime X3D field type.
 * 
 * <br><br>
 * The SFTime field specifies a single time value. Time values are specified as a double-precision floating point number. Typically, SFTime fields represent the number of seconds since Jan 1, 1970, 00:00:00 GMT. <br><br> Related field object: {@link MFTimeObject }
 * 

 * <br>
 * <i>Package hint:</i>  This specification class is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/abstracts.html#X3DFieldTypes" target="_blank">SAI Java Specification: B.4.11 X3DFieldTypes</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-2/V3.3/Part02/dataRef.html#SAIFieldType" target="blank">SAI Abstract Specification: 5.2.15 SAIFieldType</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/fieldsDef.html#SFTimeAndMFTime" target="blank">X3D Abstract Specification: SFTimeAndMFTime</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html" target="_blank">X3D Tooltips</a>
 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#field"      target="_blank">X3D Tooltips: field</a>
 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#fieldValue" target="_blank">X3D Tooltips: fieldValue</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public class SFTimeObject extends X3DConcreteField implements org.web3d.x3d.sai.SFTime
{
	/** String constant <i>NAME</i> provides name of this element: <i>SFTime</i>. */
	public static final String NAME = "SFTime";

	/** Default value for this field type is a <i>-1</i> value.
	 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html" target="_blank">Java Tutorials: Primitive Data Types</a>
     */
	public static final double DEFAULT_VALUE = -1.0;

	// Member value declaration is encapsulated and private, using preferred Java types for concretes library
	private double SFTime = DEFAULT_VALUE;

	/**
	 * Constructor for SFTimeObject performs value initialization.
	 */
	public SFTimeObject ()
	{
		initialize();
	}

	/**
	 * Initialization for SFTimeObject applies default initial value.
	 */
	@Override
	public void initialize()
	{
		SFTime = DEFAULT_VALUE;
	}

	/**
	 * Utility accessor for SFTimeObject using String value (which must pass parsing validation checks).
	 * <br ><br >
	 * <i>WARNING:</i> this method is not 
	 * <i><a href="https://en.wikipedia.org/wiki/Type_safety" target="_blank">type safe</a></i>
	 * at compile time!  Best practice for X3DJSAIL programmers is to use strongly typed methods instead, in order to avoid potential for run-time errors.
	 * @see X3DLoaderObject#toX3dObjectTree(org.w3c.dom.Node)
	 * @param newValue is new value to assign, if empty then assign DEFAULT_VALUE
	 * @return {@link MFMatrix4dObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
method invocations on the same node object).
	 */
	public SFTimeObject setValueByString (String newValue) throws InvalidFieldValueException
	{
		if (newValue == null)
			newValue = new String(); // Principle of Least Astonishment (POLA)
			// https://en.wikipedia.org/wiki/Principle_of_least_astonishment
		if (newValue.trim().isEmpty())
		{
			SFTime = DEFAULT_VALUE;
			return this;
		}
		try
		{
			SFTime = Double.parseDouble(newValue);
			if ((SFTime < 0.0) && (SFTime != DEFAULT_VALUE)) // initial value check
			{
				SFTime = DEFAULT_VALUE;
			}
		}
		catch (NumberFormatException e)
		{
			String errorNotice = "new SFTimeObject(" + newValue + ") " + e.getMessage();
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldValueException (errorNotice);
		}
		return this;
	}

	/**
	 * Constructor to copy an SFTimeObject value as initial value for this new field object.
	 * @param newValue The newValue to apply
	 */
	public SFTimeObject(SFTimeObject newValue)
	{
		if (newValue == null)
		{
			SFTime = DEFAULT_VALUE;
			return;
		}
		SFTime = newValue.getPrimitiveValue();
	}

	/**
	 * Constructor for SFTimeObject using a corresponding Java primitive double as new initial value.
	 * @param newValue is new value to assign
	 * setContainerFieldOverride(containerFieldName); // apply checksConcreteField#getTupleSize(String)
	 */
	public SFTimeObject (double newValue)
	{
		if ((newValue < 0.0) && (newValue != DEFAULT_VALUE)) // initial value check
		{
			SFTime = DEFAULT_VALUE;
			return;
		}
		SFTime = newValue;
	}

	/**
	 * Constructor using float as new initial value.
	 * @param newValue is new value to assign
	 */
	public SFTimeObject (float newValue)
	{
		SFTime = (double) newValue;
		if ((SFTime < 0.0) && (SFTime != DEFAULT_VALUE)) // initial value check
		{
			SFTime = DEFAULT_VALUE;
		}
	}
	/**
	 * Constructor using int as new initial value.
	 * @param newValue is new value to assign
	 */
	public SFTimeObject (int newValue)
	{
		SFTime = (double) newValue;
		if ((SFTime < 0.0) && (SFTime != DEFAULT_VALUE)) // initial value check
		{
			SFTime = DEFAULT_VALUE;
		}
	}

	/**
	 * Static utility method to provide String representation of a correctly typed input value.
	 * @param value The value to convert to a String
	 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#type">X3D Tooltips: type</a>
	 * @return String version of the provided value
	 */
	public static String toString (double value)
	{
		return String.valueOf(value);
	}

	/**
	 * Get the current value.
	 * @return current value
	 */
	@Override
	public double getValue()
	{
		return SFTime;
	}

	/**
	 * Provides current value of the field as a Java primitive type.
	 * @return current value
	 */
	public double getPrimitiveValue()
	{
		return SFTime;
	}
	/**
	 * Provides current value as a String.
	 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#type">X3D Tooltips: type</a>
	 * @return String version of the provided value
	 */
	@Override
	public String toString()
	{
		return String.valueOf(SFTime);
	}
	/**
	 * Assign a new value to this field.
	 * @see X3DConcreteField#getTupleSize(String)
	 * @param newValue The replacement value to assign.
	 */
	@Override
	public void setValue(double newValue)
	{
		SFTime = newValue;
	}
	
/**
*	Get the current value.
* 	@return current value
*/
@Override
public long getJavaValue()
{
	return (long)SFTime;
}	
/**
* Assign a new value, converting seconds from (long) to (double).
* @param newValue The replacement value to assign.
*/
@Override
public void setValue(long newValue)
{
	SFTime = (double)newValue;
	if ((SFTime < 0.0) && (SFTime != DEFAULT_VALUE)) // initial value check
	{
		SFTime = DEFAULT_VALUE;
	}
}

	/**
	 * Apply a float value to this double field type, note change in precision.
	 * @param newValue The float newValue to apply
	 * @return {@link SFTimeObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SFTimeObject setValue(float newValue)
	{
		SFTime = (double) newValue;
		return this;
	}

	/**
	 * Apply an int value to this double field type, note change in precision.
	 * @param newValue The float newValue to apply
	 * @return {@link SFTimeObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SFTimeObject setValue(int newValue)
	{
		SFTime = (double) newValue;
		return this;
	}

	/**
	 * Utility method to strip trailing fractional zeroes from String representations of the current object's value.
	 * Applicability: first converting an integer (such as 100) to double and then String results in trailing decimal point and zero (such as
100.0).
	 * Functionality can be globally enabled/disabled by {@link ConfigurationProperties#setStripTrailingZeroes(boolean)}.
	 * @see <a href="http://stackoverflow.com/questions/14984664/remove-trailing-zero-in-java">StackOverflow: Remove trailing zero in Java</a>
	 * @see <a href="http://stackoverflow.com/questions/11284938/remove-trailing-zeros-from-double">StackOverflow: Remove trailing zeros from double (String manipulation solution)</a>
	 * @see <a href="http://stackoverflow.com/questions/703396/how-to-nicely-format-floating-numbers-to-string-without-unnecessary-decimal-0">StackOverflow: How to nicely format floating numbers to String without unnecessary decimal 0? (&quot;In short&quot; solution)</a>
	 * @see <a href="https://library.oreilly.com/book/0636920023630/regular-expressions-cookbook-2nd-edition/275.xhtml">Regular Expressions Cookbook, 6.6. Strip Leading Zeros, by Jan Goyvaerts, Steven Levithan</a>
	 * @return string value with trailing zeros and decimal points stripped
	 */
	public String stripTrailingZeroes()
	{
		return stripTrailingZeroes(getValue());
	}
	/**
	 * Utility method to always strip trailing fractional zeroes from String value of any given double.
	 * Applicability: first converting an integer (such as 100) to double and then String results in trailing decimal point and zero (such as 100.0).
	 * <i>Note:</i> not affected by {@link ConfigurationProperties#setStripTrailingZeroes(boolean)}.
	 * @param value a double-precision number
	 * @see #stripTrailingZeroes(double)
	 * @return string value with trailing zeros and decimal points stripped
	 */
	public static String stripTrailingZeroes(double value)
	{
		String stringValue = String.valueOf(value);
		if (stringValue.contains(".") && !stringValue.contains("E") && !stringValue.contains("e"))
			 // regex to strip trailing zeroes, then strip trailing decimal point (if no other fractional part remains)
			 return stringValue.replaceAll("[0]*$", "").replaceAll("\\.$", "");
		else return stringValue; // avoided values with decimal point or exponential scientific notation
	}

	/**
	 * Apply an SFTimeObject value to this field.
	 * @param newValue The newValue to apply
	 * @return {@link SFTimeObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SFTimeObject setValue(SFTimeObject newValue)
	{
		if (newValue == null)
		{
			SFTime = DEFAULT_VALUE;
			return this;
		}
		SFTime = newValue.getPrimitiveValue();
		return this;
	}								
}
