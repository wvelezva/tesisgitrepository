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
import javax.xml.bind.annotation.XmlType;
import tva.mpeg7._2008.TextualType;


/**
 * <p>Java class for AwardType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AwardType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Category" type="{urn:tva:mpeg7:2008}TextualType"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Nominee" type="{urn:tva:metadata:2011}CreditsItemType"/>
 *           &lt;element name="Recipient" type="{urn:tva:metadata:2011}CreditsItemType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AwardType", propOrder = {
    "category",
    "nominee",
    "recipient"
})
public class AwardType {

    @XmlElement(name = "Category", required = true)
    protected TextualType category;
    @XmlElement(name = "Nominee")
    protected CreditsItemType nominee;
    @XmlElement(name = "Recipient")
    protected CreditsItemType recipient;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link TextualType }
     *     
     */
    public TextualType getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextualType }
     *     
     */
    public void setCategory(TextualType value) {
        this.category = value;
    }

    /**
     * Gets the value of the nominee property.
     * 
     * @return
     *     possible object is
     *     {@link CreditsItemType }
     *     
     */
    public CreditsItemType getNominee() {
        return nominee;
    }

    /**
     * Sets the value of the nominee property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditsItemType }
     *     
     */
    public void setNominee(CreditsItemType value) {
        this.nominee = value;
    }

    /**
     * Gets the value of the recipient property.
     * 
     * @return
     *     possible object is
     *     {@link CreditsItemType }
     *     
     */
    public CreditsItemType getRecipient() {
        return recipient;
    }

    /**
     * Sets the value of the recipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditsItemType }
     *     
     */
    public void setRecipient(CreditsItemType value) {
        this.recipient = value;
    }

}