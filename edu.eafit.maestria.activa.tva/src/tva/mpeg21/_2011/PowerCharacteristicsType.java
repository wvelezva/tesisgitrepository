//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg21._2011;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PowerCharacteristicsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PowerCharacteristicsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}TerminalCapabilityBaseType">
 *       &lt;attribute name="averageAmpereConsumption" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="batteryCapacityRemaining" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="batteryTimeRemaining" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="runningOnBatteries" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PowerCharacteristicsType")
public class PowerCharacteristicsType
    extends TerminalCapabilityBaseType
{

    @XmlAttribute(name = "averageAmpereConsumption")
    protected BigInteger averageAmpereConsumption;
    @XmlAttribute(name = "batteryCapacityRemaining")
    protected BigInteger batteryCapacityRemaining;
    @XmlAttribute(name = "batteryTimeRemaining")
    protected BigInteger batteryTimeRemaining;
    @XmlAttribute(name = "runningOnBatteries")
    protected Boolean runningOnBatteries;

    /**
     * Gets the value of the averageAmpereConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAverageAmpereConsumption() {
        return averageAmpereConsumption;
    }

    /**
     * Sets the value of the averageAmpereConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAverageAmpereConsumption(BigInteger value) {
        this.averageAmpereConsumption = value;
    }

    /**
     * Gets the value of the batteryCapacityRemaining property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBatteryCapacityRemaining() {
        return batteryCapacityRemaining;
    }

    /**
     * Sets the value of the batteryCapacityRemaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBatteryCapacityRemaining(BigInteger value) {
        this.batteryCapacityRemaining = value;
    }

    /**
     * Gets the value of the batteryTimeRemaining property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBatteryTimeRemaining() {
        return batteryTimeRemaining;
    }

    /**
     * Sets the value of the batteryTimeRemaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBatteryTimeRemaining(BigInteger value) {
        this.batteryTimeRemaining = value;
    }

    /**
     * Gets the value of the runningOnBatteries property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRunningOnBatteries() {
        return runningOnBatteries;
    }

    /**
     * Sets the value of the runningOnBatteries property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRunningOnBatteries(Boolean value) {
        this.runningOnBatteries = value;
    }

}