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
import tva.mpeg21._2011.AudioOutputType;
import tva.mpeg21._2011.CodecCapabilityBaseType;
import tva.mpeg21._2011.DisplayType;
import tva.mpeg21._2011.StorageType;
import tva.mpeg21._2011.UserInteractionInputType;


/**
 * <p>Java class for TerminalInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TerminalInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DecoderInformation" type="{urn:tva:mpeg21:2011}CodecCapabilityBaseType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EncoderInformation" type="{urn:tva:mpeg21:2011}CodecCapabilityBaseType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DisplayInformation" type="{urn:tva:mpeg21:2011}DisplayType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AudioInformation" type="{urn:tva:mpeg21:2011}AudioOutputType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InteractionInputInformation" type="{urn:tva:mpeg21:2011}UserInteractionInputType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StorageInformation" type="{urn:tva:mpeg21:2011}StorageType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SystemInformation" type="{urn:tva:metadata:extended:2011}SystemInformationType" minOccurs="0"/>
 *         &lt;element name="HardwareManufacturer" type="{urn:tva:metadata:extended:2011}HardwareManufacturerType" minOccurs="0"/>
 *         &lt;element name="TerminalType" type="{urn:tva:metadata:2011}ControlledTermType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="terminalInformationId" type="{urn:tva:metadata:2011}TVAIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminalInformationType", propOrder = {
    "decoderInformation",
    "encoderInformation",
    "displayInformation",
    "audioInformation",
    "interactionInputInformation",
    "storageInformation",
    "systemInformation",
    "hardwareManufacturer",
    "terminalType"
})
public class TerminalInformationType {

    @XmlElement(name = "DecoderInformation")
    protected List<CodecCapabilityBaseType> decoderInformation;
    @XmlElement(name = "EncoderInformation")
    protected List<CodecCapabilityBaseType> encoderInformation;
    @XmlElement(name = "DisplayInformation")
    protected List<DisplayType> displayInformation;
    @XmlElement(name = "AudioInformation")
    protected List<AudioOutputType> audioInformation;
    @XmlElement(name = "InteractionInputInformation")
    protected List<UserInteractionInputType> interactionInputInformation;
    @XmlElement(name = "StorageInformation")
    protected List<StorageType> storageInformation;
    @XmlElement(name = "SystemInformation")
    protected SystemInformationType systemInformation;
    @XmlElement(name = "HardwareManufacturer")
    protected HardwareManufacturerType hardwareManufacturer;
    @XmlElement(name = "TerminalType")
    protected ControlledTermType terminalType;
    @XmlAttribute(name = "terminalInformationId")
    protected String terminalInformationId;

    /**
     * Gets the value of the decoderInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decoderInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecoderInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodecCapabilityBaseType }
     * 
     * 
     */
    public List<CodecCapabilityBaseType> getDecoderInformation() {
        if (decoderInformation == null) {
            decoderInformation = new ArrayList<CodecCapabilityBaseType>();
        }
        return this.decoderInformation;
    }

    /**
     * Gets the value of the encoderInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encoderInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncoderInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodecCapabilityBaseType }
     * 
     * 
     */
    public List<CodecCapabilityBaseType> getEncoderInformation() {
        if (encoderInformation == null) {
            encoderInformation = new ArrayList<CodecCapabilityBaseType>();
        }
        return this.encoderInformation;
    }

    /**
     * Gets the value of the displayInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisplayType }
     * 
     * 
     */
    public List<DisplayType> getDisplayInformation() {
        if (displayInformation == null) {
            displayInformation = new ArrayList<DisplayType>();
        }
        return this.displayInformation;
    }

    /**
     * Gets the value of the audioInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the audioInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAudioInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AudioOutputType }
     * 
     * 
     */
    public List<AudioOutputType> getAudioInformation() {
        if (audioInformation == null) {
            audioInformation = new ArrayList<AudioOutputType>();
        }
        return this.audioInformation;
    }

    /**
     * Gets the value of the interactionInputInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interactionInputInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteractionInputInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserInteractionInputType }
     * 
     * 
     */
    public List<UserInteractionInputType> getInteractionInputInformation() {
        if (interactionInputInformation == null) {
            interactionInputInformation = new ArrayList<UserInteractionInputType>();
        }
        return this.interactionInputInformation;
    }

    /**
     * Gets the value of the storageInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storageInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStorageInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StorageType }
     * 
     * 
     */
    public List<StorageType> getStorageInformation() {
        if (storageInformation == null) {
            storageInformation = new ArrayList<StorageType>();
        }
        return this.storageInformation;
    }

    /**
     * Gets the value of the systemInformation property.
     * 
     * @return
     *     possible object is
     *     {@link SystemInformationType }
     *     
     */
    public SystemInformationType getSystemInformation() {
        return systemInformation;
    }

    /**
     * Sets the value of the systemInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemInformationType }
     *     
     */
    public void setSystemInformation(SystemInformationType value) {
        this.systemInformation = value;
    }

    /**
     * Gets the value of the hardwareManufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link HardwareManufacturerType }
     *     
     */
    public HardwareManufacturerType getHardwareManufacturer() {
        return hardwareManufacturer;
    }

    /**
     * Sets the value of the hardwareManufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link HardwareManufacturerType }
     *     
     */
    public void setHardwareManufacturer(HardwareManufacturerType value) {
        this.hardwareManufacturer = value;
    }

    /**
     * Gets the value of the terminalType property.
     * 
     * @return
     *     possible object is
     *     {@link ControlledTermType }
     *     
     */
    public ControlledTermType getTerminalType() {
        return terminalType;
    }

    /**
     * Sets the value of the terminalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlledTermType }
     *     
     */
    public void setTerminalType(ControlledTermType value) {
        this.terminalType = value;
    }

    /**
     * Gets the value of the terminalInformationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalInformationId() {
        return terminalInformationId;
    }

    /**
     * Sets the value of the terminalInformationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalInformationId(String value) {
        this.terminalInformationId = value;
    }

}
