//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import tva.mpeg7._2008.RatingType;


/**
 * <p>Java class for UserActionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserActionType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg7:2008}UserActionType">
 *       &lt;sequence>
 *         &lt;element name="ProgramLocation" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="Rating" type="{urn:tva:mpeg7:2008}RatingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserActionType", propOrder = {
    "programLocation",
    "rating"
}, namespace="urn:tva:metadata:2011")
public class UserActionType
    extends tva.mpeg7._2008.UserActionType
{

    @XmlElement(name = "ProgramLocation")
    @XmlSchemaType(name = "anyURI")
    protected String programLocation;
    @XmlElement(name = "Rating")
    protected RatingType rating;

    /**
     * Gets the value of the programLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramLocation() {
        return programLocation;
    }

    /**
     * Sets the value of the programLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramLocation(String value) {
        this.programLocation = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link RatingType }
     *     
     */
    public RatingType getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link RatingType }
     *     
     */
    public void setRating(RatingType value) {
        this.rating = value;
    }

}
