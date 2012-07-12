//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.metadata.interstitial._2011;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tva.metadata._2011.TVATermDefinitionType;


/**
 * <p>Java class for TargetingControlledTermsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetingControlledTermsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:2011}TVATermDefinitionType">
 *       &lt;sequence>
 *         &lt;element name="InputParameterType" type="{urn:tva:metadata:interstitial:2011}TermConstraintsType" minOccurs="0"/>
 *         &lt;element name="ReturnType" type="{urn:tva:metadata:interstitial:2011}TermConstraintsType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetingControlledTermsType", propOrder = {
    "inputParameterType",
    "returnType"
})
public class TargetingControlledTermsType
    extends TVATermDefinitionType
{

    @XmlElement(name = "InputParameterType")
    protected TermConstraintsType inputParameterType;
    @XmlElement(name = "ReturnType", required = true)
    protected TermConstraintsType returnType;

    /**
     * Gets the value of the inputParameterType property.
     * 
     * @return
     *     possible object is
     *     {@link TermConstraintsType }
     *     
     */
    public TermConstraintsType getInputParameterType() {
        return inputParameterType;
    }

    /**
     * Sets the value of the inputParameterType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermConstraintsType }
     *     
     */
    public void setInputParameterType(TermConstraintsType value) {
        this.inputParameterType = value;
    }

    /**
     * Gets the value of the returnType property.
     * 
     * @return
     *     possible object is
     *     {@link TermConstraintsType }
     *     
     */
    public TermConstraintsType getReturnType() {
        return returnType;
    }

    /**
     * Sets the value of the returnType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermConstraintsType }
     *     
     */
    public void setReturnType(TermConstraintsType value) {
        this.returnType = value;
    }

}
