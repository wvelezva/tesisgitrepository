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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Coding" type="{urn:tva:metadata:2011}ControlledTermType" minOccurs="0"/>
 *         &lt;element name="Scan" type="{urn:tva:metadata:2011}ScanType" minOccurs="0"/>
 *         &lt;element name="HorizontalSize" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="VerticalSize" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="AspectRatio" type="{urn:tva:metadata:2011}AspectRatioType" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="Color" type="{urn:tva:metadata:2011}ColorType" minOccurs="0"/>
 *         &lt;element name="FrameRate" type="{urn:tva:metadata:2011}FrameRateType" minOccurs="0"/>
 *         &lt;element name="BitRate" type="{urn:tva:metadata:2011}BitRateType" minOccurs="0"/>
 *         &lt;element name="PictureFormat" type="{urn:tva:metadata:2011}ControlledTermType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoAttributesType", propOrder = {
    "coding",
    "scan",
    "horizontalSize",
    "verticalSize",
    "aspectRatio",
    "color",
    "frameRate",
    "bitRate",
    "pictureFormat"
}, namespace ="urn:tva:metadata:2011")
public class VideoAttributesType {

    @XmlElement(name = "Coding")
    protected ControlledTermType coding;
    @XmlElement(name = "Scan")
    protected ScanType scan;
    @XmlElement(name = "HorizontalSize")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer horizontalSize;
    @XmlElement(name = "VerticalSize")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer verticalSize;
    @XmlElement(name = "AspectRatio")
    protected List<AspectRatioType> aspectRatio;
    @XmlElement(name = "Color")
    protected ColorType color;
    @XmlElement(name = "FrameRate")
    protected String frameRate;
    @XmlElement(name = "BitRate")
    protected BitRateType bitRate;
    @XmlElement(name = "PictureFormat")
    protected ControlledTermType pictureFormat;

    /**
     * Gets the value of the coding property.
     * 
     * @return
     *     possible object is
     *     {@link ControlledTermType }
     *     
     */
    public ControlledTermType getCoding() {
        return coding;
    }

    /**
     * Sets the value of the coding property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlledTermType }
     *     
     */
    public void setCoding(ControlledTermType value) {
        this.coding = value;
    }

    /**
     * Gets the value of the scan property.
     * 
     * @return
     *     possible object is
     *     {@link ScanType }
     *     
     */
    public ScanType getScan() {
        return scan;
    }

    /**
     * Sets the value of the scan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScanType }
     *     
     */
    public void setScan(ScanType value) {
        this.scan = value;
    }

    /**
     * Gets the value of the horizontalSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHorizontalSize() {
        return horizontalSize;
    }

    /**
     * Sets the value of the horizontalSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHorizontalSize(Integer value) {
        this.horizontalSize = value;
    }

    /**
     * Gets the value of the verticalSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVerticalSize() {
        return verticalSize;
    }

    /**
     * Sets the value of the verticalSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVerticalSize(Integer value) {
        this.verticalSize = value;
    }

    /**
     * Gets the value of the aspectRatio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aspectRatio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAspectRatio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AspectRatioType }
     * 
     * 
     */
    public List<AspectRatioType> getAspectRatio() {
        if (aspectRatio == null) {
            aspectRatio = new ArrayList<AspectRatioType>();
        }
        return this.aspectRatio;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link ColorType }
     *     
     */
    public ColorType getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorType }
     *     
     */
    public void setColor(ColorType value) {
        this.color = value;
    }

    /**
     * Gets the value of the frameRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrameRate() {
        return frameRate;
    }

    /**
     * Sets the value of the frameRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameRate(String value) {
        this.frameRate = value;
    }

    /**
     * Gets the value of the bitRate property.
     * 
     * @return
     *     possible object is
     *     {@link BitRateType }
     *     
     */
    public BitRateType getBitRate() {
        return bitRate;
    }

    /**
     * Sets the value of the bitRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BitRateType }
     *     
     */
    public void setBitRate(BitRateType value) {
        this.bitRate = value;
    }

    /**
     * Gets the value of the pictureFormat property.
     * 
     * @return
     *     possible object is
     *     {@link ControlledTermType }
     *     
     */
    public ControlledTermType getPictureFormat() {
        return pictureFormat;
    }

    /**
     * Sets the value of the pictureFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlledTermType }
     *     
     */
    public void setPictureFormat(ControlledTermType value) {
        this.pictureFormat = value;
    }

}
