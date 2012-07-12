//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.extended._2011;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tva.metadata._2011.ControlledTermType;


/**
 * <p>Java class for EducationalContextAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EducationalContextAttributesType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:extended:2011}ContextAttributesType">
 *       &lt;sequence>
 *         &lt;element name="IntendedUser" type="{urn:tva:metadata:2011}ControlledTermType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EducationalType" type="{urn:tva:metadata:2011}ControlledTermType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EducationalContextAttributesType", propOrder = {
    "intendedUser",
    "educationalType"
})
public class EducationalContextAttributesType
    extends ContextAttributesType
{

    @XmlElement(name = "IntendedUser")
    protected List<ControlledTermType> intendedUser;
    @XmlElement(name = "EducationalType")
    protected List<ControlledTermType> educationalType;

    /**
     * Gets the value of the intendedUser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intendedUser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntendedUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlledTermType }
     * 
     * 
     */
    public List<ControlledTermType> getIntendedUser() {
        if (intendedUser == null) {
            intendedUser = new ArrayList<ControlledTermType>();
        }
        return this.intendedUser;
    }

    /**
     * Gets the value of the educationalType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the educationalType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEducationalType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlledTermType }
     * 
     * 
     */
    public List<ControlledTermType> getEducationalType() {
        if (educationalType == null) {
            educationalType = new ArrayList<ControlledTermType>();
        }
        return this.educationalType;
    }

}