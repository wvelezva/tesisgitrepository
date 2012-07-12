//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata._2011;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for OnDemandServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OnDemandServiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OnDemandProgram" type="{urn:tva:metadata:2011}OnDemandProgramType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:tva:metadata:2011}fragmentIdentification"/>
 *       &lt;attribute name="serviceIDRef" use="required" type="{urn:tva:metadata:2011}TVAIDRefsType" />
 *       &lt;attribute name="metadataOriginIDRef" type="{urn:tva:metadata:2011}TVAIDRefType" />
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OnDemandServiceType", propOrder = {
    "onDemandProgram"
})
public class OnDemandServiceType {

    @XmlElement(name = "OnDemandProgram", required = true)
    protected List<OnDemandProgramType> onDemandProgram;
    @XmlAttribute(name = "serviceIDRef", required = true)
    protected List<String> serviceIDRef;
    @XmlAttribute(name = "metadataOriginIDRef")
    protected String metadataOriginIDRef;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;
    @XmlAttribute(name = "fragmentId")
    protected String fragmentId;
    @XmlAttribute(name = "fragmentVersion")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger fragmentVersion;
    @XmlAttribute(name = "fragmentExpirationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fragmentExpirationDate;

    /**
     * Gets the value of the onDemandProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onDemandProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnDemandProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OnDemandProgramType }
     * 
     * 
     */
    public List<OnDemandProgramType> getOnDemandProgram() {
        if (onDemandProgram == null) {
            onDemandProgram = new ArrayList<OnDemandProgramType>();
        }
        return this.onDemandProgram;
    }

    /**
     * Gets the value of the serviceIDRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceIDRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceIDRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServiceIDRef() {
        if (serviceIDRef == null) {
            serviceIDRef = new ArrayList<String>();
        }
        return this.serviceIDRef;
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
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
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
