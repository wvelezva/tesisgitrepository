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
import tva.mpeg7._2008.UniqueIDType;


/**
 * <p>Java class for GroupInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupType" type="{urn:tva:metadata:2011}BaseProgramGroupTypeType"/>
 *         &lt;element name="BasicDescription" type="{urn:tva:metadata:2011}BasicContentDescriptionType"/>
 *         &lt;element name="MemberOf" type="{urn:tva:metadata:2011}BaseMemberOfType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OtherIdentifier" type="{urn:tva:mpeg7:2008}UniqueIDType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PartOfAggregatedGroup" type="{urn:tva:metadata:2011}CRIDType" minOccurs="0"/>
 *         &lt;element name="AggregationOf" type="{urn:tva:metadata:2011}AggregationOfType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:tva:metadata:2011}fragmentIdentification"/>
 *       &lt;attribute name="groupId" use="required" type="{urn:tva:metadata:2011}CRIDType" />
 *       &lt;attribute name="ordered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="numOfItems" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="metadataOriginIDRef" type="{urn:tva:metadata:2011}TVAIDRefType" />
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *       &lt;attribute name="serviceIDRef" type="{urn:tva:metadata:2011}TVAIDRefsType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupInformationType", propOrder = {
    "groupType",
    "basicDescription",
    "memberOf",
    "otherIdentifier",
    "partOfAggregatedGroup",
    "aggregationOf"
})
public class GroupInformationType {

    @XmlElement(name = "GroupType", required = true)
    protected BaseProgramGroupTypeType groupType;
    @XmlElement(name = "BasicDescription", required = true)
    protected BasicContentDescriptionType basicDescription;
    @XmlElement(name = "MemberOf")
    protected List<BaseMemberOfType> memberOf;
    @XmlElement(name = "OtherIdentifier")
    protected List<UniqueIDType> otherIdentifier;
    @XmlElement(name = "PartOfAggregatedGroup")
    protected String partOfAggregatedGroup;
    @XmlElement(name = "AggregationOf")
    protected AggregationOfType aggregationOf;
    @XmlAttribute(name = "groupId", required = true)
    protected String groupId;
    @XmlAttribute(name = "ordered")
    protected Boolean ordered;
    @XmlAttribute(name = "numOfItems")
    @XmlSchemaType(name = "unsignedInt")
    protected Long numOfItems;
    @XmlAttribute(name = "metadataOriginIDRef")
    protected String metadataOriginIDRef;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;
    @XmlAttribute(name = "serviceIDRef")
    protected List<String> serviceIDRef;
    @XmlAttribute(name = "fragmentId")
    protected String fragmentId;
    @XmlAttribute(name = "fragmentVersion")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger fragmentVersion;
    @XmlAttribute(name = "fragmentExpirationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fragmentExpirationDate;

    /**
     * Gets the value of the groupType property.
     * 
     * @return
     *     possible object is
     *     {@link BaseProgramGroupTypeType }
     *     
     */
    public BaseProgramGroupTypeType getGroupType() {
        return groupType;
    }

    /**
     * Sets the value of the groupType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseProgramGroupTypeType }
     *     
     */
    public void setGroupType(BaseProgramGroupTypeType value) {
        this.groupType = value;
    }

    /**
     * Gets the value of the basicDescription property.
     * 
     * @return
     *     possible object is
     *     {@link BasicContentDescriptionType }
     *     
     */
    public BasicContentDescriptionType getBasicDescription() {
        return basicDescription;
    }

    /**
     * Sets the value of the basicDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicContentDescriptionType }
     *     
     */
    public void setBasicDescription(BasicContentDescriptionType value) {
        this.basicDescription = value;
    }

    /**
     * Gets the value of the memberOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memberOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemberOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BaseMemberOfType }
     * 
     * 
     */
    public List<BaseMemberOfType> getMemberOf() {
        if (memberOf == null) {
            memberOf = new ArrayList<BaseMemberOfType>();
        }
        return this.memberOf;
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
     * Gets the value of the partOfAggregatedGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartOfAggregatedGroup() {
        return partOfAggregatedGroup;
    }

    /**
     * Sets the value of the partOfAggregatedGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartOfAggregatedGroup(String value) {
        this.partOfAggregatedGroup = value;
    }

    /**
     * Gets the value of the aggregationOf property.
     * 
     * @return
     *     possible object is
     *     {@link AggregationOfType }
     *     
     */
    public AggregationOfType getAggregationOf() {
        return aggregationOf;
    }

    /**
     * Sets the value of the aggregationOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link AggregationOfType }
     *     
     */
    public void setAggregationOf(AggregationOfType value) {
        this.aggregationOf = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the ordered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOrdered() {
        if (ordered == null) {
            return false;
        } else {
            return ordered;
        }
    }

    /**
     * Sets the value of the ordered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOrdered(Boolean value) {
        this.ordered = value;
    }

    /**
     * Gets the value of the numOfItems property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumOfItems() {
        return numOfItems;
    }

    /**
     * Sets the value of the numOfItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumOfItems(Long value) {
        this.numOfItems = value;
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