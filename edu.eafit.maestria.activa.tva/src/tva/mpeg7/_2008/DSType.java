//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg7._2008;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import tva.metadata._2011.TVATermDefinitionBaseType;


/**
 * <p>Java class for DSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DSType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg7:2008}Mpeg7BaseType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:tva:mpeg7:2008}timePropertyGrp"/>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSType")
@XmlSeeAlso({
    TermDefinitionBaseType.class,
    CreationPreferencesType.class,
    UserPreferencesType.class,
    FilteringAndSearchPreferencesType.class,
    tva.mpeg7._2008.UserActionListType.class,
    BrowsingPreferencesType.class,
    tva.mpeg7._2008.UsageHistoryType.class,
    SourcePreferencesType.class,
    ClassificationPreferencesType.class,
    AgentType.class,
    SummaryPreferencesType.class,
    tva.mpeg7._2008.UserActionHistoryType.class,
    tva.metadata._2011.UsageHistoryType.class,
    ClassificationSchemeBaseType.class,
    tva.metadata._2011.UserActionListType.class,
    UserActionType.class,
    tva.metadata._2011.UserActionHistoryType.class,
    PlaceType.class,
    TVATermDefinitionBaseType.class
})
public abstract class DSType
    extends Mpeg7BaseType
{

    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "timeBase")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String timeBase;
    @XmlAttribute(name = "timeUnit")
    protected String timeUnit;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the timeBase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeBase() {
        return timeBase;
    }

    /**
     * Sets the value of the timeBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeBase(String value) {
        this.timeBase = value;
    }

    /**
     * Gets the value of the timeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeUnit() {
        return timeUnit;
    }

    /**
     * Sets the value of the timeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeUnit(String value) {
        this.timeUnit = value;
    }

}
