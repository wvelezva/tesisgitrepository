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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IlluminationCharacteristicsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IlluminationCharacteristicsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:tva:mpeg21:2011}NaturalEnvironmentCharacteristicBaseType">
 *       &lt;sequence>
 *         &lt;element name="TypeOfIllumination" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="ColorTemperature" type="{urn:tva:mpeg7:2008}unsigned8"/>
 *                   &lt;element name="Chromaticity">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="x" type="{urn:tva:mpeg7:2008}zeroToOneType"/>
 *                             &lt;element name="y" type="{urn:tva:mpeg7:2008}zeroToOneType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Illuminance" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IlluminationCharacteristicsType", propOrder = {
    "typeOfIllumination",
    "illuminance"
})
public class IlluminationCharacteristicsType
    extends NaturalEnvironmentCharacteristicBaseType
{

    @XmlElement(name = "TypeOfIllumination")
    protected IlluminationCharacteristicsType.TypeOfIllumination typeOfIllumination;
    @XmlElement(name = "Illuminance")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger illuminance;

    /**
     * Gets the value of the typeOfIllumination property.
     * 
     * @return
     *     possible object is
     *     {@link IlluminationCharacteristicsType.TypeOfIllumination }
     *     
     */
    public IlluminationCharacteristicsType.TypeOfIllumination getTypeOfIllumination() {
        return typeOfIllumination;
    }

    /**
     * Sets the value of the typeOfIllumination property.
     * 
     * @param value
     *     allowed object is
     *     {@link IlluminationCharacteristicsType.TypeOfIllumination }
     *     
     */
    public void setTypeOfIllumination(IlluminationCharacteristicsType.TypeOfIllumination value) {
        this.typeOfIllumination = value;
    }

    /**
     * Gets the value of the illuminance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIlluminance() {
        return illuminance;
    }

    /**
     * Sets the value of the illuminance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIlluminance(BigInteger value) {
        this.illuminance = value;
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
     *       &lt;choice>
     *         &lt;element name="ColorTemperature" type="{urn:tva:mpeg7:2008}unsigned8"/>
     *         &lt;element name="Chromaticity">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="x" type="{urn:tva:mpeg7:2008}zeroToOneType"/>
     *                   &lt;element name="y" type="{urn:tva:mpeg7:2008}zeroToOneType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "colorTemperature",
        "chromaticity"
    })
    public static class TypeOfIllumination {

        @XmlElement(name = "ColorTemperature")
        protected Integer colorTemperature;
        @XmlElement(name = "Chromaticity")
        protected IlluminationCharacteristicsType.TypeOfIllumination.Chromaticity chromaticity;

        /**
         * Gets the value of the colorTemperature property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getColorTemperature() {
            return colorTemperature;
        }

        /**
         * Sets the value of the colorTemperature property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setColorTemperature(Integer value) {
            this.colorTemperature = value;
        }

        /**
         * Gets the value of the chromaticity property.
         * 
         * @return
         *     possible object is
         *     {@link IlluminationCharacteristicsType.TypeOfIllumination.Chromaticity }
         *     
         */
        public IlluminationCharacteristicsType.TypeOfIllumination.Chromaticity getChromaticity() {
            return chromaticity;
        }

        /**
         * Sets the value of the chromaticity property.
         * 
         * @param value
         *     allowed object is
         *     {@link IlluminationCharacteristicsType.TypeOfIllumination.Chromaticity }
         *     
         */
        public void setChromaticity(IlluminationCharacteristicsType.TypeOfIllumination.Chromaticity value) {
            this.chromaticity = value;
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
         *         &lt;element name="x" type="{urn:tva:mpeg7:2008}zeroToOneType"/>
         *         &lt;element name="y" type="{urn:tva:mpeg7:2008}zeroToOneType"/>
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
            "x",
            "y"
        })
        public static class Chromaticity {

            protected float x;
            protected float y;

            /**
             * Gets the value of the x property.
             * 
             */
            public float getX() {
                return x;
            }

            /**
             * Sets the value of the x property.
             * 
             */
            public void setX(float value) {
                this.x = value;
            }

            /**
             * Gets the value of the y property.
             * 
             */
            public float getY() {
                return y;
            }

            /**
             * Sets the value of the y property.
             * 
             */
            public void setY(float value) {
                this.y = value;
            }

        }

    }

}
