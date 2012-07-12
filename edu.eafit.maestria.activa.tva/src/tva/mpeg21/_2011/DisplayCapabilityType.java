//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 05:28:03 PM COT 
//


package tva.mpeg21._2011;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import tva.mpeg7._2008.ControlledTermUseType;


/**
 * <p>Java class for DisplayCapabilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisplayCapabilityType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}DisplayCapabilityBaseType">
 *       &lt;sequence>
 *         &lt;element name="Mode" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Resolution" type="{urn:tva:mpeg21:2011}ResolutionType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="SizeChar" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="horizontal" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="vertical" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="refreshRate" type="{http://www.w3.org/2001/XMLSchema}float" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ScreenSize" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="horizontal" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                 &lt;attribute name="vertical" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ColorBitDepth" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="red" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="green" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="blue" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ColorPrimaries" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ChromaticityRed" type="{urn:tva:mpeg21:2011}ChromaticityType"/>
 *                   &lt;element name="ChromaticityGreen" type="{urn:tva:mpeg21:2011}ChromaticityType"/>
 *                   &lt;element name="ChromaticityBlue" type="{urn:tva:mpeg21:2011}ChromaticityType"/>
 *                   &lt;element name="ChromaticityWhite" type="{urn:tva:mpeg21:2011}ChromaticityType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CharacterSetCode" type="{urn:tva:mpeg7:2008}characterSetCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RenderingFormat" type="{urn:tva:mpeg7:2008}ControlledTermUseType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="stereoscopic" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="maximumBrightness" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="contrastRatio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="gamma" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="bitsPerPixel" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="colorCapable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="sRGB" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="fieldSequentialColor" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="backlightLuminance" type="{urn:tva:mpeg7:2008}zeroToOneType" />
 *       &lt;attribute name="dotPitch" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="activeDisplay" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayCapabilityType", propOrder = {
    "mode",
    "screenSize",
    "colorBitDepth",
    "colorPrimaries",
    "characterSetCode",
    "renderingFormat"
})
public class DisplayCapabilityType
    extends DisplayCapabilityBaseType
{

    @XmlElement(name = "Mode")
    protected List<DisplayCapabilityType.Mode> mode;
    @XmlElement(name = "ScreenSize")
    protected DisplayCapabilityType.ScreenSize screenSize;
    @XmlElement(name = "ColorBitDepth")
    protected DisplayCapabilityType.ColorBitDepth colorBitDepth;
    @XmlElement(name = "ColorPrimaries")
    protected DisplayCapabilityType.ColorPrimaries colorPrimaries;
    @XmlElement(name = "CharacterSetCode")
    protected List<String> characterSetCode;
    @XmlElement(name = "RenderingFormat")
    protected List<ControlledTermUseType> renderingFormat;
    @XmlAttribute(name = "stereoscopic")
    protected Boolean stereoscopic;
    @XmlAttribute(name = "maximumBrightness")
    protected Float maximumBrightness;
    @XmlAttribute(name = "contrastRatio")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger contrastRatio;
    @XmlAttribute(name = "gamma")
    protected Float gamma;
    @XmlAttribute(name = "bitsPerPixel")
    protected BigInteger bitsPerPixel;
    @XmlAttribute(name = "colorCapable")
    protected Boolean colorCapable;
    @XmlAttribute(name = "sRGB")
    protected Boolean srgb;
    @XmlAttribute(name = "fieldSequentialColor")
    protected Boolean fieldSequentialColor;
    @XmlAttribute(name = "backlightLuminance")
    protected Float backlightLuminance;
    @XmlAttribute(name = "dotPitch")
    protected Float dotPitch;
    @XmlAttribute(name = "activeDisplay")
    protected Boolean activeDisplay;

    /**
     * Gets the value of the mode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisplayCapabilityType.Mode }
     * 
     * 
     */
    public List<DisplayCapabilityType.Mode> getMode() {
        if (mode == null) {
            mode = new ArrayList<DisplayCapabilityType.Mode>();
        }
        return this.mode;
    }

    /**
     * Gets the value of the screenSize property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayCapabilityType.ScreenSize }
     *     
     */
    public DisplayCapabilityType.ScreenSize getScreenSize() {
        return screenSize;
    }

    /**
     * Sets the value of the screenSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayCapabilityType.ScreenSize }
     *     
     */
    public void setScreenSize(DisplayCapabilityType.ScreenSize value) {
        this.screenSize = value;
    }

    /**
     * Gets the value of the colorBitDepth property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayCapabilityType.ColorBitDepth }
     *     
     */
    public DisplayCapabilityType.ColorBitDepth getColorBitDepth() {
        return colorBitDepth;
    }

    /**
     * Sets the value of the colorBitDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayCapabilityType.ColorBitDepth }
     *     
     */
    public void setColorBitDepth(DisplayCapabilityType.ColorBitDepth value) {
        this.colorBitDepth = value;
    }

    /**
     * Gets the value of the colorPrimaries property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayCapabilityType.ColorPrimaries }
     *     
     */
    public DisplayCapabilityType.ColorPrimaries getColorPrimaries() {
        return colorPrimaries;
    }

    /**
     * Sets the value of the colorPrimaries property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayCapabilityType.ColorPrimaries }
     *     
     */
    public void setColorPrimaries(DisplayCapabilityType.ColorPrimaries value) {
        this.colorPrimaries = value;
    }

    /**
     * Gets the value of the characterSetCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characterSetCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacterSetCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCharacterSetCode() {
        if (characterSetCode == null) {
            characterSetCode = new ArrayList<String>();
        }
        return this.characterSetCode;
    }

    /**
     * Gets the value of the renderingFormat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the renderingFormat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenderingFormat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlledTermUseType }
     * 
     * 
     */
    public List<ControlledTermUseType> getRenderingFormat() {
        if (renderingFormat == null) {
            renderingFormat = new ArrayList<ControlledTermUseType>();
        }
        return this.renderingFormat;
    }

    /**
     * Gets the value of the stereoscopic property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStereoscopic() {
        return stereoscopic;
    }

    /**
     * Sets the value of the stereoscopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStereoscopic(Boolean value) {
        this.stereoscopic = value;
    }

    /**
     * Gets the value of the maximumBrightness property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMaximumBrightness() {
        return maximumBrightness;
    }

    /**
     * Sets the value of the maximumBrightness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMaximumBrightness(Float value) {
        this.maximumBrightness = value;
    }

    /**
     * Gets the value of the contrastRatio property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getContrastRatio() {
        return contrastRatio;
    }

    /**
     * Sets the value of the contrastRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setContrastRatio(BigInteger value) {
        this.contrastRatio = value;
    }

    /**
     * Gets the value of the gamma property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getGamma() {
        return gamma;
    }

    /**
     * Sets the value of the gamma property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setGamma(Float value) {
        this.gamma = value;
    }

    /**
     * Gets the value of the bitsPerPixel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBitsPerPixel() {
        return bitsPerPixel;
    }

    /**
     * Sets the value of the bitsPerPixel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBitsPerPixel(BigInteger value) {
        this.bitsPerPixel = value;
    }

    /**
     * Gets the value of the colorCapable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isColorCapable() {
        return colorCapable;
    }

    /**
     * Sets the value of the colorCapable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setColorCapable(Boolean value) {
        this.colorCapable = value;
    }

    /**
     * Gets the value of the srgb property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSRGB() {
        return srgb;
    }

    /**
     * Sets the value of the srgb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSRGB(Boolean value) {
        this.srgb = value;
    }

    /**
     * Gets the value of the fieldSequentialColor property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFieldSequentialColor() {
        return fieldSequentialColor;
    }

    /**
     * Sets the value of the fieldSequentialColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFieldSequentialColor(Boolean value) {
        this.fieldSequentialColor = value;
    }

    /**
     * Gets the value of the backlightLuminance property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBacklightLuminance() {
        return backlightLuminance;
    }

    /**
     * Sets the value of the backlightLuminance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBacklightLuminance(Float value) {
        this.backlightLuminance = value;
    }

    /**
     * Gets the value of the dotPitch property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDotPitch() {
        return dotPitch;
    }

    /**
     * Sets the value of the dotPitch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDotPitch(Float value) {
        this.dotPitch = value;
    }

    /**
     * Gets the value of the activeDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActiveDisplay() {
        return activeDisplay;
    }

    /**
     * Sets the value of the activeDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActiveDisplay(Boolean value) {
        this.activeDisplay = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="red" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="green" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="blue" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ColorBitDepth {

        @XmlAttribute(name = "red", required = true)
        protected BigInteger red;
        @XmlAttribute(name = "green", required = true)
        protected BigInteger green;
        @XmlAttribute(name = "blue", required = true)
        protected BigInteger blue;

        /**
         * Gets the value of the red property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getRed() {
            return red;
        }

        /**
         * Sets the value of the red property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setRed(BigInteger value) {
            this.red = value;
        }

        /**
         * Gets the value of the green property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getGreen() {
            return green;
        }

        /**
         * Sets the value of the green property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setGreen(BigInteger value) {
            this.green = value;
        }

        /**
         * Gets the value of the blue property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBlue() {
            return blue;
        }

        /**
         * Sets the value of the blue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBlue(BigInteger value) {
            this.blue = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ChromaticityRed" type="{urn:tva:mpeg21:2011}ChromaticityType"/>
     *         &lt;element name="ChromaticityGreen" type="{urn:tva:mpeg21:2011}ChromaticityType"/>
     *         &lt;element name="ChromaticityBlue" type="{urn:tva:mpeg21:2011}ChromaticityType"/>
     *         &lt;element name="ChromaticityWhite" type="{urn:tva:mpeg21:2011}ChromaticityType" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "chromaticityRed",
        "chromaticityGreen",
        "chromaticityBlue",
        "chromaticityWhite"
    })
    public static class ColorPrimaries {

        @XmlElement(name = "ChromaticityRed", required = true)
        protected ChromaticityType chromaticityRed;
        @XmlElement(name = "ChromaticityGreen", required = true)
        protected ChromaticityType chromaticityGreen;
        @XmlElement(name = "ChromaticityBlue", required = true)
        protected ChromaticityType chromaticityBlue;
        @XmlElement(name = "ChromaticityWhite")
        protected ChromaticityType chromaticityWhite;

        /**
         * Gets the value of the chromaticityRed property.
         * 
         * @return
         *     possible object is
         *     {@link ChromaticityType }
         *     
         */
        public ChromaticityType getChromaticityRed() {
            return chromaticityRed;
        }

        /**
         * Sets the value of the chromaticityRed property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChromaticityType }
         *     
         */
        public void setChromaticityRed(ChromaticityType value) {
            this.chromaticityRed = value;
        }

        /**
         * Gets the value of the chromaticityGreen property.
         * 
         * @return
         *     possible object is
         *     {@link ChromaticityType }
         *     
         */
        public ChromaticityType getChromaticityGreen() {
            return chromaticityGreen;
        }

        /**
         * Sets the value of the chromaticityGreen property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChromaticityType }
         *     
         */
        public void setChromaticityGreen(ChromaticityType value) {
            this.chromaticityGreen = value;
        }

        /**
         * Gets the value of the chromaticityBlue property.
         * 
         * @return
         *     possible object is
         *     {@link ChromaticityType }
         *     
         */
        public ChromaticityType getChromaticityBlue() {
            return chromaticityBlue;
        }

        /**
         * Sets the value of the chromaticityBlue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChromaticityType }
         *     
         */
        public void setChromaticityBlue(ChromaticityType value) {
            this.chromaticityBlue = value;
        }

        /**
         * Gets the value of the chromaticityWhite property.
         * 
         * @return
         *     possible object is
         *     {@link ChromaticityType }
         *     
         */
        public ChromaticityType getChromaticityWhite() {
            return chromaticityWhite;
        }

        /**
         * Sets the value of the chromaticityWhite property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChromaticityType }
         *     
         */
        public void setChromaticityWhite(ChromaticityType value) {
            this.chromaticityWhite = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Resolution" type="{urn:tva:mpeg21:2011}ResolutionType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="SizeChar" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="horizontal" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="vertical" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="refreshRate" type="{http://www.w3.org/2001/XMLSchema}float" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "resolution",
        "sizeChar"
    })
    public static class Mode {

        @XmlElement(name = "Resolution")
        protected List<ResolutionType> resolution;
        @XmlElement(name = "SizeChar")
        protected DisplayCapabilityType.Mode.SizeChar sizeChar;
        @XmlAttribute(name = "refreshRate")
        protected Float refreshRate;

        /**
         * Gets the value of the resolution property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resolution property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResolution().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ResolutionType }
         * 
         * 
         */
        public List<ResolutionType> getResolution() {
            if (resolution == null) {
                resolution = new ArrayList<ResolutionType>();
            }
            return this.resolution;
        }

        /**
         * Gets the value of the sizeChar property.
         * 
         * @return
         *     possible object is
         *     {@link DisplayCapabilityType.Mode.SizeChar }
         *     
         */
        public DisplayCapabilityType.Mode.SizeChar getSizeChar() {
            return sizeChar;
        }

        /**
         * Sets the value of the sizeChar property.
         * 
         * @param value
         *     allowed object is
         *     {@link DisplayCapabilityType.Mode.SizeChar }
         *     
         */
        public void setSizeChar(DisplayCapabilityType.Mode.SizeChar value) {
            this.sizeChar = value;
        }

        /**
         * Gets the value of the refreshRate property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getRefreshRate() {
            return refreshRate;
        }

        /**
         * Sets the value of the refreshRate property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setRefreshRate(Float value) {
            this.refreshRate = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="horizontal" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="vertical" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class SizeChar {

            @XmlAttribute(name = "horizontal", required = true)
            protected BigInteger horizontal;
            @XmlAttribute(name = "vertical", required = true)
            protected BigInteger vertical;

            /**
             * Gets the value of the horizontal property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getHorizontal() {
                return horizontal;
            }

            /**
             * Sets the value of the horizontal property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setHorizontal(BigInteger value) {
                this.horizontal = value;
            }

            /**
             * Gets the value of the vertical property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getVertical() {
                return vertical;
            }

            /**
             * Sets the value of the vertical property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setVertical(BigInteger value) {
                this.vertical = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="horizontal" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
     *       &lt;attribute name="vertical" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ScreenSize {

        @XmlAttribute(name = "horizontal", required = true)
        protected float horizontal;
        @XmlAttribute(name = "vertical", required = true)
        protected float vertical;

        /**
         * Gets the value of the horizontal property.
         * 
         */
        public float getHorizontal() {
            return horizontal;
        }

        /**
         * Sets the value of the horizontal property.
         * 
         */
        public void setHorizontal(float value) {
            this.horizontal = value;
        }

        /**
         * Gets the value of the vertical property.
         * 
         */
        public float getVertical() {
            return vertical;
        }

        /**
         * Sets the value of the vertical property.
         * 
         */
        public void setVertical(float value) {
            this.vertical = value;
        }

    }

}
