//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg7._2008;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import tva.metadata._2011.ExplanationType;
import tva.metadata._2011.KeywordType;
import tva.metadata._2011.OrganizationNameType;
import tva.metadata._2011.ServiceInformationNameType;
import tva.metadata._2011.SynopsisType;
import tva.metadata._2011.TermNameType;


/**
 * <p>Java class for TextualType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TextualType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:tva:mpeg7:2008>TextualBaseType">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextualType")
@XmlSeeAlso({
    tva.mpeg7._2008.TermDefinitionBaseType.Name.class,
    tva.mpeg7._2008.PersonGroupType.Name.class,
    tva.mpeg7._2008.CreationPreferencesType.Keyword.class,
    tva.mpeg7._2008.SourcePreferencesType.DisseminationSource.class,
    tva.mpeg7._2008.ClassificationPreferencesType.Subject.class,
    tva.mpeg7._2008.OrganizationType.Name.class,
    tva.mpeg7._2008.SummaryPreferencesType.SummaryTheme.class,
    ServiceInformationNameType.class,
    OrganizationNameType.class,
    ExplanationType.class,
    TermNameType.class,
    KeywordType.class,
    SynopsisType.class,
    tva.metadata._2011.TVATermDefinitionBaseType.Name.class,
    tva.mpeg21._2011.TextFocusOfAttentionType.Keyword.class,
    tva.mpeg7._2008.InlineTermDefinitionType.Name.class
})
public class TextualType
    extends TextualBaseType
{


}
