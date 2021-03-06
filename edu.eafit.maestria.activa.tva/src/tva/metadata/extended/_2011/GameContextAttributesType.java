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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import tva.metadata._2011.ControlledTermType;


/**
 * <p>Java class for GameContextAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GameContextAttributesType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:extended:2011}ContextAttributesType">
 *       &lt;sequence>
 *         &lt;element name="Perspectives" type="{urn:tva:metadata:2011}ControlledTermType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MaxNumPlayers" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GameContextAttributesType", propOrder = {
    "perspectives",
    "maxNumPlayers"
})
public class GameContextAttributesType
    extends ContextAttributesType
{

    @XmlElement(name = "Perspectives")
    protected List<ControlledTermType> perspectives;
    @XmlElement(name = "MaxNumPlayers")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxNumPlayers;

    /**
     * Gets the value of the perspectives property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the perspectives property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerspectives().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlledTermType }
     * 
     * 
     */
    public List<ControlledTermType> getPerspectives() {
        if (perspectives == null) {
            perspectives = new ArrayList<ControlledTermType>();
        }
        return this.perspectives;
    }

    /**
     * Gets the value of the maxNumPlayers property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxNumPlayers() {
        return maxNumPlayers;
    }

    /**
     * Sets the value of the maxNumPlayers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxNumPlayers(BigInteger value) {
        this.maxNumPlayers = value;
    }

}
