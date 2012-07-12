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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tva.metadata._2011.ControlledTermType;


/**
 * <p>Java class for RelationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelationType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:metadata:2011}ControlledTermType">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="TemporalInterval" type="{urn:tva:metadata:extended:2011}TemporalIntervalType" minOccurs="0"/>
 *         &lt;element name="SpatialInterval" type="{urn:tva:metadata:extended:2011}SpatialIntervalType" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="source" type="{urn:tva:metadata:2011}TVAIDRefsType" />
 *       &lt;attribute name="target" type="{urn:tva:metadata:2011}TVAIDRefsType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelationType", propOrder = {
    "temporalInterval",
    "spatialInterval"
})
public class RelationType
    extends ControlledTermType
{

    @XmlElement(name = "TemporalInterval")
    protected TemporalIntervalType temporalInterval;
    @XmlElement(name = "SpatialInterval")
    protected SpatialIntervalType spatialInterval;
    @XmlAttribute(name = "source")
    protected List<String> source;
    @XmlAttribute(name = "target")
    protected List<String> target;

    /**
     * Gets the value of the temporalInterval property.
     * 
     * @return
     *     possible object is
     *     {@link TemporalIntervalType }
     *     
     */
    public TemporalIntervalType getTemporalInterval() {
        return temporalInterval;
    }

    /**
     * Sets the value of the temporalInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemporalIntervalType }
     *     
     */
    public void setTemporalInterval(TemporalIntervalType value) {
        this.temporalInterval = value;
    }

    /**
     * Gets the value of the spatialInterval property.
     * 
     * @return
     *     possible object is
     *     {@link SpatialIntervalType }
     *     
     */
    public SpatialIntervalType getSpatialInterval() {
        return spatialInterval;
    }

    /**
     * Sets the value of the spatialInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpatialIntervalType }
     *     
     */
    public void setSpatialInterval(SpatialIntervalType value) {
        this.spatialInterval = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the source property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSource() {
        if (source == null) {
            source = new ArrayList<String>();
        }
        return this.source;
    }

    /**
     * Gets the value of the target property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the target property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTarget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTarget() {
        if (target == null) {
            target = new ArrayList<String>();
        }
        return this.target;
    }

}
