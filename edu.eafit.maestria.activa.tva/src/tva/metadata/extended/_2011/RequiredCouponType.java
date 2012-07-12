//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.extended._2011;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequiredCouponType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequiredCouponType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="couponId" use="required" type="{urn:tva:metadata:2011}TVAIDType" />
 *       &lt;attribute name="authorityName" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="requiredNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequiredCouponType")
public class RequiredCouponType {

    @XmlAttribute(name = "couponId", required = true)
    protected String couponId;
    @XmlAttribute(name = "authorityName")
    @XmlSchemaType(name = "anyURI")
    protected String authorityName;
    @XmlAttribute(name = "requiredNumber")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger requiredNumber;

    /**
     * Gets the value of the couponId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * Sets the value of the couponId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCouponId(String value) {
        this.couponId = value;
    }

    /**
     * Gets the value of the authorityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * Sets the value of the authorityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityName(String value) {
        this.authorityName = value;
    }

    /**
     * Gets the value of the requiredNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRequiredNumber() {
        return requiredNumber;
    }

    /**
     * Sets the value of the requiredNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRequiredNumber(BigInteger value) {
        this.requiredNumber = value;
    }

}
