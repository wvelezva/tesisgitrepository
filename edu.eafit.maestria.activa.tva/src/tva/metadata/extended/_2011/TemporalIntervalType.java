//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.extended._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tva.mpeg7._2008.MediaIncrDurationType;


/**
 * <p>Java class for TemporalIntervalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemporalIntervalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="MediaDuration" type="{urn:tva:mpeg7:2008}mediaDurationType"/>
 *         &lt;element name="MediaIncrDuration" type="{urn:tva:mpeg7:2008}MediaIncrDurationType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemporalIntervalType", propOrder = {
    "mediaDuration",
    "mediaIncrDuration"
})
public class TemporalIntervalType {

    @XmlElement(name = "MediaDuration")
    protected String mediaDuration;
    @XmlElement(name = "MediaIncrDuration")
    protected MediaIncrDurationType mediaIncrDuration;

    /**
     * Gets the value of the mediaDuration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMediaDuration() {
        return mediaDuration;
    }

    /**
     * Sets the value of the mediaDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaDuration(String value) {
        this.mediaDuration = value;
    }

    /**
     * Gets the value of the mediaIncrDuration property.
     * 
     * @return
     *     possible object is
     *     {@link MediaIncrDurationType }
     *     
     */
    public MediaIncrDurationType getMediaIncrDuration() {
        return mediaIncrDuration;
    }

    /**
     * Sets the value of the mediaIncrDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaIncrDurationType }
     *     
     */
    public void setMediaIncrDuration(MediaIncrDurationType value) {
        this.mediaIncrDuration = value;
    }

}
