//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata._2011;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PurchaseInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurchaseInformationType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:2011}PurchaseItemType">
 *       &lt;attGroup ref="{urn:tva:metadata:2011}fragmentIdentification"/>
 *       &lt;attribute name="purchaseId" use="required" type="{urn:tva:metadata:2011}TVAIDType" />
 *       &lt;attribute name="metadataOriginIDRef" type="{urn:tva:metadata:2011}TVAIDRefType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseInformationType")
public class PurchaseInformationType
    extends PurchaseItemType
{

    @XmlAttribute(name = "purchaseId", required = true)
    protected String purchaseId;
    @XmlAttribute(name = "metadataOriginIDRef")
    protected String metadataOriginIDRef;
    @XmlAttribute(name = "fragmentId")
    protected String fragmentId;
    @XmlAttribute(name = "fragmentVersion")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger fragmentVersion;
    @XmlAttribute(name = "fragmentExpirationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fragmentExpirationDate;

    /**
     * Gets the value of the purchaseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseId() {
        return purchaseId;
    }

    /**
     * Sets the value of the purchaseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseId(String value) {
        this.purchaseId = value;
    }

    /**
     * Gets the value of the metadataOriginIDRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetadataOriginIDRef() {
        return metadataOriginIDRef;
    }

    /**
     * Sets the value of the metadataOriginIDRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetadataOriginIDRef(String value) {
        this.metadataOriginIDRef = value;
    }

    /**
     * Gets the value of the fragmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFragmentId() {
        return fragmentId;
    }

    /**
     * Sets the value of the fragmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFragmentId(String value) {
        this.fragmentId = value;
    }

    /**
     * Gets the value of the fragmentVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFragmentVersion() {
        return fragmentVersion;
    }

    /**
     * Sets the value of the fragmentVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFragmentVersion(BigInteger value) {
        this.fragmentVersion = value;
    }

    /**
     * Gets the value of the fragmentExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFragmentExpirationDate() {
        return fragmentExpirationDate;
    }

    /**
     * Sets the value of the fragmentExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFragmentExpirationDate(XMLGregorianCalendar value) {
        this.fragmentExpirationDate = value;
    }

}