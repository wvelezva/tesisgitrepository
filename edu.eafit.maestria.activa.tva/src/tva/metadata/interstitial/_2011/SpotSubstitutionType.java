//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.interstitial._2011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpotSubstitutionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpotSubstitutionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpotSelectionRule" type="{urn:tva:metadata:interstitial:2011}RuleType"/>
 *         &lt;element name="ReplacementSpot" type="{urn:tva:metadata:interstitial:2011}ContentRefType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpotSubstitutionType", propOrder = {
    "spotSelectionRule",
    "replacementSpot"
})
public class SpotSubstitutionType {

    @XmlElement(name = "SpotSelectionRule", required = true)
    protected RuleType spotSelectionRule;
    @XmlElement(name = "ReplacementSpot")
    protected List<ContentRefType> replacementSpot;

    /**
     * Gets the value of the spotSelectionRule property.
     * 
     * @return
     *     possible object is
     *     {@link RuleType }
     *     
     */
    public RuleType getSpotSelectionRule() {
        return spotSelectionRule;
    }

    /**
     * Sets the value of the spotSelectionRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleType }
     *     
     */
    public void setSpotSelectionRule(RuleType value) {
        this.spotSelectionRule = value;
    }

    /**
     * Gets the value of the replacementSpot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the replacementSpot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplacementSpot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentRefType }
     * 
     * 
     */
    public List<ContentRefType> getReplacementSpot() {
        if (replacementSpot == null) {
            replacementSpot = new ArrayList<ContentRefType>();
        }
        return this.replacementSpot;
    }

}