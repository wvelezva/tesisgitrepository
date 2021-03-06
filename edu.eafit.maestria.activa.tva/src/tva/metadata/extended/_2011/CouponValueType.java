//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.extended._2011;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tva.metadata._2011.PriceType;


/**
 * <p>Java class for CouponValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CouponValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ReductionAmount" type="{urn:tva:metadata:2011}PriceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NewPrice" type="{urn:tva:metadata:2011}PriceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReductionPercentage" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="purchaseIdRef" type="{urn:tva:metadata:2011}TVAIDRefType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CouponValueType", propOrder = {
    "reductionAmount",
    "newPrice",
    "reductionPercentage"
})
public class CouponValueType {

    @XmlElement(name = "ReductionAmount")
    protected List<PriceType> reductionAmount;
    @XmlElement(name = "NewPrice")
    protected List<PriceType> newPrice;
    @XmlElement(name = "ReductionPercentage")
    protected BigInteger reductionPercentage;
    @XmlAttribute(name = "purchaseIdRef")
    protected String purchaseIdRef;

    /**
     * Gets the value of the reductionAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reductionAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReductionAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceType }
     * 
     * 
     */
    public List<PriceType> getReductionAmount() {
        if (reductionAmount == null) {
            reductionAmount = new ArrayList<PriceType>();
        }
        return this.reductionAmount;
    }

    /**
     * Gets the value of the newPrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newPrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceType }
     * 
     * 
     */
    public List<PriceType> getNewPrice() {
        if (newPrice == null) {
            newPrice = new ArrayList<PriceType>();
        }
        return this.newPrice;
    }

    /**
     * Gets the value of the reductionPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReductionPercentage() {
        return reductionPercentage;
    }

    /**
     * Sets the value of the reductionPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReductionPercentage(BigInteger value) {
        this.reductionPercentage = value;
    }

    /**
     * Gets the value of the purchaseIdRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseIdRef() {
        return purchaseIdRef;
    }

    /**
     * Sets the value of the purchaseIdRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseIdRef(String value) {
        this.purchaseIdRef = value;
    }

}
