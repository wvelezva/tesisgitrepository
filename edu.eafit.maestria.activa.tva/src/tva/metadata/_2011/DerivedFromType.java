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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DerivedFromType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DerivedFromType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:2011}BaseMemberOfType">
 *       &lt;sequence>
 *         &lt;element name="DerivationReason" type="{urn:tva:metadata:2011}GenericDerivationReasonType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DerivedFromType", propOrder = {
    "derivationReason"
})
public class DerivedFromType
    extends BaseMemberOfType
{

    @XmlElement(name = "DerivationReason")
    protected List<GenericDerivationReasonType> derivationReason;

    /**
     * Gets the value of the derivationReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derivationReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerivationReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericDerivationReasonType }
     * 
     * 
     */
    public List<GenericDerivationReasonType> getDerivationReason() {
        if (derivationReason == null) {
            derivationReason = new ArrayList<GenericDerivationReasonType>();
        }
        return this.derivationReason;
    }

}
