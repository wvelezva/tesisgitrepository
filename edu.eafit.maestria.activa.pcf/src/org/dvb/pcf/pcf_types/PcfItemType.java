//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.27 at 06:52:02 AM COT 
//


package org.dvb.pcf.pcf_types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.dvb.pcf.pcf.ActionLanguage;
import org.dvb.pcf.pcf.Boolean;
import org.dvb.pcf.pcf.ChoiceState;
import org.dvb.pcf.pcf.Color;
import org.dvb.pcf.pcf.Condition;
import org.dvb.pcf.pcf.Currency;
import org.dvb.pcf.pcf.Date;
import org.dvb.pcf.pcf.DateTime;
import org.dvb.pcf.pcf.FinalState;
import org.dvb.pcf.pcf.FontFamily;
import org.dvb.pcf.pcf.FontSize;
import org.dvb.pcf.pcf.Guard;
import org.dvb.pcf.pcf.HistoryState;
import org.dvb.pcf.pcf.InitialState;
import org.dvb.pcf.pcf.Integer;
import org.dvb.pcf.pcf.JunctionState;
import org.dvb.pcf.pcf.MarkedUpText;
import org.dvb.pcf.pcf.OnEventType;
import org.dvb.pcf.pcf.Position;
import org.dvb.pcf.pcf.Proportion;
import org.dvb.pcf.pcf.Size;
import org.dvb.pcf.pcf.State;
import org.dvb.pcf.pcf.StateCollection;
import org.dvb.pcf.pcf.Time;
import org.dvb.pcf.pcf.Timecode;
import org.dvb.pcf.pcf.TransitionCollection;
import org.dvb.pcf.pcf.TransitionType;
import org.dvb.pcf.pcf.Trigger;
import org.dvb.pcf.pcf.URI;
import org.dvb.pcf.pcf.UserKey;


/**
 * <p>Java class for pcfItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pcfItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://www.dvb.org/pcf/pcf-types}referenceAttrs"/>
 *       &lt;attGroup ref="{http://www.dvb.org/pcf/pcf-types}optionalIdentity"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pcfItemType")
@XmlSeeAlso({
    FontSize.class,
    Date.class,
    DateTime.class,
    Currency.class,
    Color.class,
    Time.class,
    UserKey.class,
    URI.class,
    Proportion.class,
    FontFamily.class,
    OnEventType.class,
    TransitionType.class,
    MarkedUpText.class,
    Size.class,
    org.dvb.pcf.pcf.StateMachine.TopState.class,
    Timecode.class,
    Boolean.class,
    Position.class,
    Integer.class,
    CollectionType.class,
    ImageDataType.class,
    StreamDataType.class,
    PcfItemArrayType.class,
    StringDataType.class,
    ComponentType.class,
    Trigger.class,
    TransitionCollection.class,
    ActionLanguage.class,
    ChoiceState.class,
    FinalState.class,
    HistoryState.class,
    InitialState.class,
    State.class,
    StateCollection.class,
    JunctionState.class,
    Guard.class,
    Condition.class
})
public class PcfItemType {

    @XmlAttribute(name = "context")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String context;
    @XmlAttribute(name = "href")
    protected String href;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContext() {
        if (context == null) {
            return "original";
        } else {
            return context;
        }
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
