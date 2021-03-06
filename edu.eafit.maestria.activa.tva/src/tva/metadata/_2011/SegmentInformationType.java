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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import edu.eafit.maestria.activa.metadata.ExtendedSegmentInformationType;
import tva.mpeg7._2008.UniqueIDType;


/**
 * <p>Java class for SegmentInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SegmentInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProgramRef" type="{urn:tva:metadata:2011}CRIDRefType" minOccurs="0"/>
 *         &lt;element name="TimeBaseReference" type="{urn:tva:metadata:2011}TimeBaseReferenceType" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:tva:metadata:2011}BasicSegmentDescriptionType" minOccurs="0"/>
 *         &lt;element name="SegmentLocator" type="{urn:tva:metadata:2011}TVAMediaTimeType" minOccurs="0"/>
 *         &lt;element name="KeyFrameLocator" type="{urn:tva:metadata:2011}TVAMediaTimeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OtherIdentifier" type="{urn:tva:mpeg7:2008}UniqueIDType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:tva:metadata:2011}fragmentIdentification"/>
 *       &lt;attribute name="segmentId" use="required" type="{urn:tva:metadata:2011}TVAIDType" />
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
@XmlType(name = "SegmentInformationType", propOrder = {
    "programRef",
    "timeBaseReference",
    "description",
    "segmentLocator",
    "keyFrameLocator",
    "otherIdentifier"
})
@XmlSeeAlso({
    ExtendedSegmentInformationType.class
})
public class SegmentInformationType {

    @XmlElement(name = "ProgramRef")
    protected CRIDRefType programRef;
    @XmlElement(name = "TimeBaseReference")
    protected TimeBaseReferenceType timeBaseReference;
    @XmlElement(name = "Description")
    protected BasicSegmentDescriptionType description;
    @XmlElement(name = "SegmentLocator")
    protected TVAMediaTimeType segmentLocator;
    @XmlElement(name = "KeyFrameLocator")
    protected List<TVAMediaTimeType> keyFrameLocator;
    @XmlElement(name = "OtherIdentifier")
    protected List<UniqueIDType> otherIdentifier;
    @XmlAttribute(name = "segmentId", required = true)
    protected String segmentId;
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
     * Gets the value of the programRef property.
     * 
     * @return
     *     possible object is
     *     {@link CRIDRefType }
     *     
     */
    public CRIDRefType getProgramRef() {
        return programRef;
    }

    /**
     * Sets the value of the programRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRIDRefType }
     *     
     */
    public void setProgramRef(CRIDRefType value) {
        this.programRef = value;
    }

    /**
     * Gets the value of the timeBaseReference property.
     * 
     * @return
     *     possible object is
     *     {@link TimeBaseReferenceType }
     *     
     */
    public TimeBaseReferenceType getTimeBaseReference() {
        return timeBaseReference;
    }

    /**
     * Sets the value of the timeBaseReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeBaseReferenceType }
     *     
     */
    public void setTimeBaseReference(TimeBaseReferenceType value) {
        this.timeBaseReference = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link BasicSegmentDescriptionType }
     *     
     */
    public BasicSegmentDescriptionType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicSegmentDescriptionType }
     *     
     */
    public void setDescription(BasicSegmentDescriptionType value) {
        this.description = value;
    }

    /**
     * Gets the value of the segmentLocator property.
     * 
     * @return
     *     possible object is
     *     {@link TVAMediaTimeType }
     *     
     */
    public TVAMediaTimeType getSegmentLocator() {
        return segmentLocator;
    }

    /**
     * Sets the value of the segmentLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link TVAMediaTimeType }
     *     
     */
    public void setSegmentLocator(TVAMediaTimeType value) {
        this.segmentLocator = value;
    }

    /**
     * Gets the value of the keyFrameLocator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyFrameLocator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyFrameLocator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TVAMediaTimeType }
     * 
     * 
     */
    public List<TVAMediaTimeType> getKeyFrameLocator() {
        if (keyFrameLocator == null) {
            keyFrameLocator = new ArrayList<TVAMediaTimeType>();
        }
        return this.keyFrameLocator;
    }

    /**
     * Gets the value of the otherIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniqueIDType }
     * 
     * 
     */
    public List<UniqueIDType> getOtherIdentifier() {
        if (otherIdentifier == null) {
            otherIdentifier = new ArrayList<UniqueIDType>();
        }
        return this.otherIdentifier;
    }

    /**
     * Gets the value of the segmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegmentId() {
        return segmentId;
    }

    /**
     * Sets the value of the segmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegmentId(String value) {
        this.segmentId = value;
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
