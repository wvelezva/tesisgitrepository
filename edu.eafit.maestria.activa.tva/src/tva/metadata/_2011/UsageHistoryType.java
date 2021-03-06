//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata._2011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tva.mpeg7._2008.DSType;
import tva.mpeg7._2008.UserChoiceType;
import tva.mpeg7._2008.UserIdentifierType;


/**
 * <p>Java class for UsageHistoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsageHistoryType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg7:2008}DSType">
 *       &lt;sequence>
 *         &lt;element name="UserIdentifier" type="{urn:tva:mpeg7:2008}UserIdentifierType" minOccurs="0"/>
 *         &lt;element name="UserActionHistory" type="{urn:tva:metadata:2011}UserActionHistoryType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="allowCollection" type="{urn:tva:mpeg7:2008}userChoiceType" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsageHistoryType", propOrder = {
    "userIdentifier",
    "userActionHistory"
}, namespace="urn:tva:metadata:2011")
public class UsageHistoryType
    extends DSType
{

    @XmlElement(name = "UserIdentifier")
    protected UserIdentifierType userIdentifier;
    @XmlElement(name = "UserActionHistory", required = true)
    protected List<UserActionHistoryType> userActionHistory;
    @XmlAttribute(name = "allowCollection")
    protected UserChoiceType allowCollection;

    /**
     * Gets the value of the userIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link UserIdentifierType }
     *     
     */
    public UserIdentifierType getUserIdentifier() {
        return userIdentifier;
    }

    /**
     * Sets the value of the userIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserIdentifierType }
     *     
     */
    public void setUserIdentifier(UserIdentifierType value) {
        this.userIdentifier = value;
    }

    /**
     * Gets the value of the userActionHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userActionHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserActionHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserActionHistoryType }
     * 
     * 
     */
    public List<UserActionHistoryType> getUserActionHistory() {
        if (userActionHistory == null) {
            userActionHistory = new ArrayList<UserActionHistoryType>();
        }
        return this.userActionHistory;
    }

    /**
     * Gets the value of the allowCollection property.
     * 
     * @return
     *     possible object is
     *     {@link UserChoiceType }
     *     
     */
    public UserChoiceType getAllowCollection() {
        if (allowCollection == null) {
            return UserChoiceType.FALSE;
        } else {
            return allowCollection;
        }
    }

    /**
     * Sets the value of the allowCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserChoiceType }
     *     
     */
    public void setAllowCollection(UserChoiceType value) {
        this.allowCollection = value;
    }

}
