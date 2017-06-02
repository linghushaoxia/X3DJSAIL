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

package org.web3d.x3d.jsail.Core;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.jsail.*; // again making sure #2

// File operations
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
// XSLT operations: Saxon HE9
import net.sf.saxon.s9api.*;
// XSLT operations: Native Java
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
// XSLT operations
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.util.Arrays;
import org.web3d.x3d.sai.Core.*;  // making sure #3
import org.web3d.x3d.jsail.*;
import org.web3d.x3d.jsail.Core.*;

import org.web3d.x3d.jsail.fields.*; // making sure #4
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Core.*;

/**
 * X3D is the root node for an Extensible 3D (X3D) Graphics model. This concrete class represents an X3D statement.
 * 
 * <br><br>
 * <i>X3D statement tooltip</i>:  X3D is the top-most XML element for an Extensible 3D (X3D) Graphics file. The X3D element contains a single head element for metadata, and a single Scene element which is root node of the 3D scene graph. 
 * <ul>
 *  <li> <i>Hint:</i>  add a head element or change its child elements to include component, unit or meta elements.  </li> 
 *  <li> <i>Hint:</i>  add a Scene element or change its children to modify the model for this scene graph.  </li> 
 *  <li> <i>Hint:</i>  for more on XML declaration and DOCTYPE (DTD) statements, see http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation  </li> 
 *  <li> <i>Hint:</i>   additional attributes are under consideration for use when embedding X3D version 4 scenes within HTML version 5 web pages.  </li> 
 * </ul>
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/concepts.html#Header" target="blank">X3D Abstract Specification: X3D</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#X3D" target="_blank">X3D Tooltips: X3D</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public class X3DObject extends org.web3d.x3d.jsail.X3DConcreteStatement
{
	private ArrayList<String> commentsList; // provided since no children array present

	// Member value declarations are encapsulated and private, using preferred Java types for concretes library

	private headObject head; // acceptable node types: head

	private String profile;

	private SceneObject Scene; // acceptable node types: Scene

	private String version;

	/** XML header <i>&lt;?xml version="1.0" encoding="UTF-8"?&gt;</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
					
	/** <i>&lt;!DOCTYPE X3D PUBLIC "ISO//Web3D//DTD X3D 4.1//EN" "http://www.web3d.org/specifications/x3d-4.1.dtd"&gt;</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String DOCTYPE_4_1 = "<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 4.1//EN\" \"http://www.web3d.org/specifications/x3d-4.1.dtd\">";
	
	/** <i>&lt;!DOCTYPE X3D PUBLIC "ISO//Web3D//DTD X3D 4.0//EN" "http://www.web3d.org/specifications/x3d-4.0.dtd"&gt;</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String DOCTYPE_4_0 = "<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 4.0//EN\" \"http://www.web3d.org/specifications/x3d-4.0.dtd\">";
	
	/** <i>&lt;!DOCTYPE X3D PUBLIC "ISO//Web3D//DTD X3D 3.3//EN" "http://www.web3d.org/specifications/x3d-3.3.dtd"&gt;</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String DOCTYPE_3_3 = "<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.3//EN\" \"http://www.web3d.org/specifications/x3d-3.3.dtd\">";
	
	/** <i>&lt;!DOCTYPE X3D PUBLIC "ISO//Web3D//DTD X3D 3.2//EN" "http://www.web3d.org/specifications/x3d-3.2.dtd"&gt;</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String DOCTYPE_3_2 = "<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.2//EN\" \"http://www.web3d.org/specifications/x3d-3.2.dtd\">";
	
	/** <i>&lt;!DOCTYPE X3D PUBLIC "ISO//Web3D//DTD X3D 3.1//EN" "http://www.web3d.org/specifications/x3d-3.1.dtd"&gt;</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String DOCTYPE_3_1 = "<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.1//EN\" \"http://www.web3d.org/specifications/x3d-3.1.dtd\">";
	
	/** <i>&lt;!DOCTYPE X3D PUBLIC "ISO//Web3D//DTD X3D 3.0//EN" "http://www.web3d.org/specifications/x3d-3.0.dtd"&gt;</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String DOCTYPE_3_0 = "<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">";

	/**
	 * <i>xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.0.xsd'</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String SCHEMA_3_0_ATTRIBUTES = "xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.0.xsd'";
	/**
	 * <i>xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.1.xsd'</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String SCHEMA_3_1_ATTRIBUTES = "xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.1.xsd'";
	/**
	 * <i>xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.2.xsd'</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String SCHEMA_3_2_ATTRIBUTES = "xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.2.xsd'";
	/**
	 * <i>xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.3.xsd'</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String SCHEMA_3_3_ATTRIBUTES = "xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-3.3.xsd'";
	/**
	 * <i>xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-4.0.xsd'</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String SCHEMA_4_0_ATTRIBUTES = "xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-4.0.xsd'";
	/**  
	 * <i>xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-4.1.xsd'</i>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Validation">X3D Scene Authoring Hints: Validation of X3D Scenes using DTD and XML Schema</a> */
	public static final String SCHEMA_4_1_ATTRIBUTES = "xmlns:xsd='http://www.w3.org/2001/XMLSchema-instance' xsd:noNamespaceSchemaLocation='http://www.web3d.org/specifications/x3d-4.1.xsd'";


	// ==== String constants for enumeration values ensure correct syntax and avoid run-time errors ====

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"Core"</i> (Java syntax) or <i>Core</i> (XML syntax). */
	public static final String PROFILE_CORE = "Core";

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"Interchange"</i> (Java syntax) or <i>Interchange</i> (XML syntax). */
	public static final String PROFILE_INTERCHANGE = "Interchange";

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"CADInterchange"</i> (Java syntax) or <i>CADInterchange</i> (XML syntax). */
	public static final String PROFILE_CADINTERCHANGE = "CADInterchange";

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"Interactive"</i> (Java syntax) or <i>Interactive</i> (XML syntax). */
	public static final String PROFILE_INTERACTIVE = "Interactive";

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"Immersive"</i> (Java syntax) or <i>Immersive</i> (XML syntax). */
	public static final String PROFILE_IMMERSIVE = "Immersive";

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"MedicalInterchange"</i> (Java syntax) or <i>MedicalInterchange</i> (XML syntax). */
	public static final String PROFILE_MEDICALINTERCHANGE = "MedicalInterchange";

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"MPEG4Interactive"</i> (Java syntax) or <i>MPEG4Interactive</i> (XML syntax). */
	public static final String PROFILE_MPEG4INTERACTIVE = "MPEG4Interactive";

	/** SFString field named <i>profile</i> can equal this enumeration value <i>"Full"</i> (Java syntax) or <i>Full</i> (XML syntax). */
	public static final String PROFILE_FULL = "Full";

	/** SFString field named <i>version</i> can equal this enumeration value <i>"3.0"</i> (Java syntax) or <i>3.0</i> (XML syntax). */
	public static final String VERSION_3_0 = "3.0";

	/** SFString field named <i>version</i> can equal this enumeration value <i>"3.1"</i> (Java syntax) or <i>3.1</i> (XML syntax). */
	public static final String VERSION_3_1 = "3.1";

	/** SFString field named <i>version</i> can equal this enumeration value <i>"3.2"</i> (Java syntax) or <i>3.2</i> (XML syntax). */
	public static final String VERSION_3_2 = "3.2";

	/** SFString field named <i>version</i> can equal this enumeration value <i>"3.3"</i> (Java syntax) or <i>3.3</i> (XML syntax). */
	public static final String VERSION_3_3 = "3.3";

	// String constants for default field values match X3D Schema definitions

	/** String constant <i>NAME</i> provides name of this element: <i>X3D</i>. */
	@SuppressWarnings("FieldNameHidesFieldInSuperclass")
	public static final String NAME = "X3D";

	/** Provides name of this element: X3D.
	 * @return name of this element
	 */
	@Override
	public final String getElementName()
	{
		return NAME;
	}

	/** SFString field named <i>profile</i> has default value <i>"Immersive"</i> (Java syntax) or <i>Immersive</i> (XML syntax). */
	public static final String PROFILE_DEFAULT_VALUE = "Immersive";

	/** SFString field named <i>version</i> has default value <i>"3.3"</i> (Java syntax) or <i>3.3</i> (XML syntax). */
	public static final String VERSION_DEFAULT_VALUE = "3.3";

	/** Indicate type corresponding to given fieldName.
	 * @param fieldName name of field in this X3D statement
	 * @see ConfigurationProperties#ERROR_UNKNOWN_FIELD_TYPE
	 * @return X3D type (SFvec3f etc.), otherwise ConfigurationProperties.ERROR_UNKNOWN_FIELD_TYPE if not recognized
	 */
	@Override		
	public String getFieldType(String fieldName)
	{
		String result;

		switch (fieldName)
		{
			// String constants for exact field type values matching X3D Schema definitions,
			// thus avoiding spelling errors and allowing type-matching checks
											
			case "containerField":
				result = "SFString";
				break;
			case "head":
				result = "SFNode";
				break;
			case "profile":
				result = "SFString";
				break;
			case "Scene":
				result = "SFNode";
				break;
			case "version":
				result = "SFString";
				break;
			default:
			{
				// if fieldName has a prefix "set_" prepended (or a suffix "_changed" appended) then try again by stripping it and recursing once
				if      (fieldName.trim().startsWith("set_"))
						 result = getFieldType(fieldName.trim().substring(4)); // after "set_"
				else if (fieldName.trim().endsWith("_changed"))
						 result = getFieldType(fieldName.trim().substring(0, fieldName.length() - 8)); // before "_changed"
				else     result = ConfigurationProperties.ERROR_UNKNOWN_FIELD_TYPE; // unique return value avoids mistaken matches
			}
		}
		return result;
	}

	/** Indicate accessType corresponding to given fieldName.
	 * @param fieldName name of field in this X3D statement
	 * @see ConfigurationProperties#ERROR_UNKNOWN_FIELD_ACCESSTYPE
	 * @return X3D accessType (inputOnly etc.), otherwise ConfigurationProperties.ERROR_UNKNOWN_FIELD_ACCESSTYPE if not recognized
	 */
	@Override
	public String getAccessType(String fieldName)
	{
		String result; // set by following checks
		switch (fieldName)
		{
			// String constants for field accessType values matching X3D Schema definitions,
			// thus avoiding spelling errors and allowing accessType-matching checks
			case "head":
				result = "inputOutput";
				break;
			case "profile":
				result = "inputOutput";
				break;
			case "Scene":
				result = "inputOutput";
				break;
			case "version":
				result = "inputOutput";
				break;
			default:
			{
				// if user has added a prefix "set_" or suffix "_changed" then try again by stripping it and recursing once
				if      (fieldName.trim().startsWith("set_"))
						 result = getAccessType(fieldName.trim().substring(4)); // after "set_"
				else if (fieldName.trim().endsWith("_changed"))
						 result = getAccessType(fieldName.trim().substring(0, fieldName.length() - 8)); // before "_changed"
				else     result = ConfigurationProperties.ERROR_UNKNOWN_FIELD_ACCESSTYPE; // unique return value avoids mistaken matches
			}
		}
		return result;
	}

	/** Constructor for X3DObject to initialize member variables with default values. */
	public X3DObject()
	{
		super(); // constructor invocation and corresponding initialize()
		initialize();
	}

	/** Initialize all member variables to default values. */
	@Override
	public final void initialize()
	{
		super.initialize();

		head = null; // clear out any prior node
		profile = PROFILE_DEFAULT_VALUE;
		Scene = null; // clear out any prior node
		version = VERSION_DEFAULT_VALUE;

		commentsList = new ArrayList<>(); // instantiate
	}

	/**
	 * File extension for X3D XML Encoding, with dot prepended: <i>.x3d</i>.
	 * @see <a href="http://www.web3d.org/documents/specifications/19776-1/V3.3/Part01/X3D_XML.html">X3D XML Encoding</a>
	 */
	public static final String FILE_EXTENSION_X3D = ".x3d";
										
	/**
	 * File extension for X3D ClassicVRML Encoding, with dot prepended: <i>.x3dv</i>.
	 * @see <a href="http://www.web3d.org/documents/specifications/19776-2/V3.3/Part02/X3D_ClassicVRML.html">X3D ClassicVRML Encoding</a>
	 */
	public static final String FILE_EXTENSION_CLASSICVRML = ".x3dv";
										
	/**
	 * File extension for VRML97 Encoding, with dot prepended: <i>.wrl</i>.
	 * @see <a href="http://www.web3d.org/documents/specifications/14772/V2.0/index.html">VRML97 Encoding</a>
	 */
	public static final String FILE_EXTENSION_VRML97 = ".wrl";
										
	/**
	 * File extension for HTML Encoding, with dot prepended: <i>.html</i>.
	 * @see <a href="https://www.w3.org/TR/html/syntax.html#syntax">HTML5: HTML syntax</a>
	 */
	public static final String FILE_EXTENSION_HTML = ".html";
										
	/**
	 * File extension for XHTML Encoding, with dot prepended: <i>.xhtml</i>.
	 * @see <a href="https://www.w3.org/TR/html/xhtml.html#xhtml">HTML5: XHTML syntax</a>
	 */
	public static final String FILE_EXTENSION_XHTML = ".xhtml";
										
	/**
	 * File extension for Java source, with dot prepended: <i>.jsail</i>.
	 * @see <a href="http://www.oracle.com/technetwork/java/javase/overview">Java Platform, Standard Edition (Java SE)</a>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Java">X3D Scene Authoring Hints: Java</a>
	 */
	public static final String FILE_EXTENSION_JAVA = ".java";
										
	/**
	 * File extension for JavaScript source, with dot prepended: <i>.js</i>.
	 * @see <a href="https://en.wikipedia.org/wiki/JavaScript">JavaScript</a>
	 * @see <a href="https://en.wikipedia.org/wiki/ECMAScript">ECMAScript ECMA-262</a>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#JavaScript">X3D Scene Authoring Hints: JavaScript</a>
	 */
	public static final String FILE_EXTENSION_JAVASCRIPT = ".js";
										
	/**
	 * File extension for JavaScript Object Notation (JSON) source, with dot prepended: <i>.json</i>.
	 * @see <a href="https://en.wikipedia.org/wiki/JSON">JavaScript Object Notation (JSON)</a>
	 * @see <a href="https://www.ecma-international.org/publications/standards/Ecma-404.htm">JSON Data Interchange Format ECMA-404</a>
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#JSON">X3D Scene Authoring Hints: JSON</a>
	 */
	public static final String FILE_EXTENSION_JSON = ".json";

	/** @see https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles */
	private BufferedWriter bufferedWriter;
										
	/**
	 * Serialize scene graph using <i>toStringX3D()</i> to create a new XML-encoding X3D file with extension <i>x3d</i>.
	 * @see X3DObject#toStringX3D()
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param fileName name of file to create and save, can include local directory path, must end with .x3d
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileX3D(String fileName)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileX3D(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_X3D + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_X3D))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_X3D + "\"");
		}
		Path outputFilePath = Paths.get(fileName);
		outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
									
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringX3D();
		try
		{
			bufferedWriter = Files.newBufferedWriter(outputFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
			return outputFilePath.toFile(); // success
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException for fileName " + fileName + ", unable to save file: " + exception);
		}
	}
	/**
	 * Serialize scene graph using <i>toStringClassicVRML()</i> to create a new X3D file with extension <i>x3dv</i>.
	 * @see X3DObject#toStringClassicVRML()
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param fileName name of file to create and save, can include local directory path, must end with .x3dv
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileClassicVRML(String fileName)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileClassicVRML(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_CLASSICVRML + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_CLASSICVRML))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_CLASSICVRML + "\"");
		}
		Path outputFilePath = Paths.get(fileName);
		outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
		
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringClassicVRML();
		try
		{
			bufferedWriter = Files.newBufferedWriter(outputFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
			return outputFilePath.toFile(); // success
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException for fileName " + fileName + ", unable to save file: " + exception);
		}
	}
	/**
	 * Serialize scene graph using <i>toStringVRML97()</i> to create a new X3D file with extension <i>wrl</i>.
	 * @see X3DObject#toStringVRML97()
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param fileName name of file to create and save, can include local directory path, must end with .wrl
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileVRML97(String fileName)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileVRML97(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_VRML97 + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_VRML97))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_VRML97 + "\"");
		}
		Path outputFilePath = Paths.get(fileName);
		outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
		
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringVRML97();
		try
		{
			bufferedWriter = Files.newBufferedWriter(outputFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
			return outputFilePath.toFile(); // success
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException for fileName " + fileName + ", unable to save file: " + exception);
		}
	}
						
	/**
	 * Serialize scene graph using <i>toFileX3D()</i> and then create a new pretty-print HTML file with extension <i>.html</i>, suitable for documentation purposes.
	 * @see X3DObject#toStringX3D()
	 * @see X3DObject#toFileX3D(String)
	 * @see X3DObject#toFileJava(String)
	 * @see X3DObject#toFileJSON(String)
	 * @see X3DObject#toFileX3DOM(String)
	 * @see X3DObject#toFileCobweb(String,String)
	 * @see <a href="http://www.saxonica.com/documentation/index.html#!using-xsl/embedding">Saxonica &gt; Saxon &gt; Using XSLT &gt; Invoking XSLT from an application</a>
	 * @see <a href="http://saxon.sourceforge.net/#F9.7HE">Saxon-HE 9.7</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html">Java Tutorials: Transforming XML Data with XSLT</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/examples/xslt_samples.zip">Java Tutorials: Transforming XML Data with XSLT, sample files</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param fileName name of file to create and save, can include local directory path, must end with .html
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileDocumentationHtml(String fileName)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileDocumentationHtml(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_HTML + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_HTML))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_HTML + "\"");
		}

		// XSLT parameter names and values
		String parameterName1  = "";
		String parameterValue1 = "";
		String parameterName2  = "";
		String parameterValue2 = "";
		Path outputFilePath = Paths.get(fileName);
		
		String intermediateX3DFileName = fileName.substring(0, fileName.length() - 5) + "PrettyPrint.intermediate.x3d";
		Path   intermediateX3DFilePath = Paths.get(intermediateX3DFileName);
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
										
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringX3D();
		try
		{
			bufferedWriter = Files.newBufferedWriter(intermediateX3DFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException when creating intermediateX3DFileName " + intermediateX3DFileName + 
				", unable to save file: " + exception);
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		factory.setValidating    (true);

		String errorNotice = new String();
		try // https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html
		{
/* TODO
			// http://stackoverflow.com/questions/20389255/reading-a-resource-file-from-within-jar
			// http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getResourceAsStream-java.lang.String-
			String stylesheetJarPath = "stylesheets/" + ConfigurationProperties.STYLESHEET_htmlDocumentation;
			InputStream stylesheetInputStream = getClass().getResourceAsStream(stylesheetJarPath);
			
			if (stylesheetInputStream == null)
			{
				errorNotice += "Stylesheet not found in jar: " + stylesheetJarPath + ", ";
			}
*/
			File stylesheetFile = new File("../lib/stylesheets/", ConfigurationProperties.STYLESHEET_htmlDocumentation);
			if (!stylesheetFile.exists())
				errorNotice += "Stylesheet not found: " + stylesheetFile.getAbsolutePath() + ", ";
										
			outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
			File outputFile = outputFilePath.toFile();
			if (!outputFile.canWrite())
				errorNotice += "outputFile not writable: " + outputFile.getAbsolutePath() + ", ";
			
			if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_saxon))
			{
				// reference: Saxon-HE 9.7 documentation and samples
				// S9APIExamples.jsail: private static class TransformA implements S9APIExamples.Test

				Processor           processor = new Processor(false);
				XsltCompiler     xsltCompiler = processor.newXsltCompiler();
				XsltExecutable xsltExecutable = xsltCompiler.compile (new StreamSource(stylesheetFile)); // stylesheetInputStream));
				XdmNode source = processor.newDocumentBuilder().build(new StreamSource(intermediateX3DFilePath.toFile()));
				Serializer out = processor.newSerializer(outputFile);
				out.setOutputProperty(Serializer.Property.METHOD, "html");
				out.setOutputProperty(Serializer.Property.INDENT, "yes");
				XsltTransformer xsltTransformer = xsltExecutable.load();
				xsltTransformer.setInitialContextNode(source);
				xsltTransformer.setDestination(out);
				if (parameterName1.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName1), new XdmAtomicValue(parameterValue1));
				if (parameterName2.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName2), new XdmAtomicValue(parameterValue2));
				xsltTransformer.transform();
			}
			else if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_nativeJava))
			{
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document x3dDocument = builder.parse(intermediateX3DFilePath.toFile());
				TransformerFactory tFactory = TransformerFactory.newInstance();
				StreamSource styleStreamSource = new StreamSource(stylesheetFile); // stylesheetInputStream);
				Transformer transformer = tFactory.newTransformer(styleStreamSource);
				if (parameterName1.length() > 0)
					transformer.setParameter(parameterName1, parameterValue1);
				if (parameterName2.length() > 0)
					transformer.setParameter(parameterName2, parameterValue2);

				DOMSource       domSource = new DOMSource(x3dDocument);
				StreamResult streamResult = new StreamResult(outputFile);
				transformer.transform(domSource, streamResult);
			}
			else // no joy
			{
				errorNotice = "Invalid ConfigurationProperties.getXsltEngine() value='" + ConfigurationProperties.getXsltEngine() + 
									 "', legal values are ConfigurationProperties.XSLT_ENGINE_saxon or ConfigurationProperties.XSLT_ENGINE_nativeJava";
//				validationResult.append(errorNotice).append("\n");
				throw new InvalidFieldValueException(errorNotice);
			}
			if (ConfigurationProperties.isDeleteIntermediateFiles()) // clean up when done
				intermediateX3DFilePath.toFile().deleteOnExit();
		}
		catch (IOException | ParserConfigurationException | TransformerException | SAXException exception)
		{
			throw new X3DException(errorNotice + "IOException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + exception);
		}
		catch (SaxonApiException saxonApiException)
		{
//			Logger.getLogger(X3DObject.class.getName()).log(Level.SEVERE, null, saxonApiException);
										
			throw new X3DException(errorNotice + "SaxonApiException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + saxonApiException);
		}
		return outputFilePath.toFile(); // success
	}

	// TODO refactor XSLT conversion methods to re-use common code

	/** Private method to read a file as a String
	 * @see https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
	 * @return file contents
	 */
	private String readFile(String file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader (file));
		String         line = null;
		StringBuilder  stringBuilder = new StringBuilder();
		String         ls = System.getProperty("line.separator");

		try {
			while((line = reader.readLine()) != null)
			{
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			return stringBuilder.toString();
		} 
		finally
		{
			reader.close();
		}
	}

	/**
	 * Serialize scene graph using X3dToJson.xslt stylesheet to create a new JSON-encoding string.
	 * @see X3DObject#toFileJSON(String)
	 * @see <a href="http://www.web3d.org/wiki/index.php/X3D_JSON_Encoding">X3D JSON Encoding</a>
	 * @see <a href="http://www.web3d.org/x3d/stylesheets/X3dToJson.html">X3D to JSON Stylesheet Converter</a>
	 * @return String containing result (if operation succeeds), empty otherwise
	 */
	public String toStringJSON()
	{
		String temporaryFileName = "temporaryJsonOutputFile.json";
		
		try
		{
			File     fileJSON = toFileJSON(temporaryFileName);

			if  ((fileJSON != null) && fileJSON.exists())
			{
				String fileContents = readFile(temporaryFileName);
				fileJSON.delete();
				return fileContents;
//				List<String> lines = Files.readAllLines(Paths.get(temporaryFileName));
//				return String.join("\n",lines);
			}
		}
		catch (Exception e)
		{
			// TODO consider throwing exception instead
		}
		return "";
	}

	/**
	 * Serialize scene graph using X3dToJson.xslt stylesheet to create a new JSON-encoding X3D file with extension <i>json</i>.
	 * @see X3DObject#toStringJSON()
	 * @see X3DObject#toStringX3D()
	 * @see X3DObject#toFileX3D(String)
	 * @see X3DObject#toFileJava(String)
	 * @see X3DObject#toFileDocumentationHtml(String)
	 * @see X3DObject#toFileCobweb(String,String)
	 * @see X3DObject#toFileX3DOM(String)
	 * @see X3DObject#FILE_EXTENSION_JSON
	 * @see X3DObject#FILE_EXTENSION_JAVASCRIPT
	 * @see ConfigurationProperties#STYLESHEET_JSON
	 * @see <a href="http://www.web3d.org/wiki/index.php/X3D_JSON_Encoding">X3D JSON Encoding</a>
	 * @see <a href="http://www.web3d.org/x3d/stylesheets/X3dToJson.html">X3D to JSON Stylesheet Converter</a>
	 * @see <a href="http://www.saxonica.com/documentation/index.html#!using-xsl/embedding">Saxonica &gt; Saxon &gt; Using XSLT &gt; Invoking XSLT from an application</a>
	 * @see <a href="http://saxon.sourceforge.net/#F9.7HE">Saxon-HE 9.7</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html">Java Tutorials: Transforming XML Data with XSLT</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/examples/xslt_samples.zip">Java Tutorials: Transforming XML Data with XSLT, sample files</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param fileName name of file to create and save, can include local directory path, must end with .xhtml (preferred) or .html
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileJSON(String fileName)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileJSON(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_JSON + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_JAVASCRIPT) && !fileName.endsWith(FILE_EXTENSION_JSON))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_JSON + "\" or  \"" + FILE_EXTENSION_JAVASCRIPT + "\"");
		}

		// XSLT parameter names and values
		String parameterName1  = "";
		String parameterValue1 = "";
		String parameterName2  = "";
		String parameterValue2 = "";

		Path outputFilePath = Paths.get(fileName);
		
		String intermediateX3DFileName = fileName + ".intermediate.x3d";
		Path   intermediateX3DFilePath = Paths.get(intermediateX3DFileName);
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
										
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringX3D();
		try
		{
			bufferedWriter = Files.newBufferedWriter(intermediateX3DFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException when creating intermediateX3DFileName " + intermediateX3DFileName + 
				", unable to save file: " + exception);
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		factory.setValidating    (true);

		String errorNotice = new String();
		try // https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html
		{
			File stylesheetFile = new File("../lib/stylesheets/", ConfigurationProperties.STYLESHEET_JSON);
			if (!stylesheetFile.exists())
				errorNotice += "Stylesheet not found: " + stylesheetFile.getAbsolutePath() + ", ";
										
			outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
			File outputFile = outputFilePath.toFile();
			if (!outputFile.canWrite())
				errorNotice += "outputFile not writable: " + outputFile.getAbsolutePath() + ", ";
			
			if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_saxon))
			{
				// reference: Saxon-HE 9.7 documentation and samples
				// S9APIExamples.jsail: private static class TransformA implements S9APIExamples.Test

				Processor           processor = new Processor(false);
				XsltCompiler     xsltCompiler = processor.newXsltCompiler();
				XsltExecutable xsltExecutable = xsltCompiler.compile (new StreamSource(stylesheetFile));
				XdmNode source = processor.newDocumentBuilder().build(new StreamSource(intermediateX3DFilePath.toFile()));
				Serializer out = processor.newSerializer(outputFile);
				out.setOutputProperty(Serializer.Property.METHOD, "html");
				out.setOutputProperty(Serializer.Property.INDENT, "yes");
				XsltTransformer xsltTransformer = xsltExecutable.load();
				xsltTransformer.setInitialContextNode(source);
				xsltTransformer.setDestination(out);
				if (parameterName1.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName1), new XdmAtomicValue(parameterValue1));
				if (parameterName2.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName2), new XdmAtomicValue(parameterValue2));
				xsltTransformer.transform();
			}
			else if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_nativeJava))
			{
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document x3dDocument = builder.parse(intermediateX3DFilePath.toFile());
				TransformerFactory tFactory = TransformerFactory.newInstance();
				StreamSource styleStreamSource = new StreamSource(stylesheetFile);
				Transformer transformer = tFactory.newTransformer(styleStreamSource);
				if (parameterName1.length() > 0)
					transformer.setParameter(parameterName1, parameterValue1);
				if (parameterName2.length() > 0)
					transformer.setParameter(parameterName2, parameterValue2);

				DOMSource       domSource = new DOMSource(x3dDocument);
				StreamResult streamResult = new StreamResult(outputFile);
				transformer.transform(domSource, streamResult);
			}
			else // no joy
			{
				errorNotice = "Invalid ConfigurationProperties.getXsltEngine() value='" + ConfigurationProperties.getXsltEngine() + 
									 "', legal values are ConfigurationProperties.XSLT_ENGINE_saxon or ConfigurationProperties.XSLT_ENGINE_nativeJava";
//				validationResult.append(errorNotice).append("\n");
				throw new InvalidFieldValueException(errorNotice);
			}
			if (ConfigurationProperties.isDeleteIntermediateFiles()) // clean up when done
				intermediateX3DFilePath.toFile().deleteOnExit();
		}
		catch (IOException | ParserConfigurationException | TransformerException | SAXException exception)
		{
			throw new X3DException(errorNotice + "IOException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + exception);
		}
		catch (SaxonApiException saxonApiException)
		{
//			Logger.getLogger(X3DObject.class.getName()).log(Level.SEVERE, null, saxonApiException);
										
			throw new X3DException(errorNotice + "SaxonApiException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + saxonApiException);
		}
		return outputFilePath.toFile(); // success
	}
	/**
	 * Serialize scene graph using X3dToJava.xslt stylesheet to create a new Java source file with extension <i>java</i>, no default license included.
	 * @see X3DObject#toFileJava(String,boolean)
	 * @param fileName name of file to create and save, can include local directory path, must end with .xhtml (preferred) or .html
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileJava(String fileName)
	{
		return toFileJava(fileName, false); // no license
	}
	/**
	 * Serialize scene graph using X3dToJava.xslt stylesheet to create a new Java source file with extension <i>java</i>.
	 * @see X3DObject#toStringX3D()
	 * @see X3DObject#toFileX3D(String)
	 * @see X3DObject#toFileJSON(String)
	 * @see X3DObject#toFileDocumentationHtml(String)
	 * @see X3DObject#toFileCobweb(String,String)
	 * @see X3DObject#toFileX3DOM(String)
	 * @see X3DObject#FILE_EXTENSION_JSON
	 * @see X3DObject#FILE_EXTENSION_JAVASCRIPT
	 * @see ConfigurationProperties#STYLESHEET_JSON
	 * @see <a href="http://www.web3d.org/wiki/index.php/X3D_JSON_Encoding">X3D JSON Encoding</a>
	 * @see <a href="http://www.web3d.org/x3d/stylesheets/X3dToJson.html">X3D to JSON Stylesheet Converter</a>
	 * @see <a href="http://www.saxonica.com/documentation/index.html#!using-xsl/embedding">Saxonica &gt; Saxon &gt; Using XSLT &gt; Invoking XSLT from an application</a>
	 * @see <a href="http://saxon.sourceforge.net/#F9.7HE">Saxon-HE 9.7</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html">Java Tutorials: Transforming XML Data with XSLT</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/examples/xslt_samples.zip">Java Tutorials: Transforming XML Data with XSLT, sample files</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param fileName name of file to create and save, can include local directory path, must end with .xhtml (preferred) or .html
	 * @param includeWeb3dLicense whether to insert default open-source Web3D license at top of source file
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileJava(String fileName, boolean includeWeb3dLicense)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileJava(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_JSON + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_JAVA))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_JAVA + "\"");
		}

		// XSLT parameter names and values
		String parameterName1  = "className";
		String parameterValue1 = fileName.substring(0,fileName.indexOf(".java"));
		String parameterName2  = "";
		String parameterValue2 = "";
		if (includeWeb3dLicense)
		{
			parameterName2  = "includeLicenseoriginals";
			parameterValue2 = Boolean.toString(includeWeb3dLicense);
		}

		Path outputFilePath = Paths.get(fileName);
		
		String intermediateX3DFileName = fileName + ".intermediate.x3d";
		Path   intermediateX3DFilePath = Paths.get(intermediateX3DFileName);
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
										
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringX3D();
		try
		{
			bufferedWriter = Files.newBufferedWriter(intermediateX3DFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException when creating intermediateX3DFileName " + intermediateX3DFileName + 
				", unable to save file: " + exception);
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		factory.setValidating    (true);

		String errorNotice = new String();
		try // https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html
		{
			File stylesheetFile = new File("../lib/stylesheets/", ConfigurationProperties.STYLESHEET_JAVA);
			if (!stylesheetFile.exists())
				errorNotice += "Stylesheet not found: " + stylesheetFile.getAbsolutePath() + ", ";
										
			outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
			File outputFile = outputFilePath.toFile();
			if (!outputFile.canWrite())
				errorNotice += "outputFile not writable: " + outputFile.getAbsolutePath() + ", ";
			
			if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_saxon))
			{
				// reference: Saxon-HE 9.7 documentation and samples
				// S9APIExamples.jsail: private static class TransformA implements S9APIExamples.Test

				Processor           processor = new Processor(false);
				XsltCompiler     xsltCompiler = processor.newXsltCompiler();
				XsltExecutable xsltExecutable = xsltCompiler.compile (new StreamSource(stylesheetFile));
				XdmNode source = processor.newDocumentBuilder().build(new StreamSource(intermediateX3DFilePath.toFile()));
				Serializer out = processor.newSerializer(outputFile);
				out.setOutputProperty(Serializer.Property.METHOD, "html");
				out.setOutputProperty(Serializer.Property.INDENT, "yes");
				XsltTransformer xsltTransformer = xsltExecutable.load();
				xsltTransformer.setInitialContextNode(source);
				xsltTransformer.setDestination(out);
				if (parameterName1.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName1), new XdmAtomicValue(parameterValue1));
				if (parameterName2.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName2), new XdmAtomicValue(parameterValue2));
				xsltTransformer.transform();
			}
			else if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_nativeJava))
			{
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document x3dDocument = builder.parse(intermediateX3DFilePath.toFile());
				TransformerFactory tFactory = TransformerFactory.newInstance();
				StreamSource styleStreamSource = new StreamSource(stylesheetFile);
				Transformer transformer = tFactory.newTransformer(styleStreamSource);
				if (parameterName1.length() > 0)
					transformer.setParameter(parameterName1, parameterValue1);
				if (parameterName2.length() > 0)
					transformer.setParameter(parameterName2, parameterValue2);

				DOMSource       domSource = new DOMSource(x3dDocument);
				StreamResult streamResult = new StreamResult(outputFile);
				transformer.transform(domSource, streamResult);
			}
			else // no joy
			{
				errorNotice = "Invalid ConfigurationProperties.getXsltEngine() value='" + ConfigurationProperties.getXsltEngine() + 
									 "', legal values are ConfigurationProperties.XSLT_ENGINE_saxon or ConfigurationProperties.XSLT_ENGINE_nativeJava";
//				validationResult.append(errorNotice).append("\n");
				throw new InvalidFieldValueException(errorNotice);
			}
			if (ConfigurationProperties.isDeleteIntermediateFiles()) // clean up when done
				intermediateX3DFilePath.toFile().deleteOnExit();
		}
		catch (IOException | ParserConfigurationException | TransformerException | SAXException exception)
		{
			throw new X3DException(errorNotice + "IOException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + exception);
		}
		catch (SaxonApiException saxonApiException)
		{
//			Logger.getLogger(X3DObject.class.getName()).log(Level.SEVERE, null, saxonApiException);
										
			throw new X3DException(errorNotice + "SaxonApiException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + saxonApiException);
		}
		return outputFilePath.toFile(); // success
	}
										
	/**
	 * Create displayable scene page rendered with X3DOM, using X3dToX3dom.xslt stylesheet by serializing XML syntax within an XHTML file having extension <i>.xhtml</i>.
	 * @see X3DObject#toStringX3D()
	 * @see X3DObject#toFileX3D(String)
	 * @see X3DObject#toFileJava(String)
	 * @see X3DObject#toFileJSON(String)
	 * @see X3DObject#toFileDocumentationHtml(String)
	 * @see X3DObject#toFileCobweb(String,String)
	 * @see ConfigurationProperties#STYLESHEET_X3DOM
	 * @see <a href="http://www.saxonica.com/documentation/index.html#!using-xsl/embedding">Saxonica &gt; Saxon &gt; Using XSLT &gt; Invoking XSLT from an application</a>
	 * @see <a href="http://saxon.sourceforge.net/#F9.7HE">Saxon-HE 9.7</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html">Java Tutorials: Transforming XML Data with XSLT</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/examples/xslt_samples.zip">Java Tutorials: Transforming XML Data with XSLT, sample files</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param fileName name of file to create and save, can include local directory path, must end with .xhtml (preferred) or .html
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileX3DOM(String fileName)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileX3DOM(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_HTML + "\" or  \"" + FILE_EXTENSION_XHTML + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_HTML) && !fileName.endsWith(FILE_EXTENSION_XHTML))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_HTML + "\" or  \"" + FILE_EXTENSION_XHTML + "\"");
		}
										
		// XSLT parameter names and values
		String parameterName1  = "";
		String parameterValue1 = "";
		String parameterName2  = "";
		String parameterValue2 = "";

		Path outputFilePath = Paths.get(fileName);
		
		String intermediateX3DFileName = fileName + ".intermediate.x3d";
		Path   intermediateX3DFilePath = Paths.get(intermediateX3DFileName);
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
										
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringX3D();
		try
		{
			bufferedWriter = Files.newBufferedWriter(intermediateX3DFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException when creating intermediateX3DFileName " + intermediateX3DFileName + 
				", unable to save file: " + exception);
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		factory.setValidating    (true);

		String errorNotice = new String();
		try // https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html
		{
			File stylesheetFile = new File("../lib/stylesheets/", ConfigurationProperties.STYLESHEET_X3DOM);
			if (!stylesheetFile.exists())
				errorNotice += "Stylesheet not found: " + stylesheetFile.getAbsolutePath() + ", ";
										
			outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
			File outputFile = outputFilePath.toFile();
			if (!outputFile.canWrite())
				errorNotice += "outputFile not writable: " + outputFile.getAbsolutePath() + ", ";
			
			if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_saxon))
			{
				// reference: Saxon-HE 9.7 documentation and samples
				// S9APIExamples.jsail: private static class TransformA implements S9APIExamples.Test

				Processor           processor = new Processor(false);
				XsltCompiler     xsltCompiler = processor.newXsltCompiler();
				XsltExecutable xsltExecutable = xsltCompiler.compile (new StreamSource(stylesheetFile));
				XdmNode source = processor.newDocumentBuilder().build(new StreamSource(intermediateX3DFilePath.toFile()));
				Serializer out = processor.newSerializer(outputFile);
				out.setOutputProperty(Serializer.Property.METHOD, "html");
				out.setOutputProperty(Serializer.Property.INDENT, "yes");
				XsltTransformer xsltTransformer = xsltExecutable.load();
				xsltTransformer.setInitialContextNode(source);
				xsltTransformer.setDestination(out);
				if (parameterName1.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName1), new XdmAtomicValue(parameterValue1));
				if (parameterName2.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName2), new XdmAtomicValue(parameterValue2));
				xsltTransformer.transform();
			}
			else if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_nativeJava))
			{
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document x3dDocument = builder.parse(intermediateX3DFilePath.toFile());
				TransformerFactory tFactory = TransformerFactory.newInstance();
				StreamSource styleStreamSource = new StreamSource(stylesheetFile);
				Transformer transformer = tFactory.newTransformer(styleStreamSource);
				if (parameterName1.length() > 0)
					transformer.setParameter(parameterName1, parameterValue1);
				if (parameterName2.length() > 0)
					transformer.setParameter(parameterName2, parameterValue2);

				DOMSource       domSource = new DOMSource(x3dDocument);
				StreamResult streamResult = new StreamResult(outputFile);
				transformer.transform(domSource, streamResult);
			}
			else // no joy
			{
				errorNotice = "Invalid ConfigurationProperties.getXsltEngine() value='" + ConfigurationProperties.getXsltEngine() + 
									 "', legal values are ConfigurationProperties.XSLT_ENGINE_saxon or ConfigurationProperties.XSLT_ENGINE_nativeJava";
//				validationResult.append(errorNotice).append("\n");
				throw new InvalidFieldValueException(errorNotice);
			}
			if (ConfigurationProperties.isDeleteIntermediateFiles()) // clean up when done
				intermediateX3DFilePath.toFile().deleteOnExit();
		}
		catch (IOException | ParserConfigurationException | TransformerException | SAXException exception)
		{
			throw new X3DException(errorNotice + "IOException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + exception);
		}
		catch (SaxonApiException saxonApiException)
		{
//			Logger.getLogger(X3DObject.class.getName()).log(Level.SEVERE, null, saxonApiException);
										
			throw new X3DException(errorNotice + "SaxonApiException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + saxonApiException);
		}
		return outputFilePath.toFile(); // success
	}
										
	/**
	 * Create displayable scene page rendered with Cobweb, using X3dToX3dom.xslt stylesheet and special settings, by serializing XML syntax within an XHTML file having extension <i>.xhtml</i>.
	 * @see X3DObject#toStringX3D()
	 * @see X3DObject#toFileX3D(String)
	 * @see X3DObject#toFileJava(String)
	 * @see X3DObject#toFileJSON(String)
	 * @see X3DObject#toFileDocumentationHtml(String)
	 * @see X3DObject#toFileX3DOM(String)
	 * @see ConfigurationProperties#STYLESHEET_X3DOM
	 * @see <a href="http://www.saxonica.com/documentation/index.html#!using-xsl/embedding">Saxonica &gt; Saxon &gt; Using XSLT &gt; Invoking XSLT from an application</a>
	 * @see <a href="http://saxon.sourceforge.net/#F9.7HE">Saxon-HE 9.7</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html">Java Tutorials: Transforming XML Data with XSLT</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/jaxp/examples/xslt_samples.zip">Java Tutorials: Transforming XML Data with XSLT, sample files</a>
	 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles">Buffered I/O Methods for Text Files</a>
	 * @param sourceSceneName X3D file to load and view
	 * @param fileName name of file to create and save, can include local directory path, must end with .html (preferred) or .xhtml
	 * @return File containing result (if operation succeeds), null otherwise
	 */
	public File toFileCobweb(String sourceSceneName, String fileName)
	{
		if ((fileName == null || fileName.isEmpty()))
		{
			throw new X3DException("toFileCobweb(fileName) fileName not provided;" +
				" be sure to end with extension \"" + FILE_EXTENSION_HTML + "\" or  \"" + FILE_EXTENSION_XHTML + "\"");
		}
		if (!fileName.endsWith(FILE_EXTENSION_HTML) && !fileName.endsWith(FILE_EXTENSION_XHTML))
		{
			throw new X3DException("fileName " + fileName + " does not end with extension \"" + FILE_EXTENSION_HTML + "\" or  \"" + FILE_EXTENSION_XHTML + "\"");
		}
										
		// XSLT parameter names and values
		String parameterName1  = "";
		String parameterValue1 = "";
		String parameterName2  = "";
		String parameterValue2 = "";
										
		parameterName1  = "player";
		parameterValue1 = "Cobweb";
		parameterName2  = "urlScene";
		parameterValue2 = sourceSceneName;

		Path outputFilePath = Paths.get(fileName);
		
		String intermediateX3DFileName = fileName + ".intermediate.x3d";
		Path   intermediateX3DFilePath = Paths.get(intermediateX3DFileName);
		
		// http://docs.oracle.com/javase/8/docs/technotes/guides/intl/encoding.doc.html
		// http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
		Charset charset = Charset.forName(ConfigurationProperties.XML_ENCODING_DECLARATION_DEFAULT); // "UTF-8"
										
		try
		{	
			validate(); // strict checks before serializing scene and saving file
		}
		catch (Exception e)
		{
			System.out.println (e); // output exception but allow serialization to continue, file may be editable
			e.printStackTrace();
			if (ConfigurationProperties.isValidationExceptionAllowed())
				 System.out.println ("Output serialization allowed to continue, file may be editable...");
			else throw (e);
		}

		String outputSceneText = toStringX3D();
		try
		{
			bufferedWriter = Files.newBufferedWriter(intermediateX3DFilePath, charset);
			bufferedWriter.write(outputSceneText, 0, outputSceneText.length());
			bufferedWriter.close(); // ensure file writing is complete
		}
		catch (IOException exception)
		{
			throw new X3DException("IOException when creating intermediateX3DFileName " + intermediateX3DFileName + 
				", unable to save file: " + exception);
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setNamespaceAware(true);
//		factory.setValidating    (true);

		String errorNotice = new String();
		try // https://docs.oracle.com/javase/tutorial/jaxp/xslt/transformingXML.html
		{
			File stylesheetFile = new File("../lib/stylesheets/", ConfigurationProperties.STYLESHEET_X3DOM);
			if (!stylesheetFile.exists())
				errorNotice += "Stylesheet not found: " + stylesheetFile.getAbsolutePath() + ", ";
										
			outputFilePath.toAbsolutePath(); // debug check, defaults to local directory
			File outputFile = outputFilePath.toFile();
			if (!outputFile.canWrite())
				errorNotice += "outputFile not writable: " + outputFile.getAbsolutePath() + ", ";
			
			if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_saxon))
			{
				// reference: Saxon-HE 9.7 documentation and samples
				// S9APIExamples.jsail: private static class TransformA implements S9APIExamples.Test

				Processor           processor = new Processor(false);
				XsltCompiler     xsltCompiler = processor.newXsltCompiler();
				XsltExecutable xsltExecutable = xsltCompiler.compile (new StreamSource(stylesheetFile));
				XdmNode source = processor.newDocumentBuilder().build(new StreamSource(intermediateX3DFilePath.toFile()));
				Serializer out = processor.newSerializer(outputFile);
				out.setOutputProperty(Serializer.Property.METHOD, "html");
				out.setOutputProperty(Serializer.Property.INDENT, "yes");
				XsltTransformer xsltTransformer = xsltExecutable.load();
				xsltTransformer.setInitialContextNode(source);
				xsltTransformer.setDestination(out);
				if (parameterName1.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName1), new XdmAtomicValue(parameterValue1));
				if (parameterName2.length() > 0)
					xsltTransformer.setParameter(new QName(parameterName2), new XdmAtomicValue(parameterValue2));
				xsltTransformer.transform();
			}
			else if (ConfigurationProperties.getXsltEngine().equals(ConfigurationProperties.XSLT_ENGINE_nativeJava))
			{
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document x3dDocument = builder.parse(intermediateX3DFilePath.toFile());
				TransformerFactory tFactory = TransformerFactory.newInstance();
				StreamSource styleStreamSource = new StreamSource(stylesheetFile);
				Transformer transformer = tFactory.newTransformer(styleStreamSource);
				if (parameterName1.length() > 0)
					transformer.setParameter(parameterName1, parameterValue1);
				if (parameterName2.length() > 0)
					transformer.setParameter(parameterName2, parameterValue2);

				DOMSource       domSource = new DOMSource(x3dDocument);
				StreamResult streamResult = new StreamResult(outputFile);
				transformer.transform(domSource, streamResult);
			}
			else // no joy
			{
				errorNotice = "Invalid ConfigurationProperties.getXsltEngine() value='" + ConfigurationProperties.getXsltEngine() + 
									 "', legal values are ConfigurationProperties.XSLT_ENGINE_saxon or ConfigurationProperties.XSLT_ENGINE_nativeJava";
//				validationResult.append(errorNotice).append("\n");
				throw new InvalidFieldValueException(errorNotice);
			}
			if (ConfigurationProperties.isDeleteIntermediateFiles()) // clean up when done
				intermediateX3DFilePath.toFile().deleteOnExit();
		}
		catch (IOException | ParserConfigurationException | TransformerException | SAXException exception)
		{
			throw new X3DException(errorNotice + "IOException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + exception);
		}
		catch (SaxonApiException saxonApiException)
		{
//			Logger.getLogger(X3DObject.class.getName()).log(Level.SEVERE, null, saxonApiException);
										
			throw new X3DException(errorNotice + "SaxonApiException when transforming and creating fileName " + outputFilePath + 
				", unable to save result: " + saxonApiException);
		}
		return outputFilePath.toFile(); // success
	}
										
  /** Provide thorough X3DJSAIL validation results for this X3D model.
   * @return "success" or validation results plus exception information (if any)
   */
  public String validationReport()
  {
	String       metaResult = new String();
	String validationResult = new String();
	String  exceptionResult = new String();
	try
	{
		initialize();
										
		if (getHead() != null)
		{
			// first list informational meta elements of interest
			for (metaObject meta : getHead().getMetaList())
			{
				if (meta.getName().equals(metaObject.NAME_ERROR) ||
					meta.getName().equals(metaObject.NAME_WARNING) ||
					meta.getName().equals(metaObject.NAME_HINT) ||
					meta.getName().equals(metaObject.NAME_INFO) ||
					meta.getName().equals(metaObject.NAME_TODO))
				{
					metaResult += meta.toStringX3D();
				}
			}
		}
		validationResult += validate(); // walk entire tree to validate correctness
	}
	catch (Exception e)
	{
		exceptionResult = e.getMessage(); // report exception failures, if any
	    if (exceptionResult == null)
	    {
			exceptionResult = "Exception caught but null message!";
			e.printStackTrace();
	    }
	}
	if  (metaResult.isEmpty() && exceptionResult.isEmpty() && validationResult.isEmpty())
	     return "success";
	else
	{
		if (!metaResult.isEmpty())
			metaResult = "\n" + metaResult; // easier to read
		String returnMessage = metaResult;
		if  (!exceptionResult.isEmpty() && !validationResult.isEmpty())
			returnMessage += "\n*** ";
		returnMessage += exceptionResult;
		if  (exceptionResult.isEmpty() && !validationResult.isEmpty())
			returnMessage = "\n" + returnMessage; // skip line before meta tags, etc.
		returnMessage += validationResult;
		return returnMessage;
	}
  }
										
	/** Utility method for standalone programs that get created with X3dToJava.xslt stylesheet.
	 * Invocation switches: -help -validate -x3d -x3dv -vrml -json -html -x3dom -cobweb [filename]
	 * @param argv command-line arguments
	 * @return result
	 */
	public String handleArguments(String[] argv)
	{
		String helpString = "Invocation switches: [-help -validate] [-x3d -x3dv -vrml -json -html -x3dom -cobweb [filename]]";
		String fileName = new String();
		File   newFile;
										
		if (argv.length == 2)
			fileName = argv[1];
		if ((argv.length == 0) || argv[0].toLowerCase().contains("help"))
        {
			return helpString;
		}
		else if (argv[0].toLowerCase().startsWith("valid"))
		{
			return validationReport();
		}
		else if (argv[0].toLowerCase().startsWith("x3dv") && !fileName.isEmpty())
		{
			newFile = toFileClassicVRML(fileName);
			if  (newFile != null)
				 return newFile.getAbsolutePath();
			else return "file not saved";
		}
		else if (argv[0].toLowerCase().startsWith("x3dv"))
		{
			return toStringClassicVRML();
		}
		else if (argv[0].toLowerCase().startsWith("x3dom") && !fileName.isEmpty())
		{
			newFile = toFileX3DOM(fileName);
			if  (newFile != null)
				 return newFile.getAbsolutePath();
			else return "file not saved";
		}
		else if (argv[0].toLowerCase().startsWith("x3d") && !fileName.isEmpty())
		{
			newFile = toFileX3D(fileName);
			if  (newFile != null)
				 return newFile.getAbsolutePath();
			else return "file not saved";
		}
		else if (argv[0].toLowerCase().startsWith("x3d"))
		{
			return toStringX3D();
		}
		else if (argv[0].toLowerCase().startsWith("vrml") && !fileName.isEmpty())
		{
			newFile = toFileVRML97(fileName);
			if  (newFile != null)
				 return newFile.getAbsolutePath();
			else return "file not saved";
		}
		else if (argv[0].toLowerCase().startsWith("vrml"))
		{
			return toStringVRML97();
		}
		else if (argv[0].toLowerCase().startsWith("json") && !fileName.isEmpty())
		{
			newFile = toFileJSON(fileName);
			if  (newFile != null)
				 return newFile.getAbsolutePath();
			else return "file not saved";
		}
		else if (argv[0].toLowerCase().startsWith("json"))
		{
			return toStringJSON();
		}
		else if (argv[0].toLowerCase().startsWith("html") && !fileName.isEmpty())
		{
			newFile = toFileDocumentationHtml(fileName);
			if  (newFile != null)
				 return newFile.getAbsolutePath();
			else return "file not saved";
		}
		else if (argv[0].toLowerCase().startsWith("html"))
		{
			return "TODO (not supported)";
		}
		else if (argv[0].toLowerCase().startsWith("cobweb") && !fileName.isEmpty())
		{
			newFile = toFileCobweb(fileName + ".x3d", fileName + ".html"); // TODO fix
			if  (newFile != null)
				 return newFile.getAbsolutePath();
			else return "file not saved";
		}
		else // no valid switch found
		{
			return helpString;
		}
	}

	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide headObject instance (using a properly typed node) from inputOutput SFNode field <i>head</i>.
	 * @return value of head field
	 */
	public headObject getHead()
	{
		return head;
	}

	/**
	 * Assign headObject instance (using a properly typed node) to inputOutput SFNode field <i>head</i>.
	 * @param newValue is new value for the head field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DObject setHead(headObject newValue)
	{
		head = newValue;
		if (newValue != null)
		{
			((X3DConcreteElement) head).setParentObject(this); // parentTest15
		}
		return this;
	}

	/**
	 * Utility method to clear SFNode value of head field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public X3DObject clearHead()
	{
		((X3DConcreteElement) head).clearParentObject(); // remove references to facilitate Java memory management
		head = null; // reset SFNode field
		return this;
	}

	/**
	 * Indicate whether an object is available for inputOutput SFNode field <i>head</i>.
	 * @return whether a concrete statement or CommentsBlock is available.
	 * @see #getHead()
	 */
	public boolean hasHead()
	{
		return (head != null);
	}
	/**
	 * Provide String enumeration value ['Core'|'Interchange'|'CADInterchange'|'Interactive'|'Immersive'|'MedicalInterchange'|'MPEG4Interactive'|'Full'] from inputOutput SFString field named <i>profile</i>.
	 * <br><br>
	 * <i>Tooltip:</i> profile is required and defines the player or tool support needed for this scene. Hint: Core profile corresponds to empty profile, used for defining capabilities via components only. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/coreprofile.html Hint: Interchange profile corresponds to minimum subset of nodes needed to display lightweight compelling content. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/interchange.html Hint: Interactive profile corresponds to Interchange geometry plus simple user interaction. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/interactive.html Hint: Immersive profile is common and approximately matches VRML97 with Script and Prototypes. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/immersive.html Hint: CADInterchange profile corresponds to Interchange geometry plus distillation of computer-aided design (CAD) models. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/CADInterchange.html Hint: MedicalInterchange profile (X3D version 3.3 or later) adds support for VolumeRendering component to Interchange profile. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/MedInterchange.html Hint: Full profile contains all nodes defined in X3D specification. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/fullProfile.html.
	 * <br><br>
	 * Available enumeration values for string comparison: {@link #PROFILE_CORE CORE}, {@link #PROFILE_INTERCHANGE INTERCHANGE}, {@link #PROFILE_CADINTERCHANGE CADINTERCHANGE}, {@link #PROFILE_INTERACTIVE INTERACTIVE}, {@link #PROFILE_IMMERSIVE IMMERSIVE}, {@link #PROFILE_MEDICALINTERCHANGE MEDICALINTERCHANGE}, {@link #PROFILE_MPEG4INTERACTIVE MPEG4INTERACTIVE}, {@link #PROFILE_FULL FULL}.
	 * @return value of profile field
	 */
	public String getProfile()
	{
		return profile;
	}

	/**
	 * Assign String enumeration value ("Core"|"Interchange"|"CADInterchange"|"Interactive"|"Immersive"|"MedicalInterchange"|"MPEG4Interactive"|"Full") ['Core'|'Interchange'|'CADInterchange'|'Interactive'|'Immersive'|'MedicalInterchange'|'MPEG4Interactive'|'Full'] to inputOutput SFString field named <i>profile</i>.
	 * <br><br>
	 * <i>WARNING:</i> authors can only choose from a strict list of enumeration values ({@link #PROFILE_CORE CORE}, {@link #PROFILE_INTERCHANGE INTERCHANGE}, {@link #PROFILE_CADINTERCHANGE CADINTERCHANGE}, {@link #PROFILE_INTERACTIVE INTERACTIVE}, {@link #PROFILE_IMMERSIVE IMMERSIVE}, {@link #PROFILE_MEDICALINTERCHANGE MEDICALINTERCHANGE}, {@link #PROFILE_MPEG4INTERACTIVE MPEG4INTERACTIVE}, {@link #PROFILE_FULL FULL}).
	 * <br><br>
	 * <i>Tooltip:</i> profile is required and defines the player or tool support needed for this scene. Hint: Core profile corresponds to empty profile, used for defining capabilities via components only. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/coreprofile.html Hint: Interchange profile corresponds to minimum subset of nodes needed to display lightweight compelling content. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/interchange.html Hint: Interactive profile corresponds to Interchange geometry plus simple user interaction. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/interactive.html Hint: Immersive profile is common and approximately matches VRML97 with Script and Prototypes. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/immersive.html Hint: CADInterchange profile corresponds to Interchange geometry plus distillation of computer-aided design (CAD) models. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/CADInterchange.html Hint: MedicalInterchange profile (X3D version 3.3 or later) adds support for VolumeRendering component to Interchange profile. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/MedInterchange.html Hint: Full profile contains all nodes defined in X3D specification. http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/fullProfile.html.
	 * @param newValue is new value for the profile field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DObject setProfile(String newValue)
	{
		if (newValue == null)
			newValue = new String(); // null string check
		else newValue = MFStringObject.cleanupUnescapedEnclosingQuotes(newValue); // enumeration value
		// Check that newValue parameter has one of the allowed legal values before assigning to scene graph
		if (!(
			newValue.isEmpty() ||
			newValue.equals(PROFILE_CORE) ||
			newValue.equals(PROFILE_INTERCHANGE) ||
			newValue.equals(PROFILE_CADINTERCHANGE) ||
			newValue.equals(PROFILE_INTERACTIVE) ||
			newValue.equals(PROFILE_IMMERSIVE) ||
			newValue.equals(PROFILE_MEDICALINTERCHANGE) ||
			newValue.equals(PROFILE_MPEG4INTERACTIVE) ||
			newValue.equals(PROFILE_FULL))) {
			throw new org.web3d.x3d.sai.InvalidFieldValueException("X3D profile newValue=\"" + newValue + "\" has illegal value, must use a valid enumeration string.");
		}
		if (newValue == null) 
			newValue = new String(); // Principle of Least Astonishment (POLA)
			// https://en.wikipedia.org/wiki/Principle_of_least_astonishment
		profile = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFString profile field, similar to {@link #setProfile(String)}.
	 * @param newValue is new value for the profile field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DObject setProfile(SFStringObject newValue)
	{
		setProfile(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide SceneObject instance (using a properly typed node) from inputOutput SFNode field <i>Scene</i>.
	 * @return value of Scene field
	 */
	public SceneObject getScene()
	{
		return Scene;
	}

	/**
	 * Assign SceneObject instance (using a properly typed node) to inputOutput SFNode field <i>Scene</i>.
	 * @param newValue is new value for the Scene field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DObject setScene(SceneObject newValue)
	{
		Scene = newValue;
		if (newValue != null)
		{
			((X3DConcreteElement) Scene).setParentObject(this); // parentTest15
		}
		return this;
	}

	/**
	 * Utility method to clear SFNode value of Scene field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public X3DObject clearScene()
	{
		((X3DConcreteElement) Scene).clearParentObject(); // remove references to facilitate Java memory management
		Scene = null; // reset SFNode field
		return this;
	}

	/**
	 * Indicate whether an object is available for inputOutput SFNode field <i>Scene</i>.
	 * @return whether a concrete statement or CommentsBlock is available.
	 * @see #getScene()
	 */
	public boolean hasScene()
	{
		return (Scene != null);
	}
	/**
	 * Provide String enumeration value ['3.0'|'3.1'|'3.2'|'3.3'] from inputOutput SFString field named <i>version</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Default is highest value matching schema and DOCTYPE in the scene. X3D version 3.0 standardization occurred in 2004, version 3.1 standardization occurred in 2006, version 3.2 standardization occurred in 2008, version 3.3 standardization occurred in 2012. Warning: X3D version 4.0 is experimental and under development, focused on HTML5/DOM interoperability. Warning: X3D version 4.1 is experimental and under development, focused on Mixed and Augmented Reality (MAR). Hint: X3D version 4 overview at http://www.web3d.org/x3d4 Hint: X3D version 4 candidate changes at http://www.web3d.org/wiki/index.php/X3D_version_4.0_Development.
	 * <br><br>
	 * Available enumeration values for string comparison: {@link #VERSION_3_0 3_0}, {@link #VERSION_3_1 3_1}, {@link #VERSION_3_2 3_2}, {@link #VERSION_3_3 3_3}.
	 * @return value of version field
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * Assign String enumeration value ("3.0"|"3.1"|"3.2"|"3.3") ['3.0'|'3.1'|'3.2'|'3.3'] to inputOutput SFString field named <i>version</i>.
	 * <br><br>
	 * <i>WARNING:</i> authors can only choose from a strict list of enumeration values ({@link #VERSION_3_0 3_0}, {@link #VERSION_3_1 3_1}, {@link #VERSION_3_2 3_2}, {@link #VERSION_3_3 3_3}).
	 * <br><br>
	 * <i>Tooltip:</i> Default is highest value matching schema and DOCTYPE in the scene. X3D version 3.0 standardization occurred in 2004, version 3.1 standardization occurred in 2006, version 3.2 standardization occurred in 2008, version 3.3 standardization occurred in 2012. Warning: X3D version 4.0 is experimental and under development, focused on HTML5/DOM interoperability. Warning: X3D version 4.1 is experimental and under development, focused on Mixed and Augmented Reality (MAR). Hint: X3D version 4 overview at http://www.web3d.org/x3d4 Hint: X3D version 4 candidate changes at http://www.web3d.org/wiki/index.php/X3D_version_4.0_Development.
	 * @param newValue is new value for the version field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DObject setVersion(String newValue)
	{
		if (newValue == null)
			newValue = new String(); // null string check
		else newValue = MFStringObject.cleanupUnescapedEnclosingQuotes(newValue); // enumeration value
		// Check that newValue parameter has one of the allowed legal values before assigning to scene graph
		if (!(
			newValue.isEmpty() ||
			newValue.equals(VERSION_3_0) ||
			newValue.equals(VERSION_3_1) ||
			newValue.equals(VERSION_3_2) ||
			newValue.equals(VERSION_3_3))) {
			throw new org.web3d.x3d.sai.InvalidFieldValueException("X3D version newValue=\"" + newValue + "\" has illegal value, must use a valid enumeration string.");
		}
		if (newValue == null) 
			newValue = new String(); // Principle of Least Astonishment (POLA)
			// https://en.wikipedia.org/wiki/Principle_of_least_astonishment
		version = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFString version field, similar to {@link #setVersion(String)}.
	 * @param newValue is new value for the version field.
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DObject setVersion(SFStringObject newValue)
	{
		setVersion(newValue.getPrimitiveValue());
		return this;
	}

	// Additional utility methods for this class ==============================

	/**
	 * Add comment as String to contained commentsList.
	 * @param newComment initial value
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public X3DObject addComments (String newComment)
	{
		commentsList.add(newComment);
		return this;
	}
	/**
	 * Add comments as String[] array to contained commentsList.
	 * @param newComments array of comments
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public X3DObject addComments (String[] newComments)
	{
		commentsList.addAll(Arrays.asList(newComments));
		return this;
	}
	/**
	 * Add CommentsBlock to contained commentsList.
	 * @param newCommentsBlock block of comments to add
	 * @return {@link X3DObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public X3DObject addComments (CommentsBlock newCommentsBlock)
	{
		commentsList.addAll(newCommentsBlock.toStringList());
		return this;
	}
		
	/**
	 * Recursive method to provide X3D string serialization of this model subgraph.
	 * @param level number of levels of indentation for this element
	 * @return X3D string
	 */
	@Override
	public String toStringX3D(int level)
	{
		boolean hasAttributes = true; // TODO check for non-default attribute values
		boolean      hasChild = (head != null) || (Scene != null) || !commentsList.isEmpty();

		StringBuilder indent = new StringBuilder();
		int  indentIncrement = ConfigurationProperties.getIndentIncrement();
		char indentCharacter = ConfigurationProperties.getIndentCharacter();
		for (int i = 0; i < (level * indentIncrement); i++)
			indent.append(indentCharacter); // level of indentation for this level

		StringBuilder stringX3D = new StringBuilder();

		stringX3D.append(XML_HEADER).append("\n");
		switch (version)
		{
			case "3.0":
				stringX3D.append(DOCTYPE_3_0).append("\n");
				break;
			case "3.1":
				stringX3D.append(DOCTYPE_3_1).append("\n");
				break;
			case "3.2":
				stringX3D.append(DOCTYPE_3_2).append("\n");
				break;
			case "3.3":
				stringX3D.append(DOCTYPE_3_3).append("\n");
				break;
			case "4.0":
				stringX3D.append(DOCTYPE_4_0).append("\n");
				break;
			case "4.1":
				stringX3D.append(DOCTYPE_4_1).append("\n");
				break;
			default:
				stringX3D.append("<!-- unknown DOCTYPE for X3D version ").append(version).append(" -->").append("\n");
		}
		stringX3D.append(indent).append("<X3D"); // start opening tag
		if (hasAttributes)
		{
			if ((true) /* required attribute */ )
			{
				stringX3D.append(" profile='").append(new SFStringObject(getProfile()).toStringX3D()).append("'");
			}
			if ((true) /* required attribute */ )
			{
				stringX3D.append(" version='").append(new SFStringObject(getVersion()).toStringX3D()).append("'");
			}
				switch (version)
				{
					case "3.0":
						stringX3D.append(" ").append(SCHEMA_3_0_ATTRIBUTES);
						break;
					case "3.1":
						stringX3D.append(" ").append(SCHEMA_3_1_ATTRIBUTES);
						break;
					case "3.2":
						stringX3D.append(" ").append(SCHEMA_3_2_ATTRIBUTES);
						break;
					case "3.3":
						stringX3D.append(" ").append(SCHEMA_3_3_ATTRIBUTES);
						break;
					case "4.0":
						stringX3D.append(" ").append(SCHEMA_4_0_ATTRIBUTES);
						break;
					case "4.1":
						stringX3D.append(" ").append(SCHEMA_4_1_ATTRIBUTES);
						break;
					default:
						stringX3D.append(" ").append(SCHEMA_3_3_ATTRIBUTES); // TODO error condition
						break;
				}
		}
		if ((hasChild)) // has contained node(s), comment(s), IS/connect and/or source code
		{
			stringX3D.append(">").append("\n"); // finish opening tag


			// recursively iterate over child elements
			if      (head != null)
			{
				stringX3D.append(((X3DConcreteElement)head).toStringX3D(level + indentIncrement));
			}
			if      (Scene != null)
			{
				stringX3D.append(((X3DConcreteElement)Scene).toStringX3D(level + indentIncrement));
			}
			if (!commentsList.isEmpty())
			{
				CommentsBlock commentsBlock = new CommentsBlock(commentsList);
				stringX3D.append(commentsBlock.toStringX3D(level + indentIncrement));
			}
			stringX3D.append(indent).append("</X3D>").append("\n"); // finish closing tag
		}
		else
		{
			stringX3D.append("/>").append("\n"); // otherwise finish singleton tag
		}
		return stringX3D.toString();
	}

	/**
	 * Recursive method to provide ClassicVRML string serialization.
	 * @param level number of levels of indentation for this element
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html#VRML">X3D Resources: Virtual Reality Modeling Language (VRML) 97</a>
	 * @see <a href="http://www.web3d.org/documents/specifications/19776-2/V3.3/Part02/grammar.html">Extensible 3D (X3D) encodings Part 2: Classic VRML encoding, Annex A: Grammar</a>
	 * @return ClassicVRML string
	 */
	@Override
	public String toStringClassicVRML(int level)
	{
		StringBuilder stringClassicVRML = new StringBuilder();
		boolean hasAttributes = true; // TODO further refinement
		boolean      hasChild = (head != null) || (Scene != null) || !commentsList.isEmpty();
		stringClassicVRML.append("#X3D V").append(version).append(" utf8").append("\n");
		stringClassicVRML.append("PROFILE").append(" ").append(profile).append("\n");
			if (hasAttributes)
			{

				if (false) // attribute handled separately
				{
					stringClassicVRML.append("profile ").append("\"").append(SFStringObject.toString(getProfile())).append("\"").append("\n");
				}
				if (false) // attribute handled separately
				{
					stringClassicVRML.append("version ").append("\"").append(SFStringObject.toString(getVersion())).append("\"").append("\n");
				}
			}
		if (hasChild) // has contained node(s), comment(s), IS/connect and/or source code
		{
			// recursively iterate over child elements
			if (head != null)
			{
				stringClassicVRML.append(((X3DConcreteElement) head).toStringClassicVRML(level)); // end X3D statement
			}
			if (Scene != null)
			{
				stringClassicVRML.append(((X3DConcreteElement) Scene).toStringClassicVRML(level)); // end X3D statement
			}
			if (!commentsList.isEmpty())
			{
				CommentsBlock commentsBlock = new CommentsBlock(commentsList);
				stringClassicVRML.append(commentsBlock.toStringClassicVRML(level));
			}
		}
		return stringClassicVRML.toString();
	}

	/**
	 * Recursive method to provide VRML97 string serialization.
	 * @param level number of levels of indentation for this element
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html#VRML">X3D Resources: Virtual Reality Modeling Language (VRML) 97</a>
	 * @see <a href="http://www.web3d.org/documents/specifications/14772/V2.0/index.html">Virtual Reality Modeling Language (VRML) 97 specification</a>
	 * @see <a href="http://www.web3d.org/documents/specifications/14772-1/V2.1/index.html">VRML 97 v2.1 Amendment</a>
	 * @return VRML97 string
	 */
	@Override
	public String toStringVRML97(int level)
	{
		return toStringClassicVRML(level)
		.replace("#X3D V3.3 utf8","#VRML V2.0 utf8")
		.replace("#X3D V3.2 utf8","#VRML V2.0 utf8")
		.replace("#X3D V3.1 utf8","#VRML V2.0 utf8")
		.replace("#X3D V3.0 utf8","#VRML V2.0 utf8")
		.replaceAll("PROFILE ","#PROFILE ")
		.replaceAll("COMPONENT ","#COMPONENT ")
		.replaceAll("META ","#META ")
		.replaceAll("UNIT ","#UNIT "); // hide unavailable X3D features
	}

	/**
	 * Recursive method to provide object reference to node or statement by name attribute, if found as part of this element or in a contained element.
	 * Elements with name fields include meta, Metadata* nodes, field/fieldValue, ProtoDeclare/ExternProtoDeclare/ProtoInstance, HAnim nodes.
	 * <br ><br >
	 * <i>WARNING:</i> more than one element may be found that has the same name, this method does not handle that case.
	 * @param nameValue is value of the name field being searched for in this element and child elements(if any)
	 * @return object reference to found element, null otherwise
	 * @see #findNodeByDEF(String)
	 */
	@Override
	public X3DConcreteElement findElementByNameValue(String nameValue)
	{
		return findElementByNameValue(nameValue, ""); // empty string is wildcard, any element match is allowed
	}
								
	/**
	 * Recursive method to provide object reference to node or statement by name attribute, if found as part of this element or in a contained element.
	 * Elements with name fields include meta, Metadata* nodes, field/fieldValue, ProtoDeclare/ExternProtoDeclare/ProtoInstance, HAnim nodes.
	 * <br ><br >
	 * <i>WARNING:</i> more than one element may be found that has the same name, this method does not handle that case.
	 * @param nameValue is value of the name field being searched for in this element and child elements(if any)
	 * @param elementName identifies the element of interest (meta MetadataString ProtoDeclare CADassembly ProtoInstance HAnimHumanoid etc.)
	 * @return object reference to found element, null otherwise
	 * @see #findNodeByDEF(String)
	 */
	@Override
	public X3DConcreteElement findElementByNameValue(String nameValue, String elementName)
	{
		if ((nameValue == null) || nameValue.isEmpty())
		{
			String errorNotice = "findElementByNameValue(\"\", " + elementName + ") cannot use empty string to find a name attribute";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
		// no name field available for this element
		X3DConcreteElement referenceElement;
		if (head != null)
		{
			referenceElement = ((X3DConcreteElement) head).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (Scene != null)
		{
			referenceElement = ((X3DConcreteElement) Scene).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		return null; // not found
	}
	/**
	 * Recursive method to determine whether node or statement with given name attribute is found, meaning both objects are attached to same scene graph.
	 * @param nameValue is value of the name field being searched for in this element and child elements(if any)
	 * @param elementName identifies the element of interest (meta MetadataString ProtoDeclare CADassembly ProtoInstance HAnimHumanoid etc.)
	 * @see #findElementByNameValue(String, String)
	 * @return whether node is found
	 */
	public boolean hasElementByNameValue(String nameValue, String elementName)
	{
		return (findElementByNameValue(nameValue, elementName) != null);
	}

	/**
	 * Recursive method to provide object reference to node by DEF, if found as this node or in a contained node.
	 * <br ><br >
	 * <i>WARNING:</i> more than one element may be found that has the same DEF, this method does not handle that case.
	 * @param DEFvalue is value of the name field being searched for in this element and child elements(if any)
	 * @return object reference to found node, null otherwise
	 * @see #findElementByNameValue(String)
	 */
	@Override
	public X3DConcreteNode findNodeByDEF(String DEFvalue)
	{
		if ((DEFvalue == null) || DEFvalue.isEmpty())
		{
			String errorNotice = "findNodeByDEF(\"\") cannot use empty string to find a name";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
		X3DConcreteNode referenceNode;
		if (head != null)
		{
			referenceNode = ((X3DConcreteElement) head).findNodeByDEF(DEFvalue);
			if (referenceNode != null)
				return referenceNode;
		}
		if (Scene != null)
		{
			referenceNode = ((X3DConcreteElement) Scene).findNodeByDEF(DEFvalue);
			if (referenceNode != null)
				return referenceNode;
		}
		return null; // not found
	}
	/**
	 * Recursive method to determine whether node with DEFvalue is found, meaning both objects are attached to same scene graph.
	 * @param DEFvalue is value of the name field being searched for in this element and child elements(if any)
	 * @see #findNodeByDEF(String)
	 * @return whether node is found
	 */
	public boolean hasNodeByDEF(String DEFvalue)
	{
		return (findNodeByDEF(DEFvalue) != null);
	}

		
	/**
	 * Recursive method to validate this element plus all contained nodes and statements.
	 * @return validation results (if any)
	 */
	@Override
	public String validate()
	{
		validationResult = new StringBuilder(); // prepare for updated results

		if (getProfile().isEmpty()) // required attribute
		{
			String errorNotice = ConfigurationProperties.ERROR_VALUE_NOT_FOUND + 
									", " + NAME + " profile field is required but no value found. ";
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldValueException(errorNotice); // report error
		}
		// TODO duplicate name checks in setValue() method
		setProfile(getProfile()); // exercise field checks, simple types

		if (getVersion().isEmpty()) // required attribute
		{
			String errorNotice = ConfigurationProperties.ERROR_VALUE_NOT_FOUND + 
									", " + NAME + " version field is required but no value found. ";
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldValueException(errorNotice); // report error
		}
		// TODO duplicate name checks in setValue() method
		setVersion(getVersion()); // exercise field checks, simple types

		if (head != null)
		{
			setHead(getHead());
			((X3DConcreteElement) head).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) head).getValidationResult());
		}
		if (Scene != null)
		{
			setScene(getScene());
			((X3DConcreteElement) Scene).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) Scene).getValidationResult());
		}
		return validationResult.toString();
	}
}
